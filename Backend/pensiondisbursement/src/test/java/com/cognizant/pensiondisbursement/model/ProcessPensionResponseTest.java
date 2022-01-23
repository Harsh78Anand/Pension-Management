package com.cognizant.pensiondisbursement.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ProcessPensionResponseTest {
	
	private ProcessPensionResponse processPensionResponse;
	
	@Before
	public void setUp() {
		
		processPensionResponse = new ProcessPensionResponse();
		processPensionResponse.setProcessPensionStatusCode(10);
		
	}
	
	@Test
	public void testGetter() {
		
		assertEquals((Integer)10,processPensionResponse.getProcessPensionStatusCode());
		
	}
	
	@Test
    public void testSetter() {
		processPensionResponse.setProcessPensionStatusCode(21);
		assertEquals((Integer)21,processPensionResponse.getProcessPensionStatusCode());
	}
}
