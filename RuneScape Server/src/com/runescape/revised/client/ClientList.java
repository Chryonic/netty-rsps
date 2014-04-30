package com.runescape.revised.client;

import java.util.Hashtable;
import java.util.Map;

public class ClientList {

	private Map<String, Integer> socketMap;

	public ClientList() {
		this.setSocketMap(new Hashtable<String, Integer>());
	}

	public void addClient(final String connection) {
		synchronized(this.getSocketMap()) {
			// this.getSocketMap().add(connection);			
		}
	}

	public void removeClient(final String connection) {
		synchronized(this.getSocketMap()) {
			this.getSocketMap().remove(connection);
		}
	}

	public void setSocketMap(final Map<String, Integer> socketMap) {
		this.socketMap = socketMap;
	}

	public Map<String, Integer> getSocketMap() {
		return this.socketMap;
	}
}