package com.runescape.util;

public class Timer {

	private long time;

	public Timer() {
		this.start();
	}

	public void start() {
		this.setTime(System.currentTimeMillis());
	}
	
	public void setTime(long time) {
		this.time = time;
	}
	
	public long getTime() {
		return this.time;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return (System.currentTimeMillis() - this.getTime()) + "ms.";
	}
}
