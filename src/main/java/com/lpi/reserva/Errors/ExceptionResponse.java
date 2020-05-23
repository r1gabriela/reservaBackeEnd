package com.lpi.reserva.Errors;

public class ExceptionResponse extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8334107662077812339L;

	public ExceptionResponse(String message) {
		super(message);
	}

}
