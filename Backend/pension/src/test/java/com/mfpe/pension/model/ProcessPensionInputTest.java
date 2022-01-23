package com.mfpe.pension.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ProcessPensionInputTest {
	private ProcessPensionInput processPensionInput;
	@Before
	public void setUp() {
		processPensionInput = new ProcessPensionInput("123232", 15000, 500);
	}
	
	@Test
	public void testGetter() {
		assertEquals("123232",processPensionInput.getAadhaarNumber());
		assertEquals(15000,processPensionInput.getPensionAmount());
		assertEquals(500,processPensionInput.getBankServiceCharge());
	}
	@Test
	public void testSetter() {
		processPensionInput.setAadhaarNumber("123233");
		assertEquals("123233",processPensionInput.getAadhaarNumber());
		
	}
}
