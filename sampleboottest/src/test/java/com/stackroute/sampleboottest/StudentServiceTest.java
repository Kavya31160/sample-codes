package com.stackroute.sampleboottest;

 
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.stackroute.sampleboottest.exceptions.InvalidDataException;
import com.stackroute.sampleboottest.model.Student;
import com.stackroute.sampleboottest.repository.StudentRepo;
import com.stackroute.sampleboottest.service.StudentServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest {

	@Mock
	StudentRepo repo;
	
	@InjectMocks
	StudentServiceImpl service;
	
	
List<Student>  students=new ArrayList<Student>();
	
	@Before
	public void init()
	{

		students.add(new Student(10,"testuser1","course1"));
		students.add(new Student(20,"testuser2","course2"));

	}
	
	@Test
	public void whenaddstudentstoredsuccess() throws InvalidDataException
	{
		Student student=new Student(90,"Victor","Statistics");
		
		 when(repo.add(student)).thenReturn(student);
		 
		 Student studresult=service.addStudent(student);
		 
		 assertEquals("Victor",studresult.getName());
		
	} 
	
}
