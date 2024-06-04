package com.servicios.gateway.controller;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RestController;

import com.servicios.gateway.config.ResilenceConfig;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import reactor.core.publisher.Mono;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

import java.time.Duration;

@RestController
@Slf4j
public class GatewayController {
	  private static final String RESILIENCE4J_INSTANCE_NAME = "userService";
	    private static final String FALLBACK_METHOD = "fallbackMethod";
		 private static final Logger log = LoggerFactory.getLogger(ResilenceConfig.class);

	    
	    @GetMapping(value = "/timeout/{timeout}", produces = MediaType.APPLICATION_JSON_VALUE)
	    @TimeLimiter(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = FALLBACK_METHOD)
	    public Mono<ResponseEntity<Boolean>> timeout(@PathVariable int timeout) {
	        log.debug("timeout method called with timeout: {}", timeout);
	        return Mono.just(new ResponseEntity<>(true, HttpStatus.OK)).delayElement(Duration.ofSeconds(timeout));
	    }


	    @GetMapping(value = "/timeDelay/{delay}", produces = MediaType.APPLICATION_JSON_VALUE)
	    @CircuitBreaker(name = RESILIENCE4J_INSTANCE_NAME, fallbackMethod = FALLBACK_METHOD)
	    public Mono<ResponseEntity<Boolean>> timeDelay(@PathVariable int delay) {
	        return Mono.just(new ResponseEntity<>(true, HttpStatus.OK)).delayElement(Duration.ofSeconds(delay));
	    }

	    private Mono<ResponseEntity<Boolean>> fallbackMethod(int value, Throwable t) {
	        log.debug("Fallback method called for value: {}", value, t);
	        return Mono.just(new ResponseEntity<>(false, HttpStatus.BAD_REQUEST));
	    }
}
