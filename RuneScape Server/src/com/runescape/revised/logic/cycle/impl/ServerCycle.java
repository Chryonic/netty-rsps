package com.runescape.revised.logic.cycle.impl;

import java.util.concurrent.ForkJoinPool;

import com.runescape.revised.logic.cycle.Cycle;
import com.runescape.revised.logic.entity.update.Update;
import com.runescape.revised.logic.net.packets.PacketSystem;
import com.runescape.revised.util.Timer;

public class ServerCycle extends Cycle {

	public ServerCycle() {
		super((short) 600);
	}

	@Override
	public void startCycle() {
		// create a ForkJoinPool for Packet System
		PacketSystem.getPacketSystem().throwPacket(/* packet */ null, /* channel */ null);
		final ForkJoinPool forkJoinPool = new ForkJoinPool();
		final Timer timer = new Timer();
		forkJoinPool.invoke(new Update());
		System.out.println("Entity Updating took " + timer.toString());
	}
}