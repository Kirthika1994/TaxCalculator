package com.taxcalculator.demo.exception;

public class NoTradeFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public NoTradeFoundException(String message) {
		super(message);
	}

	public NoTradeFoundException() {
	}
}
