package com.runescape.revised.logic.net.netty;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.DefaultChannelPipeline;

import com.runescape.net.ChannelHandler;
import com.runescape.revised.logic.net.packets.codec.game.GameEncoder;
import com.runescape.revised.logic.net.packets.codec.login.LoginDecoder;

public class ServerPipelineFactory implements ChannelPipelineFactory {

	@Override
	public ChannelPipeline getPipeline() throws Exception {
		ChannelPipeline channelPipeline = new DefaultChannelPipeline();
		channelPipeline.addLast("encoder", new GameEncoder());
		channelPipeline.addLast("decoder", new LoginDecoder());
		channelPipeline.addLast("handler", new ChannelHandler());
		return channelPipeline;
	}
}