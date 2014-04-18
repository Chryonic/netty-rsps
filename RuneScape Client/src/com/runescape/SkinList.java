package com.runescape;

import com.runescape.revised.filesystem.RSBuffer;

public class SkinList {

	public SkinList(RSBuffer stream) {
		int anInt341 = stream.readUnsignedByte();
		anIntArray342 = new int[anInt341];
		anIntArrayArray343 = new int[anInt341][];
		for(int j = 0; j < anInt341; j++) {
			anIntArray342[j] = stream.readUnsignedByte();
		}
		for(int k = 0; k < anInt341; k++) {
			int l = stream.readUnsignedByte();
			anIntArrayArray343[k] = new int[l];
			for(int i1 = 0; i1 < l; i1++) {
				anIntArrayArray343[k][i1] = stream.readUnsignedByte();
			}
		}
	}

	public final int[] anIntArray342;
	public final int[][] anIntArrayArray343;
}