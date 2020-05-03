package com.cg.userException;

public class AddmoneyServiceException extends Exception{
	String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public AddmoneyServiceException(String message) {
		super();
		this.message = message;
	}

	public AddmoneyServiceException() {
		super();
	}
	
}
