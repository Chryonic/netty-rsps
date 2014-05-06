package com.runescape.util;

import com.runescape.revised.logic.encryption.ISAACRandomGen;

public class Stream {

	public byte[] buffer = null;
	public int currentOffset = 0;
	public int bitPosition = 0;
	public static int[] bitMaskOut = new int[32];
	public ISAACRandomGen packetEncryption = null;

	public Stream() {}

	public Stream(final byte abyte0[]) {
		this.buffer = abyte0;
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
		return (this.buffer[this.currentOffset++] - 128) & 0xff;
	}

	public int readUnsignedByteC() {
		return -this.buffer[this.currentOffset++] & 0xff;
	}

	public int readUnsignedByteS() {
		return (128 - this.buffer[this.currentOffset++]) & 0xff;
	}

	public void writeByteA(final int i) {
		this.ensureCapacity(1);
		this.buffer[this.currentOffset++] = (byte) (i + 128);
	}

	public void writeByteS(final int i) {
		this.ensureCapacity(1);
		this.buffer[this.currentOffset++] = (byte) (128 - i);
	}

	public void writeByteC(final int i) {
		this.ensureCapacity(1);
		this.buffer[this.currentOffset++] = (byte) (-i);
	}

	public int readSignedWordBigEndian() {
		this.currentOffset += 2;
		int i = ((this.buffer[this.currentOffset - 1] & 0xff) << 8) + (this.buffer[this.currentOffset - 2] & 0xff);
		if (i > 32767) {
			i -= 0x10000;
		}
		return i;
	}

	public int readSignedWordA() {
		this.currentOffset += 2;
		int i = ((this.buffer[this.currentOffset - 2] & 0xff) << 8) + ((this.buffer[this.currentOffset - 1] - 128) & 0xff);
		if (i > 32767) {
			i -= 0x10000;
		}
		return i;
	}

	public int readSignedWordBigEndianA() {
		this.currentOffset += 2;
		int i = ((this.buffer[this.currentOffset - 1] & 0xff) << 8) + ((this.buffer[this.currentOffset - 2] - 128) & 0xff);
		if (i > 32767) {
			i -= 0x10000;
		}
		return i;
	}

	public int readUnsignedWordBigEndian() {
		this.currentOffset += 2;
		return ((this.buffer[this.currentOffset - 1] & 0xff) << 8) + (this.buffer[this.currentOffset - 2] & 0xff);
	}

	public int readUnsignedWordA() {
		this.currentOffset += 2;
		return ((this.buffer[this.currentOffset - 2] & 0xff) << 8) + ((this.buffer[this.currentOffset - 1] - 128) & 0xff);
	}

	public int readUnsignedWordBigEndianA() {
		this.currentOffset += 2;
		return ((this.buffer[this.currentOffset - 1] & 0xff) << 8) + ((this.buffer[this.currentOffset - 2] - 128) & 0xff);
	}

	public void writeWordBigEndianA(final int i) {
		this.ensureCapacity(2);
		this.buffer[this.currentOffset++] = (byte) (i + 128);
		this.buffer[this.currentOffset++] = (byte) (i >> 8);
	}

	public void writeWordA(final int i) {
		this.ensureCapacity(2);
		this.buffer[this.currentOffset++] = (byte) (i >> 8);
		this.buffer[this.currentOffset++] = (byte) (i + 128);
	}

	public void writeWordBigEndian_dup(final int i) {
		this.ensureCapacity(2);
		this.buffer[this.currentOffset++] = (byte) i;
		this.buffer[this.currentOffset++] = (byte) (i >> 8);
	}

	public int readDWord_v1() {
		this.currentOffset += 4;
		return ((this.buffer[this.currentOffset - 2] & 0xff) << 24) + ((this.buffer[this.currentOffset - 1] & 0xff) << 16) + ((this.buffer[this.currentOffset - 4] & 0xff) << 8)
				+ (this.buffer[this.currentOffset - 3] & 0xff);
	}

	public int readDWord_v2() {
		this.currentOffset += 4;
		return ((this.buffer[this.currentOffset - 3] & 0xff) << 24) + ((this.buffer[this.currentOffset - 4] & 0xff) << 16) + ((this.buffer[this.currentOffset - 1] & 0xff) << 8)
				+ (this.buffer[this.currentOffset - 2] & 0xff);
	}

	public void writeDWord_v1(final int i) {
		this.ensureCapacity(4);
		this.buffer[this.currentOffset++] = (byte) (i >> 8);
		this.buffer[this.currentOffset++] = (byte) i;
		this.buffer[this.currentOffset++] = (byte) (i >> 24);
		this.buffer[this.currentOffset++] = (byte) (i >> 16);
	}

	public void writeDWord_v2(final int i) {
		this.ensureCapacity(4);
		this.buffer[this.currentOffset++] = (byte) (i >> 16);
		this.buffer[this.currentOffset++] = (byte) (i >> 24);
		this.buffer[this.currentOffset++] = (byte) i;
		this.buffer[this.currentOffset++] = (byte) (i >> 8);
	}

	public void readBytes_reverse(final byte abyte0[], final int i, final int j) {
		for (int k = (j + i) - 1; k >= j; k--) {
			abyte0[k] = this.buffer[this.currentOffset++];
		}

	}

	public void writeBytes_reverse(final byte abyte0[], final int i, final int j) {
		this.ensureCapacity(i);
		for (int k = (j + i) - 1; k >= j; k--) {
			this.buffer[this.currentOffset++] = abyte0[k];
		}

	}

	public void readBytes_reverseA(final byte abyte0[], final int i, final int j) {
		this.ensureCapacity(i);
		for (int k = (j + i) - 1; k >= j; k--) {
			abyte0[k] = (byte) (this.buffer[this.currentOffset++] - 128);
		}

	}

	public void writeBytes_reverseA(final byte abyte0[], final int i, final int j) {
		this.ensureCapacity(i);
		for (int k = (j + i) - 1; k >= j; k--) {
			this.buffer[this.currentOffset++] = (byte) (abyte0[k] + 128);
		}

	}

	public void createFrame(final int id) {
		this.ensureCapacity(1);
		this.buffer[this.currentOffset++] = (byte) (id + this.packetEncryption.getNextKey());
	}

	private static final int frameStackSize = 10;
	private int frameStackPtr = -1;
	private final int frameStack[] = new int[Stream.frameStackSize];

	public void createFrameVarSize(final int id) {
		this.ensureCapacity(3);
		this.buffer[this.currentOffset++] = (byte) (id + this.packetEncryption.getNextKey());
		this.buffer[this.currentOffset++] = 0;
		if (this.frameStackPtr >= (Stream.frameStackSize - 1)) {
			throw new RuntimeException("Stack overflow");
		} else {
			this.frameStack[++this.frameStackPtr] = this.currentOffset;
		}
	}

	public void createFrameVarSizeWord(final int id) {
		this.ensureCapacity(2);
		this.buffer[this.currentOffset++] = (byte) (id + this.packetEncryption.getNextKey());
		this.writeWord(0);
		if (this.frameStackPtr >= (Stream.frameStackSize - 1)) {
			throw new RuntimeException("Stack overflow");
		} else {
			this.frameStack[++this.frameStackPtr] = this.currentOffset;
		}
	}

	public void endFrameVarSize() {
		if (this.frameStackPtr < 0) {
			throw new RuntimeException("Stack empty");
		} else {
			this.writeFrameSize(this.currentOffset - this.frameStack[this.frameStackPtr--]);
		}
	}

	public void endFrameVarSizeWord() {
		if (this.frameStackPtr < 0) {
			throw new RuntimeException("Stack empty");
		} else {
			this.writeFrameSizeWord(this.currentOffset - this.frameStack[this.frameStackPtr--]);
		}
	}

	public void writeByte(final int i) {
		this.ensureCapacity(1);
		this.buffer[this.currentOffset++] = (byte) i;
	}

	public void writeWord(final int i) {
		this.ensureCapacity(2);
		this.buffer[this.currentOffset++] = (byte) (i >> 8);
		this.buffer[this.currentOffset++] = (byte) i;
	}

	public void writeWordBigEndian(final int i) {
		this.ensureCapacity(2);
		this.buffer[this.currentOffset++] = (byte) i;
		this.buffer[this.currentOffset++] = (byte) (i >> 8);
	}

	public void write3Byte(final int i) {
		this.ensureCapacity(3);
		this.buffer[this.currentOffset++] = (byte) (i >> 16);
		this.buffer[this.currentOffset++] = (byte) (i >> 8);
		this.buffer[this.currentOffset++] = (byte) i;
	}

	public void writeDWord(final int i) {
		this.ensureCapacity(4);
		this.buffer[this.currentOffset++] = (byte) (i >> 24);
		this.buffer[this.currentOffset++] = (byte) (i >> 16);
		this.buffer[this.currentOffset++] = (byte) (i >> 8);
		this.buffer[this.currentOffset++] = (byte) i;
	}

	public void writeDWordBigEndian(final int i) {
		this.ensureCapacity(4);
		this.buffer[this.currentOffset++] = (byte) i;
		this.buffer[this.currentOffset++] = (byte) (i >> 8);
		this.buffer[this.currentOffset++] = (byte) (i >> 16);
		this.buffer[this.currentOffset++] = (byte) (i >> 24);
	}

	public void writeQWord(final long l) {
		this.ensureCapacity(8);
		this.buffer[this.currentOffset++] = (byte) (int) (l >> 56);
		this.buffer[this.currentOffset++] = (byte) (int) (l >> 48);
		this.buffer[this.currentOffset++] = (byte) (int) (l >> 40);
		this.buffer[this.currentOffset++] = (byte) (int) (l >> 32);
		this.buffer[this.currentOffset++] = (byte) (int) (l >> 24);
		this.buffer[this.currentOffset++] = (byte) (int) (l >> 16);
		this.buffer[this.currentOffset++] = (byte) (int) (l >> 8);
		this.buffer[this.currentOffset++] = (byte) (int) l;
	}

	public void writeString(final java.lang.String s) {
		this.ensureCapacity(s.length());
		System.arraycopy(s.getBytes(), 0, this.buffer, this.currentOffset, s.length());
		this.currentOffset += s.length();
		this.buffer[this.currentOffset++] = 10;
	}

	public void writeBytes(final byte abyte0[], final int i, final int j) {
		this.ensureCapacity(i);
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
		return this.buffer[this.currentOffset++] & 0xff;
	}

	public byte readSignedByte() {
		return this.buffer[this.currentOffset++];
	}

	public int readUnsignedWord() {
		this.currentOffset += 2;
		return ((this.buffer[this.currentOffset - 2] & 0xff) << 8)
				+ (this.buffer[this.currentOffset - 1] & 0xff);
	}

	public int readSignedWord() {
		this.currentOffset += 2;
		int i = ((this.buffer[this.currentOffset - 2] & 0xff) << 8) + (this.buffer[this.currentOffset - 1] & 0xff);
		if (i > 32767) {
			i -= 0x10000;
		}
		return i;
	}

	public int readDWord() {
		this.currentOffset += 4;
		return ((this.buffer[this.currentOffset - 4] & 0xff) << 24) + ((this.buffer[this.currentOffset - 3] & 0xff) << 16) + ((this.buffer[this.currentOffset - 2] & 0xff) << 8)
				+ (this.buffer[this.currentOffset - 1] & 0xff);
	}

	public long readQWord() {
		final long l = this.readDWord() & 0xffffffffL;
		final long l1 = this.readDWord() & 0xffffffffL;
		return (l << 32) + l1;
	}

	public java.lang.String readString() {
		final int i = this.currentOffset;
		while (this.buffer[this.currentOffset++] != 10) {
			;
		}
		return new String(this.buffer, i, this.currentOffset - i - 1);
	}

	public void readBytes(final byte abyte0[], final int i, final int j) {
		for (int k = j; k < (j + i); k++) {
			abyte0[k] = this.buffer[this.currentOffset++];
		}

	}

	public void initBitAccess() {
		this.bitPosition = this.currentOffset * 8;
	}

	public void writeBits(int numBits, final int value) {
		this.ensureCapacity(((int) Math.ceil(numBits * 8)) * 4);
		int bytePos = this.bitPosition >> 3;
		int bitOffset = 8 - (this.bitPosition & 7);
		this.bitPosition += numBits;

		for (; numBits > bitOffset; bitOffset = 8) {
			this.buffer[bytePos] &= ~Stream.bitMaskOut[bitOffset];
			this.buffer[bytePos++] |= (value >> (numBits - bitOffset)) & Stream.bitMaskOut[bitOffset];

			numBits -= bitOffset;
		}
		if (numBits == bitOffset) {
			this.buffer[bytePos] &= ~Stream.bitMaskOut[bitOffset];
			this.buffer[bytePos] |= value & Stream.bitMaskOut[bitOffset];
		} else {
			this.buffer[bytePos] &= ~(Stream.bitMaskOut[numBits] << (bitOffset - numBits));
			this.buffer[bytePos] |= (value & Stream.bitMaskOut[numBits]) << (bitOffset - numBits);
		}
	}

	public void finishBitAccess() {
		this.currentOffset = (this.bitPosition + 7) / 8;
	}

	static {
		for (int i = 0; i < 32; i++) {
			Stream.bitMaskOut[i] = (1 << i) - 1;
		}
	}

	public void ensureCapacity(final int len) {
		if ((this.currentOffset + len + 1) >= this.buffer.length) {
			final byte[] oldBuffer = this.buffer;
			final int newLength = (this.buffer.length * 2);
			this.buffer = new byte[newLength];
			System.arraycopy(oldBuffer, 0, this.buffer, 0, oldBuffer.length);
			this.ensureCapacity(len);
		}
	}

	public void reset() {
		if (!(this.currentOffset > 5000)) {
			final byte[] oldBuffer = this.buffer;
			this.buffer = new byte[5000]; // CHECK!
			for (int i = 0; i < this.currentOffset; i++) {
				this.buffer[i] = oldBuffer[i];
			}
		}
	}
}