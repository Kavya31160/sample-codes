package com.stackroute.samplejpa.service;

import java.util.List;
import java.util.Optional;

import com.stackroute.samplejpa.exception.DuplicateIdException;
import com.stackroute.samplejpa.exception.IdNotFoundException;
import com.stackroute.samplejpa.model.Developer;

public interface DeveloperService {

	Developer addDeveloper(Developer newuser) throws DuplicateIdException;
	List<Developer> viewDevelopers();
	boolean deleteDeveloper(int id) throws IdNotFoundException;
	
	Developer UpdateDeveloper(Developer developer) throws IdNotFoundException;
	Developer getdetailsbyId(int id);
	
	List<Developer> getDevelopersOfProject(String projectname);
	
 Developer getOneDeveloperOfProject(String projname,String uname );
	
	List<Developer> getTopTwoDevelopers(String projname);
	
	Developer findDevidUsingQuery(int id);
	
	List<Developer> findByProjnameUsingQuery(String pname);
	
}
