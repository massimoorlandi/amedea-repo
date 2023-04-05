package it.amedea.rest.common.exceptions;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class RestException extends Exception{

	private static final long serialVersionUID = 1234567L;
	public  enum StatusValues  {STATUS_OK,STATUS_ERROR};
	
    private StatusValues status = StatusValues.STATUS_ERROR;
	private BigDecimal statusCode;
	private String statusMessage;
	private String action;

	public RestException() {	
	}
	
	public RestException(String message) {	
		super(message);
	}

	public RestException(String message, Throwable throwable, boolean enableSuppression,boolean  writableStackTrace) {	
		super(message, throwable, enableSuppression, writableStackTrace);
	}

}
