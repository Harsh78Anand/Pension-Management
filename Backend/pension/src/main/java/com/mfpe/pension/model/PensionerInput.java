package com.mfpe.pension.model;

import java.time.LocalDate;

import javax.persistence.Id;



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
public class PensionerInput {

	@Id
	private String aadhaarNumber;
	private String name;
	private LocalDate dateOfBirth;
	private String pan;
	private boolean familyPension;
}
