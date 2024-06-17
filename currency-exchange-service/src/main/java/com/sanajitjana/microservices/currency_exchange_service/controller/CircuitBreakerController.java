package com.sanajitjana.microservices.currency_exchange_service.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger= LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("sample-api")
    @Retry(name="sample-api", fallbackMethod = "fallbackMethod")
//    @CircuitBreaker(name="default", fallbackMethod = "fallbackMethod")
//    @RateLimiter(name = "default")
    @Bulkhead(name="default")
    public String sampleApi() {
        logger.info("Sample API call received");
        ResponseEntity<String> responseEntity= new RestTemplate().getForEntity("http://localhost:8080/dummy-api", String.class);
        return responseEntity.getBody();
    }

    public String fallbackMethod(Exception ex){
        return "fallback method return";
    }

}
