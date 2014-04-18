package com.runescape.revised.logic.net.netty;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

public class Netty {

	private ServerBootstrap serverBootstrap;
	
	public Netty() {
		this.setServerBootstrap(new ServerBootstrap(new NioServerSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool())));
		this.getServerBootstrap().setPipelineFactory(new ServerPipelineFactory());
		this.getServerBootstrap().bind(new InetSocketAddress(43594));
	}

	public void setServerBootstrap(ServerBootstrap serverBootstrap) {
		this.serverBootstrap = serverBootstrap;
	}

	public ServerBootstrap getServerBootstrap() {
		return this.serverBootstrap;
	}
}