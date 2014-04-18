package com.runescape.revised.net.netty;

import org.jboss.netty.channel.Channel;

public class ClientChannel {

	private Channel channel;

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public Channel getChannel() {
		return this.channel;
	}
}