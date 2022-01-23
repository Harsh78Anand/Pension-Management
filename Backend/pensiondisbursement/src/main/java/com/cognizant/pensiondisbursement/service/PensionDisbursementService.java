package com.cognizant.pensiondisbursement.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.pensiondisbursement.dao.PensionDisbursementDao;
import com.cognizant.pensiondisbursement.dto.ProcessPensionInputDto;
import com.cognizant.pensiondisbursement.exception.PensionerDetailsNotFound;
import com.cognizant.pensiondisbursement.model.ConstValues;
import com.cognizant.pensiondisbursement.model.ProcessPensionResponse;
import com.cognizant.pensiondisbursement.pojo.PensionerDetail;

@Service
public class PensionDisbursementService {

	@Autowired
	private PensionDisbursementDao pensionDisbursementDao;
	

	private ProcessPensionResponse processPensionResponse= new ProcessPensionResponse();

	private static final Logger LOGGER = LoggerFactory.getLogger(PensionDisbursementService.class);

	public ProcessPensionResponse validateChargeAndPension(ProcessPensionInputDto processPensionInput, PensionerDetail pensionerDetail) throws PensionerDetailsNotFound {

		LOGGER.info("Inside validateChargeAndPension()");
		String bankType = pensionerDetail.getBankDetail().getBankType();
		double pensionCalulated = pensionDisbursementDao.getPension(pensionerDetail);
		
	
		if (bankType.equalsIgnoreCase("Public")) {
			

			if (processPensionInput.getBankServiceCharge().equals(ConstValues.PUBLIC.getVal())
					&& pensionCalulated == processPensionInput.getPensionAmount()) {
				processPensionResponse.setProcessPensionStatusCode(ConstValues.SUCCESS.getVal());
				return processPensionResponse;
			} else {
				processPensionResponse.setProcessPensionStatusCode(ConstValues.FAILURE.getVal());
				return processPensionResponse;
			}

		} else if (bankType.equalsIgnoreCase("Private")) {

			if (processPensionInput.getBankServiceCharge().equals(ConstValues.PRIVATE.getVal())
					&& pensionCalulated == processPensionInput.getPensionAmount()) {
				processPensionResponse.setProcessPensionStatusCode(ConstValues.SUCCESS.getVal());
				return processPensionResponse;
			} else {
				processPensionResponse.setProcessPensionStatusCode(ConstValues.FAILURE.getVal());
				return processPensionResponse;
			   }

		   }	
		   throw new PensionerDetailsNotFound("Pensioner Details not found");
				
		
	}

}
