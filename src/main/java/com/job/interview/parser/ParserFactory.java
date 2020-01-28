package com.job.interview.parser;

import org.springframework.stereotype.Component;

import com.job.interview.exception.FormatException;

@Component
public class ParserFactory {
	
	public FormatsProcessor getProcessor(String format) {
		
		if(format.equalsIgnoreCase("CSV")) {
			return new CSVProcessor();
		}
		else if (format.equalsIgnoreCase("JSON")) {
			return new JSONProcessor();
		}
		else if (format.equalsIgnoreCase("XML")) {
			return new XMLProcessor();
		}
		else {
			throw new FormatException("Error getting parser");
		}
		
	}

}
