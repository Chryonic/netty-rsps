package com.runescape.revised.garbagecollector;

public class GarbageCollector {

	public static void main(String[] args) {
		System.gc();
		System.runFinalization();
	}
}