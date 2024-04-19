package com.stackroute.sampleboottest;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.stackroute.sampleboottest.model.Student;

@SpringBootApplication
public class SampleboottestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleboottestApplication.class, args);
		
		ApplicationContext  context=new AnnotationConfigApplicationContext(StudentConfig.class);
		
		ClientApp clientobj=context.getBean("client",ClientApp.class);
		
		List<Student> students=clientobj.displayDetails();
		
		students.forEach(System.out::println);
		
	}

}
