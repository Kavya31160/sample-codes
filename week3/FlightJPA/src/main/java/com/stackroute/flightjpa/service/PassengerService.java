package com.stackroute.flightjpa.service;

import java.util.List;

import com.stackroute.flightjpa.exception.IdAlreadyExistException;
import com.stackroute.flightjpa.exception.IdNotFoundException;
import com.stackroute.flightjpa.model.Passenger;

public interface PassengerService {

	List<Passenger> getPassengers();
	
	Passenger addPassenger(Passenger newpassenger) throws IdAlreadyExistException;
	
	boolean deletePassenger(String passid) throws IdNotFoundException;
	

	Passenger updatePassenger(Passenger passenger) throws IdNotFoundException;
	
	List<Passenger> getPassengerByFlight(String flight) ;
	
	List<Passenger> getPassengerByFlighandseat(String flight,String seattype);
	
	List<Passenger> getPassengerWithMinPrice(int price);
	
}
