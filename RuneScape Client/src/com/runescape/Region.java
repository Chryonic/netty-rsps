package com.runescape;

import com.runescape.revised.config.definitions.Floor;
import com.runescape.revised.config.definitions.ObjectDef;
import com.runescape.revised.filesystem.RSBuffer;
import com.runescape.revised.graphics.SceneGraphic;
import com.runescape.revised.media.map.MapUtility;
import com.runescape.revised.media.map.TileSetting;
import com.runescape.revised.model.RSModel;
import com.runescape.revised.net.ondemand.OnDemandFetcher;

public class Region {

	public Region(byte abyte0[][][], int ai[][][])
	{
		lowestPlane = 99;
		landscapeSizeX = 104;
		landscapeSizeY = 104;
		vertexHeights = ai;
		renderRuleFlags = abyte0;
		underlayFloorID = new byte[4][landscapeSizeX][landscapeSizeY];
		overlayFloorID = new byte[4][landscapeSizeX][landscapeSizeY];
		overlayClippingPaths = new byte[4][landscapeSizeX][landscapeSizeY];
		overlayClippingPathRotations = new byte[4][landscapeSizeX][landscapeSizeY];
		tileCullingBitsets = new int[4][landscapeSizeX + 1][landscapeSizeY + 1];
		tileShadowIntensity = new byte[4][landscapeSizeX + 1][landscapeSizeY + 1];
		tileLightingIntensity = new int[landscapeSizeX + 1][landscapeSizeY + 1];
		blendedHue = new int[landscapeSizeY];
		blendedSaturation = new int[landscapeSizeY];
		blendedLightness = new int[landscapeSizeY];
		blendedHueDivisor = new int[landscapeSizeY];
		blendDirectionTracker = new int[landscapeSizeY];
	}

	private static int method170(int i, int j) // method170
	{
		int k = i + j * 57;
		k = k << 13 ^ k;
		int l = k * (k * k * 15731 + 0xc0ae5) + 0x5208dd0d & 0x7fffffff;
		return l >> 19 & 0xff;
	}

	public final void createLandscapeScene(TileSetting clippingPlanes[], SceneGraphic worldController)
	{ // method171
		for(int plane = 0; plane < 4; plane++)
		{
			for(int x = 0; x < 104; x++)
			{
				for(int y = 0; y < 104; y++)
					if((renderRuleFlags[plane][x][y] & 1) == 1)
					{
						int plane_ = plane;
						if((renderRuleFlags[1][x][y] & 2) == 2)
							plane_--;
						if(plane_ >= 0)
							clippingPlanes[plane_].setSolidFlag(y, x);
					}
			}
		}
		hueRandomizer += (int)(Math.random() * 5D) - 2;
		if(hueRandomizer < -8)
			hueRandomizer = -8;
		if(hueRandomizer > 8)
			hueRandomizer = 8;
		lightnessRandomizer += (int)(Math.random() * 5D) - 2;
		if(lightnessRandomizer < -16)
			lightnessRandomizer = -16;
		if(lightnessRandomizer > 16)
			lightnessRandomizer = 16;
		for(int plane = 0; plane < 4; plane++)
		{
			byte shadowIntensity[][] = tileShadowIntensity[plane];
			byte directionalLightInitialIntensity = 96;
			char specularDistributionFactor = '\u0300';
			byte directionalLightX = -50;
			byte directionalLightZ = -10;
			byte directionalLightY = -50;
			int directionalLightLength = (int)Math.sqrt(directionalLightX * directionalLightX + directionalLightZ * directionalLightZ + directionalLightY * directionalLightY);
			int specularDistribution = specularDistributionFactor * directionalLightLength >> 8;
			for(int y = 1; y < landscapeSizeY - 1; y++)
			{
				for(int x = 1; x < landscapeSizeX - 1; x++)
				{
					int xHeightDifference = vertexHeights[plane][x + 1][y] - vertexHeights[plane][x - 1][y];
					int yHeightDifference = vertexHeights[plane][x][y + 1] - vertexHeights[plane][x][y - 1];
					int normalLength = (int)Math.sqrt(xHeightDifference * xHeightDifference + 0x10000 + yHeightDifference * yHeightDifference);
					int normalizedNormalX = (xHeightDifference << 8) / normalLength;
					int normalizedNormalZ = 0x10000 / normalLength;
					int normalizedNormalY = (yHeightDifference << 8) / normalLength;
					int directionalLightIntensity = directionalLightInitialIntensity + (directionalLightX * normalizedNormalX + directionalLightZ * normalizedNormalZ + directionalLightY * normalizedNormalY) / specularDistribution;
					int weightedShadowIntensity = (shadowIntensity[x - 1][y] >> 2) + (shadowIntensity[x + 1][y] >> 3) + (shadowIntensity[x][y - 1] >> 2) + (shadowIntensity[x][y + 1] >> 3) + (shadowIntensity[x][y] >> 1);
					tileLightingIntensity[x][y] = directionalLightIntensity - weightedShadowIntensity;
				}

			}

			for(int y = 0; y < landscapeSizeY; y++)
			{
				blendedHue[y] = 0;
				blendedSaturation[y] = 0;
				blendedLightness[y] = 0;
				blendedHueDivisor[y] = 0;
				blendDirectionTracker[y] = 0;
			}

			for(int x = -5; x < landscapeSizeX + 5; x++)
			{
				for(int y = 0; y < landscapeSizeY; y++)
				{
					int xPositiveOffset = x + 5;
					if(xPositiveOffset >= 0 && xPositiveOffset < landscapeSizeX)
					{
						int floorID = underlayFloorID[plane][xPositiveOffset][y] & 0xff;
						if(floorID > 0)
						{
							Floor flo = Floor.cache[floorID - 1];
							blendedHue[y] += flo.hue;
							blendedSaturation[y] += flo.saturation;
							blendedLightness[y] += flo.lightness;
							blendedHueDivisor[y] += flo.hueDivisor;
							blendDirectionTracker[y]++;
						}
					}
					int xNegativeOffset = x - 5;
					if(xNegativeOffset >= 0 && xNegativeOffset < landscapeSizeX)
					{
						int i14 = underlayFloorID[plane][xNegativeOffset][y] & 0xff;
						if(i14 > 0)
						{
							Floor flo_1 = Floor.cache[i14 - 1];
							blendedHue[y] -= flo_1.hue;
							blendedSaturation[y] -= flo_1.saturation;
							blendedLightness[y] -= flo_1.lightness;
							blendedHueDivisor[y] -= flo_1.hueDivisor;
							blendDirectionTracker[y]--;
						}
					}
				}

				if(x >= 1 && x < landscapeSizeX - 1)
				{
					int blended_hue = 0;
					int blended_saturation = 0;
					int blended_lightness = 0;
					int blended_hue_divisor = 0;
					int blended_direction_tracker = 0;
					for(int y = -5; y < landscapeSizeY + 5; y++)
					{
						int y_positiveOffset = y + 5;
						if(y_positiveOffset >= 0 && y_positiveOffset < landscapeSizeY)
						{
							blended_hue += blendedHue[y_positiveOffset];
							blended_saturation += blendedSaturation[y_positiveOffset];
							blended_lightness += blendedLightness[y_positiveOffset];
							blended_hue_divisor += blendedHueDivisor[y_positiveOffset];
							blended_direction_tracker += blendDirectionTracker[y_positiveOffset];
						}
						int y_negativeOffset = y - 5;
						if(y_negativeOffset >= 0 && y_negativeOffset < landscapeSizeY)
						{
							blended_hue -= blendedHue[y_negativeOffset];
							blended_saturation -= blendedSaturation[y_negativeOffset];
							blended_lightness -= blendedLightness[y_negativeOffset];
							blended_hue_divisor -= blendedHueDivisor[y_negativeOffset];
							blended_direction_tracker -= blendDirectionTracker[y_negativeOffset];
						}
						if(y >= 1 && y < landscapeSizeY - 1 && (!lowMem || (renderRuleFlags[0][x][y_positiveOffset] & 2) != 0 || (renderRuleFlags[plane][x][y_positiveOffset] & 0x10) == 0 && getVisibilityPlaneFor(y_positiveOffset, plane, x) == onBuildTimePlane))
						{
							if(plane < lowestPlane)
								lowestPlane = plane;
							int underlay_floor_id = underlayFloorID[plane][x][y] & 0xff;
							int overlay_floor_id = overlayFloorID[plane][x][y] & 0xff;
							if(underlay_floor_id > 0 || overlay_floor_id > 0)
							{
								int v_sw = vertexHeights[plane][x][y];
								int v_se = vertexHeights[plane][x + 1][y];
								int v_ne = vertexHeights[plane][x + 1][y + 1];
								int v_nw = vertexHeights[plane][x][y + 1];
								int l_sw = tileLightingIntensity[x][y];
								int l_se = tileLightingIntensity[x + 1][y];
								int l_ne = tileLightingIntensity[x + 1][y + 1];
								int l_nw = tileLightingIntensity[x][y + 1];
								int hsl_bitset_unmodified = -1;
								int hsl_bitset_randomized = -1;
								if(underlay_floor_id > 0)
								{
									int hue = (blended_hue * 256) / blended_hue_divisor;
									int saturation = blended_saturation / blended_direction_tracker;
									int lightness = blended_lightness / blended_direction_tracker;
									hsl_bitset_unmodified = getHSLBitset(hue, saturation, lightness);
									hue = hue + hueRandomizer & 0xff;
									lightness += lightnessRandomizer;
									if(lightness < 0)
										lightness = 0;
									else
									if(lightness > 255)
										lightness = 255;
									hsl_bitset_randomized = getHSLBitset(hue, saturation, lightness);
								}
								if(plane > 0)
								{
									boolean hide_underlay = true;
									if(underlay_floor_id == 0 && overlayClippingPaths[plane][x][y] != 0)
										hide_underlay = false;
									if(overlay_floor_id > 0 && !Floor.cache[overlay_floor_id - 1].aBoolean393)
										hide_underlay = false;
									if(hide_underlay && v_sw == v_se && v_sw == v_ne && v_sw == v_nw)
										tileCullingBitsets[plane][x][y] |= 0x924;
								}
								int rgb_bitset_randomized = 0;
								if(hsl_bitset_unmodified != -1)
									rgb_bitset_randomized = Rasterizer.hslToRgbLookupTable[trimHSLLightness(hsl_bitset_randomized, 96)];
								if(overlay_floor_id == 0)
								{
									worldController.method279(plane, x, y, 0, 0, -1, v_sw, v_se, v_ne, v_nw, trimHSLLightness(hsl_bitset_unmodified, l_sw), trimHSLLightness(hsl_bitset_unmodified, l_se), trimHSLLightness(hsl_bitset_unmodified, l_ne), trimHSLLightness(hsl_bitset_unmodified, l_nw), 0, 0, 0, 0, rgb_bitset_randomized, 0);
								} else
								{
									int clipping_path = overlayClippingPaths[plane][x][y] + 1;
									byte clipping_path_rotation = overlayClippingPathRotations[plane][x][y];
									Floor flo_2 = Floor.cache[overlay_floor_id - 1];
									int textureID = flo_2.textureID;
									int hsl_bitset;
									int rgb_bitset;
									if(textureID >= 0)
									{
										rgb_bitset = Rasterizer.getAverageRgbColourForTexture(textureID);
										hsl_bitset = -1;
									} else
									if(flo_2.rgbColor2 == 0xff00ff)
									{
										rgb_bitset = 0;
										hsl_bitset = -2;
										textureID = -1;
									} else
									{
										hsl_bitset = getHSLBitset(flo_2.anInt394, flo_2.saturation, flo_2.lightness);
										rgb_bitset = Rasterizer.hslToRgbLookupTable[getRgbLookupTableId(flo_2.mapColor, 96)];
									}
									worldController.method279(plane, x, y, clipping_path, clipping_path_rotation, textureID, v_sw, v_se, v_ne, v_nw, trimHSLLightness(hsl_bitset_unmodified, l_sw), trimHSLLightness(hsl_bitset_unmodified, l_se), trimHSLLightness(hsl_bitset_unmodified, l_ne), trimHSLLightness(hsl_bitset_unmodified, l_nw), getRgbLookupTableId(hsl_bitset, l_sw), getRgbLookupTableId(hsl_bitset, l_se), getRgbLookupTableId(hsl_bitset, l_ne), getRgbLookupTableId(hsl_bitset, l_nw), rgb_bitset_randomized, rgb_bitset);
								}
							}
						}
					}
				}
			}

			for(int y = 1; y < landscapeSizeY - 1; y++)
			{
				for(int x = 1; x < landscapeSizeX - 1; x++)
					worldController.setVisiblePlanesFor(plane, x, y, getVisibilityPlaneFor(y, plane, x));

			}

		}

		worldController.applyDLNonTexturedObjects(-10, -50, -50);
		for(int x = 0; x < landscapeSizeX; x++)
		{
			for(int y = 0; y < landscapeSizeY; y++)
				if((renderRuleFlags[1][x][y] & 2) == 2)
					worldController.setBridgeMode(y, x);

		}

		int renderRule1 = 1;
		int renderRule2 = 2;
		int renderRule3 = 4;
		for(int currentPlane = 0; currentPlane < 4; currentPlane++)
		{
			if(currentPlane > 0)
			{
				renderRule1 <<= 3;
				renderRule2 <<= 3;
				renderRule3 <<= 3;
			}
			for(int plane = 0; plane <= currentPlane; plane++)
			{
				for(int y = 0; y <= landscapeSizeY; y++)
				{
					for(int x = 0; x <= landscapeSizeX; x++)
					{
						if((tileCullingBitsets[plane][x][y] & renderRule1) != 0)
						{
							int lowestOcclusionY = y;
							int highestOcclusionY = y;
							int lowestOcclusionPlane = plane;
							int highestOcclusionPlane = plane;
							for(; lowestOcclusionY > 0 && (tileCullingBitsets[plane][x][lowestOcclusionY - 1] & renderRule1) != 0; lowestOcclusionY--);
							for(; highestOcclusionY < landscapeSizeY && (tileCullingBitsets[plane][x][highestOcclusionY + 1] & renderRule1) != 0; highestOcclusionY++);
label0:
							for(; lowestOcclusionPlane > 0; lowestOcclusionPlane--)
							{
								for(int j10 = lowestOcclusionY; j10 <= highestOcclusionY; j10++)
									if((tileCullingBitsets[lowestOcclusionPlane - 1][x][j10] & renderRule1) == 0)
										break label0;

							}

label1:
							for(; highestOcclusionPlane < currentPlane; highestOcclusionPlane++)
							{
								for(int k10 = lowestOcclusionY; k10 <= highestOcclusionY; k10++)
									if((tileCullingBitsets[highestOcclusionPlane + 1][x][k10] & renderRule1) == 0)
										break label1;

							}

							int l10 = ((highestOcclusionPlane + 1) - lowestOcclusionPlane) * ((highestOcclusionY - lowestOcclusionY) + 1);
							if(l10 >= 8)
							{
								char c1 = '\360';
								int k14 = vertexHeights[highestOcclusionPlane][x][lowestOcclusionY] - c1;
								int l15 = vertexHeights[lowestOcclusionPlane][x][lowestOcclusionY];
								SceneGraphic.method277(currentPlane, x * 128, l15, x * 128, highestOcclusionY * 128 + 128, k14, lowestOcclusionY * 128, 1);
								for(int l16 = lowestOcclusionPlane; l16 <= highestOcclusionPlane; l16++)
								{
									for(int l17 = lowestOcclusionY; l17 <= highestOcclusionY; l17++)
										tileCullingBitsets[l16][x][l17] &= ~renderRule1;

								}

							}
						}
						if((tileCullingBitsets[plane][x][y] & renderRule2) != 0)
						{
							int l4 = x;
							int i6 = x;
							int j7 = plane;
							int l8 = plane;
							for(; l4 > 0 && (tileCullingBitsets[plane][l4 - 1][y] & renderRule2) != 0; l4--);
							for(; i6 < landscapeSizeX && (tileCullingBitsets[plane][i6 + 1][y] & renderRule2) != 0; i6++);
label2:
							for(; j7 > 0; j7--)
							{
								for(int i11 = l4; i11 <= i6; i11++)
									if((tileCullingBitsets[j7 - 1][i11][y] & renderRule2) == 0)
										break label2;

							}

label3:
							for(; l8 < currentPlane; l8++)
							{
								for(int j11 = l4; j11 <= i6; j11++)
									if((tileCullingBitsets[l8 + 1][j11][y] & renderRule2) == 0)
										break label3;

							}

							int k11 = ((l8 + 1) - j7) * ((i6 - l4) + 1);
							if(k11 >= 8)
							{
								char c2 = '\360';
								int l14 = vertexHeights[l8][l4][y] - c2;
								int i16 = vertexHeights[j7][l4][y];
								SceneGraphic.method277(currentPlane, l4 * 128, i16, i6 * 128 + 128, y * 128, l14, y * 128, 2);
								for(int i17 = j7; i17 <= l8; i17++)
								{
									for(int i18 = l4; i18 <= i6; i18++)
										tileCullingBitsets[i17][i18][y] &= ~renderRule2;

								}

							}
						}
						if((tileCullingBitsets[plane][x][y] & renderRule3) != 0)
						{
							int i5 = x;
							int j6 = x;
							int k7 = y;
							int i9 = y;
							for(; k7 > 0 && (tileCullingBitsets[plane][x][k7 - 1] & renderRule3) != 0; k7--);
							for(; i9 < landscapeSizeY && (tileCullingBitsets[plane][x][i9 + 1] & renderRule3) != 0; i9++);
label4:
							for(; i5 > 0; i5--)
							{
								for(int l11 = k7; l11 <= i9; l11++)
									if((tileCullingBitsets[plane][i5 - 1][l11] & renderRule3) == 0)
										break label4;

							}

label5:
							for(; j6 < landscapeSizeX; j6++)
							{
								for(int i12 = k7; i12 <= i9; i12++)
									if((tileCullingBitsets[plane][j6 + 1][i12] & renderRule3) == 0)
										break label5;

							}

							if(((j6 - i5) + 1) * ((i9 - k7) + 1) >= 4)
							{
								int j12 = vertexHeights[plane][i5][k7];
								SceneGraphic.method277(currentPlane, i5 * 128, j12, j6 * 128 + 128, i9 * 128 + 128, j12, k7 * 128, 4);
								for(int k13 = i5; k13 <= j6; k13++)
								{
									for(int i15 = k7; i15 <= i9; i15++)
										tileCullingBitsets[plane][k13][i15] &= ~renderRule3;

								}
							}
						}
					}
				}
			}
		}
	}

	private static int method172(int i, int j)
	{
		int k = (method176(i + 45365, j + 0x16713, 4) - 128) + (method176(i + 10294, j + 37821, 2) - 128 >> 1) + (method176(i, j, 1) - 128 >> 2);
		k = (int)((double)k * 0.29999999999999999D) + 35;
		if(k < 10)
			k = 10;
		else
		if(k > 60)
			k = 60;
		return k;
	}

	public static void method173(RSBuffer stream, OnDemandFetcher class42_sub1)
	{
label0:
		{
			int i = -1;
			do
			{
				int j = stream.method422();
				if(j == 0)
					break label0;
				i += j;
				ObjectDef class46 = ObjectDef.forID(i);
				class46.method574(class42_sub1);
				do
				{
					int k = stream.method422();
					if(k == 0)
						break;
					stream.readUnsignedByte();
				} while(true);
			} while(true);
		}
	}

	public final void method174(int i, int j, int l, int i1)
	{
		for(int j1 = i; j1 <= i + j; j1++)
		{
			for(int k1 = i1; k1 <= i1 + l; k1++)
				if(k1 >= 0 && k1 < landscapeSizeX && j1 >= 0 && j1 < landscapeSizeY)
				{
					tileShadowIntensity[0][k1][j1] = 127;
					if(k1 == i1 && k1 > 0)
						vertexHeights[0][k1][j1] = vertexHeights[0][k1 - 1][j1];
					if(k1 == i1 + l && k1 < landscapeSizeX - 1)
						vertexHeights[0][k1][j1] = vertexHeights[0][k1 + 1][j1];
					if(j1 == i && j1 > 0)
						vertexHeights[0][k1][j1] = vertexHeights[0][k1][j1 - 1];
					if(j1 == i + j && j1 < landscapeSizeY - 1)
						vertexHeights[0][k1][j1] = vertexHeights[0][k1][j1 + 1];
				}

		}
	}

	private void method175(int i, SceneGraphic worldController, TileSetting class11, int j, int k, int l, int i1,
								 int j1)
	{
		if(lowMem && (renderRuleFlags[0][l][i] & 2) == 0)
		{
			if((renderRuleFlags[k][l][i] & 0x10) != 0)
				return;
			if(getVisibilityPlaneFor(i, k, l) != onBuildTimePlane)
				return;
		}
		if(k < lowestPlane)
			lowestPlane = k;
		int k1 = vertexHeights[k][l][i];
		int l1 = vertexHeights[k][l + 1][i];
		int i2 = vertexHeights[k][l + 1][i + 1];
		int j2 = vertexHeights[k][l][i + 1];
		int k2 = k1 + l1 + i2 + j2 >> 2;
		ObjectDef class46 = ObjectDef.forID(i1);
		int l2 = l + (i << 7) + (i1 << 14) + 0x40000000;
		if(!class46.hasActions)
			l2 += 0x80000000;
		byte byte0 = (byte)((j1 << 6) + j);
		if(j == 22)
		{
			if(lowMem && !class46.hasActions && !class46.aBoolean736)
				return;
			Object obj;
			if(class46.animation_id == -1 && class46.childrenIDs == null)
				obj = class46.method578(22, j1, k1, l1, i2, j2, -1);
			else
				obj = new GameObject(i1, j1, 22, l1, i2, k1, j2, class46.animation_id, true);
			worldController.method280(k, k2, i, ((Renderable) (obj)), byte0, l2, l);
			if(class46.isUnwalkable && class46.hasActions && class11 != null)
				class11.setSolidFlag(i, l);
			return;
		}
		if(j == 10 || j == 11)
		{
			Object obj1;
			if(class46.animation_id == -1 && class46.childrenIDs == null)
				obj1 = class46.method578(10, j1, k1, l1, i2, j2, -1);
			else
				obj1 = new GameObject(i1, j1, 10, l1, i2, k1, j2, class46.animation_id, true);
			if(obj1 != null)
			{
				int i5 = 0;
				if(j == 11)
					i5 += 256;
				int j4;
				int l4;
				if(j1 == 1 || j1 == 3)
				{
					j4 = class46.height;
					l4 = class46.width;
				} else
				{
					j4 = class46.width;
					l4 = class46.height;
				}
				if(worldController.method284(l2, byte0, k2, l4, ((Renderable) (obj1)), j4, k, i5, i, l) && class46.aBoolean779)
				{
					RSModel model;
					if(obj1 instanceof RSModel)
						model = (RSModel)obj1;
					else
						model = class46.method578(10, j1, k1, l1, i2, j2, -1);
					if(model != null)
					{
						for(int j5 = 0; j5 <= j4; j5++)
						{
							for(int k5 = 0; k5 <= l4; k5++)
							{
								int l5 = model.anInt1650 / 4;
								if(l5 > 30)
									l5 = 30;
								if(l5 > tileShadowIntensity[k][l + j5][i + k5])
									tileShadowIntensity[k][l + j5][i + k5] = (byte)l5;
							}

						}

					}
				}
			}
			if(class46.isUnwalkable && class11 != null)
				class11.method212(class46.aBoolean757, class46.width, class46.height, l, i, j1);
			return;
		}
		if(j >= 12)
		{
			Object obj2;
			if(class46.animation_id == -1 && class46.childrenIDs == null)
				obj2 = class46.method578(j, j1, k1, l1, i2, j2, -1);
			else
				obj2 = new GameObject(i1, j1, j, l1, i2, k1, j2, class46.animation_id, true);
			worldController.method284(l2, byte0, k2, 1, ((Renderable) (obj2)), 1, k, 0, i, l);
			if(j >= 12 && j <= 17 && j != 13 && k > 0)
				tileCullingBitsets[k][l][i] |= 0x924;
			if(class46.isUnwalkable && class11 != null)
				class11.method212(class46.aBoolean757, class46.width, class46.height, l, i, j1);
			return;
		}
		if(j == 0)
		{
			Object obj3;
			if(class46.animation_id == -1 && class46.childrenIDs == null)
				obj3 = class46.method578(0, j1, k1, l1, i2, j2, -1);
			else
				obj3 = new GameObject(i1, j1, 0, l1, i2, k1, j2, class46.animation_id, true);
			worldController.method282(anIntArray152[j1], ((Renderable) (obj3)), l2, i, byte0, l, null, k2, 0, k);
			if(j1 == 0)
			{
				if(class46.aBoolean779)
				{
					tileShadowIntensity[k][l][i] = 50;
					tileShadowIntensity[k][l][i + 1] = 50;
				}
				if(class46.aBoolean764)
					tileCullingBitsets[k][l][i] |= 0x249;
			} else
			if(j1 == 1)
			{
				if(class46.aBoolean779)
				{
					tileShadowIntensity[k][l][i + 1] = 50;
					tileShadowIntensity[k][l + 1][i + 1] = 50;
				}
				if(class46.aBoolean764)
					tileCullingBitsets[k][l][i + 1] |= 0x492;
			} else
			if(j1 == 2)
			{
				if(class46.aBoolean779)
				{
					tileShadowIntensity[k][l + 1][i] = 50;
					tileShadowIntensity[k][l + 1][i + 1] = 50;
				}
				if(class46.aBoolean764)
					tileCullingBitsets[k][l + 1][i] |= 0x249;
			} else
			if(j1 == 3)
			{
				if(class46.aBoolean779)
				{
					tileShadowIntensity[k][l][i] = 50;
					tileShadowIntensity[k][l + 1][i] = 50;
				}
				if(class46.aBoolean764)
					tileCullingBitsets[k][l][i] |= 0x492;
			}
			if(class46.isUnwalkable && class11 != null)
				class11.method211(i, j1, l, j, class46.aBoolean757);
			if(class46.anInt775 != 16)
				worldController.method290(i, class46.anInt775, l, k);
			return;
		}
		if(j == 1)
		{
			Object obj4;
			if(class46.animation_id == -1 && class46.childrenIDs == null)
				obj4 = class46.method578(1, j1, k1, l1, i2, j2, -1);
			else
				obj4 = new GameObject(i1, j1, 1, l1, i2, k1, j2, class46.animation_id, true);
			worldController.method282(anIntArray140[j1], ((Renderable) (obj4)), l2, i, byte0, l, null, k2, 0, k);
			if(class46.aBoolean779)
				if(j1 == 0)
					tileShadowIntensity[k][l][i + 1] = 50;
				else
				if(j1 == 1)
					tileShadowIntensity[k][l + 1][i + 1] = 50;
				else
				if(j1 == 2)
					tileShadowIntensity[k][l + 1][i] = 50;
				else
				if(j1 == 3)
					tileShadowIntensity[k][l][i] = 50;
			if(class46.isUnwalkable && class11 != null)
				class11.method211(i, j1, l, j, class46.aBoolean757);
			return;
		}
		if(j == 2)
		{
			int i3 = j1 + 1 & 3;
			Object obj11;
			Object obj12;
			if(class46.animation_id == -1 && class46.childrenIDs == null)
			{
				obj11 = class46.method578(2, 4 + j1, k1, l1, i2, j2, -1);
				obj12 = class46.method578(2, i3, k1, l1, i2, j2, -1);
			} else
			{
				obj11 = new GameObject(i1, 4 + j1, 2, l1, i2, k1, j2, class46.animation_id, true);
				obj12 = new GameObject(i1, i3, 2, l1, i2, k1, j2, class46.animation_id, true);
			}
			worldController.method282(anIntArray152[j1], ((Renderable) (obj11)), l2, i, byte0, l, ((Renderable) (obj12)), k2, anIntArray152[i3], k);
			if(class46.aBoolean764)
				if(j1 == 0)
				{
					tileCullingBitsets[k][l][i] |= 0x249;
					tileCullingBitsets[k][l][i + 1] |= 0x492;
				} else
				if(j1 == 1)
				{
					tileCullingBitsets[k][l][i + 1] |= 0x492;
					tileCullingBitsets[k][l + 1][i] |= 0x249;
				} else
				if(j1 == 2)
				{
					tileCullingBitsets[k][l + 1][i] |= 0x249;
					tileCullingBitsets[k][l][i] |= 0x492;
				} else
				if(j1 == 3)
				{
					tileCullingBitsets[k][l][i] |= 0x492;
					tileCullingBitsets[k][l][i] |= 0x249;
				}
			if(class46.isUnwalkable && class11 != null)
				class11.method211(i, j1, l, j, class46.aBoolean757);
			if(class46.anInt775 != 16)
				worldController.method290(i, class46.anInt775, l, k);
			return;
		}
		if(j == 3)
		{
			Object obj5;
			if(class46.animation_id == -1 && class46.childrenIDs == null)
				obj5 = class46.method578(3, j1, k1, l1, i2, j2, -1);
			else
				obj5 = new GameObject(i1, j1, 3, l1, i2, k1, j2, class46.animation_id, true);
			worldController.method282(anIntArray140[j1], ((Renderable) (obj5)), l2, i, byte0, l, null, k2, 0, k);
			if(class46.aBoolean779)
				if(j1 == 0)
					tileShadowIntensity[k][l][i + 1] = 50;
				else
				if(j1 == 1)
					tileShadowIntensity[k][l + 1][i + 1] = 50;
				else
				if(j1 == 2)
					tileShadowIntensity[k][l + 1][i] = 50;
				else
				if(j1 == 3)
					tileShadowIntensity[k][l][i] = 50;
			if(class46.isUnwalkable && class11 != null)
				class11.method211(i, j1, l, j, class46.aBoolean757);
			return;
		}
		if(j == 9)
		{
			Object obj6;
			if(class46.animation_id == -1 && class46.childrenIDs == null)
				obj6 = class46.method578(j, j1, k1, l1, i2, j2, -1);
			else
				obj6 = new GameObject(i1, j1, j, l1, i2, k1, j2, class46.animation_id, true);
			worldController.method284(l2, byte0, k2, 1, ((Renderable) (obj6)), 1, k, 0, i, l);
			if(class46.isUnwalkable && class11 != null)
				class11.method212(class46.aBoolean757, class46.width, class46.height, l, i, j1);
			return;
		}
		if(class46.adjustToTerrain)
			if(j1 == 1)
			{
				int j3 = j2;
				j2 = i2;
				i2 = l1;
				l1 = k1;
				k1 = j3;
			} else
			if(j1 == 2)
			{
				int k3 = j2;
				j2 = l1;
				l1 = k3;
				k3 = i2;
				i2 = k1;
				k1 = k3;
			} else
			if(j1 == 3)
			{
				int l3 = j2;
				j2 = k1;
				k1 = l1;
				l1 = i2;
				i2 = l3;
			}
		if(j == 4)
		{
			Object obj7;
			if(class46.animation_id == -1 && class46.childrenIDs == null)
				obj7 = class46.method578(4, 0, k1, l1, i2, j2, -1);
			else
				obj7 = new GameObject(i1, 0, 4, l1, i2, k1, j2, class46.animation_id, true);
			worldController.method283(l2, i, j1 * 512, k, 0, k2, ((Renderable) (obj7)), l, byte0, 0, anIntArray152[j1]);
			return;
		}
		if(j == 5)
		{
			int i4 = 16;
			int k4 = worldController.method300(k, l, i);
			if(k4 > 0)
				i4 = ObjectDef.forID(k4 >> 14 & 0x7fff).anInt775;
			Object obj13;
			if(class46.animation_id == -1 && class46.childrenIDs == null)
				obj13 = class46.method578(4, 0, k1, l1, i2, j2, -1);
			else
				obj13 = new GameObject(i1, 0, 4, l1, i2, k1, j2, class46.animation_id, true);
			worldController.method283(l2, i, j1 * 512, k, anIntArray137[j1] * i4, k2, ((Renderable) (obj13)), l, byte0, anIntArray144[j1] * i4, anIntArray152[j1]);
			return;
		}
		if(j == 6)
		{
			Object obj8;
			if(class46.animation_id == -1 && class46.childrenIDs == null)
				obj8 = class46.method578(4, 0, k1, l1, i2, j2, -1);
			else
				obj8 = new GameObject(i1, 0, 4, l1, i2, k1, j2, class46.animation_id, true);
			worldController.method283(l2, i, j1, k, 0, k2, ((Renderable) (obj8)), l, byte0, 0, 256);
			return;
		}
		if(j == 7)
		{
			Object obj9;
			if(class46.animation_id == -1 && class46.childrenIDs == null)
				obj9 = class46.method578(4, 0, k1, l1, i2, j2, -1);
			else
				obj9 = new GameObject(i1, 0, 4, l1, i2, k1, j2, class46.animation_id, true);
			worldController.method283(l2, i, j1, k, 0, k2, ((Renderable) (obj9)), l, byte0, 0, 512);
			return;
		}
		if(j == 8)
		{
			Object obj10;
			if(class46.animation_id == -1 && class46.childrenIDs == null)
				obj10 = class46.method578(4, 0, k1, l1, i2, j2, -1);
			else
				obj10 = new GameObject(i1, 0, 4, l1, i2, k1, j2, class46.animation_id, true);
			worldController.method283(l2, i, j1, k, 0, k2, ((Renderable) (obj10)), l, byte0, 0, 768);
		}
	}

	private static int method176(int i, int j, int k)
	{
		int l = i / k;
		int i1 = i & k - 1;
		int j1 = j / k;
		int k1 = j & k - 1;
		int l1 = method186(l, j1);
		int i2 = method186(l + 1, j1);
		int j2 = method186(l, j1 + 1);
		int k2 = method186(l + 1, j1 + 1);
		int l2 = method184(l1, i2, i1, k);
		int i3 = method184(j2, k2, i1, k);
		return method184(l2, i3, k1, k);
	}

	private int getHSLBitset(int i, int j, int k)
	{
		if(k > 179)
			j /= 2;
		if(k > 192)
			j /= 2;
		if(k > 217)
			j /= 2;
		if(k > 243)
			j /= 2;
		return (i / 4 << 10) + (j / 32 << 7) + k / 2;
	}

	public static boolean method178(int i, int j)
	{
		ObjectDef class46 = ObjectDef.forID(i);
		if(j == 11)
			j = 10;
		if(j >= 5 && j <= 8)
			j = 4;
		return class46.method577(j);
	}

	public final void method179(int i, int j, TileSetting clippingPlanes[], int l, int i1, byte abyte0[],
								int j1, int k1, int l1)
	{
		for(int i2 = 0; i2 < 8; i2++)
		{
			for(int j2 = 0; j2 < 8; j2++)
				if(l + i2 > 0 && l + i2 < 103 && l1 + j2 > 0 && l1 + j2 < 103)
					clippingPlanes[k1].anIntArrayArray294[l + i2][l1 + j2] &= 0xfeffffff;

		}
		RSBuffer stream = new RSBuffer(abyte0);
		for(int l2 = 0; l2 < 4; l2++)
		{
			for(int i3 = 0; i3 < 64; i3++)
			{
				for(int j3 = 0; j3 < 64; j3++)
					if(l2 == i && i3 >= i1 && i3 < i1 + 8 && j3 >= j1 && j3 < j1 + 8)
						method181(l1 + MapUtility.method156(j3 & 7, j, i3 & 7), 0, stream, l + MapUtility.method155(j, j3 & 7, i3 & 7), k1, j, 0);
					else
						method181(-1, 0, stream, -1, 0, 0, 0);

			}

		}

	}

	public final void method180(byte abyte0[], int i, int j, int k, int l, TileSetting clippingPlanes[])
	{
		for(int i1 = 0; i1 < 4; i1++)
		{
			for(int j1 = 0; j1 < 64; j1++)
			{
				for(int k1 = 0; k1 < 64; k1++)
					if(j + j1 > 0 && j + j1 < 103 && i + k1 > 0 && i + k1 < 103)
						clippingPlanes[i1].anIntArrayArray294[j + j1][i + k1] &= 0xfeffffff;

			}

		}

		RSBuffer stream = new RSBuffer(abyte0);
		for(int l1 = 0; l1 < 4; l1++)
		{
			for(int i2 = 0; i2 < 64; i2++)
			{
				for(int j2 = 0; j2 < 64; j2++)
					method181(j2 + i, l, stream, i2 + j, l1, 0, k);

			}

		}
	}

	private void method181(int i, int j, RSBuffer stream, int k, int l, int i1,
								 int k1)
	{
		if(k >= 0 && k < 104 && i >= 0 && i < 104)
		{
			renderRuleFlags[l][k][i] = 0;
			do
			{
				int l1 = stream.readUnsignedByte();
				if(l1 == 0)
					if(l == 0)
					{
						vertexHeights[0][k][i] = -method172(0xe3b7b + k + k1, 0x87cce + i + j) * 8;
						return;
					} else
					{
						vertexHeights[l][k][i] = vertexHeights[l - 1][k][i] - 240;
						return;
					}
				if(l1 == 1)
				{
					int j2 = stream.readUnsignedByte();
					if(j2 == 1)
						j2 = 0;
					if(l == 0)
					{
						vertexHeights[0][k][i] = -j2 * 8;
						return;
					} else
					{
						vertexHeights[l][k][i] = vertexHeights[l - 1][k][i] - j2 * 8;
						return;
					}
				}
				if(l1 <= 49)
				{
					overlayFloorID[l][k][i] = stream.readSignedByte();
					overlayClippingPaths[l][k][i] = (byte)((l1 - 2) / 4);
					overlayClippingPathRotations[l][k][i] = (byte)((l1 - 2) + i1 & 3);
				} else
				if(l1 <= 81)
					renderRuleFlags[l][k][i] = (byte)(l1 - 49);
				else
					underlayFloorID[l][k][i] = (byte)(l1 - 81);
			} while(true);
		}
		do
		{
			int i2 = stream.readUnsignedByte();
			if(i2 == 0)
				break;
			if(i2 == 1)
			{
				stream.readUnsignedByte();
				return;
			}
			if(i2 <= 49)
				stream.readUnsignedByte();
		} while(true);
	}

	private int getVisibilityPlaneFor(int i, int j, int k)
	{
		if((renderRuleFlags[j][k][i] & 8) != 0)
			return 0;
		if(j > 0 && (renderRuleFlags[1][k][i] & 2) != 0)
			return j - 1;
		else
			return j;
	}

	public final void method183(TileSetting clippingPlanes[], SceneGraphic worldController, int i, int j, int k, int l,
								byte abyte0[], int i1, int j1, int k1)
	{
label0:
		{
			RSBuffer stream = new RSBuffer(abyte0);
			int l1 = -1;
			do
			{
				int i2 = stream.method422();
				if(i2 == 0)
					break label0;
				l1 += i2;
				int j2 = 0;
				do
				{
					int k2 = stream.method422();
					if(k2 == 0)
						break;
					j2 += k2 - 1;
					int l2 = j2 & 0x3f;
					int i3 = j2 >> 6 & 0x3f;
					int j3 = j2 >> 12;
					int k3 = stream.readUnsignedByte();
					int l3 = k3 >> 2;
					int i4 = k3 & 3;
					if(j3 == i && i3 >= i1 && i3 < i1 + 8 && l2 >= k && l2 < k + 8)
					{
						ObjectDef class46 = ObjectDef.forID(l1);
						int j4 = j + MapUtility.method157(j1, class46.height, i3 & 7, l2 & 7, class46.width);
						int k4 = k1 + MapUtility.method158(l2 & 7, class46.height, j1, class46.width, i3 & 7);
						if(j4 > 0 && k4 > 0 && j4 < 103 && k4 < 103)
						{
							int l4 = j3;
							if((renderRuleFlags[1][j4][k4] & 2) == 2)
								l4--;
							TileSetting class11 = null;
							if(l4 >= 0)
								class11 = clippingPlanes[l4];
							method175(k4, worldController, class11, l3, l, j4, l1, i4 + j1 & 3);
						}
					}
				} while(true);
			} while(true);
		}
	}

	private static int method184(int i, int j, int k, int l)
	{
		int i1 = 0x10000 - Rasterizer.anIntArray1471[(k * 1024) / l] >> 1;
		return (i * (0x10000 - i1) >> 16) + (j * i1 >> 16);
	}

	private int getRgbLookupTableId(int i, int j)
	{
		if(i == -2)
			return 0xbc614e;
		if(i == -1)
		{
			if(j < 0)
				j = 0;
			else
			if(j > 127)
				j = 127;
			j = 127 - j;
			return j;
		}
		j = (j * (i & 0x7f)) / 128;
		if(j < 2)
			j = 2;
		else
		if(j > 126)
			j = 126;
		return (i & 0xff80) + j;
	}

	private static int method186(int i, int j)
	{
		int k = method170(i - 1, j - 1) + method170(i + 1, j - 1) + method170(i - 1, j + 1) + method170(i + 1, j + 1);
		int l = method170(i - 1, j) + method170(i + 1, j) + method170(i, j - 1) + method170(i, j + 1);
		int i1 = method170(i, j);
		return k / 16 + l / 8 + i1 / 4;
	}

	private static int trimHSLLightness(int i, int j)
	{
		if(i == -1)
			return 0xbc614e;
		j = (j * (i & 0x7f)) / 128;
		if(j < 2)
			j = 2;
		else
		if(j > 126)
			j = 126;
		return (i & 0xff80) + j;
	}

	public static void method188(SceneGraphic worldController, int i, int j, int k, int l, TileSetting class11, int ai[][][], int i1,
								 int j1, int k1)
	{
		int l1 = ai[l][i1][j];
		int i2 = ai[l][i1 + 1][j];
		int j2 = ai[l][i1 + 1][j + 1];
		int k2 = ai[l][i1][j + 1];
		int l2 = l1 + i2 + j2 + k2 >> 2;
		ObjectDef class46 = ObjectDef.forID(j1);
		int i3 = i1 + (j << 7) + (j1 << 14) + 0x40000000;
		if(!class46.hasActions)
			i3 += 0x80000000;
		byte byte1 = (byte)((i << 6) + k);
		if(k == 22)
		{
			Object obj;
			if(class46.animation_id == -1 && class46.childrenIDs == null)
				obj = class46.method578(22, i, l1, i2, j2, k2, -1);
			else
				obj = new GameObject(j1, i, 22, i2, j2, l1, k2, class46.animation_id, true);
			worldController.method280(k1, l2, j, ((Renderable) (obj)), byte1, i3, i1);
			if(class46.isUnwalkable && class46.hasActions)
				class11.setSolidFlag(j, i1);
			return;
		}
		if(k == 10 || k == 11)
		{
			Object obj1;
			if(class46.animation_id == -1 && class46.childrenIDs == null)
				obj1 = class46.method578(10, i, l1, i2, j2, k2, -1);
			else
				obj1 = new GameObject(j1, i, 10, i2, j2, l1, k2, class46.animation_id, true);
			if(obj1 != null)
			{
				int j5 = 0;
				if(k == 11)
					j5 += 256;
				int k4;
				int i5;
				if(i == 1 || i == 3)
				{
					k4 = class46.height;
					i5 = class46.width;
				} else
				{
					k4 = class46.width;
					i5 = class46.height;
				}
				worldController.method284(i3, byte1, l2, i5, ((Renderable) (obj1)), k4, k1, j5, j, i1);
			}
			if(class46.isUnwalkable)
				class11.method212(class46.aBoolean757, class46.width, class46.height, i1, j, i);
			return;
		}
		if(k >= 12)
		{
			Object obj2;
			if(class46.animation_id == -1 && class46.childrenIDs == null)
				obj2 = class46.method578(k, i, l1, i2, j2, k2, -1);
			else
				obj2 = new GameObject(j1, i, k, i2, j2, l1, k2, class46.animation_id, true);
			worldController.method284(i3, byte1, l2, 1, ((Renderable) (obj2)), 1, k1, 0, j, i1);
			if(class46.isUnwalkable)
				class11.method212(class46.aBoolean757, class46.width, class46.height, i1, j, i);
			return;
		}
		if(k == 0)
		{
			Object obj3;
			if(class46.animation_id == -1 && class46.childrenIDs == null)
				obj3 = class46.method578(0, i, l1, i2, j2, k2, -1);
			else
				obj3 = new GameObject(j1, i, 0, i2, j2, l1, k2, class46.animation_id, true);
			worldController.method282(anIntArray152[i], ((Renderable) (obj3)), i3, j, byte1, i1, null, l2, 0, k1);
			if(class46.isUnwalkable)
				class11.method211(j, i, i1, k, class46.aBoolean757);
			return;
		}
		if(k == 1)
		{
			Object obj4;
			if(class46.animation_id == -1 && class46.childrenIDs == null)
				obj4 = class46.method578(1, i, l1, i2, j2, k2, -1);
			else
				obj4 = new GameObject(j1, i, 1, i2, j2, l1, k2, class46.animation_id, true);
			worldController.method282(anIntArray140[i], ((Renderable) (obj4)), i3, j, byte1, i1, null, l2, 0, k1);
			if(class46.isUnwalkable)
				class11.method211(j, i, i1, k, class46.aBoolean757);
			return;
		}
		if(k == 2)
		{
			int j3 = i + 1 & 3;
			Object obj11;
			Object obj12;
			if(class46.animation_id == -1 && class46.childrenIDs == null)
			{
				obj11 = class46.method578(2, 4 + i, l1, i2, j2, k2, -1);
				obj12 = class46.method578(2, j3, l1, i2, j2, k2, -1);
			} else
			{
				obj11 = new GameObject(j1, 4 + i, 2, i2, j2, l1, k2, class46.animation_id, true);
				obj12 = new GameObject(j1, j3, 2, i2, j2, l1, k2, class46.animation_id, true);
			}
			worldController.method282(anIntArray152[i], ((Renderable) (obj11)), i3, j, byte1, i1, ((Renderable) (obj12)), l2, anIntArray152[j3], k1);
			if(class46.isUnwalkable)
				class11.method211(j, i, i1, k, class46.aBoolean757);
			return;
		}
		if(k == 3)
		{
			Object obj5;
			if(class46.animation_id == -1 && class46.childrenIDs == null)
				obj5 = class46.method578(3, i, l1, i2, j2, k2, -1);
			else
				obj5 = new GameObject(j1, i, 3, i2, j2, l1, k2, class46.animation_id, true);
			worldController.method282(anIntArray140[i], ((Renderable) (obj5)), i3, j, byte1, i1, null, l2, 0, k1);
			if(class46.isUnwalkable)
				class11.method211(j, i, i1, k, class46.aBoolean757);
			return;
		}
		if(k == 9)
		{
			Object obj6;
			if(class46.animation_id == -1 && class46.childrenIDs == null)
				obj6 = class46.method578(k, i, l1, i2, j2, k2, -1);
			else
				obj6 = new GameObject(j1, i, k, i2, j2, l1, k2, class46.animation_id, true);
			worldController.method284(i3, byte1, l2, 1, ((Renderable) (obj6)), 1, k1, 0, j, i1);
			if(class46.isUnwalkable)
				class11.method212(class46.aBoolean757, class46.width, class46.height, i1, j, i);
			return;
		}
		if(class46.adjustToTerrain)
			if(i == 1)
			{
				int k3 = k2;
				k2 = j2;
				j2 = i2;
				i2 = l1;
				l1 = k3;
			} else
			if(i == 2)
			{
				int l3 = k2;
				k2 = i2;
				i2 = l3;
				l3 = j2;
				j2 = l1;
				l1 = l3;
			} else
			if(i == 3)
			{
				int i4 = k2;
				k2 = l1;
				l1 = i2;
				i2 = j2;
				j2 = i4;
			}
		if(k == 4)
		{
			Object obj7;
			if(class46.animation_id == -1 && class46.childrenIDs == null)
				obj7 = class46.method578(4, 0, l1, i2, j2, k2, -1);
			else
				obj7 = new GameObject(j1, 0, 4, i2, j2, l1, k2, class46.animation_id, true);
			worldController.method283(i3, j, i * 512, k1, 0, l2, ((Renderable) (obj7)), i1, byte1, 0, anIntArray152[i]);
			return;
		}
		if(k == 5)
		{
			int j4 = 16;
			int l4 = worldController.method300(k1, i1, j);
			if(l4 > 0)
				j4 = ObjectDef.forID(l4 >> 14 & 0x7fff).anInt775;
			Object obj13;
			if(class46.animation_id == -1 && class46.childrenIDs == null)
				obj13 = class46.method578(4, 0, l1, i2, j2, k2, -1);
			else
				obj13 = new GameObject(j1, 0, 4, i2, j2, l1, k2, class46.animation_id, true);
			worldController.method283(i3, j, i * 512, k1, anIntArray137[i] * j4, l2, ((Renderable) (obj13)), i1, byte1, anIntArray144[i] * j4, anIntArray152[i]);
			return;
		}
		if(k == 6)
		{
			Object obj8;
			if(class46.animation_id == -1 && class46.childrenIDs == null)
				obj8 = class46.method578(4, 0, l1, i2, j2, k2, -1);
			else
				obj8 = new GameObject(j1, 0, 4, i2, j2, l1, k2, class46.animation_id, true);
			worldController.method283(i3, j, i, k1, 0, l2, ((Renderable) (obj8)), i1, byte1, 0, 256);
			return;
		}
		if(k == 7)
		{
			Object obj9;
			if(class46.animation_id == -1 && class46.childrenIDs == null)
				obj9 = class46.method578(4, 0, l1, i2, j2, k2, -1);
			else
				obj9 = new GameObject(j1, 0, 4, i2, j2, l1, k2, class46.animation_id, true);
			worldController.method283(i3, j, i, k1, 0, l2, ((Renderable) (obj9)), i1, byte1, 0, 512);
			return;
		}
		if(k == 8)
		{
			Object obj10;
			if(class46.animation_id == -1 && class46.childrenIDs == null)
				obj10 = class46.method578(4, 0, l1, i2, j2, k2, -1);
			else
				obj10 = new GameObject(j1, 0, 4, i2, j2, l1, k2, class46.animation_id, true);
			worldController.method283(i3, j, i, k1, 0, l2, ((Renderable) (obj10)), i1, byte1, 0, 768);
		}
	}

  public static boolean method189(int i, byte[] is, int i_250_
  ) //xxx bad method, decompiled with JODE
  {
	boolean bool = true;
	RSBuffer stream = new RSBuffer(is);
	int i_252_ = -1;
	for (;;)
	  {
	int i_253_ = stream.method422 ();
	if (i_253_ == 0)
	  break;
	i_252_ += i_253_;
	int i_254_ = 0;
	boolean bool_255_ = false;
	for (;;)
	  {
		if (bool_255_)
		  {
		int i_256_ = stream.method422 ();
		if (i_256_ == 0)
		  break;
		stream.readUnsignedByte();
		  }
		else
		  {
		int i_257_ = stream.method422 ();
		if (i_257_ == 0)
		  break;
		i_254_ += i_257_ - 1;
		int i_258_ = i_254_ & 0x3f;
		int i_259_ = i_254_ >> 6 & 0x3f;
		int i_260_ = stream.readUnsignedByte() >> 2;
		int i_261_ = i_259_ + i;
		int i_262_ = i_258_ + i_250_;
		if (i_261_ > 0 && i_262_ > 0 && i_261_ < 103 && i_262_ < 103)
		  {
			ObjectDef class46 = ObjectDef.forID (i_252_);
			if (i_260_ != 22 || !lowMem || class46.hasActions
					|| class46.aBoolean736)
			  {
			bool &= class46.method579 ();
			bool_255_ = true;
			  }
		  }
		  }
	  }
	  }
	return bool;
  }

	public final void method190(int i, TileSetting clippingPlanes[], int j, SceneGraphic worldController, byte abyte0[])
	{
label0:
		{
			RSBuffer stream = new RSBuffer(abyte0);
			int l = -1;
			do
			{
				int i1 = stream.method422();
				if(i1 == 0)
					break label0;
				l += i1;
				int j1 = 0;
				do
				{
					int k1 = stream.method422();
					if(k1 == 0)
						break;
					j1 += k1 - 1;
					int l1 = j1 & 0x3f;
					int i2 = j1 >> 6 & 0x3f;
					int j2 = j1 >> 12;
					int k2 = stream.readUnsignedByte();
					int l2 = k2 >> 2;
					int i3 = k2 & 3;
					int j3 = i2 + i;
					int k3 = l1 + j;
					if(j3 > 0 && k3 > 0 && j3 < 103 && k3 < 103)
					{
						int l3 = j2;
						if((renderRuleFlags[1][j3][k3] & 2) == 2)
							l3--;
						TileSetting class11 = null;
						if(l3 >= 0)
							class11 = clippingPlanes[l3];
						method175(k3, worldController, class11, l2, j2, j3, l, i3);
					}
				} while(true);
			} while(true);
		}
	}

	public static int hueRandomizer = (int)(Math.random() * 17D) - 8;
	public final int[] blendedHue;
	public final int[] blendedSaturation;
	public final int[] blendedLightness;
	public final int[] blendedHueDivisor;
	public final int[] blendDirectionTracker;
	public final int[][][] vertexHeights;
	public final byte[][][] overlayFloorID;
	public static int onBuildTimePlane;
	public static int lightnessRandomizer = (int)(Math.random() * 33D) - 16;
	public final byte[][][] tileShadowIntensity;
	public final int[][][] tileCullingBitsets;
	public final byte[][][] overlayClippingPaths;
	public static final int anIntArray137[] = {
		1, 0, -1, 0
	};
	public static final int anInt138 = 323;
	public final int[][] tileLightingIntensity;
	public static final int anIntArray140[] = {
		16, 32, 64, 128
	};
	public final byte[][][] underlayFloorID;
	public static final int anIntArray144[] = {
		0, -1, 0, 1
	};
	static int lowestPlane = 99;
	public final int landscapeSizeX;
	public final int landscapeSizeY;
	public final byte[][][] overlayClippingPathRotations;
	public final byte[][][] renderRuleFlags;
	public static boolean lowMem = true;
	public static final int anIntArray152[] = {
		1, 2, 4, 8
	};
}