package com.stackroute.sampleboottest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.sampleboottest.exceptions.InvalidDataException;
import com.stackroute.sampleboottest.model.Student;
import com.stackroute.sampleboottest.service.StudentService;

public class ClientApp {

	@Autowired
	StudentService studservice;
	
	public List<Student> displayDetails()
	{
		List<Student> studentdetails=studservice.getAllStudents();
		return studentdetails;
	}
	
	public Student viewStudentByRollno(int rollno)
	{
		Student studobj=studservice.findByRollno(rollno);
		return studobj;
	}
	
	public void addStudent(Student stud)
	{
		try {
			studservice.addStudent(stud);
		} catch (InvalidDataException e) {
			 System.out.println(e);
		}
	}
}


