package com.runescape.revised.system.area.impl;

import java.util.PriorityQueue;
import java.util.Queue;

import com.runescape.revised.system.System;
import com.runescape.revised.system.area.Area;

public class Midground extends Area {

	private Queue<System> systemQueue;

	public Midground() {
		this.setSystemQueue(new PriorityQueue<System>()); // TransferQueue?
	}

	@Override
	public void sendSystem(final System system, final Area area) {
		this.getSystemQueue().remove(system);
		area.getSystemQueue().add(system);
	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.system.area.Area#getSystems()
	 */
	@Override
	public System[] getSystems() {
		return (System[]) this.getSystemQueue().toArray();
	}

	public void setSystemQueue(final Queue<System> systemQueue) {
		this.systemQueue = systemQueue;
	}

	/*
	 * (non-Javadoc)
	 * @see com.runescape.revised.system.area.Area#getSystemQueue()
	 */
	@Override
	public Queue<System> getSystemQueue() {
		return this.systemQueue;
	}
}