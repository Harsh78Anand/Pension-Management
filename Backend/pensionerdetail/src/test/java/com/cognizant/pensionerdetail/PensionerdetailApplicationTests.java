package com.cognizant.pensionerdetail;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class PensionerdetailApplicationTests {

	@Test
	void appplicationStarts() throws IOException {
		PensionerdetailApplication.main(new String[] {});
		assertTrue(true);
	}

}
