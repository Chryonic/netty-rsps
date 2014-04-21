package com.runescape.revised.net.netty;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.DefaultChannelPipeline;

public class ClientPipelineFactory implements ChannelPipelineFactory {

	@Override
	public ChannelPipeline getPipeline() throws Exception {
		ChannelPipeline channelPipeline = new DefaultChannelPipeline();
		channelPipeline.addLast("encoder", new GameEncoder());
		channelPipeline.addLast("decoder", new LoginDecoder());
		channelPipeline.addLast("handler", new ClientChannelHandler());
		return channelPipeline;
	}
}