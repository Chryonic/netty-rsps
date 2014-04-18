package com.runescape.revised.util;

public class Benchmarker {

    private long startTime;
    
    public Benchmarker() {
            this.setStartTime(System.currentTimeMillis());
    }

    public void setStartTime(long startTime) {
            this.startTime = startTime;
    }

    public long getStartTime() {
            return this.startTime;
    }

    @Override
    public String toString() {
            return ((System.currentTimeMillis() - this.getStartTime()) / 1000000.0) + "ms";
    }
}