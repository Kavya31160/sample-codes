package com.stackroute.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.consumer.service.RecommendServiceImpl;

@RestController
public class RecommendController {
	
	@Autowired
	RecommendServiceImpl rservice;
	
	@GetMapping("/consumer/viewcount/{bookname}")
	public ResponseEntity<String> getcount(@PathVariable("bookname") String bookname)
	{
		int count=rservice.findBookCount(bookname);
		return new ResponseEntity<String>(bookname + " purchased by " + count + " users" ,HttpStatus.OK);
	}
	

}
