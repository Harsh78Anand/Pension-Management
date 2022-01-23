package com.cognizant.pensionerdetail.exception;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
public class CustomErrorResponse {
	
	private String message;
	private LocalDateTime dateTime;

}
