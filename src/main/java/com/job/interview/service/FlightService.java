package com.job.interview.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.job.interview.entity.Flight;
import com.job.interview.parser.FormatsProcessor;
import com.job.interview.parser.ParserFactory;
import com.job.interview.repository.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	ParserFactory parserFactory;
	
	@Autowired
	FlightRepository flightRepository;
	
	public void registerFlights(List<Flight> flights) {
		flightRepository.saveAll(flights);
	}
	
	public List<Flight> convertToFlights(byte[] file, String format) {
		
		FormatsProcessor processor = parserFactory.getProcessor(format);
		List<Flight> flights = processor.read(file);
		
		return flights;
	}
	
	public List<Flight> getFlights() {
		List<Flight> flights = flightRepository.findAll();
		return flights;
	}
	
	
	public byte[] convertFlights(List<Flight> flights, String format) {
		
		FormatsProcessor processor = parserFactory.getProcessor(format);
		byte[] response = processor.write(flights);
		return response;
	}

}
