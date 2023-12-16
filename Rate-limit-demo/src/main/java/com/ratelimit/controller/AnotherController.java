//package com.ratelimit.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.RestTemplate;
//
//import io.github.bucket4j.Bucket;
//import io.github.bucket4j.BucketState;
//
//@RestController
//@RequestMapping("/rate-limits")
//public class AnotherController {
//	
//	private Bucket bucket=null;
//	
////	@Autowired
////	public RateLimitController restcontroller;
//	
//	//bucket=rest.Bucket.builder();
//	
//	@GetMapping("/demo")
//	public ResponseEntity<String> demo(){
////		 String uri = "http://localhost:8080/rate-limit/token-generate/free123";
//		String uri ="http://localhost:8080/rate-limit/token-generate";
//			RestTemplate rest = new RestTemplate();
//			ResponseEntity<String> response = rest.getForEntity(uri, String.class);
//			System.out.println(response);
//		     String str=response.toString();
//		     String strs=response.getBody();
//		     System.out.println("hello :"+strs);
//		     
//		      // Bucket dhdh = Bucket.parseBucket(response);
//		     //  bucket=dhdh;
//		     bucket=BucketState.deserialize(strs);
//		//if(bucket.tryConsumer(1)) {  //try to comsume 1 token
//		if(bucket.tryConsume(1)) {
//		     //if(str.)
//			System.out.println("====================API Working successfully===============");
//		return new ResponseEntity<String>("  Success!!!", HttpStatus.OK);	
//	}
//	System.out.println("====================number of hits exceeded===============");
//	return new ResponseEntity<String>("TOO MANY HITS || PLease try later !!!", HttpStatus.TOO_MANY_REQUESTS);	
//		}
//	
//
//}
