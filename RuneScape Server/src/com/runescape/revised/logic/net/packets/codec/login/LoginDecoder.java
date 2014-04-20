package com.runescape.revised.logic.net.packets.codec.login;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

import com.runescape.revised.logic.net.packets.PacketSystem;
import com.runescape.revised.logic.net.packets.codec.login.impl.Request;
import com.runescape.revised.logic.net.packets.codec.login.impl.UserAuthentication;

public class LoginDecoder extends FrameDecoder {
	
	private LoginState loginState;

	@Override
	protected Object decode(ChannelHandlerContext chc, Channel channel, ChannelBuffer channelBuffer) throws Exception {
		this.setLoginState(LoginState.CONNECTED);
		if(!channel.isConnected()) {
			return null;
		}
		switch (this.getLoginState()) {
		case CONNECTED:
			PacketSystem.getPacketSystem().throwPacket(new Request(), channelBuffer, channel);
		case LOGGED_IN:
			PacketSystem.getPacketSystem().throwPacket(new UserAuthentication(), channelBuffer, channel);
		}
		return null;
	}

	public void setLoginState(LoginState loginState) {
		this.loginState = loginState;
	}

	public LoginState getLoginState() {
		return this.loginState;
	}
}