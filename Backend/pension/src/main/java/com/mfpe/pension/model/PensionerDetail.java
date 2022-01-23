package com.mfpe.pension.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class PensionerDetail {
	private String name;
	private LocalDate dateOfBirth;
	private String pan;
	private int salaryEarned;
	private int allowances;
	private String aadhaarNumber;
	private boolean familyPension;
	private BankDetail bankDetail;
}
