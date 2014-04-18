package com.runescape.revised.client;

public class UpdateMask {

	private void refreshUpdateMasks(RSBuffer stream)
	{
		for(int j = 0; j < anInt893; j++)
		{
			int k = anIntArray894[j];
			Player player = playerArray[k];
			int l = stream.readUnsignedByte();
			if((l & 0x40) != 0)
				l += stream.readUnsignedByte() << 8;
			appendPlayerUpdateMask(l, k, stream, player);
		}

	}
	
	
	
	
	
	private void npcUpdateMask(RSBuffer stream)
	{
		for(int j = 0; j < anInt893; j++)
		{
			int k = anIntArray894[j];
			NPC npc = sessionNPCs[k];
			int l = stream.readUnsignedByte();
			if((l & 0x10) != 0)
			{
				int i1 = stream.method434();
				if(i1 == 65535)
					i1 = -1;
				int i2 = stream.readUnsignedByte();
				if(i1 == npc.anim && i1 != -1)
				{
					int l2 = Animation.anims[i1].anInt365;
					if(l2 == 1)
					{
						npc.anInt1527 = 0;
						npc.anInt1528 = 0;
						npc.anInt1529 = i2;
						npc.anInt1530 = 0;
					}
					if(l2 == 2)
						npc.anInt1530 = 0;
				} else
				if(i1 == -1 || npc.anim == -1 || Animation.anims[i1].anInt359 >= Animation.anims[npc.anim].anInt359)
				{
					npc.anim = i1;
					npc.anInt1527 = 0;
					npc.anInt1528 = 0;
					npc.anInt1529 = i2;
					npc.anInt1530 = 0;
					npc.anInt1542 = npc.smallXYIndex;
				}
			}
			if((l & 8) != 0)
			{
				int j1 = stream.method426();
				int j2 = stream.method427();
				npc.updateHitData(j2, j1, loopCycle);
				npc.loopCycleStatus = loopCycle + 300;
				npc.currentHealth = stream.method426();
				npc.maxHealth = stream.readUnsignedByte();
			}
			if((l & 0x80) != 0)
			{
				npc.anInt1520 = stream.readUnsignedWord();
				int k1 = stream.readDWord();
				npc.anInt1524 = k1 >> 16;
				npc.anInt1523 = loopCycle + (k1 & 0xffff);
				npc.anInt1521 = 0;
				npc.anInt1522 = 0;
				if(npc.anInt1523 > loopCycle)
					npc.anInt1521 = -1;
				if(npc.anInt1520 == 65535)
					npc.anInt1520 = -1;
			}
			if((l & 0x20) != 0)
			{
				npc.interactingEntity = stream.readUnsignedWord();
				if(npc.interactingEntity == 65535)
					npc.interactingEntity = -1;
			}
			if((l & 1) != 0)
			{
				npc.textSpoken = stream.readString();
				npc.textCycle = 100;
//	entityMessage(npc);
	
			}
			if((l & 0x40) != 0)
			{
				int l1 = stream.method427();
				int k2 = stream.method428();
				npc.updateHitData(k2, l1, loopCycle);
				npc.loopCycleStatus = loopCycle + 300;
				npc.currentHealth = stream.method428();
				npc.maxHealth = stream.method427();
			}
			if((l & 2) != 0)
			{
				npc.desc = NPCDef.forID(stream.method436());
				npc.anInt1540 = npc.desc.aByte68;
				npc.anInt1504 = npc.desc.anInt79;
				npc.anInt1554 = npc.desc.anInt67;
				npc.anInt1555 = npc.desc.anInt58;
				npc.anInt1556 = npc.desc.anInt83;
				npc.anInt1557 = npc.desc.anInt55;
				npc.anInt1511 = npc.desc.anInt77;
			}
			if((l & 4) != 0)
			{
				npc.anInt1538 = stream.method434();
				npc.anInt1539 = stream.method434();
			}
		}
	}
}