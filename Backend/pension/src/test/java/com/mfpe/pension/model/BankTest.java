package com.mfpe.pension.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;


public class BankTest {
	
	private BankDetail bankDetail;
	@Before
	public void setUp() throws Exception {
		bankDetail = new BankDetail("ICICI","2710199813","public");
	}
	@Test
	public void testGetter() {
		assertEquals("ICICI", bankDetail.getBankName());
		assertEquals("2710199813", bankDetail.getAccountNumber());
		assertEquals("public", bankDetail.getBankType());
	}
	
	@Test
	public void testSetter() {
		bankDetail.setBankName("HDFC");
		assertEquals("HDFC", bankDetail.getBankName());
	}
}
