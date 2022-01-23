package com.cognizant.pensionerdetail.exception;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class AadhaarNumberNotFoundExceptionTest {
	
	@Mock
	AadhaarNumberNotFoundException aadhaarNumberNotFoundException;
	
	@Test
	public void testOneArgConstructor() {
		AadhaarNumberNotFoundException userNotFoundException = new AadhaarNumberNotFoundException("Aadhaar not found");
		assertEquals("Aadhaar not found", userNotFoundException.getMessage());
	}

}
