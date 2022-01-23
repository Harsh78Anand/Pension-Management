package com.mfpe.pension.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class PensionDetailTest {
	private PensionDetail pensionDetail;
	@Before
	public void setUp() throws Exception {
		LocalDate date = LocalDate.of(1997, 10, 12);
		pensionDetail = new PensionDetail("xyz2323", "John", date, 15000, true);
	}
	@Test
	public void testGetter() {
		assertEquals("John", pensionDetail.getName());
		assertEquals("xyz2323", pensionDetail.getPan());
		assertEquals(15000, pensionDetail.getPensionAmount());
	}
	
	@Test
	public void testSetter() {
		pensionDetail.setFamilyPension(false);
		assertEquals(false, pensionDetail.isFamilyPension());
	}
}
