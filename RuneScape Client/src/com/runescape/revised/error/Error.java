package com.runescape.revised.error;

public class Error {

	private String message;
	
	public Error(String message) {
		this.setMessage(message);
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
}