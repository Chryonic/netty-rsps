package com.runescape.revised.logic.net.netty;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;

public class ServerChannel {

	private Channel channel;
	private ChannelBuffer channelBuffer;
	
	public ServerChannel(Channel channel, ChannelBuffer channelBuffer) {
		this.setChannel(channel);
		this.setChannelBuffer(channelBuffer);
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}

	public Channel getChannel() {
		return this.channel;
	}

	public void setChannelBuffer(ChannelBuffer channelBuffer) {
		this.channelBuffer = channelBuffer;
	}

	public ChannelBuffer getChannelBuffer() {
		return this.channelBuffer;
	}
}