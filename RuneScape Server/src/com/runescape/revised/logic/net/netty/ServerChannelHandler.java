package com.runescape.revised.logic.net.netty;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.logic.net.packets.PacketSystem;

public class ServerChannelHandler extends SimpleChannelHandler {
	
	/*
	 * (non-Javadoc)
	 * @see org.jboss.netty.channel.SimpleChannelHandler#exceptionCaught(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.ExceptionEvent)
	 */
	@Override
	public void exceptionCaught(final ChannelHandlerContext chc, final ExceptionEvent ee) throws Exception {}
	
	/*
	 * (non-Javadoc)
	 * @see org.jboss.netty.channel.SimpleChannelHandler#messageReceived(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.MessageEvent)
	 */
	@Override
	public void messageReceived(final ChannelHandlerContext chc, final MessageEvent me) throws Exception {
		PacketSystem.getPacketSystem().throwPacket((Packet) me.getMessage(), chc.getChannel());
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.jboss.netty.channel.SimpleChannelHandler#channelConnected(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.ChannelStateEvent)
	 */
	@Override
	public void channelConnected(final ChannelHandlerContext chc, final ChannelStateEvent cse) {
		System.out.println("Connected.");
	}
	
	/*
	 * (non-Javadoc)
	 * @see org.jboss.netty.channel.SimpleChannelHandler#channelClosed(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.ChannelStateEvent)
	 */
	@Override
	public void channelClosed(final ChannelHandlerContext chc, final ChannelStateEvent cse) throws Exception {
		System.out.println("Disconnected.");
	}
}