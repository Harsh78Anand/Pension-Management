package com.cognizant.pensiondisbursement.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProcessPensionInputDto {
	
	private String aadhaarNumber;
	private Double pensionAmount;
	private Integer bankServiceCharge;

}
