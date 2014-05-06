package com.runescape.revised.logic.net.packets.codec.game;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

public class GameDecoder extends FrameDecoder {

	public GameDecoder() {

	}

	@Override
	protected Object decode(final ChannelHandlerContext chc, final Channel channel, final ChannelBuffer channelBuffer) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}