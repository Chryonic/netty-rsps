package com.runescape;

import com.runescape.revised.GameClient;
import com.runescape.revised.GarbageCollector;
import com.runescape.revised.client.newclient.login.LoginFrame;
import com.runescape.revised.util.Timer;

/**
 * The Main class for the Client to
 * startup.
 * 
 * @author Josh
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
	 * The GarbageCollector instance.
	 */
	private GarbageCollector garbageCollector;

	/**
	 * The LoginFrame instance.
	 */
	private LoginFrame loginFrame;

	/**
	 * The Main constructor.
	 */
	public Main() {

		/* The timer to time how long the server takes. */
		final Timer timer = new Timer();

		/* The GameClient. */
		this.setGameClient(new GameClient());

		/* The garbage collector for cleaning up. */
		new GarbageCollector();

		/* The Netty networking API. */
		// new Netty();

		/* The LoginFrame so we can log into the game. */
		new LoginFrame();

		/* Print out how long it took to start everything up. */
		System.out.println("RuneScape Client started in " + timer.toString());
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 * 			The arguments for the client.
	 */
	public static void main(final String[] args) {

		/* Get the Main instance. */
		Main.getMain();
	}

	/**
	 * The setter for the Main instance.
	 * 
	 * @param main
	 * 			The Main to set.
	 */
	public static void setMain(final Main main) {

		/* Set the old Main instance to the new one. */
		Main.main = main;
	}

	/**
	 * The getter for the Main instance.
	 * 
	 * @return main
	 * 			The Main instance.
	 */
	public static Main getMain() {

		/* If the Main instance is null. */
		if (Main.main == null) {

			/* Create a new Main object. */
			Main.setMain(new Main());
		}

		/* Return the Main instance. */
		return Main.main;
	}

	/**
	 * The setter for the GameClient instance.
	 * 
	 * @param gameClient
	 * 			The gameClient parameter.
	 */
	public void setGameClient(final GameClient gameClient) {

		/* Set the old game client to the new one. */
		this.gameClient = gameClient;
	}

	/**
	 * The getter for the GameClient instance.
	 * 
	 * @return gameClient
	 * 			The gameClient instance.
	 */
	public GameClient getGameClient() {

		/* Return the game client. */
		return this.gameClient;
	}

	/**
	 * The setter for the GarbageCollector
	 * instance.
	 * 
	 * @param garbageCollector
	 * 			The garbage collector.
	 */
	public void setGarbageCollector(final GarbageCollector garbageCollector) {

		/* Set the old garbage collector to the new one. */
		this.garbageCollector = garbageCollector;
	}

	/**
	 * The getter for the GarbageCollector
	 * instance.
	 * 
	 * @return garbageCollector
	 * 			The garbage collector.
	 */
	public GarbageCollector getGarbageCollector() {

		/* Return the garbage collector. */
		return this.garbageCollector;
	}

	/**
	 * The setter for the LoginFrame
	 * instance.
	 * 
	 * @param loginFrame
	 * 			The login frame.
	 */
	public void setLoginFrame(final LoginFrame loginFrame) {

		/* Set the old login frame to the new one. */
		this.loginFrame = loginFrame;
	}

	/**
	 * The getter for the LoginFrame
	 * instance.
	 * 
	 * @return loginFrame
	 * 			The login frame.
	 */
	public LoginFrame getLoginFrame() {

		/* Return the login frame. */
		return this.loginFrame;
	}
}