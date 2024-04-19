package com.stackroute.sampleboottest;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.stackroute.sampleboottest.model.Student;
import com.stackroute.sampleboottest.service.StudentService;

@RunWith(MockitoJUnitRunner.class)
public class ClientAppTest {
	
	@Mock
	StudentService service;
	

	@InjectMocks
	ClientApp clientapp;
	
	List<Student>  students=new ArrayList< >();
	
	@Before
	public void init()
	{

		students.add(new Student(10,"testuser1","course1"));
		students.add(new Student(20,"testuser2","course2"));

	}
	
	@Test
	public void whendisplaycalledthenreturnallstudentsuccess()
	{
		when (service.getAllStudents()).thenReturn(students);
		
	List<Student> actuals=clientapp.displayDetails();
	
	assertEquals(actuals.size(),2);
	
	}
	
	@Test
	public void givenrollnogetthestudentsuccess()
	{
		Student student=new Student(11,"dummy","course");
		when(service.findByRollno(anyInt())).thenReturn(student);
		
		Student result=clientapp.viewStudentByRollno(10);
		
		assertEquals("dummy",result.getName());
		
		verify(service,times(1)).findByRollno(10);
		
	}
	
	
	
}
