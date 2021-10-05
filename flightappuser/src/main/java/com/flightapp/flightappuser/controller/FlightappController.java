package com.flightapp.flightappuser.controller;

import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.flightappuser.model.Booking;
import com.flightapp.flightappuser.model.BookingDetails;
import com.flightapp.flightappuser.model.Inventory;
import com.flightapp.flightappuser.service.FlightappService;

@RestController
@RequestMapping("/api/v1.0/flight")
public class FlightappController{
	private static final Logger logger = LoggerFactory.getLogger(FlightappController.class);
	@Autowired  
	FlightappService flightService; 
	@PostMapping("/search")  
	public ResponseEntity< List<Inventory>> getAllFlight(@RequestParam(required = true)
	String fromPlace, @RequestParam String toPlace, @RequestParam Timestamp startTimeStamp )  
   
	{  
	logger.info("entered search Flight"+fromPlace);
	 return flightService.getAllFlight(fromPlace, toPlace, startTimeStamp);  
	}  

	@PostMapping("/booking/{flightNo}")  
	public ResponseEntity<Booking> bookFlight(@PathVariable("flightNo") int flightNo, @RequestBody (required = true) BookingDetails book  )   
	{  
	   return flightService.flightBooking(flightNo,book);  
	}  
}


