package com.cognizant.pensiondisbursement.pojo;

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
public class BankDetail {
	
	private String bankName;
	private String accountNumber;
	private String bankType;

}