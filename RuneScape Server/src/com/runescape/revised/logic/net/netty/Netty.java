package com.runescape.revised.logic.net.netty;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import com.runescape.revised.logic.net.netty.pipeline.ServerPipelineFactory;

public class Netty {
	
	public Netty() {
		ServerBootstrap serverBootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool()));
		serverBootstrap.setPipelineFactory(new ServerPipelineFactory());
		serverBootstrap.setOption("tcpNoDelay", true);
		serverBootstrap.setOption("keepAlive", true);
		serverBootstrap.bind(new InetSocketAddress(43594));
	}
}