package com.cognizant.pensionerdetail.services;


import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.pensionerdetail.exception.AadhaarNumberNotFoundException;
import com.cognizant.pensionerdetail.models.BankDetail;
import com.cognizant.pensionerdetail.models.PensionerDetail;
import com.cognizant.pensionerdetail.repository.BankDetailRepository;
import com.cognizant.pensionerdetail.repository.PensionerDetailRepository;
import com.cognizant.pensionerdetail.utils.ReadCsvUtil;

@Service
public class PensionerDetailService {
	
	private static List<PensionerDetail> pensionerDetails = new ArrayList<>();

	ReadCsvUtil csvRead = new ReadCsvUtil();
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PensionerDetailService.class);
	
	private BankDetailRepository bankDetailRepository;
	
	private PensionerDetailRepository pensionerDetailRepository;
	
	
	@Autowired
	public PensionerDetailService(BankDetailRepository bankDetailRepository, PensionerDetailRepository pensionerDetailRepository) {
		this.bankDetailRepository = bankDetailRepository;
		this.pensionerDetailRepository = pensionerDetailRepository;
		try {
			List<String[]> list = csvRead.readData();
			for(int i=1;i<list.size();i++) {
				String name = list.get(i)[0];
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate date = LocalDate.parse(list.get(i)[1], formatter);
				String pan = list.get(i)[2];
				int salary = Integer.parseInt(list.get(i)[3]);
				int allowance = Integer.parseInt(list.get(i)[4]);
				String aadhaar = list.get(i)[5];
				boolean familyPension = Boolean.parseBoolean(list.get(i)[6]);
				BankDetail bankDetail = new BankDetail(list.get(i)[7].split("/")[0], list.get(i)[7].split("/")[1], list.get(i)[7].split("/")[2]);
				PensionerDetail pensionerDetail = new PensionerDetail(name,date,pan,salary,allowance,aadhaar, familyPension,bankDetail);
				pensionerDetails.add(pensionerDetail);	
				this.bankDetailRepository.save(bankDetail);
				
			}
		} catch (IOException e) {
			LOGGER.debug(e.getMessage());
		}
	
		
	}
	
	@Transactional
	public PensionerDetail findPensionDetailByAadhaar(String aadhaar) throws AadhaarNumberNotFoundException{
		LOGGER.info("Inside findPensionDetailByAadhaar()");
		for(PensionerDetail pensionerDetail: pensionerDetails) {
			if(pensionerDetail.getAadhaarNumber().equals(aadhaar)) {
				LOGGER.info("PensionerDetail:{}", pensionerDetail);
				this.pensionerDetailRepository.save(pensionerDetail);
				return pensionerDetail;
			}
		}
		throw new AadhaarNumberNotFoundException("Aadhaar Number is Not Found");
		
	}

}
