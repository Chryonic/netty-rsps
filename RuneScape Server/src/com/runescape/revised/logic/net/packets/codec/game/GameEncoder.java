package com.runescape.revised.logic.net.packets.codec.game;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

import com.runescape.revised.logic.net.packets.Packet;

public class GameEncoder extends OneToOneEncoder {

	@Override
	protected Object encode(ChannelHandlerContext chc, Channel channel, Object object) throws Exception {
		// TODO Auto-generated method stub
		return ((Packet) object);
		
		// needs to be packetbuffer or packet? channelbuffer
	}
}