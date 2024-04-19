package com.stackroute.sampleresttemp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.stackroute.sampleresttemp.dao.AirportRepo;
import com.stackroute.sampleresttemp.helper.Passenger;
import com.stackroute.sampleresttemp.model.Airport;

import jakarta.ws.rs.core.MediaType;

@Service
public class AirportServiceImpl implements AirportService {

	@Autowired
	AirportRepo repo;
	
	
	
	
	@Override
	public Airport addAirport(Airport airport) {
		 
		return repo.save(airport);
	}

	@Override
	public List<Airport> viewAirports() {
	 
		return repo.findAll();
	}

	 
	public List<Passenger> viewPassengersByFlight(String flightno) {
	 
		RestTemplate restobj=new RestTemplate();
		
		String url="http://localhost:9099/passenger/viewbyflight/"+flightno;
		
	ResponseEntity<List> details=restobj.exchange(url, HttpMethod.GET, getEntity(), List.class);
		
		return details.getBody();
	}
	
	private HttpEntity getEntity()
	{
		HttpHeaders headers=new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON);
		//headers.set("Authorization", );
		return new HttpEntity<>(headers);
	}
	
	

}
