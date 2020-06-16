package com.lpi.reserva.Exception;

import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor @Getter @Setter
public class CustomException{
	
	private final String message;
	
	private final int httpStatus;
	
	private final ZonedDateTime timestamp;

}