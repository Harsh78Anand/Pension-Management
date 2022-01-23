package com.cognizant.pensionerdetail.models;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class BankDetailTest {
	
	@Mock
	BankDetail bankDetail;
	
	@BeforeEach
	void setUp() throws Exception {
		bankDetail = new BankDetail();
		bankDetail.setAccountNumber("0");
		bankDetail.setBankName("0");
		bankDetail.setBankType("0");
	}
	
	@Test
	void accountNumberTest() {
		assertEquals("0", bankDetail.getAccountNumber());
	}
	
	@Test
	void bankNameTest() {
		assertEquals("0", bankDetail.getBankName());
	}
	
	@Test
	void bankTypeTest() {
		assertEquals("0", bankDetail.getBankType());
	}

}
