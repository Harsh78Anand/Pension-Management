package com.cognizant.pensionerdetail.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.pensionerdetail.exception.AadhaarNumberNotFoundException;
import com.cognizant.pensionerdetail.exception.PensionerDetailNotFound;
import com.cognizant.pensionerdetail.feign.AuthorisationClient;
import com.cognizant.pensionerdetail.models.PensionerDetail;
import com.cognizant.pensionerdetail.services.PensionerDetailService;

@RestController
@RequestMapping("/details")
public class PensionerDetailController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PensionerDetailController.class);
	
	@Autowired
	private AuthorisationClient authClient;
	 
	@Autowired
	private PensionerDetailService pensionerDetailService;
	
	@GetMapping("/health-check")
	public ResponseEntity<String> healthCheck() {
		return new ResponseEntity<>("Ok", HttpStatus.OK);
	}
	
	@GetMapping("/PensionDetailByAadhaar")
	public ResponseEntity<PensionerDetail> getPensionDetailByAadhaar(@RequestHeader(name = "Authorization") String token,  @RequestParam String aadhaarNumber) throws AadhaarNumberNotFoundException, PensionerDetailNotFound{
		LOGGER.info("START");
		LOGGER.info(aadhaarNumber);
		LOGGER.info("END");
		if(authClient.validate(token)) { 
			LOGGER.info("Inside If");
			return new ResponseEntity<>(pensionerDetailService.findPensionDetailByAadhaar(aadhaarNumber),HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.FORBIDDEN);
	}

}
