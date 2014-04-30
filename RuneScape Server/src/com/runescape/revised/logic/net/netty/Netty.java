package com.runescape.revised.logic.net.netty;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import com.runescape.revised.logic.net.netty.pipeline.ServerPipelineFactory;

public class Netty {
	
	public Netty() {
		final ChannelFactory channelFactory = new NioServerSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool());
		final ServerBootstrap serverBootstrap = new ServerBootstrap(channelFactory);
		serverBootstrap.setPipelineFactory(new ServerPipelineFactory());
		serverBootstrap.setOption("tcpNoDelay", true);
		serverBootstrap.setOption("keepAlive", true);
		serverBootstrap.bind(new InetSocketAddress(43594));
		/** 
		 * final ServerBootstrap httpServerBootstrap = new ServerBootstrap(channelFactory);
		 * httpServerBootstrap.setPipelineFactory(new HTTPPipelineFactory());
		 * final ServerBootstrap jaggrabServerBootstrap = new ServerBootstrap(channelFactory);
		 * jaggrabServerBootstrap.setPipelineFactory(new JAGGrabPipelineFactory());
		 */
	}
}