package com.runescape.revised.logic.net.io;

import com.runescape.revised.logic.encryption.ISAACRandomGen;

public class IoPacketBuffer {

	public ISAACRandomGen packetEncryption = null;
	public byte[] buffer = null;
	public int currentOffset = 0;
	public int bitPosition = 0;
	public static int[] bitMaskOut = new int[32];

	public IoPacketBuffer() {}

	public IoPacketBuffer(final byte[] buffer) {
		this.buffer = buffer;
		this.currentOffset = 0;
	}

	public byte readSignedByteA() {
		return (byte) (this.buffer[this.currentOffset++] - 128);
	}

	public byte readSignedByteC() {
		return (byte) (-this.buffer[this.currentOffset++]);
	}

	public byte readSignedByteS() {
		return (byte) (128 - this.buffer[this.currentOffset++]);
	}

	public int readUnsignedByteA() {
		return (this.buffer[this.currentOffset++] - 128) & 0xFF;
	}

	public int readUnsignedByteC() {
		return -this.buffer[this.currentOffset++] & 0xFF;
	}

	public int readUnsignedByteS() {
		return (128 - this.buffer[this.currentOffset++]) & 0xFF;
	}

	public void writeByteA(final int i) {
		this.buffer[this.currentOffset++] = (byte) (i + 128);
	}

	public void writeByteS(final int i) {
		this.buffer[this.currentOffset++] = (byte) (128 - i);
	}

	public void writeByteC(final int i) {
		this.buffer[this.currentOffset++] = (byte) (-i);
	}

	public int readSignedWordBigEndian() {
		this.currentOffset += 2;
		int i = ((this.buffer[this.currentOffset - 1] & 0xFF) << 8) + (this.buffer[this.currentOffset - 2] & 0xFF);
		if (i > 32767) {
			i -= 0x10000;
		}
		return i;
	}

	public int readSignedWordA() {
		this.currentOffset += 2;
		int i = ((this.buffer[this.currentOffset - 2] & 0xFF) << 8) + ((this.buffer[this.currentOffset - 1] - 128) & 0xFF);
		if (i > 32767) {
			i -= 0x10000;
		}
		return i;
	}

	public int readSignedWordBigEndianA() {
		this.currentOffset += 2;
		int i = ((this.buffer[this.currentOffset - 1] & 0xFF) << 8) + ((this.buffer[this.currentOffset - 2] - 128) & 0xFF);
		if (i > 32767) {
			i -= 0x10000;
		}
		return i;
	}

	public int readUnsignedWordBigEndian() {
		this.currentOffset += 2;
		return ((this.buffer[this.currentOffset - 1] & 0xFF) << 8) + (this.buffer[this.currentOffset - 2] & 0xFF);
	}

	public int readUnsignedWordA() {
		this.currentOffset += 2;
		return ((this.buffer[this.currentOffset - 2] & 0xFF) << 8) + ((this.buffer[this.currentOffset - 1] - 128) & 0xFF);
	}

	public int readUnsignedWordBigEndianA() {
		this.currentOffset += 2;
		return ((this.buffer[this.currentOffset - 1] & 0xFF) << 8) + ((this.buffer[this.currentOffset - 2] - 128) & 0xFF);
	}

	public void writeWordBigEndianA(final int i) {
		this.buffer[this.currentOffset++] = (byte) (i + 128);
		this.buffer[this.currentOffset++] = (byte) (i >> 8);
	}

	public void writeWordA(final int i) {
		this.buffer[this.currentOffset++] = (byte) (i >> 8);
		this.buffer[this.currentOffset++] = (byte) (i + 128);
	}

	public void writeWordBigEndian_dup(final int i) {
		this.buffer[this.currentOffset++] = (byte) i;
		this.buffer[this.currentOffset++] = (byte) (i >> 8);
	}

	public int readDWord_v1() {
		this.currentOffset += 4;
		return ((this.buffer[this.currentOffset - 2] & 0xFF) << 24) + ((this.buffer[this.currentOffset - 1] & 0xFF) << 16) + ((this.buffer[this.currentOffset - 4] & 0xFF) << 8) + (this.buffer[this.currentOffset - 3] & 0xFF);
	}

	public int readDWord_v2() {
		this.currentOffset += 4;
		return ((this.buffer[this.currentOffset - 3] & 0xFF) << 24) + ((this.buffer[this.currentOffset - 4] & 0xFF) << 16) + ((this.buffer[this.currentOffset - 1] & 0xFF) << 8) + (this.buffer[this.currentOffset - 2] & 0xFF);
	}

	public void writeDWord_v1(final int i) {
		this.buffer[this.currentOffset++] = (byte) (i >> 8);
		this.buffer[this.currentOffset++] = (byte) i;
		this.buffer[this.currentOffset++] = (byte) (i >> 24);
		this.buffer[this.currentOffset++] = (byte) (i >> 16);
	}

	public void writeDWord_v2(final int i) {
		this.buffer[this.currentOffset++] = (byte) (i >> 16);
		this.buffer[this.currentOffset++] = (byte) (i >> 24);
		this.buffer[this.currentOffset++] = (byte) i;
		this.buffer[this.currentOffset++] = (byte) (i >> 8);
	}

	public void readBytes_reverse(final byte[] abyte0, final int i, final int j) {
		for (int k = (j + i) - 1; k >= j; k--) {
			abyte0[k] = this.buffer[this.currentOffset++];
		}
	}

	public void writeBytes_reverseA(final byte[] abyte0, final int i, final int j) {
		for (int k = (j + i) - 1; k >= j; k--) {
			this.buffer[this.currentOffset++] = (byte) (abyte0[k] + 128);
		}
	}

	public void createFrame(final int i) {
		this.buffer[this.currentOffset++] = (byte) (i + this.packetEncryption.getNextKey());
	}

	public void writeByte(final int i) {
		this.buffer[this.currentOffset++] = (byte) i;
	}

	public void writeWord(final int i) {
		this.buffer[this.currentOffset++] = (byte) (i >> 8);
		this.buffer[this.currentOffset++] = (byte) i;
	}

	public void writeWordBigEndian(final int i) {
		this.buffer[this.currentOffset++] = (byte) i;
		this.buffer[this.currentOffset++] = (byte) (i >> 8);
	}

	public void write3Byte(final int i) {
		this.buffer[this.currentOffset++] = (byte) (i >> 16);
		this.buffer[this.currentOffset++] = (byte) (i >> 8);
		this.buffer[this.currentOffset++] = (byte) i;
	}

	public void writeDWord(final int i) {
		this.buffer[this.currentOffset++] = (byte) (i >> 24);
		this.buffer[this.currentOffset++] = (byte) (i >> 16);
		this.buffer[this.currentOffset++] = (byte) (i >> 8);
		this.buffer[this.currentOffset++] = (byte) i;
	}

	public void writeDWordBigEndian(final int i) {
		this.buffer[this.currentOffset++] = (byte) i;
		this.buffer[this.currentOffset++] = (byte) (i >> 8);
		this.buffer[this.currentOffset++] = (byte) (i >> 16);
		this.buffer[this.currentOffset++] = (byte) (i >> 24);
	}

	public void writeQWord(final long l) {
		this.buffer[this.currentOffset++] = (byte) (int) (l >> 56);
		this.buffer[this.currentOffset++] = (byte) (int) (l >> 48);
		this.buffer[this.currentOffset++] = (byte) (int) (l >> 40);
		this.buffer[this.currentOffset++] = (byte) (int) (l >> 32);
		this.buffer[this.currentOffset++] = (byte) (int) (l >> 24);
		this.buffer[this.currentOffset++] = (byte) (int) (l >> 16);
		this.buffer[this.currentOffset++] = (byte) (int) (l >> 8);
		this.buffer[this.currentOffset++] = (byte) (int) l;
	}

	@SuppressWarnings("deprecation")
	public void writeString(final java.lang.String s) {
		s.getBytes(0, s.length(), this.buffer, this.currentOffset);
		this.currentOffset += s.length();
		this.buffer[this.currentOffset++] = 10;
	}

	public void writeBytes(final byte abyte0[], final int i, final int j) {
		for (int k = j; k < (j + i); k++) {
			this.buffer[this.currentOffset++] = abyte0[k];
		}
	}

	public void writeFrameSize(final int i) {
		this.buffer[this.currentOffset - i - 1] = (byte) i;
	}

	public void writeFrameSizeWord(final int i) {
		this.buffer[this.currentOffset - i - 2] = (byte) (i >> 8);
		this.buffer[this.currentOffset - i - 1] = (byte) i;
	}

	public int readUnsignedByte() {
		return this.buffer[this.currentOffset++] & 0xFF;
	}

	public byte readSignedByte() {
		return this.buffer[this.currentOffset++];
	}

	public int readUnsignedWord() {
		this.currentOffset += 2;
		return ((this.buffer[this.currentOffset - 2] & 0xFF) << 8) + (this.buffer[this.currentOffset - 1] & 0xFF);
	}

	public int readSignedWord() {
		this.currentOffset += 2;
		int i = ((this.buffer[this.currentOffset - 2] & 0xFF) << 8) + (this.buffer[this.currentOffset - 1] & 0xFF);
		if (i > 32767) {
			i -= 0x10000;
		}
		return i;
	}

	public int readDWord() {
		this.currentOffset += 4;
		return ((this.buffer[this.currentOffset - 4] & 0xFF) << 24) + ((this.buffer[this.currentOffset - 3] & 0xFF) << 16) + ((this.buffer[this.currentOffset - 2] & 0xFF) << 8) + (this.buffer[this.currentOffset - 1] & 0xFF);
	}

	public long readQWord() {
		final long l = this.readDWord() & 0xFFFFFFFFL;
		final long l1 = this.readDWord() & 0xFFFFFFFFL;
		return (l << 32) + l1;
	}

	public String readString() {
		final int i = this.currentOffset;
		while (this.buffer[this.currentOffset++] != 10) {
			;
		}
		return new String(this.buffer, i, this.currentOffset - i - 1);
	}

	public void readBytes(final byte[] abyte0, final int i, final int j) {
		for (int k = j; k < (j + i); k++) {
			abyte0[k] = this.buffer[this.currentOffset++];
		}
	}

	public void initBitAccess() {
		this.bitPosition = this.currentOffset * 8;
	}

	public void writeBits(int numBits, final int value) {
		int bytePos = this.bitPosition >> 3;
		int bitOffset = 8 - (this.bitPosition & 7);
		this.bitPosition += numBits;
		for (; numBits > bitOffset; bitOffset = 8) {
			this.buffer[bytePos] &= ~ IoPacketBuffer.bitMaskOut[bitOffset];		// mask out the desired area
			this.buffer[bytePos++] |= (value >> (numBits - bitOffset)) & IoPacketBuffer.bitMaskOut[bitOffset];
			numBits -= bitOffset;
		}
		if (numBits == bitOffset) {
			this.buffer[bytePos] &= ~ IoPacketBuffer.bitMaskOut[bitOffset];
			this.buffer[bytePos] |= value & IoPacketBuffer.bitMaskOut[bitOffset];
		} else {
			this.buffer[bytePos] &= ~ (IoPacketBuffer.bitMaskOut[numBits] << (bitOffset - numBits));
			this.buffer[bytePos] |= (value&IoPacketBuffer.bitMaskOut[numBits]) << (bitOffset - numBits);
		}
	}

	public void finishBitAccess() {
		this.currentOffset = (this.bitPosition + 7) / 8;
	}

	static {
		for (int i = 0; i < 32; i++) {
			int power = 1;
			for (int x = 0; x < i; x++) {
				power *= 2;
			}
			IoPacketBuffer.bitMaskOut[i] = power - 1;
		}
	}
}