package com.runescape.revised.client;

import org.jboss.netty.channel.Channel;

public class GameClient {

	private Channel channel;
	private short id;
	
	public GameClient(final Channel channel, final short id) {
		this.setChannel(channel);
		this.setID(id);
	}

	public void setChannel(final Channel channel) {
		this.channel = channel;
	}

	public Channel getChannel() {
		return this.channel;
	}

	public void setID(final short id) {
		this.id = id;
	}

	public short getID() {
		return this.id;
	}
}