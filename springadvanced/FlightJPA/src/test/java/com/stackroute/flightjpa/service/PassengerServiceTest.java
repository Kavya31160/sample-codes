package com.stackroute.flightjpa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.stackroute.flightjpa.dao.PassengerDAO;
import com.stackroute.flightjpa.exception.IdAlreadyExistException;
import com.stackroute.flightjpa.exception.IdNotFoundException;
import com.stackroute.flightjpa.model.Passenger;

public class PassengerServiceTest {

	@Mock
	PassengerDAO passdao;
	
	@InjectMocks
	PassengerServiceImpl  pservice;
	
	Passenger passenger=new Passenger();
	
	List<Passenger> passengers=new ArrayList<Passenger>();
	
	@BeforeEach
	public void initializedata()
	{
		MockitoAnnotations.openMocks(this);
		
		passenger.setCountry("UK");
		passenger.setFare(3000);
		passenger.setFlight("Fl10");
		passenger.setPassengerid("P100");
		passenger.setPassengerName("Dan");
		passenger.setSeattype("BusinessClass");
		
		passengers.add(passenger);
		
		Passenger pass2=new Passenger();
		
		pass2.setCountry("India");
		pass2.setFare(3000);
		pass2.setFlight("Fl10");
		pass2.setPassengerid("P101");
		pass2.setPassengerName("Angel");
		pass2.setSeattype("EconomicClass");
		
		passengers.add(pass2);
		
		
	}
	
	@Test
	public void whenaddpassengerthensuccess() throws IdAlreadyExistException 
	{
		
		//stub
		when(passdao.save(passenger)).thenReturn(passenger);
		
		
		
		//when
		Passenger storedpass=	pservice.addPassenger(passenger);
	
	
	//then
	
	assertEquals(storedpass.getPassengerName(),"Dan");
	
	verify(passdao,times(1)).findById(passenger.getPassengerid());
	verify(passdao,times(1)).save(passenger);
		
	}
	
	
	
	@Test
	public void whenaddthenfailedwithduplicate()
	{
		//stub
		when(passdao.findById("P100")).thenReturn(Optional.of(passenger));
		
		
		
		assertThrows(IdAlreadyExistException.class,()->pservice.addPassenger(passenger));
		
	}
	
	
	
	@Test
	public void whenviewthenall()
	{
		when(passdao.findAll()).thenReturn(passengers);
		
		List<Passenger> passlist=	pservice.getPassengers();
;
		assertEquals(passlist,passengers); 
	}
	@Test
	public void wnenviewbyidthensucess()
	{
		
		//when(passdao.findByFlightAndSeat(any(),any()).thenReturn(passengers);
		when (passdao.findByflightName(any())).thenReturn(passengers);
		
		List<Passenger> passlist=	pservice.getPassengerByFlight("F110");
		
				assertEquals(passlist,passengers); 
		
		
		
	}
	
	@Test
	public void whendeletebyidthensuccess() throws IdNotFoundException
	{
		when(passdao.findById(passenger.getPassengerid())).thenReturn(Optional.of(passenger));
		
		boolean result=pservice.deletePassenger(passenger.getPassengerid());
		
		
		assertTrue(result);
		verify(passdao,times(1)).deleteById(passenger.getPassengerid());
		
		
	}
	
	@Test
	public void whendetetethenerros()
	{
		when(passdao.findById(passenger.getPassengerid())).thenReturn(Optional.empty());
		
		assertThrows(IdNotFoundException.class,()->pservice.deletePassenger(passenger.getPassengerid()));
		

		verify(passdao,times(0)).deleteById("Pa00");
	}
	
	
	
}
