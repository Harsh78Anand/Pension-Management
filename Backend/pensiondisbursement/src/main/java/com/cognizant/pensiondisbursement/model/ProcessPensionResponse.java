package com.cognizant.pensiondisbursement.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProcessPensionResponse {
	
	@Id
	private Integer processPensionStatusCode;

}
