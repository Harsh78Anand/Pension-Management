package com.cognizant.pensionerdetail.models;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class PensionerDetailTest {

	@Mock
	PensionerDetail pensionerDetail;
	
	DateTimeFormatter formatter;

	@BeforeEach
	void setUp() throws Exception {
		formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		pensionerDetail = new PensionerDetail();
		pensionerDetail.setAadhaarNumber("0");
		pensionerDetail.setAllowances(0);
		pensionerDetail.setDateOfBirth(LocalDate.parse("01/01/1999", formatter));
		pensionerDetail.setFamilyPension(false);
		pensionerDetail.setPan("0");
		pensionerDetail.setSalaryEarned(0);
		pensionerDetail.setBankDetail(new BankDetail("0", "0", "0"));
	}

	@Test
	void aadhaarNumberTest() {
		assertEquals("0", pensionerDetail.getAadhaarNumber());
	}
	
	@Test
	void allowancesTest() {
		assertEquals( 0, pensionerDetail.getAllowances());
	}
	
	@Test
	void dateOfBirthTest() {
		assertEquals(pensionerDetail.getDateOfBirth(), LocalDate.parse("01/01/1999", formatter));
	}
	
	@Test
	void familyPensionTest() {
		assertEquals(false, pensionerDetail.isFamilyPension());
	}
	@Test
	void panTest() {
		assertEquals("0", pensionerDetail.getPan());
	}
	
	@Test
	void salaryEarnedTest() {
		assertEquals(0, pensionerDetail.getSalaryEarned());
	}
	
	@Test
	void bankDetailTest() {
		assertEquals((new BankDetail("0", "0", "0")).toString(), pensionerDetail.getBankDetail().toString());
	}

}
