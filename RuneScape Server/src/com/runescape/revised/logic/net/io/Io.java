package com.runescape.revised.logic.net.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
	 * Class constructor.
	 * 
	 * @throws IOException
	 */
	public Io() throws IOException {
		final ServerSocket serverSocket = new ServerSocket(43594, 1, null);
		final Socket socket = serverSocket.accept();
		socket.setTcpNoDelay(true);
		// (new Thread(new ClientHandler(socket))).start();
	}
}