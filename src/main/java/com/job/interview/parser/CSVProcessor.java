package com.job.interview.parser;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.List;

import com.job.interview.entity.Flight;
import com.job.interview.exception.FormatException;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class CSVProcessor implements FormatsProcessor {

	@Override
	public List<Flight> read(byte[] file) {
		Reader fileReader = new InputStreamReader(new ByteArrayInputStream(file));
		List<Flight> flights = new CsvToBeanBuilder<Flight>(fileReader).withType(Flight.class).build().parse();
		return flights;
	}

	@Override
	public byte[] write(List<Flight> flights) {

		StringWriter writer = new StringWriter();
		StatefulBeanToCsvBuilder<Flight> builder = new StatefulBeanToCsvBuilder<Flight>(writer);
		StatefulBeanToCsv<Flight> beanWriter = builder.build();

		try {
			beanWriter.write(flights);
		} catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
			throw new FormatException("Error generating file", e);
		}
		return writer.toString().getBytes();
	}

}
