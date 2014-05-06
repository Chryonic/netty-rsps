package com.runescape.revised.system.area;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.runescape.revised.system.System;
import com.runescape.revised.system.area.impl.Background;
import com.runescape.revised.system.area.impl.Foreground;
import com.runescape.revised.system.area.impl.Midground;

public class AreaSystem extends System implements Runnable {

	private static AreaSystem areaSystem;

	/**
	 * The Background area.
	 */
	private Area backgroundArea;

	/**
	 * The Midground area.
	 */
	private Area midgroundArea;

	/**
	 * The Foreground area.
	 */
	private Area foregroundArea;

	/**
	 * Class constructor.
	 * @throws IOException
	 */
	public AreaSystem() throws IOException {

		/* Create a new Background for background tasks. */
		this.setBackgroundArea(new Background());

		/* Create a new Midground for midground tasks. */
		this.setMidgroundArea(new Midground());

		/* Create a new Foreground for the single foreground task. */
		this.setForegroundArea(new Foreground());

		/*  */
		java.lang.System.out.println("System Amount Total: " + this.getSystemAmount());
	}

	@Override
	public void executeSystem() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		if (this.getForegroundArea().getSystems().length >= 2) {
			java.lang.System.out.println("System amount within foreground is greater than or equal to 2.");
			return;
		}
	}

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public byte getSystemAmount() throws IOException {
		byte increment = 0;
		final File directory = new File("C:/Users/Josh/Desktop/Programming/RuneScape/RuneScape Server/src/com/runescape/");
		final File[] filesWithinDirectory = directory.listFiles();
		for (final File f : filesWithinDirectory) {
			final BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
			final String line = bufferedReader.readLine();
			while (line != null) {
				if (line.contains("extends System")) {
					increment++;
				}
			}
		}
		return increment;
	}

	public static void setAreaSystem(final AreaSystem areaSystem) {
		AreaSystem.areaSystem = areaSystem;
	}

	public static AreaSystem getAreaSystem() {
		if (AreaSystem.areaSystem == null) {
			try {
				AreaSystem.setAreaSystem(new AreaSystem());
			} catch (final IOException ioe) {
				// TODO Auto-generated catch block
				ioe.printStackTrace();
			}
		}
		return AreaSystem.areaSystem;
	}

	public void setBackgroundArea(final Area backgroundArea) {
		this.backgroundArea = backgroundArea;
	}

	public Area getBackgroundArea() {
		return this.backgroundArea;
	}

	public void setMidgroundArea(final Area midgroundArea) {
		this.midgroundArea = midgroundArea;
	}

	public Area getMidgroundArea() {
		return this.midgroundArea;
	}

	public void setForegroundArea(final Area foregroundArea) {
		this.foregroundArea = foregroundArea;
	}

	public Area getForegroundArea() {
		return this.foregroundArea;
	}
}