package com.cognizant.pensiondisbursement.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PensionerDetailsNotFoundTest {
	
	PensionerDetailsNotFound pensionerDetailsNotFound;

	@Before
	public void init() {
		pensionerDetailsNotFound = new PensionerDetailsNotFound("Pensioner Details not found");
	}

	@Test
	public void testPensionerDetailsNotFound() {
		assertEquals("Pensioner Details not found", pensionerDetailsNotFound.getMessage());
	}


}
