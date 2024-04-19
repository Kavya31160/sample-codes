package com.stackroute.samplejpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.stackroute.samplejpa.dao.DeveloperDao;
import com.stackroute.samplejpa.dao.DeveloperDaoTwo;
import com.stackroute.samplejpa.exception.DuplicateIdException;
import com.stackroute.samplejpa.exception.IdNotFoundException;
import com.stackroute.samplejpa.model.Developer;

@Service
public class DeveloperServiceImpl implements DeveloperService{

	@Autowired
	DeveloperDao developerdao;
	
	@Autowired
	DeveloperDaoTwo daotwo;
	
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
	
	return	developerdao.findAll();

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
		
	return	developerdao.findByUserName("Tom");
		
	}

	@Override
	public List<Developer> getDevelopersOfProject(String projectname) {
		
		return		developerdao.findByProjectname(projectname);
		
		// return null;
	}

	@Override
	public  Developer getOneDeveloperOfProject(String projname, String uname) {
	Optional<Developer> optdevelop=	developerdao.findByProjectnameAndUserName(projname, uname);
	
	 if(optdevelop.isPresent())
		 return optdevelop.get();
	 else
		return null;
	}

	@Override
	public List<Developer> getTopTwoDevelopers(String projname) {
		// TODO Auto-generated method stub
		return  developerdao.findFirst2ByProjectname(projname);
	}

	@Override
	public Developer findDevidUsingQuery(int id) {
		 
		return daotwo.findByDeveloperId(id);
	}

	@Override
	public List<Developer> findByProjnameUsingQuery(String pname) {
	 
		//return  daotwo.findDevelopersbyQuery(pname,Sort.DEFAULT_DIRECTION);
		return daotwo.findDevelopersbyQuery(pname,Sort.by("projectname"));
		
	}
	

}
