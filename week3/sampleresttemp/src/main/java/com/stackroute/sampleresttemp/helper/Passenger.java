package com.stackroute.sampleresttemp.helper;

 
public class Passenger {

 
	String passengerid;
	 String passengerName;
 	String flight;
int fare;
	
 	String seattype;
	String country;
	public String getPassengerid() {
		return passengerid;
	}
	public void setPassengerid(String passengerid) {
		this.passengerid = passengerid;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getFlight() {
		return flight;
	}
	public void setFlight(String flight) {
		this.flight = flight;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public String getSeattype() {
		return seattype;
	}
	public void setSeattype(String seattype) {
		this.seattype = seattype;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	
}
