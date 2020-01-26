package com.job.interview.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.job.interview.entity.Flight;

public interface FlightRepository extends CrudRepository<Flight, Long>{
	
	@Override
    List<Flight> findAll();

}
