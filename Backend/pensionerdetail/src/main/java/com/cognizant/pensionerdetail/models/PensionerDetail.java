package com.cognizant.pensionerdetail.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "pensionerdetail")
public class PensionerDetail {
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "dob")
	private LocalDate dateOfBirth;
	
	@Column(name = "pan")
	private String pan;
	
	@Column(name = "salaryearned")
	private int salaryEarned;
	
	@Column(name = "allowances")
	private int allowances;
	
	@Id
	@Column(name = "aadhaarnumber")
	private String aadhaarNumber;
	
	@Column(name = "familypension")
	private boolean familyPension;
	
	
	@OneToOne
	private BankDetail bankDetail;

}
