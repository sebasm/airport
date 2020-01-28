package com.job.interview.parser;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.job.interview.entity.Flight;
import com.job.interview.exception.FormatException;

public class XMLProcessor implements FormatsProcessor {

	@Override
	public List<Flight> read(byte[] file) {
		
		
		JAXBContext jaxbContext;
		Flights response = null;
		try {
			jaxbContext = JAXBContext.newInstance(Flights.class);
			
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		    response = (Flights) jaxbUnmarshaller.unmarshal( new ByteArrayInputStream(file));
		     
		} catch (JAXBException e) {
			throw new FormatException("Error reading file", e);
		}

		return response.getFlights();
	}

	@Override
	public byte[] write(List<Flight> flights) {
		
		Flights flightsObj = new Flights();
		flightsObj.setFlights(flights);
		
		JAXBContext jaxbContext;
		StringWriter writer = new StringWriter();
		try {
			jaxbContext = JAXBContext.newInstance(Flights.class);
		
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		 
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		     
		    jaxbMarshaller.marshal(flightsObj, writer);
	     
		} catch (JAXBException e) {
			throw new FormatException("Error reading file", e);
		}
	    return writer.toString().getBytes();
	}

}
