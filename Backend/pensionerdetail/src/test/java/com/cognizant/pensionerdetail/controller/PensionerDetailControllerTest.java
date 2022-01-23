package com.cognizant.pensionerdetail.controller;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.pensionerdetail.exception.AadhaarNumberNotFoundException;
import com.cognizant.pensionerdetail.exception.PensionerDetailNotFound;
import com.cognizant.pensionerdetail.feign.AuthorisationClient;
import com.cognizant.pensionerdetail.models.BankDetail;
import com.cognizant.pensionerdetail.models.PensionerDetail;
import com.cognizant.pensionerdetail.services.PensionerDetailService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

@RunWith(SpringRunner.class)
@WebMvcTest(PensionerDetailController.class)
@ContextConfiguration(classes = {PensionerDetailController.class ,PensionerDetailService.class})
public class PensionerDetailControllerTest {
	
	
	@MockBean
	private PensionerDetailService pensionerDetailService;
	
	@MockBean
	AuthorisationClient authClient;
	
	
	@Autowired
	private MockMvc mockMvc;
	
	ObjectMapper mapper = new ObjectMapper();
	
	@Mock
	BankDetail bankDetail;
	
	DateTimeFormatter formatter;
	LocalDate date;
	
	@Mock
	PensionerDetail pensionerDetail;
	
	@BeforeEach
	public void setup() throws Exception{

		mapper = new ObjectMapper()
	            .registerModule(new ParameterNamesModule())
	            .registerModule(new Jdk8Module())
	            .registerModule(new JavaTimeModule());
		bankDetail = new BankDetail("ICICI", "2232", "public");
		formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		date = LocalDate.parse("12/10/1997", formatter);
		pensionerDetail = new PensionerDetail("John", date, "xyz2323", 25000, 5000, "123232",true, bankDetail);
		when(pensionerDetailService.findPensionDetailByAadhaar("123232")).thenReturn(pensionerDetail);
		when(pensionerDetailService.findPensionDetailByAadhaar("1")).thenThrow(new AadhaarNumberNotFoundException("Aadhaar Number Not Found"));
		when(authClient.validate("user1")).thenReturn(true);
		
		
	}
	
	@Test
	public void healthCheck() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/details/health-check").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(200, result.getResponse().getStatus());
	}
	
	@Test
	public void invalidAadhaarNumberTest() throws Exception{
		
		when(authClient.validate(Mockito.anyString())).thenReturn(true);
		when(pensionerDetailService.findPensionDetailByAadhaar(Mockito.anyString())).thenThrow(new AadhaarNumberNotFoundException("Aadhaar Number Not Found"));
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/details/PensionDetailByAadhaar")
				.param("aadhaarNumber", "1")
				.header("Authorization", "user1").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals("Aadhaar Number Not Found", result.getResponse().getErrorMessage());
		
	}
	
	@Test
	public void validAadhaarNumberTest() throws Exception{
		
		mapper = new ObjectMapper()
	            .registerModule(new ParameterNamesModule())
	            .registerModule(new Jdk8Module())
	            .registerModule(new JavaTimeModule());
		bankDetail = new BankDetail("ICICI", "2232", "public");
		formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		date = LocalDate.parse("12/10/1997", formatter);
		pensionerDetail = new PensionerDetail("John", date, "xyz2323", 25000, 5000, "123232",true, bankDetail);
		when(authClient.validate(Mockito.anyString())).thenReturn(true);
		when(pensionerDetailService.findPensionDetailByAadhaar(Mockito.anyString())).thenReturn(pensionerDetail);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/details/PensionDetailByAadhaar")
				.param("aadhaarNumber", "123232")
				.header("Authorization", "user1").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		PensionerDetail pensionerDetailn = mapper.readValue(result.getResponse().getContentAsString(), PensionerDetail.class);
		assertEquals(pensionerDetailn.toString(), pensionerDetailService.findPensionDetailByAadhaar("123232").toString());
		
	}
	

}
