package com.mfpe.pension.service;

import java.time.LocalDate;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mfpe.pension.model.PensionDetail;
import com.mfpe.pension.model.PensionerDetail;
import com.mfpe.pension.model.PensionerInput;
import com.mfpe.pension.repository.PensionDetailRepository;



@Service
public class PensionDetailService {
	
	@Autowired 
	private PensionDetailRepository pensionDetailRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PensionDetailService.class);
	
	public PensionDetail calculatePensionAmount(PensionerDetail pensionerDetail) {
		
		LOGGER.info("Inside calculatePensionAmount()");
		double lastSalary = 0;
		double allowances = 0;
		lastSalary = pensionerDetail.getSalaryEarned();
		allowances = pensionerDetail.getAllowances();
		var pensionDetail = new PensionDetail(pensionerDetail.getPan(), pensionerDetail.getName(), pensionerDetail.getDateOfBirth() , 0, pensionerDetail.isFamilyPension());
		LOGGER.info("PensionDetail:{}", pensionDetail);
		if (pensionerDetail.isFamilyPension()) {
			pensionDetail.setPensionAmount( (allowances + lastSalary) * 0.5);
		}
		else {
			pensionDetail.setPensionAmount( (allowances + lastSalary) * 0.8);
		}
		Optional<PensionDetail> pensionDetailRepo = pensionDetailRepository.findById(pensionDetail.getPan());
		if (! (pensionDetailRepo.isPresent()) ) {
			pensionDetailRepository.save(pensionDetail);
		}
		LOGGER.info("End calculatePensionAmount()");
		return pensionDetail;
	}
	public boolean validate(PensionerInput pensionerInput, PensionerDetail pensionerDetail) {

		LOGGER.info("Inside validate()");
		String pensionerDetailName = pensionerDetail.getName().trim();
		String pensionerDetailPan = pensionerDetail.getPan().trim();
		LocalDate pensionerDetailDob = pensionerDetail.getDateOfBirth();
		LocalDate pensionerInputDob = pensionerInput.getDateOfBirth();
		boolean pensionerDetailFamilyPension = pensionerInput.isFamilyPension();
		boolean pensionerInputFamilyPension = pensionerDetail.isFamilyPension();
		String pensionerInputName = pensionerInput.getName().trim();
		String pensionerInputPan = pensionerInput.getPan().trim();
		LOGGER.info("End validate method");
		return ( pensionerDetailName.equalsIgnoreCase(pensionerInputName) 
				&& (pensionerDetailPan.equalsIgnoreCase(pensionerInputPan)) 
				&& (pensionerDetailFamilyPension == pensionerInputFamilyPension) 
				&& pensionerDetailDob.equals(pensionerInputDob));
	}
	
}
