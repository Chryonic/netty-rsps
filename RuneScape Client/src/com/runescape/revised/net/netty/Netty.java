package com.runescape.revised.net.netty;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

import org.jboss.netty.bootstrap.ClientBootstrap;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.socket.nio.NioClientSocketChannelFactory;

public class Netty {

	private ClientBootstrap clientBootstrap;
	
	public Netty() {
		this.setClientBootstrap(new ClientBootstrap((ChannelFactory) new NioClientSocketChannelFactory(Executors.newCachedThreadPool(), Executors.newCachedThreadPool())));
		this.getClientBootstrap().setPipelineFactory(new ClientPipelineFactory());
		this.getClientBootstrap().bind(new InetSocketAddress(43594));
	}

	public void setClientBootstrap(ClientBootstrap clientBootstrap) {
		this.clientBootstrap = clientBootstrap;
	}

	public ClientBootstrap getClientBootstrap() {
		return clientBootstrap;
	}
}