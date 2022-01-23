package com.mfpe.pension.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.mfpe.pension.model.BankDetail;
import com.mfpe.pension.model.PensionDetail;
import com.mfpe.pension.model.PensionerDetail;
import com.mfpe.pension.model.PensionerInput;
import com.mfpe.pension.repository.PensionDetailRepository;


@RunWith(MockitoJUnitRunner.class) 

public class PensionDetailServiceTest {

	@Mock
	private PensionDetailRepository pensionDetailRepository;
	@InjectMocks
	private PensionDetailService pensionDetailService;

	private PensionDetail pensionDetail;
	private PensionerDetail pensionerDetail;
	private PensionerInput pensionerInput;

	
	@Before
	public void setUp() {
		LocalDate date = LocalDate.of(1997, 10, 12);
		pensionerDetail = new PensionerDetail("John", date, "xyz2323", 25000, 5000, "123232", true,
				new BankDetail("ICIC", "2232", "public"));
		pensionDetail = new PensionDetail("xyz2323", "John", date, 15000, true);
		pensionerInput = new PensionerInput("123232", "John", date, "xyz2323", true);

		//when(pensionDetailService.validate(pensionerInput, pensionerDetail)).thenReturn(true);
	}

	@Test
	public void testPensionAmountCalculated() {
		
		
		PensionDetail pensionDetailr =  pensionDetailService.calculatePensionAmount(pensionerDetail);
		assertEquals(pensionDetail.toString(), pensionDetailr.toString());
		

	}
	@Test
	public void testValidate() {
		
		
		//PensionDetail pensionDetailr =  pensionDetailService.calculatePensionAmount(pensionerDetail);
		assertTrue (pensionDetailService.validate(pensionerInput, pensionerDetail));
		

	}
	
	@Test
	public void testValidateFalse() {
		
		PensionerInput pensionerInput = new PensionerInput("1234", "Avikrit", LocalDate.now(), "23456", false);
		//PensionDetail pensionDetailr =  pensionDetailService.calculatePensionAmount(pensionerDetail);
		assertFalse (pensionDetailService.validate(pensionerInput, pensionerDetail));
		

	}

}
