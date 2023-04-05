package it.amedea.rest.common.controllers;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import it.amedea.rest.common.exceptions.RestException;
import it.amedea.rest.common.exceptions.UnauthorizedException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<RestException> unauthorizedException(UnauthorizedException ex){
		RestException restExcpetion = new RestException(null, null, false, false);
		restExcpetion.setStatusCode(new BigDecimal(1));
		restExcpetion.setAction("Verifica Credenziali");
		restExcpetion.setStatusMessage(ex.getLocalizedMessage());
		return new ResponseEntity<RestException>(restExcpetion, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<RestException> illegalException(IllegalArgumentException ex){
		RestException restExcpetion = new RestException(null, null, false, false);
		restExcpetion.setStatusCode(new BigDecimal(1));
		restExcpetion.setAction("Verifica Parametri Input");
		restExcpetion.setStatusMessage(ex.getLocalizedMessage());
		return new ResponseEntity<RestException>(restExcpetion, HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(RestException.class)
	public ResponseEntity<RestException> restException(RestException ex){
		return new ResponseEntity<RestException>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
