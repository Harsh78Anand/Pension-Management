package com.mfpe.pension.exception;

import static org.junit.Assert.assertEquals;

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
	public void handlesPensionDetailsNotFoundExceptionTest() {
		PensionDetailsNotFound pensionDetailsNotFoundException = new PensionDetailsNotFound(
				"PensionDetails not found Exception");
		globalExceptionHandler.handleCustomerLoanNotFoundException(pensionDetailsNotFoundException);
		apiErrorResponse.setMessage(pensionDetailsNotFoundException.getMessage());
		apiErrorResponse.setLocalizedMessage(pensionDetailsNotFoundException.getLocalizedMessage());
		ResponseEntity<?> entity = new ResponseEntity<>(apiErrorResponse, HttpStatus.UNAUTHORIZED);
		assertEquals(401, entity.getStatusCode().value());
	}
}
