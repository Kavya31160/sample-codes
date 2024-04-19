package com.stackroute.sampleresttemp.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.modelmapper.ModelMapper;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.sampleresttemp.dto.AirportDTO;
import com.stackroute.sampleresttemp.helper.Passenger;
import com.stackroute.sampleresttemp.model.Airport;
import com.stackroute.sampleresttemp.service.AirportService;

@RestController
@RequestMapping("/airport")
public class AirportController {
	
    private static Logger logger = LoggerFactory.getLogger(AirportController.class);

 
    
    ModelMapper modelMapper;


	
	AirportService aservice;
	
	@Autowired
	AirportController(AirportService aserve,  ModelMapper model)
	{
		this.aservice=aserve;
		this.modelMapper=model;
	}
	
	
	@PostMapping("newairport")
  public ResponseEntity<?> addairport(@RequestBody Airport aport)
  {
	Airport result=	aservice.addAirport(aport);
	
	
    ObjectMapper mapper = new ObjectMapper();
    String jsonInString = null;
    try {
        jsonInString = mapper.writeValueAsString(convertToDto(aport));
    } catch (JsonProcessingException e) {
        logger.error("json.parser.error", e.getMessage());

    }

    logger.info("Airport details saved to db : details are " + jsonInString + " on " + new Date());

	return new ResponseEntity<String>(jsonInString,HttpStatus.CREATED);
		
  }
	
	@GetMapping("showpassenger/{flightno}")
	public ResponseEntity<?> viewpassenger(@PathVariable("flightno") String flightnum)
	{
	List<Passenger> passengers=aservice.viewPassengersByFlight(flightnum);
	
	return new ResponseEntity<List>(passengers,HttpStatus.OK);
	
	}
	
	@GetMapping("viewairports")
	public ResponseEntity<?> viewairport()
	{
		List<Airport> airports=aservice.viewAirports();
		return new ResponseEntity<List>(airports,HttpStatus.OK);
	}
	
	
	private AirportDTO convertToDto(Airport airport) {
		AirportDTO airportdto = null;
        if (airport != null) {

        	//airportdto = modelMapper.map(airport, AirportDTO.class);
            if (airportdto == null) {
            	airportdto = new AirportDTO();
                airportdto.setCountry(airport.getCountry());
                airportdto.setName(airport.getName());

            }
        //    airportdto = airportdto == null ? new AirportDTO() : airportdto;

        }
        return airportdto;
    }

	
	
}
