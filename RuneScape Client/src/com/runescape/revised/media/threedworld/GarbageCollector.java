package com.runescape.revised.media.threedworld;

import com.runescape.revised.util.Timer;

public class GarbageCollector implements Runnable {

    @Override
	public void run() {
    	Timer time = new Timer();
    	long beforeCollector = Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
    	System.gc();
    	System.runFinalization();
    	long afterCollector = Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory();
    	int memory = (int) (beforeCollector - afterCollector) / 1024;
    	System.out.println("Cleaned out " + memory + " KB of memory in " + time + "...");
    }
}