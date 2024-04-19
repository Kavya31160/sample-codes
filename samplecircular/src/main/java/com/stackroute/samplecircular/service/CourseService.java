package com.stackroute.samplecircular.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	final   StudentService studentservice;
	
	@Autowired
	public CourseService(@Lazy StudentService service)
	{
		this.studentservice=service;
	}
	
	public List<String> coursesJoined()
	{
		List<String> courses=new ArrayList();
		
	courses.add("Java");
		courses.add("Python");
		courses.add("CPP");
		return courses;
		
	}
	
	public String getUser()
	{
		return studentservice.showDetail();
	}
}
