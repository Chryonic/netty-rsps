package com.runescape.revised.client.newclient;

import com.runescape.revised.client.newclient.login.LoginFrame;

public class Main {
	
	private static GameClientState gameClientState;

	public static void main(String[] args) {
		long start = java.lang.System.currentTimeMillis();
		new LoginFrame();
		/** int cores = Runtime.getRuntime().availableProcessors();
		for (byte b = 0; b <= cores; b++) {
			@SuppressWarnings("unused")
			Thread[] thread = new Thread[b];
			thread[0] = new IOThread();
			thread[1] = new ContentThread();
		}
		System.out.println("Number of Processors: " + cores); */
		System.out.println("Client VM - " + (System.currentTimeMillis() - start) + "ms");
	}

	public static void setGameClientState(GameClientState gameClientState) {
		Main.gameClientState = gameClientState;
	}

	public static GameClientState getGameClientState() {
		return Main.gameClientState;
	}
}