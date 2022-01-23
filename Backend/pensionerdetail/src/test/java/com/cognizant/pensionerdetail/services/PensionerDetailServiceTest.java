package com.cognizant.pensionerdetail.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import com.cognizant.pensionerdetail.exception.AadhaarNumberNotFoundException;
import com.cognizant.pensionerdetail.models.BankDetail;
import com.cognizant.pensionerdetail.models.PensionerDetail;
import com.cognizant.pensionerdetail.repository.BankDetailRepository;
import com.cognizant.pensionerdetail.repository.PensionerDetailRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PensionerDetailServiceTest {
	
	@MockBean
	PensionerDetailService pensionDetailService;
	
	@Mock
	PensionerDetailRepository pensionerDetailRepository;
	
	@Mock
	BankDetailRepository bankDetailRepository;
	
	@Mock
	BankDetail bankDetail;
	
	DateTimeFormatter formatter;
	
	LocalDate date;
	
	@Mock
	PensionerDetail pensionerDetail;
	
	
	@Before
	public void setup() throws Exception{
		
		bankDetail = new BankDetail("ICICI", "2232", "public");
		formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		date = LocalDate.parse("12/10/1997", formatter);
		pensionerDetail = new PensionerDetail("John", date, "xyz2323", 25000, 5000, "123232",true, bankDetail);
	}
	
	@Test
	public void validAadhaarNumberTest() throws Exception{
		when(pensionDetailService.findPensionDetailByAadhaar("123232")).thenReturn(pensionerDetail);
		PensionerDetail pd = pensionDetailService.findPensionDetailByAadhaar("123232");
		assertEquals("123232", pd.getAadhaarNumber());
		
	}
	
	@Test(expected = AadhaarNumberNotFoundException.class)
	public void invalidAadhaarNumberTest() throws Exception{
		when(pensionDetailService.findPensionDetailByAadhaar("0")).thenThrow(new AadhaarNumberNotFoundException("aadhar not found"));
		PensionerDetail pd = pensionDetailService.findPensionDetailByAadhaar("0");
	}

}
