package com.cognizant.pensiondisbursement.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.cognizant.pensiondisbursement.pojo.BankDetail;
import com.cognizant.pensiondisbursement.pojo.PensionerDetail;

@RunWith(MockitoJUnitRunner.class)
public class PensionDisbursementDaoImplTest {
	
	@InjectMocks
	private PensionDisbursementDaoImpl pensionDisbusreDao;
	
	
	private PensionerDetail pensionerDetail;
	private BankDetail bankDetail;
	
	@Before
	public void setUp() throws Exception{
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse("12/10/1997", formatter);
		bankDetail = new BankDetail("ICICI","2913289862","public");
		pensionerDetail = new PensionerDetail("John", date,"xyz2323", 25000, 5000, "123232", true, bankDetail);
		
		
		
	}
	
	@Test
	public void testGetPension() {
		
		assertEquals(15000.0, pensionDisbusreDao.getPension(pensionerDetail));
	}

}
