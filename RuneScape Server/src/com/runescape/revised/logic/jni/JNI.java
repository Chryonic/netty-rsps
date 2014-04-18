package com.runescape.revised.logic.jni;

public class JNI {

	static {
		System.loadLibrary("JNI Library");
	}

	public static void main(String[] args) {
		new JNI().helloWorld("Hello World");
	}

	public native void helloWorld(String hello);
}