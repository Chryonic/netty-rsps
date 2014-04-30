package com.runescape.revised.logic.net.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import com.runescape.util.Timer;

/**
 * We'll be using a regular input/output
 * for the server seeing how Netty isn't
 * working at this very moment.
 * 
 * @author Josh
 *
 */
public class Io {

	/**
	 * The ServerSocket.
	 */
	private ServerSocket serverSocket = null;

	/**
	 * The Socket.
	 */
	private Socket socket = null;

	/**
	 * The Client's thread.
	 */
	private ClientThread clientThread;

	/**
	 * Whether or not the server is
	 * running.
	 */
	private boolean isRunning = true;

	/**
	 * Class constructor.
	 */
	public Io() {
		final Timer timer = new Timer();
		try {
			this.setServerSocket(new ServerSocket(43594, 1, null));
			System.out.println("RuneScape Server started in " + timer.toString());
			while (this.isRunning()) {
				this.setSocket(this.getServerSocket().accept());
				this.getSocket().setTcpNoDelay(true);
				this.setClientThread(new ClientThread(this.getSocket()));
				try {
					Thread.sleep(1000);
					this.setRunning(false);
				} catch (final InterruptedException ie) {
					ie.printStackTrace();
				}
			}
			this.getServerSocket().close();
			this.getSocket().close();
			this.setServerSocket(null);
			this.setSocket(null);
		} catch (final SocketException se) {
			se.printStackTrace();
		} catch (final IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void setServerSocket(final ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}

	public ServerSocket getServerSocket() {
		return this.serverSocket;
	}

	public void setSocket(final Socket socket) {
		this.socket = socket;
	}

	public Socket getSocket() {
		return this.socket;
	}

	public void setClientThread(final ClientThread clientThread) {
		this.clientThread = clientThread;
	}

	public ClientThread getClientThread() {
		return this.clientThread;
	}

	public void setRunning(final boolean isRunning) {
		this.isRunning = isRunning;
	}

	public boolean isRunning() {
		return this.isRunning;
	}
}