package com.runescape.revised.logic.net.netty;

import org.jboss.netty.channel.Channel;

public class ServerChannel {

	private Channel channel;

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public Channel getChannel() {
		return this.channel;
	}
}