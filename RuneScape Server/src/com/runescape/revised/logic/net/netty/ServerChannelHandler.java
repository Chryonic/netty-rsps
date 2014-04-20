package com.runescape.revised.logic.net.netty;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.logic.net.packets.PacketSystem;

public class ServerChannelHandler extends SimpleChannelHandler {
	
	private ServerChannel serverChannel;
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception { }
	
	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
		PacketSystem.getPacketSystem().throwPacket((Packet) e.getMessage(), this.getServerChannel().getChannelBuffer(), ctx.getChannel());
	}
	
	@Override
	public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
		if (this.getServerChannel() != null) {
			this.setServerChannel((ServerChannel) ctx.getChannel());
		}
	}
	
	@Override
	public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
		
	}

	public ServerChannel getServerChannel() {
		return this.serverChannel;
	}

	public void setServerChannel(ServerChannel serverChannel) {
		this.serverChannel = serverChannel;
	}
}