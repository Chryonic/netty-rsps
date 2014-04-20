package com.runescape.revised.client;

import org.jboss.netty.channel.Channel;

public class GameClient {

	private Channel channel;
	private int id;
	
	public GameClient(Channel channel, int id) {
		this.setChannel(channel);
		this.setID(id);
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public Channel getChannel() {
		return this.channel;
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getID() {
		return this.id;
	}
}