package com.ratelimit.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill; 
 
@Service
public class RatelimitPricePlanService {
	
	@Value("$rate.limit.client.basic")
	private String basic;
	
	@Value("$rate.limit.client.free")
	private String free;
	
	public Bucket getPlanServiceBucket(String clientToken) {
		return Bucket.builder()
				.addLimit(getclientBandwith(clientToken))
				//.addLimit(getclientBandWith(clientToken))
				.build();
	}
	
	private Bandwidth getclientBandwith(String clientToken) {
		if(clientToken.equals(basic))  //basic plan customers
			return Bandwidth.classic(5, Refill.of(5, Duration.ofMinutes(1)));
		else if(clientToken.equals(free))  //premium customers
			return Bandwidth.classic(25, Refill.of(25, Duration.ofMinutes(1)));
		
		return Bandwidth.classic(2, Refill.of(2, Duration.ofMinutes(1)));
	}

}
