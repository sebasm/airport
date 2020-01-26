package com.job.interview.controller;

import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.job.interview.FormatException;
import com.job.interview.entity.Flight;
import com.job.interview.service.FlightService;

@RestController
public class FlightController {
	
	@Autowired
	FlightService flightService;
	
	private Pattern validExtensions = Pattern.compile("([^\\s]+(\\.(?i)(csv|xml|json))$)");
	
	@RequestMapping(value = "/flights", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void postFlights(@RequestParam("file") MultipartFile file) {
		
		Matcher matcher = validExtensions.matcher(file.getOriginalFilename());
		
		if(matcher.matches()) {
			try {
				List<Flight> flights = flightService.convertToFlights(file.getBytes(), file.getOriginalFilename().substring(file.getOriginalFilename().length()-3));
				flightService.registerFlights(flights);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("");
			
		}else {
			throw new FormatException("Format not allowed, file must be CSV, XML or JSON");
		}
		
		
	}
	
	@RequestMapping(value = "/flights", method = RequestMethod.GET, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public @ResponseBody byte[] getFlights(@RequestParam(name = "format", required = false, defaultValue = "CSV") String format) {
		List<Flight> flights = flightService.getFlights();
		byte [] response = flightService.convertFlights(flights, format);
		return response;
	}

}
