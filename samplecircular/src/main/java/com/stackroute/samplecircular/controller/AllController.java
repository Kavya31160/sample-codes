package com.stackroute.samplecircular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.samplecircular.service.CourseService;
import com.stackroute.samplecircular.service.StudentService;

@RestController
@RequestMapping("/admission")
public class AllController {
	
	CourseService courseservice;
	StudentService studentservice;
	
	@Autowired
	public AllController(CourseService cservice,StudentService sservice)
	{
		this.courseservice=cservice;
		this.studentservice=sservice;
	}

	
	@GetMapping("/viewStudent")
	public ResponseEntity getstudent()
	{
		return new ResponseEntity(studentservice.showDetail(),HttpStatus.OK);
	}
	
	@GetMapping("/courses")
	public ResponseEntity getcourses()
	{
		return new ResponseEntity(studentservice.getCourseDetails(),HttpStatus.OK);
	}
	
	@GetMapping("/enrollment")
	public ResponseEntity getenroll()
	{
		return new ResponseEntity(courseservice.getUser(),HttpStatus.OK);
	}
	
}
