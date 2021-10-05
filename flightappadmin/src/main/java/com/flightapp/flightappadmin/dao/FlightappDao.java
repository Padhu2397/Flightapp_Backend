package com.flightapp.flightappadmin.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.flightapp.flightappadmin.exception.AdminNotMatchException;
import com.flightapp.flightappadmin.model.Airline;
import com.flightapp.flightappadmin.model.Inventory;
import com.flightapp.flightappadmin.model.Login;
import com.flightapp.flightappadmin.repository.AirlineRepository;
import com.flightapp.flightappadmin.repository.FlightappRepository;
import com.flightapp.flightappadmin.repository.LoginRepository;


@Repository
public class FlightappDao{
	@Autowired  
	FlightappRepository flightappRepository;  
	@Autowired 
	LoginRepository loginRepository;
	@Autowired
	AirlineRepository airlineRepository;
	

	public ResponseEntity<List<Inventory>> addInventory(Inventory inventory)	{ 
		try {
		List<Airline> airline = airlineRepository.findByAirlineName(inventory.getAirlineName());
		if(airline.size()>0) {
		flightappRepository.save(inventory);
		 return new ResponseEntity<>(HttpStatus.OK);
		}
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	} catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	public ResponseEntity<List<Inventory>> updateInventory(Inventory inventory)	{ 
		try {
		List<Inventory> invento = flightappRepository.findById(inventory.getFlightNo());
		if(invento.size()>0) {
		flightappRepository.save(inventory);
		 return new ResponseEntity<>(HttpStatus.OK);
		}
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);

	} catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	public ResponseEntity<List<Airline>> addAirline(Airline airline)	{ 
		try {
			airlineRepository.save(airline);
		 return new ResponseEntity<>(HttpStatus.OK);
	} catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
		
		
		public ResponseEntity<Login> loginAdmin(Login login) {
			List<Login> loginOk = loginRepository.findAll();
	        for (Login user : loginOk) {
	            if ((user.getUserName().equals(login.getUserName()))&&(user.getPassWord().equals(login.getPassWord()))) {
	               
	       		 return new ResponseEntity<>(HttpStatus.OK);
	            }
	        }
      		 return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
	    }
	    
}
	