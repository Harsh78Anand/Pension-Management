package com.cognizant.pensiondisbursement.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	
	@ExceptionHandler(PensionerDetailsNotFound.class)
	public ResponseEntity<ApiErrorResponse> handlePensionerDetailsNotFoundException(PensionerDetailsNotFound ex) {
		ApiErrorResponse errorResponse = new ApiErrorResponse(HttpStatus.NOT_FOUND);
		errorResponse.setLocalizedMessage(ex.getLocalizedMessage());
		errorResponse.setMessage(ex.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	
	

}
