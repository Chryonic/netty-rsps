package com.runescape.revised.logic.net.packets;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

public class NettyPacketBuffer {
	
	private ChannelBuffer channelBuffer = ChannelBuffers.dynamicBuffer();
	private static final int[] BIT_MASK_OUT = new int[32];
	private VariableType variableType;
	private short opcode;
	
	static {
		for(int i = 0; i < BIT_MASK_OUT.length; i++) {
			BIT_MASK_OUT[i] = (1 << i) - 1;
		}
	}
	
	public NettyPacketBuffer writeByte(byte b) {
		this.getChannelBuffer().writeByte(b);
		return this;
	}
	
	public NettyPacketBuffer writeBytes(byte[] b) {
		this.getChannelBuffer().writeBytes(b);
		return this;
	}
	
	public NettyPacketBuffer writeShort(short s) {
		this.getChannelBuffer().writeShort(s);
		return this;
	}
	
	public NettyPacketBuffer writeInt(int i) {
		this.getChannelBuffer().writeInt(i);
		return this;
	}
	
	public NettyPacketBuffer writeLong(long l) {
		this.getChannelBuffer().writeLong(l);
		return this;
	}
	
	public NettyPacketBuffer writeString(String string) {
		return this.writeBytes(string.getBytes()).writeByte((byte) 10);
	}

	public NettyPacketBuffer putShortA(int val) {
		return this.writeByte((byte) (val >> 8)).writeByte((byte) (val + 128));
	}

	public NettyPacketBuffer writeByteA(int val) {
		return this.writeByte((byte) (val + 128));
	}

	public NettyPacketBuffer writeLEShortA(int val) {
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

	public NettyPacketBuffer writeByteC(int val) {
		return this.writeByte((byte) (-val));
	}

	public NettyPacketBuffer writeLEShort(int val) {
		return this.writeByte((byte) val).writeByte((byte) (val >> 8));
	}

	public NettyPacketBuffer writeInt1(int val) {
		return this.writeByte((byte) (val >> 8)).writeByte((byte) val).writeByte((byte) (val >> 24)).writeByte((byte) (val >> 16));
	}
	
	public NettyPacketBuffer writeInt2(int val) {
		return this.writeByte((byte) (val >> 16)).writeByte((byte) (val >> 24)).writeByte((byte) val).writeByte((byte) (val >> 8));
	}
	
	public NettyPacketBuffer writeLEInt(int val) {
		return this.writeByte((byte) (val)).writeByte((byte) (val >> 8)).writeByte((byte) (val >> 16)).writeByte((byte) (val >> 24));
	}

	/** public PacketBuilder put(byte[] data, int offset, int length) {
		payload.put(data, offset, length);
		return this;
	} */
	
	public NettyPacketBuffer writeByteA(byte val) {
		return this.writeByte((byte) (val + 128));
	}
	
	public NettyPacketBuffer writeByteC(byte val) {
		return this.writeByte((byte) (-val));
	}
	
	public NettyPacketBuffer writeByteS(byte val) {
		return this.writeByte((byte) (128 - val));
	}
	
	public NettyPacketBuffer writeReverse(byte[] is, int offset, int length) {
		for(int i = (offset + length - 1); i >= offset; i--) {
			this.writeByte(is[i]);
		}
		return this;
	}
	
	public NettyPacketBuffer writeReverseA(byte[] is, int offset, int length) {
		for(int i = (offset + length - 1); i >= offset; i--) {
			this.writeByteA(is[i]);
		}
		return this;
	}
	
	public NettyPacketBuffer writeTriByte(int val) {
		return this.writeByte((byte) (val >> 16)).writeByte((byte) (val >> 8)).writeByte((byte) val);
	}

	public NettyPacketBuffer writeSmart(int val) {
		if(val >= 128) {
			this.writeShort((short) (val + 32768));
		} else {
			this.writeByte((byte) val);
		}
		return this;
	}
	
	public NettyPacketBuffer putSignedSmart(int val) {
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