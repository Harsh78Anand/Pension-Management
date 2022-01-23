package com.cognizant.pensiondisbursement.pojo;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;





public class PensionerDetailTest {
	
	

	private PensionerDetail pensionerDetail;
	private BankDetail bankDetail;
	
	DateTimeFormatter formatter;

	@Before
	public void setUp() throws Exception {
		formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		pensionerDetail = new PensionerDetail();
		pensionerDetail.setName("name");
		pensionerDetail.setAadhaarNumber("0");
		pensionerDetail.setAllowances(0);
		pensionerDetail.setDateOfBirth(LocalDate.parse("01/01/1999", formatter));
		pensionerDetail.setFamilyPension(false);
		pensionerDetail.setPan("0");
		pensionerDetail.setSalaryEarned(0);
		bankDetail= new BankDetail("0", "0", "0");
		pensionerDetail.setBankDetail(bankDetail);
	}
	
	@Test
	public void nameTest() {
		assertEquals("name",pensionerDetail.getName());
	}

	@Test
	public void aadhaarNumberTest() {
		assertEquals("0",pensionerDetail.getAadhaarNumber());
	}
	
	@Test
	public void allowancesTest() {
		assertEquals(0,pensionerDetail.getAllowances());
	}
	
	@Test
	public void dateOfBirthTest() {
		assertEquals(LocalDate.parse("01/01/1999", formatter),pensionerDetail.getDateOfBirth());
	}
	
	@Test
	public void familyPensionTest() {
		assertEquals(false,pensionerDetail.isFamilyPension());
	}
	@Test
	public void panTest() {
		assertEquals("0",pensionerDetail.getPan());
	}
	
	@Test
	public void salaryEarnedTest() {
		assertEquals(0,pensionerDetail.getSalaryEarned());
	}
	
	@Test
	public void bankDetailTest() {
		assertEquals(bankDetail.toString(),pensionerDetail.getBankDetail().toString());
	}
	
}
