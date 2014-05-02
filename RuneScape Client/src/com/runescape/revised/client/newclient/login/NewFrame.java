package com.runescape.revised.client.newclient.login;

import java.awt.Frame;
import java.awt.Panel;

/**
 * The NewFrame for a newer look and feel.
 * 
 * @author Josh
 *
 */
public class NewFrame extends Frame {

	/**
	 * The generated serial version.
	 */
	private static final long serialVersionUID = -6937113470579526192L;

	/**
	 * The panel to view everything.
	 */
	private Panel panel;

	/**
	 * Class constructor.
	 */
	public NewFrame() {

		/* Creates a new Panel. */
		this.setPanel(new Panel());

		/* Adds the Panel to the Frame. */
		this.add(this.getPanel());
	}

	/**
	 * Sets the panel.
	 * 
	 * @param panel
	 * 			The panel to set.
	 */
	public void setPanel(final Panel panel) {

		/* Sets the old panel equal to the new one. */
		this.panel = panel;
	}

	/**
	 * Gets the panel.
	 * 
	 * @return panel
	 * 			The panel to get.
	 */
	public Panel getPanel() {

		/* Returns the panel. */
		return this.panel;
	}
}