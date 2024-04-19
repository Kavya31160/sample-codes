package com.stackroute.circuitbreaker.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.circuitbreaker.service.CircuitService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class CircuitController {
	
	@Autowired
	CircuitService service;
	
	
	
	@GetMapping("/circuit/viewflight")
	@CircuitBreaker(name="myservice",fallbackMethod="handleFail")
	public ResponseEntity<String> getall()
	{
		String result=service.viewPassengersByFlight();
	
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	
	
	
	public ResponseEntity<String> handleFail(Exception e)
	{
		return new ResponseEntity<String>("Flight Microserrvice is currently down " + LocalDateTime.now() + " kindly wait for some time",HttpStatus.OK);
	}
	
	

}
