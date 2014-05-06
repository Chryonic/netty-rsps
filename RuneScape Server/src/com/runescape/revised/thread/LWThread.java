package com.runescape.revised.thread;

import com.runescape.Constants;

public class LWThread<T> extends Thread implements Runnable {

	/**
	 * The capacity for the LWThread.
	 */
	private int capacity;

	/**
	 * Whether or not Thread per Client is being
	 * used.
	 */
	private boolean isThreadPerClient;

	/**
	 * The amount of connections - starting off at 0
	 * since we haven't connected yet.
	 */
	private short connectionAmount = 0;

	/**
	 * The size of the LWThread.
	 */
	private short size = 0;

	/**
	 * The array of Objects.
	 */
	private Object[] objectArray;

	/**
	 * Class constructor.
	 */
	public LWThread() {
		this(50);
	}

	/**
	 * Class constructor.
	 * 
	 * @param capacity
	 * 			The capacity to set.
	 */
	public LWThread(final int capacity) {
		this.setCapacity(capacity);
	}

	/**
	 * 
	 * @param t
	 * 			The Object to add.
	 * @return this
	 */
	public LWThread<T> add(final T t) {

		// TODO use an array or a Node to add and remove Objects?

		/* Increase the connectionAmount by 1. */
		this.setConnectionAmount(this.connectionAmount++);

		/* If we are working on the Thread per Client model. */
		if (this.isThreadPerClient()) {

			/* If the connection is equal to the maximum connections per thread (50). */
			if (this.getSize() == Constants.MAX_CONNECTIONS_PER_THREAD) {

				/* Create a new Thread and add the Element to the LWThread list. */
				final LWThread<T> lwThread = new LWThread<T>(this.getCapacity()).add(t); // TODO FIND OUT IF THIS IS CORRECT!

				/* Start up the Thread. */
				lwThread.start();
			}
		}

		/* Return this for chaining purposes. */
		return new LWThread<T>();
	}

	/**
	 * Check if the list is empty or not.
	 * 
	 * @return
	 * 			Whether the size is 0.
	 */
	public boolean isEmpty() {

		/* Return if the size is equal to 0. */
		return this.getSize() == 0;
	}

	/**
	 * Get something out of the LWThread.
	 * 
	 * @param t
	 * 			The object to get.
	 * @return this
	 * 			This for chaining purposes.
	 */
	public LWThread<T> get(final T t) {

		// TODO

		/* Return this for chaining purposes. */
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

		// TODO use an array or a Node to add and remove Objects?

		/* Return this for chaining purposes. */
		return this;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	/**
	 * Sets the capacity.
	 * 
	 * @param capacity
	 * 			The capacity to set.
	 */
	public void setCapacity(final int capacity) {

		/* Set the old capacity to the new one. */
		this.capacity = capacity;
	}

	/**
	 * Gets the capacity.
	 * 
	 * @return capacity
	 * 			The capacity to get.
	 */
	public int getCapacity() {

		/* Return the capacity. */
		return this.capacity;
	}

	/**
	 * Sets the boolean isThreadPerClient.
	 * 
	 * @param isThreadPerClient
	 * 			The boolean to set.
	 */
	public void setThreadPerClient(final boolean isThreadPerClient) {

		/* Sets the old isThreadPerClient to the new one. */
		this.isThreadPerClient = isThreadPerClient;
	}

	/**
	 * Gets the boolean isThreadPerClient.
	 * 
	 * @return isThreadPerClient
	 * 			The boolean to get.
	 */
	public boolean isThreadPerClient() {

		/* Return the boolean isThreadPerClient. */
		return this.isThreadPerClient;
	}

	/**
	 * Sets the amount of connections.
	 * 
	 * @param connectionAmount
	 * 			The amount of connections.
	 */
	public void setConnectionAmount(final short connectionAmount) {

		/* Sets the old connectionAmount to the new one. */
		this.connectionAmount = connectionAmount;
	}

	/**
	 * Gets the amount of connections.
	 * 
	 * @return connectionAmount
	 * 			The amount of connections.
	 */
	public short getConnectionAmount() {

		/* Return the amount of connections. */
		return this.connectionAmount;
	}

	/**
	 * 
	 * @param size
	 */
	public void setSize(final short size) {

		/* Set the old size equal to the new one. */
		this.size = size;
	}

	/**
	 * Gets the size.
	 * 
	 * @return size
	 * 			The size of the LWThread.
	 */
	public short getSize() {

		/* Return the size of the LWThread. */
		return this.size;
	}

	/**
	 * Sets the Object array.
	 * 
	 * @param objectArray
	 * 			The Object array to set.
	 */
	public void setObjectArray(final Object[] objectArray) {

		/* Sets the old Object array to a new one. */
		this.objectArray = objectArray;
	}

	/**
	 * Gets the array of Objects.
	 * 
	 * @return objectArray
	 * 			The Object array to get.
	 */
	public Object[] getObjectArray() {

		/* Return the Object array. */
		return this.objectArray;
	}
}