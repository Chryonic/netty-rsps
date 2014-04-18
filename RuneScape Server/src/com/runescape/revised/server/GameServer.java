package com.runescape.revised.server;

import com.runescape.revised.system.System;
import com.runescape.revised.thread.ContentThread;
import com.runescape.revised.thread.IOThread;
import com.sun.jmx.remote.internal.ArrayQueue;

public abstract class GameServer {

	private ArrayQueue<System> systemQueue;
	// private Pool<System> systemPool; Two or more systems are allowed at a time - ex:
	// item and minigame. Take from the Pool and put it back into the Pool. Shutdown the
	// system before you put it back into the Pool.
	// Difference between a Pool, a List, and a Queue of Systems.
	
	public GameServer() {
		byte coreAmount = (byte) Runtime.getRuntime().availableProcessors();
		for (byte b = 0; b <= coreAmount; b++) {
			Thread[] thread = new Thread[b];
			thread[0] = new IOThread(); // Networking/IO Thread
			thread[1] = new ContentThread(); // Content Thread
		}
		// this.setSystemQueue(new ArrayQueue<System>(0));
	}

	public void setSystemQueue(ArrayQueue<System> systemQueue) {
		this.systemQueue = systemQueue;
	}

	public ArrayQueue<System> getSystemQueue() {
		return this.systemQueue;
	}
	
	// public void setSystemPool(Pool<System> systemPool) {
		// this.systemPool = systemPool;
	// }
	
	// public Pool<System> getSystemPool() {
		// return this.systemPool;
	// }
}