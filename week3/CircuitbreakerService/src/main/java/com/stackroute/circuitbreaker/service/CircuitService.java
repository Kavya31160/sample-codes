package com.stackroute.circuitbreaker.service;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
 
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.ws.rs.core.MediaType;

@Service
public class CircuitService {
	
	
	 
		public String viewPassengersByFlight() {
		 
			RestTemplate restobj=new RestTemplate();
			
			String url="http://localhost:9099/passenger/viewall";
			
		ResponseEntity<String> details=restobj.exchange(url, HttpMethod.GET, getEntity(), String.class);
			
			return details.getBody();
		}
		
		private HttpEntity getEntity()
		{
			HttpHeaders headers=new HttpHeaders();
	//	headers.set
		//	headers.set("Accept", "APPLICATION_JSON");
			headers.set("Accept", MediaType.APPLICATION_JSON);
			return new HttpEntity<>(headers);
		}
		
		

}
