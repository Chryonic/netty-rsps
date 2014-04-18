package com.runescape.util;

public class Timer {

	private long time;

	public Timer() {
		this.start();
	}

	public void start() {
		this.setTime(System.currentTimeMillis());
	}

	public long elapsed() {
		return System.currentTimeMillis() - time;
	}
	
	public void setTime(long time) {
		this.time = time;
	}
	
	public long getTime() {
		return this.time;
	}
}
