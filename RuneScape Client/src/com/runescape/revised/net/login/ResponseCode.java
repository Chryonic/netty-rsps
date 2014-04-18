package com.runescape.revised.net.login;

public enum ResponseCode {
	
	WAIT_AND_COUNT_FAILURES((byte) -1, null, null),
	EXCHANGE((byte) 0, null, null),
	WAIT((byte) 1, null, null),
	LOGIN((byte) 2, null, null),
	INVALID_USER_PASS((byte) 3, "Invalid username or password.", ""),
	ACCOUNT_DISABLED((byte) 4, "Your account has been disabled.", "Please check your message center for details."),
	ALREADY_LOGGED_IN((byte) 5, "Your account is already logged in.", "Try again in 60 seconds."),
	UPDATE((byte) 6, "RuneScape has been updated!", "Please reload this page."),
	WORLD_FULL((byte) 7, "This world is full.", "Please use a different world."),
	LOGIN_SERVER_OFFLINE((byte) 8, "Unable to connect.", "Login server offline."),
	LIMIT_EXCEEDED((byte) 9, "Login limit exceeded.", "Too many connections from your address."),
	BAD_SESSION_ID((byte) 10, "Unable to connect.", "Bad session id."),
	REJECTED_SESSION((byte) 11, "Login server rejected session.", "Please try again."),
	MEMBERS_NEEDED((byte) 12, "You need a members account to login to this world.", "Please subscribe, or use a different world."),
	INCOMPLETE_LOGIN((byte) 13, "Could not complete login.", "Please try using a different world."),
	SERVER_UPDATE((byte) 14, "The server is being updated.", "Please wait 1 minute and try again."),
	UNKNOWN((byte) 15, "", ""),
	LOGIN_ATTEMPTS_EXCEEDED((byte) 16, "Login attempts exceeded.", "Please wait 1 minute and try again."),
	MEMBERS_ONLY_AREA((byte) 17, "You are standing in a members-only area.", "To play on this world move to a free area first."),
	INVALID_LOGINSERVER((byte) 20, "Invalid loginserver requested.", "Please try using a different world."),
	TRANSFER((byte) 21, "You have only just left another world.", "Your profile will be transferred in: 10 seconds."),
	UNEXPECTED_SERVER_RESPONSE((byte) 22, "Unexpected server response.", "Please try using a different world.");
	
	private byte value;
	private String firstResponse;
	private String secondResponse;
	
	ResponseCode(byte value, String firstResponse, String secondResponse) {
		this.setValue(value);
		this.setFirstResponse(firstResponse);
		this.setSecondResponse(secondResponse);
	}
	
	public void setValue(byte value) {
		this.value = value;
	}
	
	public byte getValue() {
		return this.value;
	}
	
	public void setFirstResponse(String firstResponse) {
		this.firstResponse = firstResponse;
	}
	
	public String getFirstResponse() {
		return this.firstResponse;
	}

	public void setSecondResponse(String secondResponse) {
		this.secondResponse = secondResponse;
	}

	public String getSecondResponse() {
		return this.secondResponse;
	}
}