package com.mfpe.pension.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mfpe.pension.feign.AuthorisationClient;
import com.mfpe.pension.feign.PensionDisbursementClient;
import com.mfpe.pension.feign.PensionerDetailClient;
import com.mfpe.pension.model.BankDetail;
import com.mfpe.pension.model.PensionDetail;
import com.mfpe.pension.model.PensionerDetail;
import com.mfpe.pension.model.PensionerInput;
import com.mfpe.pension.model.ProcessPensionInput;
import com.mfpe.pension.model.ProcessPensionResponse;
import com.mfpe.pension.repository.PensionDetailRepository;
import com.mfpe.pension.service.PensionDetailService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProcessPensionController.class)
public class ProcessPensionControllerTest {
	@MockBean
	AuthorisationClient authorisationClient;

	@MockBean
	private PensionDetailRepository pensionDetailRepository;

	@MockBean
	private PensionDisbursementClient pensionDisbursementClient;
	

	@MockBean
	PensionDetailService pensionDetailService;
	
	@MockBean
	private PensionerDetailClient pensionerDetailClient;

	ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		
		
		
		when(authorisationClient.validate("user1")).thenReturn(true);
		LocalDate date = LocalDate.of(1997, 10, 12);
		PensionDetail pensionDetail = new PensionDetail("xyz2323", "John", date, 15000, true);

		PensionerDetail pensionerDetail = new PensionerDetail("John", date, "xyz2323", 25000, 5000, "123232", true,
				new BankDetail("ICIC", "2232", "public"));
		
		ProcessPensionInput processPensionInput = new ProcessPensionInput("123232", 15000, 500);

		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse(10);
		
		when(pensionerDetailClient.getPensionDetailByAadhaar("user1", "123232")).thenReturn(pensionerDetail);
		when(pensionDetailService.calculatePensionAmount(pensionerDetail)).thenReturn(pensionDetail);
		when(pensionDisbursementClient.disbursePension("user1", processPensionInput))
				.thenReturn(processPensionResponse);
	}

	@Test
	public void testGetPension() throws Exception {
		
		when(pensionDetailService.validate(Mockito.any(PensionerInput.class), Mockito.any(PensionerDetail.class))).thenReturn(true);
		String inputObject = "{\"aadhaarNumber\": \"123232\",\"name\": \"John\",\"dateOfBirth\": \"1997-10-12\",\"pan\":\"xyz2323\",\"familyPension\": true}";	
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/process/pensionDetail")
				.contentType(MediaType.APPLICATION_JSON).header("Authorization", "user1").content(inputObject)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		assertEquals(200, result.getResponse().getStatus());

	}
	
	@Test
	public void testGetPensionInvalidValidation() throws Exception {

		when(pensionDetailService.validate(Mockito.any(PensionerInput.class), Mockito.any(PensionerDetail.class))).thenReturn(false);
		String inputObject = "{\"aadhaarNumber\": \"123232\",\"name\": \"John\",\"dateOfBirth\": \"1997-10-12\",\"pan\":\"xyz2323\",\"familyPension\": true}";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/process/pensionDetail")
				.contentType(MediaType.APPLICATION_JSON).header("Authorization", "user1").content(inputObject)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse().getContentAsString());
		assertEquals(404, result.getResponse().getStatus());

	}
	
	@Test
	public void testGetPensionWithoutAuthorization() throws Exception {

		String inputObject = "{\"aadhaarNumber\": \"123232\",\"name\": \"John\",\"dateOfBirth\": \"1997-10-12\",\"pan\":\"xyz2323\",\"familyPension\": true}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/process/pensionDetail")
				.contentType(MediaType.APPLICATION_JSON).header("Authorization", "user2").content(inputObject)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assertEquals(403, result.getResponse().getStatus());

	}
	
	@Test(expected = Exception.class)
	public void testProcessPension() throws Exception {
		String inputObject = "{\"aadhaarNumber\": \"123232\",\"pensionAmount\": 15000,\"bankServiceCharge\": 500}";
		ProcessPensionInput processPensionInputs = new ProcessPensionInput("123232", 15000, 500);

		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse(10);
		when(pensionDisbursementClient.disbursePension("user1", processPensionInputs))
				.thenReturn(processPensionResponse);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/process/processPension")
				.contentType(MediaType.APPLICATION_JSON).header("Authorization", "user1").content(inputObject)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
	
		
	}
	
	
	@Test(expected = Exception.class)
	public void testProcessPensionWithoutAuthorisation() throws Exception {
		String inputObject = "{\"aadhaarNumber\": \"123232\",\"pensionAmount\": 15000,\"bankServiceCharge\": 500}";
		ProcessPensionInput processPensionInputs = new ProcessPensionInput("123232", 15000, 500);

		ProcessPensionResponse processPensionResponse = new ProcessPensionResponse(10);
		when(pensionDisbursementClient.disbursePension("user1", processPensionInputs))
				.thenReturn(processPensionResponse);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/process/processPension")
				.contentType(MediaType.APPLICATION_JSON).header("Authorization", "user1").content(inputObject)
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
	}
	
}
