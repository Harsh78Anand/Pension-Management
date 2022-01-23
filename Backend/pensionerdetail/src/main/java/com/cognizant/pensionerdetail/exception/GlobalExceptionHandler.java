package com.cognizant.pensionerdetail.exception;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(AadhaarNumberNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handlesAadhaarNumberNotFoundException(AadhaarNumberNotFoundException aadhaarNumberNotFoundException) {
		
		CustomErrorResponse response = new CustomErrorResponse();
		response.setDateTime(LocalDateTime.now());
		response.setMessage(aadhaarNumberNotFoundException.getMessage());
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(PensionerDetailNotFound.class)
	public ResponseEntity<ApiErrorResponse> handleCustomerLoanNotFoundException(PensionerDetailNotFound ex) {
		ApiErrorResponse errorResponse = new ApiErrorResponse(HttpStatus.NOT_FOUND);
		errorResponse.setLocalizedMessage(ex.getLocalizedMessage());
		errorResponse.setMessage(ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

}
