package com.runescape.revised.logic.net.packets.codec.login;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.client.GameClient;

public class Login {
	
	private String username;
	private String password;

	public Login(Channel channel) {
		new GameClient(channel, -1);
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