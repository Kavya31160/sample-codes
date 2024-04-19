package com.stackroute.sampleresttemp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Airport {

	@Id
	String airportnumber;
	String name;
	String country;
	public String getAirportnumber() {
		return airportnumber;
	}
	public void setAirportnumber(String airportnumber) {
		this.airportnumber = airportnumber;
	}
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
