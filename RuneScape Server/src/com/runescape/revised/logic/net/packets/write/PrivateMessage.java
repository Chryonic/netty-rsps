package com.runescape.revised.logic.net.packets.write;

import org.jboss.netty.channel.Channel;

import com.runescape.revised.Priority;
import com.runescape.revised.logic.net.packets.Packet;
import com.runescape.revised.logic.net.packets.VariableType;

public class PrivateMessage extends Packet {

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
		return 196;
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
	 * 
		if(pktType == 196)
		{
			long l5 = inStream.readQWord();
			int j18 = inStream.readDWord();
			int l21 = inStream.readUnsignedByte();
			boolean flag5 = false;
			for(int i28 = 0; i28 < 100; i28++)
			{
				if(anIntArray1240[i28] != j18)
					continue;
				flag5 = true;
				break;
			}

			if(l21 <= 1)
			{
				for(int l29 = 0; l29 < ignoreCount; l29++)
				{
					if(ignoreListAsLongs[l29] != l5)
						continue;
					flag5 = true;
					break;
				}

			}
			if(!flag5 && anInt1251 == 0)
				try
				{
					anIntArray1240[anInt1169] = j18;
					anInt1169 = (anInt1169 + 1) % 100;
					String s9 = TextInput.method525(pktSize - 13, inStream);
					if(l21 != 3)
						s9 = Censor.doCensor(s9);
					if(l21 == 2 || l21 == 3)
						pushMessage(s9, 7, "@cr2@" + TextClass.fixName(TextClass.nameForLong(l5)));
					else
					if(l21 == 1)
						pushMessage(s9, 7, "@cr1@" + TextClass.fixName(TextClass.nameForLong(l5)));
					else
						pushMessage(s9, 3, TextClass.fixName(TextClass.nameForLong(l5)));
				}
				catch(Exception exception1)
				{
					signlink.reporterror("cde1");
				}
			pktType = -1;
			return true;
		}
	 */
}