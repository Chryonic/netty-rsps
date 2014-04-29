package com.runescape.revised.logic.net.packets;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

public class PacketBuffer {
	
	private ChannelBuffer channelBuffer = ChannelBuffers.dynamicBuffer();
	private static final int[] BIT_MASK_OUT = new int[32];
	private VariableType variableType;
	private short opcode;
	
	static {
		for(int i = 0; i < BIT_MASK_OUT.length; i++) {
			BIT_MASK_OUT[i] = (1 << i) - 1;
		}
	}
	
	public Packet toPacket() {
		return new Packet(this.getOpcode(), this.getVariableType());
	}
	
	public PacketBuffer writeByte(byte b) {
		this.getChannelBuffer().writeByte(b);
		return this;
	}
	
	public PacketBuffer writeBytes(byte[] b) {
		this.getChannelBuffer().writeBytes(b);
		return this;
	}
	
	public PacketBuffer writeShort(short s) {
		this.getChannelBuffer().writeShort(s);
		return this;
	}
	
	public PacketBuffer writeInt(int i) {
		this.getChannelBuffer().writeInt(i);
		return this;
	}
	
	public PacketBuffer writeLong(long l) {
		this.getChannelBuffer().writeLong(l);
		return this;
	}
	
	public PacketBuffer writeString(String string) {
		return this.writeBytes(string.getBytes()).writeByte((byte) 10);
	}

	public PacketBuffer putShortA(int val) {
		return this.writeByte((byte) (val >> 8)).writeByte((byte) (val + 128));
	}

	public PacketBuffer writeByteA(int val) {
		return this.writeByte((byte) (val + 128));
	}

	public PacketBuffer writeLEShortA(int val) {
		return this.writeByte((byte) (val + 128)).writeByte((byte) (val >> 8));
	}

	/** public boolean isEmpty() {
		return payload.position() == 0;
	}

	public PacketBuilder startBitAccess() {
		bitPosition = payload.position() * 8;
		return this;
	}
	
	public PacketBuilder finishBitAccess() {
		payload.position((bitPosition + 7) / 8);
		return this;
	}

	public PacketBuilder putBits(int numBits, int value) {
		if(!payload.hasArray()) {
			throw new UnsupportedOperationException("The IoBuffer implementation must support array() for bit usage.");
		}
		
		int bytes = (int) Math.ceil((double) numBits / 8D) + 1;
		payload.expand((bitPosition + 7) / 8 + bytes);
		
		byte[] buffer = payload.array();
		
		int bytePos = bitPosition >> 3;
		int bitOffset = 8 - (bitPosition & 7);
		bitPosition += numBits;
		
		for(; numBits > bitOffset; bitOffset = 8) {
			buffer[bytePos] &= ~BIT_MASK_OUT[bitOffset];
			buffer[bytePos++] |= (value >> (numBits-bitOffset)) & BIT_MASK_OUT[bitOffset];
			numBits -= bitOffset;
		}
		if(numBits == bitOffset) {
			buffer[bytePos] &= ~BIT_MASK_OUT[bitOffset];
			buffer[bytePos] |= value & BIT_MASK_OUT[bitOffset];
		} else {
			buffer[bytePos] &= ~(BIT_MASK_OUT[numBits] << (bitOffset - numBits));
			buffer[bytePos] |= (value & BIT_MASK_OUT[numBits]) << (bitOffset - numBits);
		}
		return this;
	}

	public PacketBuilder put(IoBuffer buf) {
		payload.put(buf);
		return this;
	} */

	public PacketBuffer writeByteC(int val) {
		return this.writeByte((byte) (-val));
	}

	public PacketBuffer writeLEShort(int val) {
		return this.writeByte((byte) val).writeByte((byte) (val >> 8));
	}

	public PacketBuffer writeInt1(int val) {
		return this.writeByte((byte) (val >> 8)).writeByte((byte) val).writeByte((byte) (val >> 24)).writeByte((byte) (val >> 16));
	}
	
	public PacketBuffer writeInt2(int val) {
		return this.writeByte((byte) (val >> 16)).writeByte((byte) (val >> 24)).writeByte((byte) val).writeByte((byte) (val >> 8));
	}
	
	public PacketBuffer writeLEInt(int val) {
		return this.writeByte((byte) (val)).writeByte((byte) (val >> 8)).writeByte((byte) (val >> 16)).writeByte((byte) (val >> 24));
	}

	/** public PacketBuilder put(byte[] data, int offset, int length) {
		payload.put(data, offset, length);
		return this;
	} */
	
	public PacketBuffer writeByteA(byte val) {
		return this.writeByte((byte) (val + 128));
	}
	
	public PacketBuffer writeByteC(byte val) {
		return this.writeByte((byte) (-val));
	}
	
	public PacketBuffer writeByteS(byte val) {
		return this.writeByte((byte) (128 - val));
	}
	
	public PacketBuffer writeReverse(byte[] is, int offset, int length) {
		for(int i = (offset + length - 1); i >= offset; i--) {
			this.writeByte(is[i]);
		}
		return this;
	}
	
	public PacketBuffer writeReverseA(byte[] is, int offset, int length) {
		for(int i = (offset + length - 1); i >= offset; i--) {
			this.writeByteA(is[i]);
		}
		return this;
	}
	
	public PacketBuffer writeTriByte(int val) {
		return this.writeByte((byte) (val >> 16)).writeByte((byte) (val >> 8)).writeByte((byte) val);
	}

	public PacketBuffer writeSmart(int val) {
		if(val >= 128) {
			this.writeShort((short) (val + 32768));
		} else {
			this.writeByte((byte) val);
		}
		return this;
	}
	
	public PacketBuffer putSignedSmart(int val) {
		if(val >= 128) {
			this.writeShort((short) (val + 49152));
		} else {
			this.writeByte((byte) (val + 64));
		}
		return this;
	}

	public void setChannelBuffer(ChannelBuffer channelBuffer) {
		this.channelBuffer = channelBuffer;
	}

	public ChannelBuffer getChannelBuffer() {
		return this.channelBuffer;
	}

	public void setVariableType(VariableType variableType) {
		this.variableType = variableType;
	}

	public VariableType getVariableType() {
		return this.variableType;
	}

	public void setOpcode(short opcode) {
		this.opcode = opcode;
	}

	public short getOpcode() {
		return this.opcode;
	}
}