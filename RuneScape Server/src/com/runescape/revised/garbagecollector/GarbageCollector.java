package com.runescape.revised.garbagecollector;

public class GarbageCollector {

	public GarbageCollector() {
		System.gc();
		System.runFinalization();
	}
}