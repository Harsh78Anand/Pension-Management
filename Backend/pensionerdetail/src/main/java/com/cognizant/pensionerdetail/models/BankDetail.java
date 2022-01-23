package com.cognizant.pensionerdetail.models;



import javax.persistence.Column;
import javax.persistence.Entity;
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
@Entity(name="bankdetail")
public class BankDetail {
	
	@Column(name="bankname")
	private String bankName;
	@Id
	@Column(name="accountnumber")
	private String accountNumber;
	@Column(name="banktype")
	private String bankType;

}
