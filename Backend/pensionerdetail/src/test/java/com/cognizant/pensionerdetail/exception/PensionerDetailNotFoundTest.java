package com.cognizant.pensionerdetail.exception;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PensionerDetailNotFoundTest {
	
	@Mock
	PensionerDetailNotFoundTest pensionerDetailNotFoundTest;
	
	@Test
	public void testOneArgConstructor() {
		PensionerDetailNotFound pensionerDetailNotFound = new PensionerDetailNotFound("Pensioner not found");
		assertEquals("Pensioner not found", pensionerDetailNotFound.getMessage());
	}

}
