package com.job.interview.parser;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.job.interview.entity.Flight;

@XmlRootElement(name = "flights")
@XmlAccessorType (XmlAccessType.FIELD)
public class Flights {
	
	@XmlElement(name = "flights")
    private List<Flight> flights = new ArrayList<Flight>();
 
    public List<Flight> getFlights() {
        return flights;
    }
 
    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
}
