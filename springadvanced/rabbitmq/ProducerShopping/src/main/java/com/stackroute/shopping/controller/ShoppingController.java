package com.stackroute.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.shopping.model.Book;
import com.stackroute.shopping.service.ShoppingService;

@RestController
public class ShoppingController {
	
	
	@Autowired
	ShoppingService shopservice;
	

	@PostMapping("/producer/addbook")
	public ResponseEntity<String> saveBook(@RequestBody Book book)
	{
		Book bookobj=shopservice.addbook(book);
		shopservice.sendBook(bookobj);
		return new ResponseEntity<String>("Stored and sent " + bookobj.toString(),HttpStatus.CREATED);
	}
	
	
}
