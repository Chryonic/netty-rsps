package com.runescape.revised.client.load;

public interface Chainable<E> {

	public void add(E e);
	public void remove(E e);
}