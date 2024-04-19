package com.stackroute.flightjpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.flightjpa.model.Passenger;

@Repository
public interface PassengerDAO extends JpaRepository<Passenger,String>{
	
 
	List<Passenger> findByFlight(String flight);
	
	List<Passenger> findByFlightAndSeattype(String flight,String seattype);
	
	List<Passenger> findByFareGreaterThan(int amount);
}
