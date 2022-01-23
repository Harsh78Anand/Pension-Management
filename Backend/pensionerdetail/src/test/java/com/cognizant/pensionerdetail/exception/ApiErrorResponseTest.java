package com.cognizant.pensionerdetail.exception;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ApiErrorResponseTest {
	
	@Mock
	ApiErrorResponse aer;
	
	
	@Test
	public void argsConstructor() {
		aer = new ApiErrorResponse(HttpStatus.ACCEPTED);
		assertEquals(HttpStatus.ACCEPTED, aer.getHttpStatus());
	}
	
	@Test
	public void argsConstructor2() {
		aer = new ApiErrorResponse(HttpStatus.ACCEPTED, new Throwable());
		assertEquals( HttpStatus.ACCEPTED, aer.getHttpStatus());
		assertEquals("Unexpected error in the request", aer.getMessage());
	}

}
