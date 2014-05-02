package com.runescape.revised.client.newclient.login;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import com.runescape.revised.client.newclient.GameClientState;
import com.runescape.revised.client.newclient.Main;

/**
 * The Login Frame for logging in.
 * 
 * @author Josh
 *
 */
public class LoginFrame extends JFrame {

	/**
	 * The generated serial version.
	 */
	private static final long serialVersionUID = -6663761968794517716L;

	/**
	 * The loading bar to load models, images, etc.
	 */
	private JProgressBar loadingBar;

	/**
	 * The username label.
	 */
	private JLabel userLabel;

	/**
	 * The text field to write out your username.
	 */
	private JTextField userTextField;

	/**
	 * The password label.
	 */
	private JLabel passLabel;

	/**
	 * The text field to write out your password.
	 */
	private JPasswordField passTextField;

	/**
	 * The login button to login to the game.
	 */
	private JButton loginButton;

	/**
	 * Class constructor.
	 */
	public LoginFrame() {

		/* Create a new JPanel for adding components to. */
		final JPanel loginPanel = new JPanel();

		/* Create a new JLabel for the username. */
		this.setUserLabel(new JLabel("Username"));

		/* Create a new JTextField for the username. */
		this.setUserTextField(new JTextField());

		/* Set the amount of columns (how long the bar is). */
		this.getUserTextField().setColumns(10);

		/* Create a new JLabel for the password. */
		this.setPassLabel(new JLabel("Password"));

		/* Create a new JPasswordField for the password. */
		this.setPassTextField(new JPasswordField());

		/* Set the amount of columns (how long the bar is). */
		this.getPassTextField().setColumns(10);

		/* Create a new JButton for the login. */
		this.setLoginButton(new JButton("Login"));

		/* Set the login button to enabled. */
		this.getLoginButton().setEnabled(true);

		/* Add the ActionListener to the LoginButton. */
		this.getLoginButton().addActionListener(new ActionListener() {

			/* Override the actionPerformed method. */
			@Override
			public void actionPerformed(final ActionEvent ae) {

				/* Set the GameClient's state. */
				Main.setGameClientState(GameClientState.LOGIN);

				/* Make the password readable by converting it to a String. */
				final String password = new String(LoginFrame.this.getPassTextField().getPassword());

				/* Create the login with the required credentials. */
				new Login(LoginFrame.this, LoginFrame.this.getUserTextField().getText(), password);
			}
		});

		/* Add the username label to the panel. */
		loginPanel.add(this.getUserLabel());

		/* Add the username text field to the panel. */
		loginPanel.add(this.getUserTextField());

		/* Add the password label to the panel. */
		loginPanel.add(this.getPassLabel());

		/* Add the password text field to the panel. */
		loginPanel.add(this.getPassTextField());

		/* Add the login button to the login panel. */
		loginPanel.add(this.getLoginButton());

		/* Create a new JProgressBar. */
		this.setLoadingBar(new JProgressBar());

		/* Set the size of the loading bar. */
		this.getLoadingBar().setSize(100, 50);

		/* Set the value of the loading bar.*/
		this.getLoadingBar().setValue(100);

		/* Add the loading bar to the NORTH end of the Border. */
		this.add(this.getLoadingBar(), BorderLayout.NORTH);

		/* Add the login panel to the SOUTH end of the Border. */
		this.add(loginPanel, BorderLayout.SOUTH);

		/* Set the title of the JFrame. */
		this.setTitle("RuneScape Login");

		/* Set the size of the JFrame. */
		this.setSize(500, 90);

		/* Set it to be resizable. */
		this.setResizable(false);

		/* Set the JFrame visibility to true. */
		this.setVisible(true);

		/* Set the close operation to exit when clicking on the "x" button. */
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Shutdown the LoginFrame.
	 */
	public void shutdown() {

		/* Set the visibility of the LoginFrame to false. */
		this.setVisible(false);
	}

	/**
	 * 
	 * @param progressionAmount
	 * @param text
	 */
	public void drawText(final byte progressionAmount, final String text) {
		this.getLoadingBar().setValue(progressionAmount);
		this.getLoadingBar().setString(text);
	}

	/**
	 * 
	 * @param loadingBar
	 */
	public void setLoadingBar(final JProgressBar loadingBar) {
		this.loadingBar = loadingBar;
	}

	public JProgressBar getLoadingBar() {
		return this.loadingBar;
	}

	public void setUserLabel(final JLabel userLabel) {
		this.userLabel = userLabel;
	}

	public JLabel getUserLabel() {
		return this.userLabel;
	}

	public void setUserTextField(final JTextField userTextField) {
		this.userTextField = userTextField;
	}

	public JTextField getUserTextField() {
		return this.userTextField;
	}

	public void setPassLabel(final JLabel passLabel) {
		this.passLabel = passLabel;
	}

	public JLabel getPassLabel() {
		return this.passLabel;
	}

	/**
	 * The setter for the JPasswordField
	 * instance.
	 * 
	 * @param passTextField
	 * 			The password text field.
	 */
	public void setPassTextField(final JPasswordField passTextField) {
		this.passTextField = passTextField;
	}

	/**
	 * The getter for the JPasswordField
	 * instance.
	 * 
	 * @return passTextField
	 * 			The password text field.
	 */
	public JPasswordField getPassTextField() {
		return this.passTextField;
	}

	/**
	 * The getter for the LoginButton
	 * instance.
	 * 
	 * @return loginButton
	 * 			The login button.
	 */
	public void setLoginButton(final JButton loginButton) {
		this.loginButton = loginButton;
	}

	/**
	 * The getter for the LoginButton
	 * instance.
	 * 
	 * @return loginButton
	 * 			The login button.
	 */
	public JButton getLoginButton() {
		return this.loginButton;
	}
}