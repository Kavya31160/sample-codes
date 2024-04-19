package com.stackroute.samplerestbasic.service;

import java.util.List;
import java.util.Optional;

import com.stackroute.samplerestbasic.exception.DuplicateIdException;
import com.stackroute.samplerestbasic.exception.IdNotFoundException;
import com.stackroute.samplerestbasic.model.Developer;

 

public interface DeveloperService {

	Developer addDeveloper(Developer newuser) throws DuplicateIdException;
	List<Developer> viewDevelopers();
	boolean deleteDeveloper(int id) throws IdNotFoundException;
	
	Developer UpdateDeveloper(Developer developer) throws IdNotFoundException;
	Developer getdetailsbyId(int id);
	
 
 
	
}
