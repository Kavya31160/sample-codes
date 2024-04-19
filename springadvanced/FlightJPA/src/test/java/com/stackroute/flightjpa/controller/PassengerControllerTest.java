package com.stackroute.flightjpa.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.flightjpa.exception.IdAlreadyExistException;
import com.stackroute.flightjpa.model.Passenger;
import com.stackroute.flightjpa.service.PassengerService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc

public class PassengerControllerTest {
	
	
	@MockBean
	PassengerService passengerservice;
	
	
	@InjectMocks
	PassengerController passcontrol;
	
	MockMvc mockmvc;
	
	Passenger passenger=new Passenger();
	
	List<Passenger> passengers=new ArrayList();
	
	
	@BeforeEach
	public void initializedata()
	{
		MockitoAnnotations.openMocks(this);
		
		mockmvc=MockMvcBuilders.standaloneSetup(passcontrol).build();
		
		passenger.setCountry("UK");
		passenger.setFare(1000);
		passenger.setFlight("Fl10");
		passenger.setPassengerid("P100");
		passenger.setPassengerName("Dan");
		passenger.setSeattype("BusinessClass");
		
		Passenger passenger2=new Passenger();
		passenger2.setCountry("India");
		passenger2.setFare(5000);
		passenger2.setFlight("Fl10");
		passenger2.setPassengerid("P101");
		passenger2.setPassengerName("Vani");
		passenger2.setSeattype("BusinessClass");
		
		passengers.add(passenger);
		passengers.add(passenger2);
		
	}
	 
	@Test
	public void whenaddpassengerstoredsuccess() throws Exception
	{
		Mockito.when(passengerservice.addPassenger(passenger)).thenReturn(passenger);
		
		mockmvc.perform(MockMvcRequestBuilders.post("/passenger/addpassenger")
						.contentType(MediaType.APPLICATION_JSON)
						.content(convertObject(passenger))
						)
					.andExpect(MockMvcResultMatchers.status().isCreated());
		
	verify(passengerservice,times(1)).addPassenger(any());
		
	}
	
	
	@Test
	public void whenaddpassengeraddthenfailure() throws Exception
	{
	//	Mockito.when(passengerservice.addPassenger(any())).thenThrow(IdAlreadyExistException.class);
		
		Mockito.when(passengerservice.addPassenger(any())).thenThrow(new IdAlreadyExistException("Duplicate id"));
		
		mockmvc.perform(MockMvcRequestBuilders.post("/passenger/addpassenger")
						.contentType(MediaType.APPLICATION_JSON)
						.content(convertObject(passenger))
						)
						.andExpect(MockMvcResultMatchers.status().isConflict())
					//	   .andExpect(MockMvcResultMatchers.content().string("Duplicate id"))
						 .andDo(MockMvcResultHandlers.print());
		
     //   verify(passengerservice,times(0)).addPassenger(any());

		
	}
	
	public void whenflighnamegiventhenreturnflights() throws Exception
	{
		Mockito.when(passengerservice.getPassengerByFlight(any())).thenReturn(passengers);
		
		
		mockmvc.perform(MockMvcRequestBuilders.get("/passenger//viewbyflight/F10")
				.contentType(MediaType.APPLICATION_JSON)
				 
				)
				.andExpect(MockMvcResultMatchers.status().isOk())
				 .andDo(MockMvcResultHandlers.print());
		
		verify(passengerservice,times(1)).getPassengerByFlight(any());
	}
	
	
	private String convertObject(Object obj) throws JsonProcessingException
	{
		ObjectMapper objmap=new ObjectMapper();
	return	objmap.writeValueAsString(obj);
		
	}

	@Test
	public void whendeletethensuccess() throws Exception
	{
		Mockito.when(passengerservice.deletePassenger("P100")).thenReturn(true);
		
		mockmvc.perform(MockMvcRequestBuilders.delete("/passenger/removePassenger/P100")
					.contentType(MediaType.APPLICATION_JSON)
						)
					.andExpect(MockMvcResultMatchers.status().isOk());
					
		
	}
	
	@Test
	public void whenflightpricegiventhenreturnpassenger() throws Exception
	{
Mockito.when(passengerservice.getPassengerWithMinPrice(2000)).thenReturn(passengers);
		
		
		mockmvc.perform(MockMvcRequestBuilders.get("/passenger/viewbycost/2000")
				.contentType(MediaType.APPLICATION_JSON)
				 
				)
				.andExpect(MockMvcResultMatchers.status().isOk())
				 .andDo(MockMvcResultHandlers.print());
		
		verify(passengerservice,times(1)).getPassengerWithMinPrice(2000);
	}
	
	
}
	