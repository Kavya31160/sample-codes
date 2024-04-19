package com.stackroute.samplerestbasic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stackroute.samplerestbasic.exception.DuplicateIdException;
import com.stackroute.samplerestbasic.exception.IdNotFoundException;
import com.stackroute.samplerestbasic.model.Developer;
import com.stackroute.samplerestbasic.repository.DeveloperDao;

 

@Service
public class DeveloperServiceImpl implements DeveloperService{

	@Autowired
	DeveloperDao developerdao;
	
 
	
	@Override
	public Developer addDeveloper(Developer newuser) throws DuplicateIdException {
		
		Optional<Developer> developerobj=developerdao.findById(newuser.getDeveloperId());
		
		
		if (developerobj.isPresent())
		{
			throw new DuplicateIdException("Id already exist");
		}
		else
		{
		 developerdao.save(newuser);
		 	return newuser;
		}
	}

	@Override
	public List<Developer> viewDevelopers() 
		{
	//	developerdao.
	
	return	(List<Developer>) developerdao.findAll();

	}

	@Override
	public boolean deleteDeveloper(int devid) throws IdNotFoundException {
		
		//select * from developer where developerid=paramname
		
	Optional<Developer> developerobj=developerdao.findById(devid);
	
	if (developerobj.isPresent())
	{
		//developerdao.deleteById(devid);
		developerdao.delete(developerobj.get());
		return true;
	}
		
	else
		throw new IdNotFoundException("given id does not exist in the databasse");
		
	
	}

	@Override
	public Developer UpdateDeveloper(Developer developer) throws IdNotFoundException {
		
		Optional<Developer> developerobj=developerdao.findById(developer.getDeveloperId());
		
		if (developerobj.isPresent())
		{
			developerdao.save(developer);
			 
			return developer;
		}
			
		else
			throw new IdNotFoundException("given id does not exist in the databasse");
			
		
		
	}

	@Override
	public Developer getdetailsbyId(int devid) {
		// TODO Auto-generated method stub
		//return developerdao.findById(devid).orElse(null);
		
	return	developerdao.findById(devid).get();
		
	}

 

 

	 
	

}
