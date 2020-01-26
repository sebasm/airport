package com.job.interview;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FormatException extends RuntimeException{

	private static final long serialVersionUID = 746173540880549426L;
	
	public FormatException(String message) {
		super(message);
	}
	
	public FormatException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
