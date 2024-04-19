package com.stackroute.samplejpa;

import java.io.BufferedInputStream;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.stackroute.samplejpa.exception.DuplicateIdException;
import com.stackroute.samplejpa.exception.IdNotFoundException;
import com.stackroute.samplejpa.filter.DeveloperFilter;
import com.stackroute.samplejpa.model.Developer;
import com.stackroute.samplejpa.service.DeveloperService;

@SpringBootApplication
public class SampleJpaApplication {

	@Autowired
	DeveloperService service;
	
	public static void main(String[] args) {
		SpringApplication.run(SampleJpaApplication.class, args);
		
	
	
	}

	@Bean
	public FilterRegistrationBean getfilter()
	{
		FilterRegistrationBean fbean=new FilterRegistrationBean();
		fbean.setFilter(new DeveloperFilter());
		fbean.addUrlPatterns("/developer/role/*");
		return fbean;
		
	}
		
 

}















