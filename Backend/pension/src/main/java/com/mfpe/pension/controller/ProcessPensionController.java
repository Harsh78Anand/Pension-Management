package com.mfpe.pension.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mfpe.pension.exception.PensionDetailsNotFound;
import com.mfpe.pension.feign.AuthorisationClient;
import com.mfpe.pension.feign.PensionDisbursementClient;
import com.mfpe.pension.feign.PensionerDetailClient;
import com.mfpe.pension.model.PensionDetail;
import com.mfpe.pension.model.PensionerInput;
import com.mfpe.pension.model.ProcessPensionInput;
import com.mfpe.pension.service.PensionDetailService;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/process")
public class ProcessPensionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProcessPensionController.class);

	@Autowired
	private PensionDetailService pensionDetailService;

	@Autowired
	private PensionerDetailClient pensionerDetailClient;
	

	@Autowired
	private PensionDisbursementClient pensionDisbursementClient;
	
	@Autowired
	private AuthorisationClient authClient;

	@PostMapping("/pensionDetail")
	@ApiOperation(value = "Gets Pension details from pensioner input", notes="Provide pensioner details to get specific corrresponding details")
	public ResponseEntity<PensionDetail> getPensionDetail(@RequestHeader(name = "Authorization") String token,
			@RequestBody PensionerInput pensionerInput) throws PensionDetailsNotFound {
		LOGGER.info("Inside getPensionDetail()");
		if (authClient.validate(token)) {
			LOGGER.info("PensionerInput:{}", pensionerInput);
			var pensionerDetail = pensionerDetailClient.getPensionDetailByAadhaar(token,
					pensionerInput.getAadhaarNumber());
			
			if (!(pensionDetailService.validate(pensionerInput, pensionerDetail))) {
				LOGGER.info("Validation Failed");
				throw new PensionDetailsNotFound("Pension details not found");
			}
			LOGGER.info("PensionDetail:{}", pensionDetailService.calculatePensionAmount(pensionerDetail));
			return new ResponseEntity<>(pensionDetailService.calculatePensionAmount(pensionerDetail), HttpStatus.OK) ;
		}
		else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}
	
	@PostMapping("/processPension")
	@ApiOperation(value = "Gets response from process input", notes="Provide process pension input to get validation response according to the input provided")
	public ResponseEntity<Integer> processPension(@RequestHeader(name = "Authorization") String token, @RequestBody ProcessPensionInput processPensionInput) {
		
		LOGGER.info("Inside processPension()");
		if (authClient.validate(token)) {
			LOGGER.info("ProcessPension:{}", processPensionInput);
			var processPensionResponse = pensionDisbursementClient.disbursePension(token, processPensionInput);
			LOGGER.info("ProcessPensionResponse:{}", processPensionResponse);
			LOGGER.info("End processPension() method");
			return new ResponseEntity<>(processPensionResponse.getProcessPensionStatusCode(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

}
