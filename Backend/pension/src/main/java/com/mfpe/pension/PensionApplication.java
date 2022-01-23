package com.mfpe.pension;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class PensionApplication {

	public static void main(String[] args) {
		SpringApplication.run(PensionApplication.class, args);
	}

}
