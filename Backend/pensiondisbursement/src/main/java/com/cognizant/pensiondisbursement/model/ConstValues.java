package com.cognizant.pensiondisbursement.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ConstValues {
	
  PUBLIC(500),PRIVATE(550),SUCCESS(10),FAILURE(21);
	
	private Integer val;

}
