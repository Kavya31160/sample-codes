package com.stackroute.sampleboottest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.stackroute.sampleboottest.repository.StudentRepo;
import com.stackroute.sampleboottest.service.StudentService;
import com.stackroute.sampleboottest.service.StudentServiceImpl;

@Configuration
public class StudentConfig {
	
	
	@Bean("client")
	public ClientApp getclient()
	{
		return new ClientApp();
	}
	
	@Bean
	public StudentRepo getRepo()
	{
		return new StudentRepo();
	}
	
	@Bean
	public StudentService getService()
	{
		return new StudentServiceImpl();
	}

}
