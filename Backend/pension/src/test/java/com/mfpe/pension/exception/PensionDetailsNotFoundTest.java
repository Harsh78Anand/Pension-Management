package com.mfpe.pension.exception;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class PensionDetailsNotFoundTest {
	PensionDetailsNotFound pensionDetailsNotFound;

	@Before
	public void init() {
		pensionDetailsNotFound= new PensionDetailsNotFound("Pension Detail Not Found Exception");
	}

	@Test
	public void testLoanNotFound() {
		assertEquals("Pension Detail Not Found Exception", pensionDetailsNotFound.getMessage());
	}

}
