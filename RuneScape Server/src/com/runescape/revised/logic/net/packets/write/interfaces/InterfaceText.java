package com.runescape.revised.logic.net.packets.write.interfaces;

public class InterfaceText {

	/**
	 * 
		if(pktType == 126)
		{
			String s1 = inStream.readString();
			int k13 = inStream.method435();
			RSInterface.interfaceCache[k13].message = s1;
			if(RSInterface.interfaceCache[k13].parentID == tabInterfaceIDs[tabID])
				needDrawTabArea = true;
			pktType = -1;
			return true;
		}
	 */
}