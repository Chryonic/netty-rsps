package com.runescape.revised.logic.net.packets.codec.login;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.client.GameClient;

public class Login {
	
	private String username;
	private String password;

	public Login(final Channel channel) {
		new GameClient(channel, (short) -1);
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getUsername() {
		return this.username;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}
}