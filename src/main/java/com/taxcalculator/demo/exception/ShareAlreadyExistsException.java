package com.taxcalculator.demo.exception;

public class ShareAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ShareAlreadyExistsException(String message) {
		super(message);
	}

	public ShareAlreadyExistsException() {
	}

}
