package com.runescape.revised.net.login;

public class LoginSystem {

	private static LoginSystem loginSystem;

	public static void setLoginSystem(LoginSystem loginSystem) {
		LoginSystem.loginSystem = loginSystem;
	}

	public static LoginSystem getLoginSystem() {
		return LoginSystem.loginSystem;
	}
}