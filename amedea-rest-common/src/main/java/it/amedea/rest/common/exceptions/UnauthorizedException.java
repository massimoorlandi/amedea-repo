package it.amedea.rest.common.exceptions;

public class UnauthorizedException extends RuntimeException{
	public UnauthorizedException(String message, Throwable cause,
            boolean enableSuppression,
            boolean writableStackTrace) {
		super(message, cause, enableSuppression,writableStackTrace);
	}
}
