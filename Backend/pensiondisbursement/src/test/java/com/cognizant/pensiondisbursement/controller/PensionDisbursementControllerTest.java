package com.cognizant.pensiondisbursement.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cognizant.pensiondisbursement.dto.ProcessPensionInputDto;
import com.cognizant.pensiondisbursement.feign.AuthorisationClient;
import com.cognizant.pensiondisbursement.feign.PensionerDetailClient;
import com.cognizant.pensiondisbursement.model.ProcessPensionResponse;
import com.cognizant.pensiondisbursement.pojo.BankDetail;
import com.cognizant.pensiondisbursement.pojo.PensionerDetail;
import com.cognizant.pensiondisbursement.service.PensionDisbursementService;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@WebMvcTest(PensionDisbursementController.class)
public class PensionDisbursementControllerTest {
	
	@MockBean
	AuthorisationClient authClient;
	
	@MockBean
	PensionDisbursementService pensionDisbursementService;
	
	@MockBean
	PensionerDetailClient pensionerDetailClient;
	
	
	ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private MockMvc mockMvc;
	
	private ProcessPensionInputDto processPensionInput;
	private ProcessPensionResponse processResponse;
	private PensionerDetail pensionerDetail;
	private BankDetail bankDetail;
	
	@Before
	public void Setup() throws Exception{
		
		processPensionInput = new ProcessPensionInputDto("111111",(Double)25000.0,(Integer)100);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse("12/10/1997", formatter);
		bankDetail = new BankDetail("ICICI","2913289862","public");
		pensionerDetail = new PensionerDetail("John", date,"xyz2323", 25000, 5000, "123232", true, bankDetail);
		processResponse =  new ProcessPensionResponse((Integer)21);
		when(authClient.validate("user1")).thenReturn(true);
		when(pensionDisbursementService.validateChargeAndPension(processPensionInput, pensionerDetail)).thenReturn(processResponse);
	
	}
	
	@Test
	public void testDisbursePension() throws Exception{
		String json = mapper.writeValueAsString(processResponse);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/disbursement/disbursePension")
				.header("Authorization", "user1").content(json).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(200, result.getResponse().getStatus());
			
	}

	@Test
	public void testDisbursePensionAuthorizationFailed() throws Exception {
		String json = mapper.writeValueAsString(processResponse);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/disbursement/disbursePension")
				.header("Authorization", "user2").content(json).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		assertEquals(403, result.getResponse().getStatus());
	}
	
	

}
