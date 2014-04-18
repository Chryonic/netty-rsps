package com.runescape.revised.net.login.screen;

public class LoginScreen {
	
	private Button newUser;
	private Button existingUser;
	private String login;
	private String cancel;
	private Logo logo;
	private Flame[] flames;
	
	public LoginScreen() {
		this.setNewUser(new Button("New User"));
		this.setExistingUser(new Button("Existing User"));
		this.setLogin("Login");
		this.setCancel("Cancel");
		this.setLogo(new Logo());
	}
	
	public void setNewUser(Button newUser) {
		this.newUser = newUser;
	}
	
	public Button getNewUser() {
		return this.newUser;
	}
	
	public void setExistingUser(Button existingUser) {
		this.existingUser = existingUser;
	}
	
	public Button getExistingUser() {
		return this.existingUser;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getLogin() {
		return this.login;
	}
	
	public void setCancel(String cancel) {
		this.cancel = cancel;
	}
	
	public String getCancel() {
		return this.cancel;
	}

	public void setLogo(Logo logo) {
		this.logo = logo;
	}

	public Logo getLogo() {
		return this.logo;
	}

	public void setFlames(Flame[] flames) {
		this.flames = flames;
	}

	public Flame[] getFlames() {
		return this.flames;
	}
}