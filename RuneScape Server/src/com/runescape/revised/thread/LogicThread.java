package com.runescape.revised.thread;

import com.runescape.revised.client.ClientList;

public class LogicThread extends Thread {

	private ClientList clientList;

	@Override
	public void run() {
		this.setClientList(new ClientList());
		this.getClientList().addClient("127.0.0.1");
	}

	public void setClientList(ClientList clientList) {
		this.clientList = clientList;
	}

	public ClientList getClientList() {
		return this.clientList;
	}
}