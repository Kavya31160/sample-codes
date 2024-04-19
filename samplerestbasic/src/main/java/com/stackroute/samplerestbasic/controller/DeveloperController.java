package com.stackroute.samplerestbasic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.samplerestbasic.exception.DuplicateIdException;
import com.stackroute.samplerestbasic.exception.IdNotFoundException;
import com.stackroute.samplerestbasic.model.Developer;
import com.stackroute.samplerestbasic.service.DeveloperService;

import jakarta.servlet.http.HttpSession;

@RestController

@RequestMapping("/developer")
public class DeveloperController {
	
	@Autowired
	DeveloperService devservice;
	
	@PostMapping("/newdeveloper")
	public ResponseEntity<?> adddeveloper(@RequestBody Developer devobj,HttpSession sess) 
	{
		String uname=(String) sess.getAttribute("username");
		Developer dev;
		try {
			dev = devservice.addDeveloper(devobj);
			return new ResponseEntity<Developer>(dev,HttpStatus.CREATED);
		} catch (DuplicateIdException e) {
			return new ResponseEntity<String>("dulicate id",HttpStatus.CONFLICT);
		}
		
		
	}
	
	@GetMapping("/viewall")
	public ResponseEntity<?> viewall()
	{
		List<Developer> developers=devservice.viewDevelopers();
		return new ResponseEntity<List>(developers,HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/{devid}")
	public ResponseEntity<?> deletedev(@PathVariable("devid") int devid)  
	{
		try {
			boolean result=	devservice.deleteDeveloper(devid);
			return new ResponseEntity<String>("successfully deleted",HttpStatus.OK);
		} catch (IdNotFoundException e) {
			return new ResponseEntity<String>("Invalid id",HttpStatus.OK);
		}
	
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateDev(@RequestBody Developer dev)
	{
		try {
			Developer result=	devservice.UpdateDeveloper(dev);
			return new ResponseEntity<Developer>(result,HttpStatus.OK);
		} catch (IdNotFoundException e) {
			return new ResponseEntity<String>("Invalid id",HttpStatus.OK);
		}
	}
	

}
