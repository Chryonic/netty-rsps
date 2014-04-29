package com.runescape;

import com.runescape.revised.garbagecollector.GarbageCollector;
import com.runescape.revised.logic.net.netty.Netty;
import com.runescape.revised.server.GameServer;
import com.runescape.util.Timer;

/**
 * The main class that starts everything
 * up.
 * 
 * @author Josh
 *
 */
public class Main {
	
	/**
	 * The main instance.
	 */
	private static Main main;
	
	/**
	 * The game server instance.
	 */
	private GameServer gameServer;
	
	/**
	 * The constructor.
	 */
	public Main() {
		Timer timer = new Timer();
		new GarbageCollector();
		new Netty();
		System.out.println("RuneScape Server started in " + timer.toString());
	}
	
	/**
	 * The main method.
	 * 
	 * @param args
	 * 			The method's arguments.
	 */
	public static void main(String[] args) {
		Main.getMain();
	}

	/**
	 * Sets the main instance.
	 * 
	 * @param main
	 * 			The main instance to set.
	 */
	public static void setMain(Main main) {
		Main.main = main;
	}

	/**
	 * Gets the main instance.
	 * 
	 * @return main
	 * 			The main instance to get.
	 */
	public static Main getMain() {
		if (Main.main == null) {
			Main.setMain(new Main());
		}
		return Main.main;
	}

	/**
	 * Sets the game server.
	 * 
	 * @param gameServer
	 * 			The game server to set.
	 */
	public void setGameServer(GameServer gameServer) {
		this.gameServer = gameServer;
	}

	/**
	 * Gets the game server.
	 * 
	 * @return gameServer
	 * 			The game server to get.
	 */
	public GameServer getGameServer() {
		return this.gameServer;
	}
}