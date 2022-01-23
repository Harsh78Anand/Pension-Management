package com.mfpe.pension.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;

public class PensionerDetailTest {
	DateTimeFormatter formatter;
	private PensionerDetail pensionerDetail;
	private BankDetail bankDetail;
	@Before
	public void setUp() throws Exception {
		formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		pensionerDetail = new PensionerDetail();
		pensionerDetail.setAadhaarNumber("0");
		pensionerDetail.setAllowances(0);
		pensionerDetail.setDateOfBirth(LocalDate.parse("01/01/1999", formatter));
		pensionerDetail.setFamilyPension(false);
		pensionerDetail.setPan("0");
		pensionerDetail.setSalaryEarned(0);
		pensionerDetail.setName("");
		pensionerDetail.setBankDetail(new BankDetail("0", "0", "0"));
		bankDetail = new BankDetail();
		bankDetail.setAccountNumber("0");
		bankDetail.setBankName("0");
		bankDetail.setBankType("0");
	}

	@Test
	public void aadhaarNumberTest() {
		assertEquals("0", pensionerDetail.getAadhaarNumber());
	}
	
	@Test
	public void allowancesTest() {
		assertEquals(0,pensionerDetail.getAllowances());
	}
	
	@Test
	public void dateOfBirthTest() {
		assertEquals(LocalDate.parse("01/01/1999", formatter), pensionerDetail.getDateOfBirth());
	}
	
	@Test
	public void familyPensionTest() {
		assertEquals(false, pensionerDetail.isFamilyPension());
	}
	@Test
	public void panTest() {
		assertEquals("0", pensionerDetail.getPan());
	}
	
	@Test
	public void salaryEarnedTest() {
		assertEquals(0, pensionerDetail.getSalaryEarned());
	}
	
	@Test
	public void bankDetailTest() {
		assertEquals((new BankDetail("0", "0", "0")).toString(),bankDetail.toString());
	}
	
	@Test
	public void testToString() {
		PensionerDetail pensionerDetailR = new PensionerDetail("",LocalDate.parse("01/01/1999", formatter) , "0", 0, 0, "0", false, bankDetail);
		assertEquals(pensionerDetail.toString(), pensionerDetailR.toString());
	}
}
