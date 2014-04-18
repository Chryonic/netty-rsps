package com.runescape.revised.system;

import com.runescape.revised.chain.Chainable;

public class System implements Chainable {

	private static System system;
	private SystemQueue systemQueue;
	
	public System() {
		
	}

	@Override
	public void add(Object object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Object object) {
		// TODO Auto-generated method stub
		
	}

	public static void setSystem(System system) {
		System.system = system;
	}

	public static System getSystem() {
		return System.system;
	}

	public void setSystemQueue(SystemQueue systemQueue) {
		this.systemQueue = systemQueue;
	}

	public SystemQueue getSystemQueue() {
		return systemQueue;
	}
}
