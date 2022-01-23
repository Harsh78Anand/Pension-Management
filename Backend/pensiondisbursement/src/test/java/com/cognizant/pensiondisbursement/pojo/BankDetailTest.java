package com.cognizant.pensiondisbursement.pojo;

import org.junit.Test;
import org.meanbean.test.BeanTester;

public class BankDetailTest {
	
	@Test
	public void testPojoBankDetail() {
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(BankDetail.class);
	}

}
