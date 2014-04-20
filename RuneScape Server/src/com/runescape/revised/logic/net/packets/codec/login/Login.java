package com.runescape.revised.logic.net.packets.codec.login;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.client.GameClient;
import com.runescape.revised.logic.net.packets.PacketBuffer;

public class Login {
	
	private String username;
	private String password;
	private short revision;

	public Login(Channel channel) {
		// channel.write(new PacketBuffer().writeByte((byte) 2).writeByte((byte) 0).writeByte((byte) 0));
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

	public void setRevision(short revision) {
		this.revision = revision;
	}

	public short getRevision() {
		return this.revision;
	}
}