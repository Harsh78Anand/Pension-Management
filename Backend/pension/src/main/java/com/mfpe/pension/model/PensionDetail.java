package com.mfpe.pension.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString

public class PensionDetail {
	@Id
	private String pan;
	private String name;
	private LocalDate dateOfBirth;
	private double pensionAmount;
	private boolean familyPension;

}
