package com.stackroute.sampleresttemp.service;

import java.util.List;

import com.stackroute.sampleresttemp.helper.Passenger;
import com.stackroute.sampleresttemp.model.Airport;

public interface AirportService {
	
	Airport addAirport(Airport airport);
	
	List<Airport> viewAirports();
	
	List<Passenger>		viewPassengersByFlight(String flightno);

}
