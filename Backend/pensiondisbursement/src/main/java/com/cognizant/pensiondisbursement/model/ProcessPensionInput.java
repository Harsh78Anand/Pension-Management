package com.cognizant.pensiondisbursement.model;

import javax.persistence.Entity;
import javax.persistence.Id;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor


public class ProcessPensionInput {

	@Id
	private String aadhaarNumber;
	private Double pensionAmount;
	private Integer bankServiceCharge;

}
