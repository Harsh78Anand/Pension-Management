package com.mfpe.pension.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ProcessPensionResponseTest {

	private ProcessPensionResponse processPensionResponse;
	
	@Before
	public void setUp() {
		processPensionResponse = new ProcessPensionResponse(10);
	}
	
	@Test
	public void testGetter() {
		assertEquals(10, processPensionResponse.getProcessPensionStatusCode());
	}
	
	@Test
	public void testSetter() {
		processPensionResponse.setProcessPensionStatusCode(21);
		assertEquals(21, processPensionResponse.getProcessPensionStatusCode());
	}
	@Test
	public void testToString() {
		ProcessPensionResponse processPensionResponset = new ProcessPensionResponse(10);
		assertEquals(processPensionResponse.toString(), processPensionResponset.toString());
	}
}
