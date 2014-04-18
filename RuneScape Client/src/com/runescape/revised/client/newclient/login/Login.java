package com.runescape.revised.client.newclient.login;

import com.runescape.revised.client.newclient.GameClient;

public class Login {

	private String username;
	private String password;
	
	public Login(LoginFrame loginFrame, String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
		new GameClient();
		loginFrame.shutdown();
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}
}