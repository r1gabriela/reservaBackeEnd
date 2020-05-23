package com.lpi.reserva.Exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	  @Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	        List<ErrorObject> errors = getErrors(ex);
	        ErrorResponse errorResponse = getErrorResponse(ex, status, errors);
	        return new ResponseEntity<>(errorResponse, status);
	    }

	    private ErrorResponse getErrorResponse(MethodArgumentNotValidException ex, HttpStatus status, List<ErrorObject> errors) {
	        return new ErrorResponse("Requisição possui campos inválidos", status.value(),
	                status.getReasonPhrase(), ex.getBindingResult().getObjectName(), errors);
	    }

	    private List<ErrorObject> getErrors(MethodArgumentNotValidException ex) {
	        return ex.getBindingResult().getFieldErrors().stream()
	                .map(error -> new ErrorObject(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
	                .collect(Collectors.toList());
	    }
	    
	   @ExceptionHandler(ExceptionResponse.class)
	   public ResponseEntity<Object> handleAnyException(ExceptionResponse e, WebRequest request){
	    	CustomException exceptionResponse = new CustomException(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), ZonedDateTime.now(ZoneId.of("Z")));
	    	return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    
		
}