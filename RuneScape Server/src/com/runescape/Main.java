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
	 * The garbage collector instance.
	 */
	private GarbageCollector garbageCollector;
	
	/**
	 * The netty instance.
	 */
	private Netty netty;
	
	/**
	 * The constructor.
	 */
	public Main() {
		final Timer timer = new Timer();
		this.setGarbageCollector(new GarbageCollector());
		this.setNetty(new Netty());
		this.setGameServer(new GameServer());
		System.out.println("RuneScape Server started in " + timer.toString());
	}
	
	/**
	 * The main method.
	 * 
	 * @param args
	 * 			The method's arguments.
	 */
	public static void main(final String[] args) {
		Main.getMain();
	}

	/**
	 * Sets the main instance.
	 * 
	 * @param main
	 * 			The main instance to set.
	 */
	public static void setMain(final Main main) {
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
	public void setGameServer(final GameServer gameServer) {
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

	/**
	 * Sets the garbage collector.
	 * 
	 * @param garbageCollector
	 * 			The garbage collector to set.
	 */
	public void setGarbageCollector(final GarbageCollector garbageCollector) {
		this.garbageCollector = garbageCollector;
	}

	/**
	 * Gets the garbage collector.
	 * 
	 * @return garbageCollector
	 * 			The garbage collector to get.
	 */
	public GarbageCollector getGarbageCollector() {
		return this.garbageCollector;
	}

	/**
	 * Sets the Netty networking.
	 * 
	 * @param netty
	 * 			The networking to set.
	 */
	public void setNetty(final Netty netty) {
		this.netty = netty;
	}

	/**
	 * Gets the Netty networking.
	 * 
	 * @return netty
	 * 			The networking to get.
	 */
	public Netty getNetty() {
		return this.netty;
	}
}