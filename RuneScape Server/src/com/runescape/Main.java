package com.runescape;

import java.io.IOException;

import com.runescape.revised.garbagecollector.GarbageCollector;
import com.runescape.revised.logic.cycle.CycleSystem;
import com.runescape.revised.logic.cycle.impl.ServerCycle;
import com.runescape.revised.logic.net.io.Io;
import com.runescape.revised.server.GameServer;
import com.runescape.revised.system.area.AreaSystem;

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
	 * The GameServer instance.
	 */
	private GameServer gameServer;

	/**
	 * The GarbageCollector instance.
	 */
	private GarbageCollector garbageCollector;

	/**
	 * The netty instance.
	 */
	// private Netty netty;

	/**
	 * The Io instance.
	 */
	private Io io;

	/** private LWThread<Content> contentThread;
	private LWThread<Logic> logicThread; */

	/**
	 * The constructor.
	 * 
	 * @throws IOException
	 */
	public Main() throws IOException {

		/* Create a new Garbage Collector. */
		this.setGarbageCollector(new GarbageCollector());

		/* Remove the Netty networking due to a few problems. */
		// this.setNetty(new Netty());

		/* Setup the Cycle based system for processes. */
		CycleSystem.getCycleSystem().addCycle(new ServerCycle(), 0);

		/* Setup the Io networking. */
		this.setIo(new Io());

		/* Setup the GameServer. */
		this.setGameServer(new GameServer());

		/*
		 * Create a new Thread with a new, lazy initialization of AreaSystem
		 * and start it up.
		 */
		new Thread(AreaSystem.getAreaSystem()).start();

		/** public static void main(final String[] args) {
			final Chainable chainable = new System();
			chainable.add(new ItemSystem()).add(new ContentSystem());
		} */
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 * 			The method's arguments.
	 * @throws IOException
	 */
	public static void main(final String[] args) throws IOException {
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
	 * @throws IOException
	 */
	public static Main getMain() throws IOException {
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
	/** public void setNetty(final Netty netty) {
		this.netty = netty;
	} */

	/**
	 * Gets the Netty networking.
	 * 
	 * @return netty
	 * 			The networking to get.
	 */
	/** public Netty getNetty() {
		return this.netty;
	} */

	/**
	 * Sets the Io networking.
	 * 
	 * @param io
	 * 			The Io networking to get.
	 */
	public void setIo(final Io io) {
		this.io = io;
	}

	/**
	 * Gets the Io networking.
	 * 
	 * @return io
	 * 			The Io networking to get.
	 */
	public Io getIo() {
		return this.io;
	}
}