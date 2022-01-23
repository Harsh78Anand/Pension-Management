package com.mfpe.pension.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class PensionerInputTest {
	private PensionerInput pensionerInput;
	
	@Before
	public void setUp() {
		LocalDate date = LocalDate.of(1997, 10, 12);
		pensionerInput = new PensionerInput("123232", "John", date, "xyz2323", true);
	}
	
	@Test
	public void testGetter() {
		assertEquals("123232", pensionerInput.getAadhaarNumber());
		assertEquals("John", pensionerInput.getName());
		assertEquals("xyz2323", pensionerInput.getPan());
	}
	
	@Test
	public void testSetter() {
		LocalDate date = LocalDate.of(1996, 10, 12);
		pensionerInput.setDateOfBirth(date);
		assertEquals(date, pensionerInput.getDateOfBirth());
		
	}
}
