package com.job.interview.parser;

import org.springframework.stereotype.Component;

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
			return null;
		}
		
	}

}
