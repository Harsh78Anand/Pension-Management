package com.cognizant.pensiondisbursement.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.cognizant.pensiondisbursement.dao.PensionDisbursementDao;
import com.cognizant.pensiondisbursement.dto.ProcessPensionInputDto;
import com.cognizant.pensiondisbursement.exception.PensionerDetailsNotFound;
import com.cognizant.pensiondisbursement.model.ProcessPensionResponse;
import com.cognizant.pensiondisbursement.pojo.BankDetail;
import com.cognizant.pensiondisbursement.pojo.PensionerDetail;

@RunWith(MockitoJUnitRunner.class)
public class PensionDisbursementServiceTest {
	
	
	@Mock
	PensionDisbursementDao pensionDao;
	
	@InjectMocks
	PensionDisbursementService pensionService;
	
	private PensionerDetail pensionerDetail;
	private BankDetail bankDetail;
	private ProcessPensionResponse processResponse;

	private ProcessPensionInputDto processPensionInput;
	
	@Before
	 public void setUp() throws Exception {
		
		processPensionInput = new ProcessPensionInputDto("123232",15000.0,500);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse("12/10/1997", formatter);
		bankDetail = new BankDetail("ICICI","2913289862","public");
		pensionerDetail = new PensionerDetail("John", date,"xyz2323", 25000, 5000, "123232", true, bankDetail);
		processResponse =  new ProcessPensionResponse(10);
		when(pensionDao.getPension(pensionerDetail)).thenReturn(15000.0);
	
		
	}
	
	@Test
	public void validateChargeAndPensionPublicTest() throws PensionerDetailsNotFound {
		assertEquals(processResponse.getProcessPensionStatusCode(), pensionService.validateChargeAndPension(processPensionInput, pensionerDetail).getProcessPensionStatusCode());
	}
	
	@Test
	public void validateChargeAndPensionPrivateTest() throws PensionerDetailsNotFound {
		processPensionInput = new ProcessPensionInputDto("123232",15000.0,550);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse("12/10/1997", formatter);
		bankDetail = new BankDetail("ICICI","2913289862","private");
		pensionerDetail = new PensionerDetail("John", date,"xyz2323", 25000, 5000, "123232", true, bankDetail);
		when(pensionDao.getPension(pensionerDetail)).thenReturn(15000.0);
		assertEquals(processResponse.getProcessPensionStatusCode(), pensionService.validateChargeAndPension(processPensionInput, pensionerDetail).getProcessPensionStatusCode());
	}
	
	@Test
	public void validateChargeAndPensioninvalidTest() throws PensionerDetailsNotFound {
		processResponse.setProcessPensionStatusCode((Integer)21);
		processPensionInput = new ProcessPensionInputDto("111111",(Double)25000.0,(Integer)100);
		assertEquals(processResponse.getProcessPensionStatusCode(), pensionService.validateChargeAndPension(processPensionInput, pensionerDetail).getProcessPensionStatusCode());
	}
	
	
	@Test(expected = PensionerDetailsNotFound.class)
	public void testPensionerDetailsNotFoundExceptionForValidate() throws PensionerDetailsNotFound{
		 pensionerDetail.setBankDetail(new BankDetail("ICICI","2913289862",""));
		 pensionService.validateChargeAndPension(processPensionInput, pensionerDetail);
	} 
	
	
}
