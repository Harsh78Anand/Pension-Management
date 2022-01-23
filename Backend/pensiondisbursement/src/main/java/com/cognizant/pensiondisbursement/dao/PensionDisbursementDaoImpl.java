package com.cognizant.pensiondisbursement.dao;




import org.springframework.stereotype.Repository;

import com.cognizant.pensiondisbursement.pojo.PensionerDetail;


@Repository
public class PensionDisbursementDaoImpl implements PensionDisbursementDao {
	
	

	@Override
	public Double getPension(PensionerDetail pensionerDetail) {
		double lastSalary = 0; 
		double allowances = 0;
		lastSalary = pensionerDetail.getSalaryEarned();
		allowances = pensionerDetail.getAllowances();

		
		if (pensionerDetail.isFamilyPension()) {
			return ( (allowances + lastSalary) * 0.5);
		}
		else {
			return ( (allowances + lastSalary) * 0.8);
		}
		
	}
		
		
	
	

}
