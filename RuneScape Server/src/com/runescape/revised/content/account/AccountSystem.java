package com.runescape.revised.content.account;

import com.runescape.revised.system.System;

public class AccountSystem extends System {

	private static AccountSystem accountSystem;

	public static void setAccountSystem(AccountSystem accountSystem) {
		AccountSystem.accountSystem = accountSystem;
	}

	public static AccountSystem getAccountSystem() {
		return AccountSystem.accountSystem;
	}
}