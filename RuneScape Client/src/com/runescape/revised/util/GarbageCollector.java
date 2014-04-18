package com.runescape.revised.util;

public class GarbageCollector {

	public void collectGarbage() {
		System.gc();
		System.runFinalization();
	}
}