package com.runescape.revised.packets.read;

import com.runescape.revised.client.GameClient;
import com.runescape.revised.packets.Packet;

public class WelcomeScreen extends Packet {

	@Override
	public void executePacket(GameClient c, int packetType, int packetSize) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 176;
	}
	
	@Override
	public byte getSize() {
		return 0;
	}

	/**
	 * if(pktType == 176)
		{
			daysSinceRecovChange = inStream.method427();
			unreadMessages = inStream.method435();
			membersInt = inStream.readUnsignedByte();
			anInt1193 = inStream.method440();
			daysSinceLastLogin = inStream.readUnsignedWord();
			if(anInt1193 != 0 && openInterfaceID == -1)
			{
				signlink.dnslookup(TextClass.method586(anInt1193));
				clearTopInterfaces();
				char c = '\u028A';
				if(daysSinceRecovChange != 201 || membersInt == 1)
					c = '\u028F';
				reportAbuseInput = "";
				canMute = false;
				for(int k9 = 0; k9 < RSInterface.interfaceCache.length; k9++)
				{
					if(RSInterface.interfaceCache[k9] == null || RSInterface.interfaceCache[k9].anInt214 != c)
						continue;
					openInterfaceID = RSInterface.interfaceCache[k9].parentID;
					break;
				}

			}
			pktType = -1;
			return true;
		}
	 */
}