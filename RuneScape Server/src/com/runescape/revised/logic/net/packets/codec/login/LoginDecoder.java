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
	private static ConnectionType connectionType;

	@Override
	protected Object decode(ChannelHandlerContext chc, Channel channel, ChannelBuffer channelBuffer) throws Exception {
		if (!channel.isConnected()) {
			return null;
		}
		System.out.println("Throwing Request login packet");
		PacketSystem.getPacketSystem().throwPacket(new Request(), channelBuffer, channel);
		System.out.println("Throwing UserAuthentication login packet");
		PacketSystem.getPacketSystem().throwPacket(new UserAuthentication(), channelBuffer, channel);
		return null;
	}

	public void setLoginState(LoginState loginState) {
		this.loginState = loginState;
	}

	public LoginState getLoginState() {
		return this.loginState;
	}

	public static void setConnectionType(ConnectionType connectionType) {
		LoginDecoder.connectionType = connectionType;
	}

	public static ConnectionType getConnectionType() {
		return LoginDecoder.connectionType;
	}
}