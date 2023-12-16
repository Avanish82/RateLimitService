package com.ratelimit.controller;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.user.management.config.RatelimitPricePlanService;

//import com.ratelimit.config.RatelimitPricePlanService;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
//import io.github.bucket4j.Refill;
////
////////Second way 
////@RestController
////@RequestMapping("/rate-limit")
////public class RateLimitController {
////	
////	private Bucket bucket=null;
////	
////	@Autowired
////	private RatelimitPricePlanService ratelimitPricePlanService;
////	
////	@GetMapping("/token-generate/{clientToken}")
////	public ResponseEntity<String> generateToken(@PathVariable("clientToken") String clientToken){
////		 bucket=ratelimitPricePlanService.getPlanServiceBucket(clientToken);
////		 String str=bucket.toString();
////		 System.out.println(str);
////		return new ResponseEntity<String>("Generated Successfully !!!"+bucket.toString(), HttpStatus.OK);
////	}
////	
////	@GetMapping("/demooo")
////	public ResponseEntity<String> demo(){
////		//if(bucket.tryConsumer(1)) {  //try to comsume 1 token
////		if(bucket.tryConsume(1)) {
////			System.out.println("====================API Working successfully===============");
////		return new ResponseEntity<String>("  Success!!!", HttpStatus.OK);	
////	}
////	System.out.println("====================number of hits exceeded===============");
////	return new ResponseEntity<String>("TOO MANY HITS || PLease try later !!!", HttpStatus.TOO_MANY_REQUESTS);	
////	}
////
////}
////
////First way 
@RestController
@RequestMapping("/rate-limit")
public class RateLimitController {
	
//	private Bucket bucket;
//	
//	
//	@GetMapping("/token-generate")
//	public ResponseEntity<String> generateToken(){
//		//refill
//		Refill refill = Refill.of(5, Duration.ofMinutes(1));
//		//buket
////		Bucket buket=Bucket4j.builder()
//		 bucket=Bucket.builder()
//				//.addlimit(Bandwidth.classic(5, refill))  //to add 5 token at 1 minutes
//				.addLimit(Bandwidth.classic(5, refill))
//				.build();
//		//return new ResponseEntity<String>("Generated Successfully !!!", HttpStatus.OK);
//		 String str=bucket.toString();
//		 System.out.println(str);
////		return new ResponseEntity<String>("Generated Successfully !!!"+bucket.toString(), HttpStatus.OK);
//		 return new ResponseEntity<String>(bucket.toString(), HttpStatus.OK);
//	}
	
//	@Autowired
//	private RatelimitPricePlanService ratelimitPricePlanService;
	
	private final Bucket bucket;

    public RateLimitController() {
//        Bandwidth limit = Bandwidth.classic(10, Refill.greedy(10, Duration.ofMinutes(10)));
    	  Bandwidth limit = Bandwidth.classic(10, Refill.greedy(20, Duration.ofSeconds(20)));
        //this.bucket = Bucket4j.builder()
        this.bucket = Bucket.builder()
                .addLimit(limit)
                .build();
    }
	
	@GetMapping("/demo")
	public ResponseEntity<String> demo(){
		//if(bucket.tryConsumer(1)) {  //try to comsume 1 token
		if(bucket.tryConsume(1)) {
			System.out.println("====================API Working successfully===============");
		return new ResponseEntity<String>("  Success!!!", HttpStatus.OK);	
	}
	System.out.println("====================number of hits exceeded===============");
	return new ResponseEntity<String>("TOO MANY HITS || PLease try later !!!", HttpStatus.TOO_MANY_REQUESTS);	
	}

}
