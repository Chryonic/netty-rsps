package com.runescape.revised.packets.read;

import com.runescape.revised.client.GameClient;
import com.runescape.revised.client.Logout;
import com.runescape.revised.packets.Packet;

public class LogoutPacket extends Packet {
	
	private Logout logout;

	@Override
	public void executePacket(GameClient c, int packetType, int packetSize) {
		this.getLogout().resetLogout();
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
	
	public void setLogout(Logout logout) {
		this.setLogout(logout);
	}
	
	public Logout getLogout() {
		return this.logout;
	}
}