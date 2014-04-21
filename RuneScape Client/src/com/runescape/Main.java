package com.runescape;

import com.runescape.revised.GameClient;
import com.runescape.revised.GarbageCollector;
import com.runescape.revised.client.newclient.login.LoginFrame;
import com.runescape.revised.net.netty.Netty;

public class Main {

	private static Main main;
	private GameClient gameClient;
	
	public Main() {
		long start = java.lang.System.currentTimeMillis();
		this.setGameClient(new GameClient());
		new GarbageCollector();
		new Netty();
		new LoginFrame();
		System.out.println("Client VM - " + (System.currentTimeMillis() - start) + "ms");
	}
	
	public static void main(String[] args) {
		Main.getMain();
	}

	public static void setMain(Main main) {
		Main.main = main;
	}

	public static Main getMain() {
		if (Main.main == null) {
			Main.setMain(new Main());
		}
		return Main.main;
	}

	public void setGameClient(GameClient gameClient) {
		this.gameClient = gameClient;
	}

	public GameClient getGameClient() {
		return this.gameClient;
	}
}