package com.runescape.revised.thread;

public class LWThread<T> implements Runnable {

	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @param t
	 * 			The Object to add.
	 * @return this
	 */
	public LWThread<T> add(final T t) {
		return this;
	}

	/**
	 * 
	 * 
	 * @param t
	 * 			The Object to remove.
	 * @return this
	 * 
	 */
	public LWThread<T> remove(final T t) {
		return this;
	}
}