package com.stackroute.sampleboottest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.stackroute.sampleboottest.exceptions.InvalidDataException;
import com.stackroute.sampleboottest.model.Student;
import com.stackroute.sampleboottest.repository.StudentRepo;


public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo repo;
	
	public StudentServiceImpl()
	{
		
	}
	
	
  
	public Student addStudent(Student student) throws InvalidDataException {

        
		if(student.getRollno()<=0)
			throw new InvalidDataException("roll no can not be -ve");
		else
			repo.add(student);
		
		return student;
		
	}

	@Override
	public void deleteStudent(int rollno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Student> getAllStudents() {
		
	return	repo.getAll();
		 
	}

	@Override
	public Student findByRollno(int rollno) {
		 
		return repo.findById(rollno);
	}

}
