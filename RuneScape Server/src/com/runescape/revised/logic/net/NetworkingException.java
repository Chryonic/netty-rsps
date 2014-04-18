package com.runescape.revised.logic.net;

public class NetworkingException extends Exception {

	private static final long serialVersionUID = 1L;

	public NetworkingException() {
		super();
	}
	
	public NetworkingException(String message) {
		super(message);
	}
	
	public NetworkingException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public NetworkingException(Throwable cause) {
		super(cause);
	}
}