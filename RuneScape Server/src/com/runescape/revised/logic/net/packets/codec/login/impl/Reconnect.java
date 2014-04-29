package com.runescape.revised.logic.net.packets.codec.login.impl;

import org.jboss.netty.channel.Channel;

// import com.runescape.revised.logic.net.packets.PacketBuffer;
import com.runescape.revised.logic.net.packets.codec.game.GameDecoder;
import com.runescape.revised.logic.net.packets.codec.login.Login;
import com.runescape.revised.logic.net.packets.codec.login.LoginPacket;

/**
 * The reconnect login packet.
 * 
 * @author Josh
 * 
 */
public class Reconnect extends LoginPacket {

	/**
	 * The constructor.
	 */
	public Reconnect() {
		super((byte) 18, null);
	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#executePacket(org.jboss.netty.buffer.ChannelBuffer, org.jboss.netty.channel.Channel)
	 */
	@Override
	public void executePacket(Channel channel) {
		System.out.println("Now logging in...");
		// channel.write(new PacketBuffer().writeByte((byte) 2).writeByte((byte) 0).writeByte((byte) 0));
		new Login(channel/*, (short) version, name, pass*/);
		channel.getPipeline().replace("decoder", "decoder", new GameDecoder(null));
		// player.write(new PacketBuilder(249).putByteA(1).putLEShortA(player.getIndex()).toPacket());
		// player.write(new PacketBuilder(107).toPacket());
	}
}