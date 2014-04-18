package com.runescape.revised.logic.cycle;

public class CycleException extends Exception {

	private static final long serialVersionUID = 1L;

	public CycleException() {
		super();
	}
	
	public CycleException(String message) {
		super(message);
	}
	
	public CycleException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public CycleException(Throwable cause) {
		super(cause);
	}
}