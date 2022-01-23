package com.cognizant.pensiondisbursement.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.pensiondisbursement.dto.ProcessPensionInputDto;
import com.cognizant.pensiondisbursement.exception.PensionerDetailsNotFound;
import com.cognizant.pensiondisbursement.feign.AuthorisationClient;
import com.cognizant.pensiondisbursement.feign.PensionerDetailClient;
import com.cognizant.pensiondisbursement.model.ProcessPensionResponse;
import com.cognizant.pensiondisbursement.pojo.PensionerDetail;
import com.cognizant.pensiondisbursement.service.PensionDisbursementService;

import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("/disbursement")
public class PensionDisbursementController {

	@Autowired
	private PensionerDetailClient pensionerDetailClient;
	
	@Autowired
	private PensionDisbursementService pensionDisbursementService;

	@Autowired
	private AuthorisationClient authClient;

	private static final Logger LOGGER = LoggerFactory.getLogger(PensionDisbursementController.class);

	
	
	ProcessPensionResponse processPensionResponse = new ProcessPensionResponse(); 

	@PostMapping("/disbursePension")
	@ApiOperation(value = "Gets process response from process input", notes="Provide process pension input to get validation response according to the input provided")
	public ResponseEntity<ProcessPensionResponse> disbursePension(@RequestHeader("Authorization") String token,
			@RequestBody ProcessPensionInputDto processPensionInput) throws PensionerDetailsNotFound {

		if (authClient.validate(token)) {
			LOGGER.info("Inside DisbursePension()");
			PensionerDetail pensionerDetail = pensionerDetailClient.getPensionDetailByAadhaar(token,
					processPensionInput.getAadhaarNumber());
			LOGGER.info("PensionerDetail:{}", pensionerDetail);
			processPensionResponse = pensionDisbursementService.validateChargeAndPension(processPensionInput, pensionerDetail);		
			LOGGER.info("End PensionerDetail");
			
			return new ResponseEntity<>(processPensionResponse, HttpStatus.OK);
		}
		
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	
	}
	
}
