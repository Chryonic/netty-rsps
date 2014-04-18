package com.runescape.revised.jni;

public class JNI {

	static {
		System.loadLibrary("JNI Library");
	}

	public static void main(String[] args) {
		new JNI().helloWorld("Hello World");
	}

	public native void helloWorld(String hello);
}