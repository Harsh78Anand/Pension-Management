package com.cognizant.pensiondisbursement.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class GlobalExceptionHandlerTest {
	
	@Autowired
	GlobalExceptionHandler globalExceptionHandler;

	ApiErrorResponse apiErrorResponse;
	
	@Before
	public void setUp() {
		apiErrorResponse = new ApiErrorResponse();
	}
	
	@Test
	public void handlePensionerDetailsNotFoundTest() {
		PensionerDetailsNotFound pensionerDetailsNotFound = new PensionerDetailsNotFound("Pensioner details not found");
		globalExceptionHandler.handlePensionerDetailsNotFoundException(pensionerDetailsNotFound);
		apiErrorResponse.setMessage(pensionerDetailsNotFound.getMessage());
		apiErrorResponse.setLocalizedMessage(pensionerDetailsNotFound.getLocalizedMessage());
		ResponseEntity<?> entity = new ResponseEntity<>(apiErrorResponse, HttpStatus.UNAUTHORIZED);
		assertEquals(401, entity.getStatusCode().value());
	}
	
	
}
