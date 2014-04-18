package com.runescape.revised.content.guild;

public class GuildException extends Exception {

	private static final long serialVersionUID = 1L;

	public GuildException() {
		super();
	}
	
	public GuildException(String message) {
		super(message);
	}
	
	public GuildException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public GuildException(Throwable cause) {
		super(cause);
	}
}