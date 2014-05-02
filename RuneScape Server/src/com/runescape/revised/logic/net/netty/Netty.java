package com.runescape.revised.logic.net.netty;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import com.runescape.revised.logic.net.netty.pipeline.ServerPipelineFactory;

/**
 * The Netty networking class.
 * 
 * @author Josh
 *
 */
public class Netty {

	/**
	 * Class constructor.
	 */
	public Netty() {
		/* Set up the ChannelFactory for all Bootstraps. */
		final ChannelFactory channelFactory = new NioServerSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool());

		/* Set up the main Btootstrap. */
		final ServerBootstrap serverBootstrap = new ServerBootstrap(channelFactory);

		/* Set up the Pipeline Factory for the main Bootstrap. */
		serverBootstrap.setPipelineFactory(new ServerPipelineFactory());

		/* Set the TCP to no delay. */
		serverBootstrap.setOption("tcpNoDelay", true);

		/* Keep the  */
		serverBootstrap.setOption("keepAlive", true);

		/* Bind the port for the Socket to connect to. */
		serverBootstrap.bind(new InetSocketAddress(43594));
		/**
		 * final ServerBootstrap httpServerBootstrap = new ServerBootstrap(channelFactory);
		 * httpServerBootstrap.setPipelineFactory(new HTTPPipelineFactory());
		 * final ServerBootstrap jaggrabServerBootstrap = new ServerBootstrap(channelFactory);
		 * jaggrabServerBootstrap.setPipelineFactory(new JAGGrabPipelineFactory());
		 */
	}
}