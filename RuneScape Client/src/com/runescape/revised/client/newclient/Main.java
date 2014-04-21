package com.runescape.revised.client.newclient;

public class Main {
	
	private static GameClientState gameClientState;

	public static void main(String[] args) {
		/** int cores = Runtime.getRuntime().availableProcessors();
		for (byte b = 0; b <= cores; b++) {
			@SuppressWarnings("unused")
			Thread[] thread = new Thread[b];
			thread[0] = new IOThread();
			thread[1] = new ContentThread();
		}
		System.out.println("Number of Processors: " + cores); */
	}

	public static void setGameClientState(GameClientState gameClientState) {
		Main.gameClientState = gameClientState;
	}

	public static GameClientState getGameClientState() {
		return Main.gameClientState;
	}
}