package com.stackroute.sampleresttemp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.sampleresttemp.model.Airport;

@Repository
public interface AirportRepo extends JpaRepository<Airport,String> {

	
}
