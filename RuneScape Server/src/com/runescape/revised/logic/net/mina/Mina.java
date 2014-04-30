package com.runescape.revised.logic.net.mina;

import java.io.IOException;
import java.net.InetSocketAddress;

import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 * The MINA networking API.
 * 
 * @author Josh
 *
 */
public class Mina {

	/**
	 * Class constructor.
	 * 
	 * @throws IOException
	 * 			
	 */
	public Mina() throws IOException {
		final IoAcceptor ioAcceptor = new NioSocketAcceptor(2);
		ioAcceptor.setHandler(new ServerIoHandler());
		ioAcceptor.bind(new InetSocketAddress(43594));
	}
}