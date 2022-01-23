package com.cognizant.pensiondisbursement.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ProcessPensionInputTest {
	
	private ProcessPensionInput processPensionInput;
	
	@Before
	public void setUp() throws Exception {
		
		processPensionInput=new ProcessPensionInput();
		processPensionInput.setAadhaarNumber("123232");
		processPensionInput.setPensionAmount((Double) 15000.0);
		processPensionInput.setBankServiceCharge(500);
		
	}
	
	@Test
	public void testGetter() {
		
		assertEquals("123232", processPensionInput.getAadhaarNumber());
		assertEquals((Double)15000.0, processPensionInput.getPensionAmount());
		assertEquals((Integer)500, processPensionInput.getBankServiceCharge());
		
	}
	
	@Test
	public void testSetter() {
		processPensionInput.setAadhaarNumber("232343");
		assertEquals("232343", processPensionInput.getAadhaarNumber());
	}

}
