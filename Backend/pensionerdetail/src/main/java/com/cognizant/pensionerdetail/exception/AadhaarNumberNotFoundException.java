package com.cognizant.pensionerdetail.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Aadhaar Number Not Found")
public class AadhaarNumberNotFoundException extends Exception {
	
	public AadhaarNumberNotFoundException(String msg) {
		super(msg);
	}

	/**
	 * This method sets the custom error message
	 * 
	 * @param message
	 */
	private static final long serialVersionUID = 1L;
	
}
