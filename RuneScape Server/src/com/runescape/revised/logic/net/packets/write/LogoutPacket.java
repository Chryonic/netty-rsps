package com.runescape.revised.logic.net.packets.write;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.logic.net.packets.VariableType;

public class LogoutPacket extends Packet {
	
	// private Logout logout;

	@Override
	public void executePacket(Channel channel) {
		// this.getLogout().resetLogout();
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 109;
	}
	
	@Override
	public byte getSize() {
		return 0;
	}

	@Override
	public VariableType getVariableType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/** public void setLogout(Logout logout) {
		this.setLogout(logout);
	}
	
	public Logout getLogout() {
		return this.logout;
	} */
}