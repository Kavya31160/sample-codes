package com.stackroute.EmployeeTestJaco;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DeveloperTest {

	Developer developer;
	
	@BeforeEach()
	public void initialize()
	{
		developer=new Developer("Marshel",10);
	}
	
	
	@Test

	public void whennamegiventhenstore()
	{
		assertEquals("Marshel",developer.getName());
		
	}
	
	@Test
	public void whennameset()
	{
		developer.setName("Mary");
		assertEquals("Mary",developer.getName());
		
	}
	
	@Test
	
	public void whenexperienceset()
	{
		developer.setExperience(10);
		assertEquals(10,developer.getExperience());
	}
	
	
	@Test
	public void checkingexperiencefailure()
	{
		developer.setExperience(-10);
		assertFalse(developer.checkExperience());
	}
	
	
	@Test
	public void checkingexperiencesuccess()
	{
		developer.setExperience(10);
		assertTrue(developer.checkExperience());
	}
	
	
	@Test
	public void checkvalidatesuccess() throws InvalidExperienceException
	{
		developer.setExperience(20);
		assertEquals("valid",developer.validateExperience());
	}
	
	@Test
	public void checkvalidateexprfailure()
	{
		
		developer.setExperience(-2);
		
	    Exception exception = assertThrows(InvalidExperienceException.class, () ->
       developer.validateExperience());
	    
    assertEquals("Invalid Years", exception.getMessage());
		
	}
	
	
	@Test
	public void timeoutcheck()
	{
		  String actualResult = assertTimeout(Duration.ofMinutes(2), () -> {
	       String name= developer.changeName();
	       return name;
	        });
	        assertEquals("MARSHEL", actualResult);
	}
	

//	
//	
//	@Test
//	public void whenchangenamereturnincapital()
//	{
//		assertEquals("MARSHEL",developer.changeName());
//	}
}
