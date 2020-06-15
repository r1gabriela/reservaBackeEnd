package com.lpi.reserva.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor @Setter @Getter
public class ErrorObject {
	
    private final String message;
    
    private final String field;
    
    private final Object parameter;
	
}