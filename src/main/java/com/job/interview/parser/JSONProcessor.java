package com.job.interview.parser;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.job.interview.entity.Flight;
import com.job.interview.exception.FormatException;

public class JSONProcessor implements FormatsProcessor {
	
	ObjectMapper om = new ObjectMapper();

	@Override
	public List<Flight> read(byte[] file) {
		List<Flight> response = null;
		try {
			response = om.readValue(file, new TypeReference<List<Flight>>(){});
		} catch (IOException e) {
			throw new FormatException("Error reading file", e);
		}
		return response;
	}

	@Override
	public byte[] write(List<Flight> flights) {
		String response = null;
        try { 
            response = om.writeValueAsString(flights); 
        } catch (IOException e) { 
			throw new FormatException("Error reading file", e);
        } 
		return response.getBytes();
	}

}
