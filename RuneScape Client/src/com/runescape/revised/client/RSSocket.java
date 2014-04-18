package com.runescape.revised.client;

public class RSSocket {

	public Socket openSocket(int i) throws IOException
	{
		if(SignLink.mainapp != null)
			return SignLink.opensocket(i);
		else
			return new Socket(InetAddress.getByName(getCodeBase().getHost()), i);
	}
}