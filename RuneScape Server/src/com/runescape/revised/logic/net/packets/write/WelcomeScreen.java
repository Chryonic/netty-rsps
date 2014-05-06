package com.runescape.revised.logic.net.packets.write;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.Priority;
import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.logic.net.packets.VariableType;

public class WelcomeScreen extends Packet {

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#executePacket(org.jboss.netty.channel.Channel)
	 */
	@Override
	public void executePacket(final Channel channel) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#getOpcode()
	 */
	@Override
	public short getOpcode() {
		// TODO Auto-generated method stub
		return 176;
	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#getSize()
	 */
	@Override
	public byte getSize() {
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#getVariableType()
	 */
	@Override
	public VariableType getVariableType() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.logic.net.packets.Packet#getPriority()
	 */
	@Override
	public Priority getPriority() {
		// TODO Auto-generated method stub
		return null;
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