package com.runescape.revised.system;

import java.util.Queue;

public class SystemQueue {

	private Queue<System> systemQueue;
	
	public void add(System system) {
		this.getSystemQueue().add(system);
	}
	
	public void remove(System system) {
		this.getSystemQueue().remove(system);
	}
	
	public void setSystemQueue(Queue<System> systemQueue) {
		this.systemQueue = systemQueue;
	}
	
	public Queue<System> getSystemQueue() {
		return this.systemQueue;
	}
}