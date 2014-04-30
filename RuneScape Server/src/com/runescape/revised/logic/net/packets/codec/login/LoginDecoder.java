package com.runescape.revised.logic.net.packets.codec.login;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

import com.runescape.revised.logic.net.packets.PacketSystem;
import com.runescape.revised.logic.net.packets.codec.login.impl.Connect;
import com.runescape.revised.logic.net.packets.codec.login.impl.Request;
import com.runescape.revised.logic.net.packets.codec.login.impl.Update;

public class LoginDecoder extends FrameDecoder {
	
	private LoginState loginState;
	private static ConnectionType connectionType;

	/*
	 * (non-Javadoc)
	 * @see org.jboss.netty.handler.codec.frame.FrameDecoder#decode(org.jboss.netty.channel.ChannelHandlerContext, org.jboss.netty.channel.Channel, org.jboss.netty.buffer.ChannelBuffer)
	 */
	@Override
	protected Object decode(final ChannelHandlerContext chc, final Channel channel, final ChannelBuffer channelBuffer) throws Exception {
		final byte opcode = (byte) channelBuffer.readUnsignedByte();
		switch (opcode) {
		case 14:
			System.out.println("Throwing Request login packet");
			PacketSystem.getPacketSystem().throwPacket(new Request(), channel);
			// channel.write(new PacketBuffer().writeByte((byte) 0));
			break;
		case 15:
			System.out.println("Throwing Update login packet");
			PacketSystem.getPacketSystem().throwPacket(new Update(), channel);
			break;
		case 16:
		case 18:
			System.out.println("Throwing Connect login packet");
			PacketSystem.getPacketSystem().throwPacket(new Connect(), channel);
			// channel.write(new PacketBuffer().writeByte((byte) 2));
			break;
		}
		return null;
	}

	public void setLoginState(final LoginState loginState) {
		this.loginState = loginState;
	}

	public LoginState getLoginState() {
		return this.loginState;
	}

	public static void setConnectionType(final ConnectionType connectionType) {
		LoginDecoder.connectionType = connectionType;
	}

	public static ConnectionType getConnectionType() {
		return LoginDecoder.connectionType;
	}
}