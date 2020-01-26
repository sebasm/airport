package com.job.interview.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

@Entity
@XmlRootElement(name = "flight")
@XmlAccessorType (XmlAccessType.FIELD)
public class Flight {

	@Id
	@GeneratedValue
	Long id;

	@CsvBindByName(column = "airline")
	private String airline;

	@CsvBindByName(column = "flight_number")
	@JsonAlias("flight_number")
	private String number;

	@CsvBindByName(column = "type")
	private String type;

	@CsvBindByName(column = "time")
	@CsvDate(value = "yyyy-MM-dd'T'hh:mm")
	private Date time;

	@CsvBindByName(column = "terminal")
	private Character terminal;

	@CsvBindByName(column = "gate")
	private Integer gate;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Character getTerminal() {
		return terminal;
	}

	public void setTerminal(Character terminal) {
		this.terminal = terminal;
	}

	public Integer getGate() {
		return gate;
	}

	public void setGate(Integer gate) {
		this.gate = gate;
	}
	
	

}
