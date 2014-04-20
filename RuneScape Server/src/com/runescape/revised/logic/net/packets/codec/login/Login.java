package com.runescape.revised.logic.net.packets.codec.login;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.client.GameClient;
import com.runescape.revised.logic.net.packets.PacketBuffer;
import com.runescape.util.ISAACCipher;

public class Login {
	
	private String username;
	private String password;
	private short revision;

	public Login(Channel channel, ISAACCipher in, ISAACCipher out, short version, String name, String pass) {
		byte returnCode = 2;
		new GameClient(channel, -1);
		channel.write(new PacketBuffer().writeByte((byte) returnCode));
		
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