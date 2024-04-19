package com.stackroute.samplejpa.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.stackroute.samplejpa.model.Developer;

public interface DeveloperDaoTwo extends JpaRepository<Developer,Integer> {
	
	@Query(
			
		value="select * from developer d where d.developer_id= :devid",nativeQuery=true
			)
	
	Developer findByDeveloperId(@Param("devid") int divid);

	
	
	@Query("select d from Developer d where d.projectname=?1")
	List<Developer> findDevelopersbyQuery(String pname,Sort sort);
	
	
	
}
