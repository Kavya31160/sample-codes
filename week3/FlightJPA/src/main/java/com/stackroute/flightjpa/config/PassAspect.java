package com.stackroute.flightjpa.config;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import com.stackroute.flightjpa.model.Passenger;

@Aspect
public class PassAspect {
	
	Logger mylog=LoggerFactory.getLogger(PassAspect.class);
	
	
	@Before("execution (* com.stackroute.flightjpa.controller.PassengerController.getpassenger(..))")
	public void beforeview(JoinPoint jp)
	{
		mylog.info("Some Client is calling View all passenger method" + jp.toString());
	}
	
	@Before("execution (* com.stackroute.flightjpa.controller.PassengerController.addpassenger(..))")
	public void beforeadd(JoinPoint jp)
	{
		mylog.warn("Some Client is calling add method" + jp.toString());
	}

	@Around("execution (* com.stackroute.flightjpa.controller.PassengerController.addpassenger(..))")
	public Object adddata(ProceedingJoinPoint jp) throws Throwable
	{
		
		Object obj=jp.proceed();
		
		try
		{
			ResponseEntity resentity=(ResponseEntity) obj;
		 	Passenger passenger=(Passenger)resentity.getBody();
		 	
		 	mylog.info("new user got stored " + passenger.getPassengerName() +  " at  " + LocalDateTime.now());
		 	
		}
		catch(Exception e)
		{
			mylog.warn("Exception raised while adding passenger" + e.getMessage() + " at  " + LocalDateTime.now());
		}
		
		return obj;
	}
	
	
	
}
