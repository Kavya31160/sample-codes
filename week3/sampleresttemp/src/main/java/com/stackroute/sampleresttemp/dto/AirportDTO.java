package com.stackroute.sampleresttemp.dto;

import jakarta.persistence.Id;

public class AirportDTO {
	
 
	String name;
	String country;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

}
