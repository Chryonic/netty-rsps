package com.runescape;

import com.runescape.revised.GameClient;
import com.runescape.revised.GarbageCollector;
import com.runescape.revised.client.newclient.login.LoginFrame;
import com.runescape.revised.net.netty.Netty;

/**
 * The Main class for the Client to
 * startup.
 * 
 * @author josh
 * 
 */
public class Main {

	/**
	 * The Main instance.
	 */
	private static Main main;
	
	/**
	 * The GameClient instance.
	 */
	private GameClient gameClient;
	
	/**
	 * The Main constructor.
	 */
	public Main() {
		long start = java.lang.System.currentTimeMillis();
		this.setGameClient(new GameClient());
		new GarbageCollector();
		new Netty();
		new LoginFrame();
		System.out.println("Client VM - " + (System.currentTimeMillis() - start) + "ms");
	}
	
	/**
	 * The main method.
	 * 
	 * @param args
	 * 			The arguments for the client.
	 */
	public static void main(String[] args) {
		Main.getMain();
	}

	/**
	 * The setter for the Main instance.
	 * 
	 * @param main
	 * 			The Main parameter.
	 */
	public static void setMain(Main main) {
		Main.main = main;
	}

	/**
	 * The getter for the Main instance.
	 * 
	 * @return main
	 * 			The Main instance.
	 */
	public static Main getMain() {
		if (Main.main == null) {
			Main.setMain(new Main());
		}
		return Main.main;
	}

	/**
	 * The setter for the GameClient instance.
	 * 
	 * @param gameClient
	 * 			The gameClient parameter.
	 */
	public void setGameClient(GameClient gameClient) {
		this.gameClient = gameClient;
	}

	/**
	 * The getter for the GameClient instance.
	 * 
	 * @return gameClient
	 * 			The gameClient instance.
	 */
	public GameClient getGameClient() {
		return this.gameClient;
	}
}