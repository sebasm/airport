package com.job.interview.parser;

import java.util.List;

import com.job.interview.entity.Flight;

public interface FormatsProcessor {
	
	List<Flight> read(byte[] file);
	
	byte[] write(List<Flight> flights);

}
