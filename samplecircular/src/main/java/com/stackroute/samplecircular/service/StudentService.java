package com.stackroute.samplecircular.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	String studentName="Mary";
	String address="Blore";
	final CourseService cservice;
	@Autowired
	public StudentService(CourseService courseserve)
	{
		this.cservice=courseserve;
	}

	public String showDetail()
	{
		return "Name is " + studentName + " Addr " + address;
	}
	
	public List<String> getCourseDetails()
	{
		return cservice.coursesJoined();
	}
}
