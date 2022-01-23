package com.cognizant.pensionerdetail.exception;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GlobalExpcetionHandlerTest {
	
	@InjectMocks
	GlobalExceptionHandler globalExceptionHandler;

	@Mock
	CustomErrorResponse customErrorResponse;
	
	@Before
	public void setUp() {
		customErrorResponse = new CustomErrorResponse();
	}
	
	
	@Test
	public void handlesAadhaarNumberNotFoundException() {
		AadhaarNumberNotFoundException userNameNumericException = new AadhaarNumberNotFoundException("Not Found");
		globalExceptionHandler.handlesAadhaarNumberNotFoundException(userNameNumericException);
		customErrorResponse.setDateTime(LocalDateTime.now());
		customErrorResponse.setMessage(userNameNumericException.getMessage());
		ResponseEntity<?> entity = new ResponseEntity<>(customErrorResponse, HttpStatus.UNAUTHORIZED);
		assertEquals(401, entity.getStatusCodeValue());
	}
	
	@Test
	public void handlesPensionerDetailNotFound() {
		PensionerDetailNotFound userNameNumericException = new PensionerDetailNotFound("Not Found");
		globalExceptionHandler.handleCustomerLoanNotFoundException(userNameNumericException);
		customErrorResponse.setDateTime(LocalDateTime.now());
		customErrorResponse.setMessage(userNameNumericException.getMessage());
		ResponseEntity<?> entity = new ResponseEntity<>(customErrorResponse, HttpStatus.UNAUTHORIZED);
		assertEquals(401, entity.getStatusCodeValue());
	}
	
}
