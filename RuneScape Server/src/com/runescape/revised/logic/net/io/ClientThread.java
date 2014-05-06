package com.runescape.revised.logic.net.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.runescape.revised.logic.encryption.ISAACRandomGen;

/**
 * Represents a Thread for the Client
 * connecting to the Server.
 * 
 * @author Josh
 *
 */
public class ClientThread implements Runnable {

	private Socket socket;
	private Thread clientThread;
	// private LWThread<Client> clientThreadList = new LWThread<Client>(2000);
	private InputStream inputStream;
	private OutputStream outputStream;
	private IoPacketBuffer inStream;
	private IoPacketBuffer outStream;
	private ISAACRandomGen inStreamDecryption;
	private ISAACRandomGen outStreamDecryption;

	/**
	 * The constructor.
	 * 
	 * @param socket
	 * 			The Socket we wish to connect
	 * 			with.
	 * @throws IOException
	 */
	public ClientThread(final Socket socket) {
		this.setSocket(socket);
		this.setClientThread(new Thread(this));
		this.getClientThread().start();
		try {
			this.setInputStream(socket.getInputStream());
			this.setOutputStream(socket.getOutputStream());
		} catch (final IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		this.setOutStream(new IoPacketBuffer(new byte[100000]));
		this.getOutStream().currentOffset = 0;
		this.setInStream(new IoPacketBuffer(new byte[10000]));
		this.getInStream().currentOffset = 0;
		long serverSessionKey = 0;
		long clientSessionKey = 0;
		serverSessionKey = ((long) (Math.random() * 99999999D) << 32) + (long) (Math.random() * 99999999D);
		try {
			this.fillInStream(2);
			if (this.getInStream().readUnsignedByte() != 14) {
				return;
			}
			this.getInStream().readUnsignedByte();
			for (int i = 0; i < 8; i++) {
				this.getOutputStream().write(0);
			}
			this.getOutputStream().write(0);
			this.getOutStream().writeQWord(serverSessionKey);
			this.flushOutStream();
			this.fillInStream(2);
			final int loginType = this.getInStream().readUnsignedByte();
			if ((loginType != 16) && (loginType != 18)) {
				return;
			}
			final int loginPacketSize = this.getInStream().readUnsignedByte();
			int loginEncryptPacketSize = loginPacketSize - 40;
			if (loginEncryptPacketSize <= 0) {
				return;
			}
			this.fillInStream(loginPacketSize);
			if (this.getInStream().readUnsignedByte() != 255) {
				return;
			}
			final short revision = (short) this.getInStream().readUnsignedWord();
			switch (revision) {
			case 317:
				System.out.println("Revision #317 supported!");
				break;
			case 562:
				System.out.println("Revision #562 supported!");
				break;
			default:
				System.out.println("No revision supported!");
				break;
			}
			this.getInStream().readUnsignedByte(); // memory.
			for (int i = 0; i < 9; i++) {
				Integer.toHexString(this.getInStream().readDWord());
			}
			loginEncryptPacketSize--;
			int tmp = this.getInStream().readUnsignedByte();
			if (loginEncryptPacketSize != tmp) {
				return;
			}
			tmp = this.getInStream().readUnsignedByte();
			if (tmp != 10) {
				return;
			}
			clientSessionKey = this.getInStream().readQWord();
			serverSessionKey = this.getInStream().readQWord();
			@SuppressWarnings("unused")
			final int userID = this.getInStream().readDWord();
			this.getInStream().readString();
			@SuppressWarnings("unused")
			final String password = this.getInStream().readString();
			final int sessionKey[] = new int[4];
			sessionKey[0] = (int) (clientSessionKey >> 32);
			sessionKey[1] = (int) clientSessionKey;
			sessionKey[2] = (int) (serverSessionKey >> 32);
			sessionKey[3] = (int) serverSessionKey;
			for (int i = 0; i < 4; i++) {
				Integer.toHexString(sessionKey[i]);
			}
			this.setInStreamDecryption(new ISAACRandomGen(sessionKey));
			for (int i = 0; i < 4; i++) {
				sessionKey[i] += 50;
			}
			for (int i = 0; i < 4; i++) {
				Integer.toHexString(sessionKey[i]);
			}
			this.setOutStreamDecryption(new ISAACRandomGen(sessionKey));
			this.getOutStream().packetEncryption = this.getOutStreamDecryption();
			this.getOutputStream().write(2);
			this.getOutputStream().write(0);
			this.getOutputStream().write(0);
			// this.getOutStream().createFrame(249);
			// this.getOutStream().writeByteA(1);
			// this.getOutStream().writeWordA(1);
			// this.getOutStream().createFrame(107);
		} catch (final Exception e) {
			e.printStackTrace();
			return;
		}
		final int mapRegionX = 0x182, mapRegionY = 0x195;
		this.getOutStream().createFrame(73);
		this.getOutStream().writeWordA(mapRegionX);
		this.getOutStream().writeWord(mapRegionY);
	}

	public void flushOutStream() throws IOException {
		this.getOutputStream().write(this.getOutStream().buffer, 0, this.getOutStream().currentOffset);
		this.getOutStream().currentOffset = 0;
	}

	public void fillInStream(final int forceRead) throws IOException {
		this.getInStream().currentOffset = 0;
		this.getInputStream().read(this.getInStream().buffer, 0, forceRead);
	}

	public void setSocket(final Socket socket) {
		this.socket = socket;
	}

	public Socket getSocket() {
		return this.socket;
	}

	public void setClientThread(final Thread clientThread) {
		this.clientThread = clientThread;
	}

	public Thread getClientThread() {
		return this.clientThread;
	}

	public void setInputStream(final InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public InputStream getInputStream() {
		return this.inputStream;
	}

	public void setOutputStream(final OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	public OutputStream getOutputStream() {
		return this.outputStream;
	}

	public void setInStream(final IoPacketBuffer inStream) {
		this.inStream = inStream;
	}

	public IoPacketBuffer getInStream() {
		return this.inStream;
	}

	public void setOutStream(final IoPacketBuffer outStream) {
		this.outStream = outStream;
	}

	public IoPacketBuffer getOutStream() {
		return this.outStream;
	}

	public void setInStreamDecryption(final ISAACRandomGen inStreamDecryption) {
		this.inStreamDecryption = inStreamDecryption;
	}

	public ISAACRandomGen getInStreamDecryption() {
		return this.inStreamDecryption;
	}

	public void setOutStreamDecryption(final ISAACRandomGen outStreamDecryption) {
		this.outStreamDecryption = outStreamDecryption;
	}

	public ISAACRandomGen getOutStreamDecryption() {
		return this.outStreamDecryption;
	}
}