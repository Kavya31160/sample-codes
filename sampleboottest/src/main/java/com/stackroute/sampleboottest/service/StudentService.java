package com.stackroute.sampleboottest.service;

import java.util.List;

import com.stackroute.sampleboottest.exceptions.InvalidDataException;
import com.stackroute.sampleboottest.model.Student;

public interface StudentService {

	Student addStudent(Student student) throws InvalidDataException;
	
	void deleteStudent(int rollno);
	
	List<Student> getAllStudents();
	
	Student findByRollno(int rollno);
	
	
}
