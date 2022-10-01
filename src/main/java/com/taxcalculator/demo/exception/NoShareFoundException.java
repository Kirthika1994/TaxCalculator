package com.taxcalculator.demo.exception;

public class NoShareFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoShareFoundException(String message) {
		super(message);
	}

	public NoShareFoundException() {
	}

}
