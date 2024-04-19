package com.stackroute.springsecurityone.contoller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sampleweb")
public class SampleController {

	@GetMapping("/about")
	public ResponseEntity getabout()
	{
		return new ResponseEntity("About us , we are in the market for 2 decades",HttpStatus.OK);
	}
	
	
	@GetMapping("/viewemployee")
	@PreAuthorize("hasAuthority('ROLE_MANAGER')")
	public ResponseEntity viewemp()
	{
		return new ResponseEntity("Hi manager, The employee details are : ..." , HttpStatus.OK);
	}
	
	@GetMapping("/viewalluser")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public ResponseEntity viewall()
	{
		
		return new ResponseEntity("Hi Admin,All employee details are : ..." , HttpStatus.OK);

	}
}

