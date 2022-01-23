package com.cognizant.pensiondisbursement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PensiondisbursementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PensiondisbursementApplication.class, args);
	}

}
