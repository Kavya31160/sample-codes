package com.stackroute.samplejpa.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.samplejpa.model.Developer;

@Repository
public interface DeveloperDao extends JpaRepository<Developer,Integer>{
	
	List<Developer> findByProjectname(String project);
	
	Optional<Developer> findByProjectnameAndUserName(String pname,String uname);
	
	List<Developer> findFirst2ByProjectname(String projname);
	
	
	Developer findByUserName(String uname);	
	
	
	
	
	
	
	
}
