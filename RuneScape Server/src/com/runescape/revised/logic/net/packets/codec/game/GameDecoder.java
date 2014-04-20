package com.runescape.revised.logic.net.packets.codec.game;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

import com.runescape.util.ISAACCipher;

public class GameDecoder extends FrameDecoder {
	
	public GameDecoder(ISAACCipher in) {
		
	}

	@Override
	protected Object decode(ChannelHandlerContext chc, Channel channel, ChannelBuffer channelBuffer) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}