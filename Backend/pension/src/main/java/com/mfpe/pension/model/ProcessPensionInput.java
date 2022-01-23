package com.mfpe.pension.model;


import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor

public class ProcessPensionInput {
	@Id
	private String aadhaarNumber;
	private double pensionAmount;
	private int bankServiceCharge;
}
