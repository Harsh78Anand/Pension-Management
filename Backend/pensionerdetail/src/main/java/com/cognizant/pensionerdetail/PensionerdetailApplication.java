package com.cognizant.pensionerdetail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@EnableAutoConfiguration
@EnableJpaRepositories
public class PensionerdetailApplication {

	public static void main(String[] args) {
		SpringApplication.run(PensionerdetailApplication.class, args);
	}

}
