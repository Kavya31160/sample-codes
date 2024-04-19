package com.stackroute.sampleboottest.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.stackroute.sampleboottest.model.Student;


public class StudentRepo {

	
	List<Student> students=new ArrayList<Student>();
	public StudentRepo() {}
	
	public List<Student> getAll()
	{

		students.add(new Student(10,"Liza","Science"));
		students.add(new Student(20,"Ria","Maths"));
		students.add(new Student(30,"Titan","IT"));
		
		return students;
		
	}
	
	public Student add(Student stud)
	{
		students.add(stud);
		return stud;
	}
	
	public Student findById(int roll)
	{
		
		Optional<Student> optstudent=students.stream().filter( stud->stud.getRollno()==roll).findFirst();
		 if (optstudent.isPresent())
			 return optstudent.get();
		 else
			 return null;
	}
	
}
