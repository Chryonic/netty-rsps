package com.runescape.revised.graphics;

import com.runescape.Deque;
import com.runescape.GroundTile;
import com.runescape.Rasterizer;
import com.runescape.Renderable;
import com.runescape.revised.graphics.cache.CullingCluster;
import com.runescape.revised.graphics.cache.GroundItemTile;
import com.runescape.revised.graphics.cache.Wall;
import com.runescape.revised.graphics.cache.FloorDecoration;
import com.runescape.revised.graphics.cache.InteractiveObject;
import com.runescape.revised.graphics.cache.PlainTile;
import com.runescape.revised.graphics.cache.ShapedTile;
import com.runescape.revised.graphics.cache.WallDecoration;
import com.runescape.revised.graphics.image.DrawingArea;
import com.runescape.revised.model.RSModel;
import com.runescape.revised.model.VertexNormal;

public final class SceneGraphic {

	public SceneGraphic(int ai[][][])
	{
		int i = 104;//was parameter
		int j = 104;//was parameter
		int k = 4;//was parameter
		aBoolean434 = true;
		obj5Cache = new InteractiveObject[5000];
		anIntArray486 = new int[10000];
		anIntArray487 = new int[10000];
		mapSizeZ = k;
		mapSizeX = j;
		mapSizeY = i;
			groundArray = new GroundTile[k][j][i];
			anIntArrayArrayArray445 = new int[k][j + 1][i + 1];
			anIntArrayArrayArray440 = ai;
			clearScene();
	}

	public static void nullLoader()
	{
		interactiveObjects = null;
		cullingClusterPointer = null;
		cullingClusters = null;
		aClass19_477 = null;
		aBooleanArrayArrayArrayArray491 = null;
		aBooleanArrayArray492 = null;
	}

	public void clearScene() // initToNull
	{
		for(int z = 0; z < mapSizeZ; z++)
		{
			for(int x = 0; x < mapSizeX; x++)
			{
				for(int y = 0; y < mapSizeY; y++)
					groundArray[z][x][y] = null;

			}

		}
		for(int l = 0; l < anInt472; l++)
		{
			for(int j1 = 0; j1 < cullingClusterPointer[l]; j1++)
				cullingClusters[l][j1] = null;

			cullingClusterPointer[l] = 0;
		}

		for(int k1 = 0; k1 < obj5CacheCurrPos; k1++)
			obj5Cache[k1] = null;

		obj5CacheCurrPos = 0;
		for(int l1 = 0; l1 < interactiveObjects.length; l1++)
			interactiveObjects[l1] = null;

	}

	public void setHeightLevel(int z) // method275
	{
		currentHeightLevel = z;
		for(int x = 0; x < mapSizeX; x++)
		{
			for(int y = 0; y < mapSizeY; y++)
				if(groundArray[z][x][y] == null)
					groundArray[z][x][y] = new GroundTile(z, x, y);

		}

	}

	public void setBridgeMode(int i, int j)
	{
		GroundTile class30_sub3 = groundArray[0][j][i];
		for(int l = 0; l < 3; l++)
		{
			GroundTile class30_sub3_1 = groundArray[l][j][i] = groundArray[l + 1][j][i];
			if(class30_sub3_1 != null)
			{
				class30_sub3_1.tileZ--;
				for(int j1 = 0; j1 < class30_sub3_1.actorCount; j1++)
				{
					InteractiveObject class28 = class30_sub3_1.interactiveObjects[j1];
					if((class28.uid >> 29 & 3) == 2 && class28.tileLeft == j && class28.tileTop == i)
						class28.zPosition--;
				}

			}
		}
		if(groundArray[0][j][i] == null)
			groundArray[0][j][i] = new GroundTile(0, j, i);
		groundArray[0][j][i].tileBelow = class30_sub3;
		groundArray[3][j][i] = null;
	}

	public static void createSceneCluster(int z, int lowestX, int lowestZ, int highestX, int highestY, int highestZ, int lowestY,
								 int searchMask) // method277
	{
		CullingCluster class47 = new CullingCluster();
		class47.tileStartX = lowestX / 128;
		class47.tileEndX = highestX / 128;
		class47.tileStartY = lowestY / 128;
		class47.tileEndY = highestY / 128;
		class47.searchMask = searchMask;
		class47.worldStartX = lowestX;
		class47.worldEndX = highestX;
		class47.worldStartY = lowestY;
		class47.worldEndY= highestY;
		class47.worldStartZ = highestZ;
		class47.worldEndZ = lowestZ;
		cullingClusters[z][cullingClusterPointer[z]++] = class47;
	}

	public void setVisiblePlanesFor(int z, int x, int y, int l) {
		GroundTile class30_sub3 = groundArray[z][x][y];
		if(class30_sub3 != null) {
			groundArray[z][x][y].logicHeight = l;
		}
	}

	public void addTile(int tileZ, int tileX, int tileY, int shape, int i1, int j1, int k1, 
			int l1, int i2, int j2, int k2, int l2, int i3, int j3, 
			int k3, int l3, int i4, int j4, int k4, int l4) { // method279
		if(shape == 0) {
			PlainTile class43 = new PlainTile(k2, l2, i3, j3, -1, k4, false);
			for(int heightLevel = tileZ; heightLevel >= 0; heightLevel--)
				if(groundArray[heightLevel][tileX][tileY] == null)
					groundArray[heightLevel][tileX][tileY] = new GroundTile(heightLevel, tileX, tileY);

			groundArray[tileZ][tileX][tileY].aClass43_1311 = class43;
			return;
		}
		if(shape == 1) {
			PlainTile class43_1 = new PlainTile(k3, l3, i4, j4, j1, l4, k1 == l1 && k1 == i2 && k1 == j2);
			for(int heightLevel = tileZ; heightLevel >= 0; heightLevel--)
				if(groundArray[heightLevel][tileX][tileY] == null)
					groundArray[heightLevel][tileX][tileY] = new GroundTile(heightLevel, tileX, tileY);

			groundArray[tileZ][tileX][tileY].aClass43_1311 = class43_1;
			return;
		}
		ShapedTile class40 = new ShapedTile(tileY, k3, j3, i2, j1, i4, i1, k2, k4, i3, j2, l1, k1, shape, j4, l3, l2, tileX, l4);
		for(int heightLevel = tileZ; heightLevel >= 0; heightLevel--)
			if(groundArray[heightLevel][tileX][tileY] == null)
				groundArray[heightLevel][tileX][tileY] = new GroundTile(heightLevel, tileX, tileY);

		groundArray[tileZ][tileX][tileY].aClass40_1312 = class40;
	}

	public void addGroundDecoration(int i, int j, int k, Renderable class30_sub2_sub4, byte byte0, int i1,
						  int j1) // method280
	{
		if(class30_sub2_sub4 == null)
			return;
		FloorDecoration class49 = new FloorDecoration();
		class49.actor = class30_sub2_sub4;
		class49.xPosition = j1 * 128 + 64;
		class49.yPosition = k * 128 + 64;
		class49.zPosition = j;
		class49.uid = i1;
		class49.objectConfig = byte0;
		if(groundArray[i][j1][k] == null)
			groundArray[i][j1][k] = new GroundTile(i, j1, k);
		groundArray[i][j1][k].floorDecoration = class49;
	}

	public void addGroundItem(int x, int j, Renderable secondGroundItem, int z, Renderable thirdGroundItem, Renderable firstGroundItem,
						  int tileZ, int y) // method281
	{
		GroundItemTile object4 = new GroundItemTile();
		object4.firstGroundItem = firstGroundItem;
		object4.x = x * 128 + 64;
		object4.y = y * 128 + 64;
		object4.z = z;
		object4.uid = j;
		object4.secondGroundItem = secondGroundItem;
		object4.thirdGroundItem = thirdGroundItem;
		int off = 0;
		GroundTile class30_sub3 = groundArray[tileZ][x][y];
		if(class30_sub3 != null)
		{
			for(int count = 0; count < class30_sub3.actorCount; count++)
				if(class30_sub3.interactiveObjects[count].actor instanceof RSModel)
				{
					int l1 = ((RSModel)class30_sub3.interactiveObjects[count].actor).anInt1654;
					if(l1 > off)
						off = l1;
				}

		}
		object4.anInt52 = off;
		if(groundArray[tileZ][x][y] == null)
			groundArray[tileZ][x][y] = new GroundTile(tileZ, x, y);
		groundArray[tileZ][x][y].groundItemTile = object4;
	}

	public void addWall(int orientationOne, Renderable actorOne, int uid, int y, byte objectConfig, int x,
						  Renderable actorTwo, int z, int orientationTwo, int tileZ)
	{
		if(actorOne == null && actorTwo == null)
			return;
		Wall wall = new Wall();
		wall.uid = uid;
		wall.objectConfig = objectConfig;
		wall.x = x * 128 + 64;
		wall.y = y * 128 + 64;
		wall.z = z;
		wall.actorOne = actorOne;
		wall.actorTwo = actorTwo;
		wall.orientation = orientationOne;
		wall.orientation1 = orientationTwo;
		for(int groundZ = tileZ; groundZ >= 0; groundZ--)
			if(groundArray[groundZ][x][y] == null)
				groundArray[groundZ][x][y] = new GroundTile(groundZ, x, y);

		groundArray[tileZ][x][y].wall = wall;
	}

	public void addWallDecoration(int i, int j, int k, int i1, int j1, int k1,
						  Renderable class30_sub2_sub4, int l1, byte byte0, int i2, int j2) // method283
	{
		if(class30_sub2_sub4 == null)
			return;
		WallDecoration class26 = new WallDecoration();
		class26.uid = i;
		class26.aByte506 = byte0;
		class26.anInt500 = l1 * 128 + 64 + j1;
		class26.anInt501 = j * 128 + 64 + i2;
		class26.anInt499 = k1;
		class26.aClass30_Sub2_Sub4_504 = class30_sub2_sub4;
		class26.anInt502 = j2;
		class26.anInt503 = k;
		for(int k2 = i1; k2 >= 0; k2--)
			if(groundArray[k2][l1][j] == null)
				groundArray[k2][l1][j] = new GroundTile(k2, l1, j);

		groundArray[i1][l1][j].wallDecoration = class26;
	}

	public boolean addActorB(int i, byte byte0, int j, int k, Renderable class30_sub2_sub4, int l, int i1,
							 int j1, int k1, int l1) // method284
	{
		if(class30_sub2_sub4 == null)
		{
			return true;
		} else
		{
			int i2 = l1 * 128 + 64 * l;
			int j2 = k1 * 128 + 64 * k;
			return addActorC(i1, l1, k1, l, k, i2, j2, j, class30_sub2_sub4, j1, false, i, byte0);
		}
	}

	public boolean addActorA(int i, int drawHeight, int k, int l, int boundExtentY, int j1,
							 int boundExtentX, Renderable npc, boolean flag) // method285
	{
		if(npc == null)
			return true;
		int x = boundExtentX - j1;
		int y = boundExtentY - j1;
		int j2 = boundExtentX + j1;
		int k2 = boundExtentY + j1;
		if(flag)
		{
			if(drawHeight > 640 && drawHeight < 1408)
				k2 += 128;
			if(drawHeight > 1152 && drawHeight < 1920)
				j2 += 128;
			if(drawHeight > 1664 || drawHeight < 384)
				y -= 128;
			if(drawHeight > 128 && drawHeight < 896)
				x -= 128;
		}
		x /= 128;
		y /= 128;
		j2 /= 128;
		k2 /= 128;
		return addActorC(i, x, y, (j2 - x) + 1, (k2 - y) + 1, boundExtentX, boundExtentY, k, npc, drawHeight, true, l, (byte)0);
	}

	public boolean addActor(int j, int k, Renderable actor, int l, int i1, int j1,
							 int k1, int l1, int i2, int j2, int k2) // method286
	{
		return actor == null || addActorC(j, l1, k2, (i2 - l1) + 1, (i1 - k2) + 1, j1, k, k1, actor, l, true, j2, (byte) 0);
	}

	private boolean addActorC(int i, int j, int k, int l, int i1, int j1, int k1,
			int l1, Renderable class30_sub2_sub4, int i2, boolean flag, int j2, byte byte0) // method287
	{
		for(int k2 = j; k2 < j + l; k2++)
		{
			for(int l2 = k; l2 < k + i1; l2++)
			{
				if(k2 < 0 || l2 < 0 || k2 >= mapSizeX || l2 >= mapSizeY)
					return false;
				GroundTile class30_sub3 = groundArray[i][k2][l2];
				if(class30_sub3 != null && class30_sub3.actorCount >= 5)
					return false;
			}

		}

		InteractiveObject class28 = new InteractiveObject();
		class28.uid = j2;
		class28.objectConfiguration = byte0;
		class28.zPosition = i;
		class28.worldX = j1;
		class28.worldY = k1;
		class28.worldZ = l1;
		class28.actor = class30_sub2_sub4;
		class28.rotation = i2;
		class28.tileLeft = j;
		class28.tileTop = k;
		class28.tileRight = (j + l) - 1;
		class28.tileBottom = (k + i1) - 1;
		for(int i3 = j; i3 < j + l; i3++)
		{
			for(int j3 = k; j3 < k + i1; j3++)
			{
				int k3 = 0;
				if(i3 > j)
					k3++;
				if(i3 < (j + l) - 1)
					k3 += 4;
				if(j3 > k)
					k3 += 8;
				if(j3 < (k + i1) - 1)
					k3 += 2;
				for(int l3 = i; l3 >= 0; l3--)
					if(groundArray[l3][i3][j3] == null)
						groundArray[l3][i3][j3] = new GroundTile(l3, i3, j3);

				GroundTile class30_sub3_1 = groundArray[i][i3][j3];
				class30_sub3_1.interactiveObjects[class30_sub3_1.actorCount] = class28;
				class30_sub3_1.anIntArray1319[class30_sub3_1.actorCount] = k3;
				class30_sub3_1.anInt1320 |= k3;
				class30_sub3_1.actorCount++;
			}

		}

		if(flag)
			obj5Cache[obj5CacheCurrPos++] = class28;
		return true;
	}

	public void clearObj5Cache()
	{
		for(int i = 0; i < obj5CacheCurrPos; i++)
		{
			InteractiveObject interactiveObject = obj5Cache[i];
			method289(interactiveObject);
			obj5Cache[i] = null;
		}

		obj5CacheCurrPos = 0;
	}

	private void method289(InteractiveObject class28)
	{
		for(int j = class28.tileLeft; j <= class28.tileRight; j++)
		{
			for(int k = class28.tileTop; k <= class28.tileBottom; k++)
			{
				GroundTile class30_sub3 = groundArray[class28.zPosition][j][k];
				if(class30_sub3 != null)
				{
					for(int l = 0; l < class30_sub3.actorCount; l++)
					{
						if(class30_sub3.interactiveObjects[l] != class28)
							continue;
						class30_sub3.actorCount--;
						for(int i1 = l; i1 < class30_sub3.actorCount; i1++)
						{
							class30_sub3.interactiveObjects[i1] = class30_sub3.interactiveObjects[i1 + 1];
							class30_sub3.anIntArray1319[i1] = class30_sub3.anIntArray1319[i1 + 1];
						}

						class30_sub3.interactiveObjects[class30_sub3.actorCount] = null;
						break;
					}

					class30_sub3.anInt1320 = 0;
					for(int j1 = 0; j1 < class30_sub3.actorCount; j1++)
						class30_sub3.anInt1320 |= class30_sub3.anIntArray1319[j1];

				}
			}

		}

	}

	public void method290(int i, int k, int l, int i1)
	{
		GroundTile class30_sub3 = groundArray[i1][l][i];
		if(class30_sub3 == null)
			return;
		WallDecoration class26 = class30_sub3.wallDecoration;
		if(class26 != null)
		{
			int j1 = l * 128 + 64;
			int k1 = i * 128 + 64;
			class26.anInt500 = j1 + ((class26.anInt500 - j1) * k) / 16;
			class26.anInt501 = k1 + ((class26.anInt501 - k1) * k) / 16;
		}
	}

	public void method291(int i, int j, int k, byte byte0)
	{
		GroundTile class30_sub3 = groundArray[j][i][k];
		if(byte0 != -119)
			aBoolean434 = !aBoolean434;
		if(class30_sub3 != null)
		{
			class30_sub3.wall = null;
		}
	}

	public void method292(int j, int k, int l)
	{
		GroundTile class30_sub3 = groundArray[k][l][j];
		if(class30_sub3 != null)
		{
			class30_sub3.wallDecoration = null;
		}
	}

	public void method293(int i, int k, int l)
	{
		GroundTile class30_sub3 = groundArray[i][k][l];
		if(class30_sub3 == null)
			return;
		for(int j1 = 0; j1 < class30_sub3.actorCount; j1++)
		{
			InteractiveObject class28 = class30_sub3.interactiveObjects[j1];
			if((class28.uid >> 29 & 3) == 2 && class28.tileLeft == k && class28.tileTop == l)
			{
				method289(class28);
				return;
			}
		}

	}

	public void method294(int i, int j, int k)
	{
		GroundTile class30_sub3 = groundArray[i][k][j];
		if(class30_sub3 == null)
			return;
		class30_sub3.floorDecoration = null;
	}

	public void method295(int i, int j, int k)
	{
		GroundTile class30_sub3 = groundArray[i][j][k];
		if(class30_sub3 != null)
		{
			class30_sub3.groundItemTile = null;
		}
	}

	public Wall method296(int i, int j, int k)
	{
		GroundTile class30_sub3 = groundArray[i][j][k];
		if(class30_sub3 == null)
			return null;
		else
			return class30_sub3.wall;
	}

	public WallDecoration method297(int i, int k, int l)
	{
		GroundTile class30_sub3 = groundArray[l][i][k];
		if(class30_sub3 == null)
			return null;
		else
			return class30_sub3.wallDecoration;
	}

	public InteractiveObject method298(int i, int j, int k)
	{
		GroundTile class30_sub3 = groundArray[k][i][j];
		if(class30_sub3 == null)
			return null;
		for(int l = 0; l < class30_sub3.actorCount; l++)
		{
			InteractiveObject class28 = class30_sub3.interactiveObjects[l];
			if((class28.uid >> 29 & 3) == 2 && class28.tileLeft == i && class28.tileTop == j)
				return class28;
		}
		return null;
	}

	public FloorDecoration method299(int i, int j, int k)
	{
		GroundTile class30_sub3 = groundArray[k][j][i];
		if(class30_sub3 == null || class30_sub3.floorDecoration == null)
			return null;
		else
			return class30_sub3.floorDecoration;
	}

	public int method300(int i, int j, int k)
	{
		GroundTile class30_sub3 = groundArray[i][j][k];
		if(class30_sub3 == null || class30_sub3.wall == null)
			return 0;
		else
			return class30_sub3.wall.uid;
	}

	public int method301(int i, int j, int l)
	{
		GroundTile class30_sub3 = groundArray[i][j][l];
		if(class30_sub3 == null || class30_sub3.wallDecoration == null)
			return 0;
		else
			return class30_sub3.wallDecoration.uid;
	}

	public int method302(int i, int j, int k)
	{
		GroundTile class30_sub3 = groundArray[i][j][k];
		if(class30_sub3 == null)
			return 0;
		for(int l = 0; l < class30_sub3.actorCount; l++)
		{
			InteractiveObject class28 = class30_sub3.interactiveObjects[l];
			if((class28.uid >> 29 & 3) == 2 && class28.tileLeft == j && class28.tileTop == k)
				return class28.uid;
		}

		return 0;
	}

	public int method303(int i, int j, int k)
	{
		GroundTile class30_sub3 = groundArray[i][j][k];
		if(class30_sub3 == null || class30_sub3.floorDecoration == null)
			return 0;
		else
			return class30_sub3.floorDecoration.uid;
	}

	public int method304(int i, int j, int k, int l)
	{
		GroundTile class30_sub3 = groundArray[i][j][k];
		if(class30_sub3 == null)
			return -1;
		if(class30_sub3.wall != null && class30_sub3.wall.uid == l)
			return class30_sub3.wall.objectConfig & 0xff;
		if(class30_sub3.wallDecoration != null && class30_sub3.wallDecoration.uid == l)
			return class30_sub3.wallDecoration.aByte506 & 0xff;
		if(class30_sub3.floorDecoration != null && class30_sub3.floorDecoration.uid == l)
			return class30_sub3.floorDecoration.objectConfig & 0xff;
		for(int i1 = 0; i1 < class30_sub3.actorCount; i1++)
			if(class30_sub3.interactiveObjects[i1].uid == l)
				return class30_sub3.interactiveObjects[i1].objectConfiguration & 0xff;

		return -1;
	}

	public void applyDLNonTexturedObjects(int i, int k, int i1)
	{
		int j = 64;//was parameter
		int l = 768;//was parameter
		int j1 = (int)Math.sqrt(k * k + i * i + i1 * i1);
		int k1 = l * j1 >> 8;
		for(int l1 = 0; l1 < mapSizeZ; l1++)
		{
			for(int i2 = 0; i2 < mapSizeX; i2++)
			{
				for(int j2 = 0; j2 < mapSizeY; j2++)
				{
					GroundTile class30_sub3 = groundArray[l1][i2][j2];
					if(class30_sub3 != null)
					{
						Wall class10 = class30_sub3.wall;
						if(class10 != null && class10.actorOne != null && class10.actorOne.aClass33Array1425 != null)
						{
							method307(l1, 1, 1, i2, j2, (RSModel)class10.actorOne);
							if(class10.actorTwo != null && class10.actorTwo.aClass33Array1425 != null)
							{
								method307(l1, 1, 1, i2, j2, (RSModel)class10.actorTwo);
								method308((RSModel)class10.actorOne, (RSModel)class10.actorTwo, 0, 0, 0, false);
								((RSModel)class10.actorTwo).method480(j, k1, k, i, i1);
							}
							((RSModel)class10.actorOne).method480(j, k1, k, i, i1);
						}
						for(int k2 = 0; k2 < class30_sub3.actorCount; k2++)
						{
							InteractiveObject class28 = class30_sub3.interactiveObjects[k2];
							if(class28 != null && class28.actor != null && class28.actor.aClass33Array1425 != null)
							{
								method307(l1, (class28.tileRight - class28.tileLeft) + 1, (class28.tileBottom - class28.tileTop) + 1, i2, j2, (RSModel)class28.actor);
								((RSModel)class28.actor).method480(j, k1, k, i, i1);
							}
						}

						FloorDecoration class49 = class30_sub3.floorDecoration;
						if(class49 != null && class49.actor.aClass33Array1425 != null)
						{
							method306(i2, l1, (RSModel)class49.actor, j2);
							((RSModel)class49.actor).method480(j, k1, k, i, i1);
						}
					}
				}
			}
		}
	}

	private void method306(int i, int j, RSModel model, int k)
	{
		if(i < mapSizeX)
		{
			GroundTile class30_sub3 = groundArray[j][i + 1][k];
			if(class30_sub3 != null && class30_sub3.floorDecoration != null && class30_sub3.floorDecoration.actor.aClass33Array1425 != null)
				method308(model, (RSModel)class30_sub3.floorDecoration.actor, 128, 0, 0, true);
		}
		if(k < mapSizeX)
		{
			GroundTile class30_sub3_1 = groundArray[j][i][k + 1];
			if(class30_sub3_1 != null && class30_sub3_1.floorDecoration != null && class30_sub3_1.floorDecoration.actor.aClass33Array1425 != null)
				method308(model, (RSModel)class30_sub3_1.floorDecoration.actor, 0, 0, 128, true);
		}
		if(i < mapSizeX && k < mapSizeY)
		{
			GroundTile class30_sub3_2 = groundArray[j][i + 1][k + 1];
			if(class30_sub3_2 != null && class30_sub3_2.floorDecoration != null && class30_sub3_2.floorDecoration.actor.aClass33Array1425 != null)
				method308(model, (RSModel)class30_sub3_2.floorDecoration.actor, 128, 0, 128, true);
		}
		if(i < mapSizeX && k > 0)
		{
			GroundTile class30_sub3_3 = groundArray[j][i + 1][k - 1];
			if(class30_sub3_3 != null && class30_sub3_3.floorDecoration != null && class30_sub3_3.floorDecoration.actor.aClass33Array1425 != null)
				method308(model, (RSModel)class30_sub3_3.floorDecoration.actor, 128, 0, -128, true);
		}
	}

	private void method307(int i, int j, int k, int l, int i1, RSModel model)
	{
		boolean flag = true;
		int j1 = l;
		int k1 = l + j;
		int l1 = i1 - 1;
		int i2 = i1 + k;
		for(int j2 = i; j2 <= i + 1; j2++)
			if(j2 != mapSizeZ)
			{
				for(int k2 = j1; k2 <= k1; k2++)
					if(k2 >= 0 && k2 < mapSizeX)
					{
						for(int l2 = l1; l2 <= i2; l2++)
							if(l2 >= 0 && l2 < mapSizeY && (!flag || k2 >= k1 || l2 >= i2 || l2 < i1 && k2 != l))
							{
								GroundTile class30_sub3 = groundArray[j2][k2][l2];
								if(class30_sub3 != null)
								{
									int i3 = (anIntArrayArrayArray440[j2][k2][l2] + anIntArrayArrayArray440[j2][k2 + 1][l2] + anIntArrayArrayArray440[j2][k2][l2 + 1] + anIntArrayArrayArray440[j2][k2 + 1][l2 + 1]) / 4 - (anIntArrayArrayArray440[i][l][i1] + anIntArrayArrayArray440[i][l + 1][i1] + anIntArrayArrayArray440[i][l][i1 + 1] + anIntArrayArrayArray440[i][l + 1][i1 + 1]) / 4;
									Wall class10 = class30_sub3.wall;
									if(class10 != null && class10.actorOne != null && class10.actorOne.aClass33Array1425 != null)
										method308(model, (RSModel)class10.actorOne, (k2 - l) * 128 + (1 - j) * 64, i3, (l2 - i1) * 128 + (1 - k) * 64, flag);
									if(class10 != null && class10.actorTwo != null && class10.actorTwo.aClass33Array1425 != null)
										method308(model, (RSModel)class10.actorTwo, (k2 - l) * 128 + (1 - j) * 64, i3, (l2 - i1) * 128 + (1 - k) * 64, flag);
									for(int j3 = 0; j3 < class30_sub3.actorCount; j3++)
									{
										InteractiveObject class28 = class30_sub3.interactiveObjects[j3];
										if(class28 != null && class28.actor != null && class28.actor.aClass33Array1425 != null)
										{
											int k3 = (class28.tileRight - class28.tileLeft) + 1;
											int l3 = (class28.tileBottom - class28.tileTop) + 1;
											method308(model, (RSModel)class28.actor, (class28.tileLeft - l) * 128 + (k3 - j) * 64, i3, (class28.tileTop - i1) * 128 + (l3 - k) * 64, flag);
										}
									}

								}
							}

					}

				j1--;
				flag = false;
			}

	}

	private void method308(RSModel model, RSModel model_1, int i, int j, int k, boolean flag)
	{
		anInt488++;
		int l = 0;
		int ai[] = model_1.anIntArray1627;
		int i1 = model_1.anInt1626;
		for(int j1 = 0; j1 < model.anInt1626; j1++)
		{
			VertexNormal class33 = model.aClass33Array1425[j1];
			VertexNormal class33_1 = model.aClass33Array1660[j1];
			if(class33_1.magnitude != 0)
			{
				int i2 = model.anIntArray1628[j1] - j;
				if(i2 <= model_1.anInt1651)
				{
					int j2 = model.anIntArray1627[j1] - i;
					if(j2 >= model_1.anInt1646 && j2 <= model_1.anInt1647)
					{
						int k2 = model.anIntArray1629[j1] - k;
						if(k2 >= model_1.anInt1649 && k2 <= model_1.anInt1648)
						{
							for(int l2 = 0; l2 < i1; l2++)
							{
								VertexNormal class33_2 = model_1.aClass33Array1425[l2];
								VertexNormal class33_3 = model_1.aClass33Array1660[l2];
								if(j2 == ai[l2] && k2 == model_1.anIntArray1629[l2] && i2 == model_1.anIntArray1628[l2] && class33_3.magnitude != 0)
								{
									class33.x += class33_3.x;
									class33.y += class33_3.y;
									class33.z += class33_3.z;
									class33.magnitude += class33_3.magnitude;
									class33_2.x += class33_1.x;
									class33_2.y += class33_1.y;
									class33_2.z += class33_1.z;
									class33_2.magnitude += class33_1.magnitude;
									l++;
									anIntArray486[j1] = anInt488;
									anIntArray487[l2] = anInt488;
								}
							}

						}
					}
				}
			}
		}

		if(l < 3 || !flag)
			return;
		for(int k1 = 0; k1 < model.anInt1630; k1++)
			if(anIntArray486[model.anIntArray1631[k1]] == anInt488 && anIntArray486[model.anIntArray1632[k1]] == anInt488 && anIntArray486[model.anIntArray1633[k1]] == anInt488)
				model.anIntArray1637[k1] = -1;

		for(int l1 = 0; l1 < model_1.anInt1630; l1++)
			if(anIntArray487[model_1.anIntArray1631[l1]] == anInt488 && anIntArray487[model_1.anIntArray1632[l1]] == anInt488 && anIntArray487[model_1.anIntArray1633[l1]] == anInt488)
				model_1.anIntArray1637[l1] = -1;

	}

	public void method309(int ai[], int i, int k, int l, int i1)
	{
		int j = 512;//was parameter
		GroundTile class30_sub3 = groundArray[k][l][i1];
		if(class30_sub3 == null)
			return;
		PlainTile class43 = class30_sub3.aClass43_1311;
		if(class43 != null)
		{
			int j1 = class43.anInt722;
			if(j1 == 0)
				return;
			for(int k1 = 0; k1 < 4; k1++)
			{
				ai[i] = j1;
				ai[i + 1] = j1;
				ai[i + 2] = j1;
				ai[i + 3] = j1;
				i += j;
			}

			return;
		}
		ShapedTile class40 = class30_sub3.aClass40_1312;
		if(class40 == null)
			return;
		int l1 = class40.anInt684;
		int i2 = class40.anInt685;
		int j2 = class40.anInt686;
		int k2 = class40.anInt687;
		int ai1[] = anIntArrayArray489[l1];
		int ai2[] = anIntArrayArray490[i2];
		int l2 = 0;
		if(j2 != 0)
		{
			for(int i3 = 0; i3 < 4; i3++)
			{
				ai[i] = ai1[ai2[l2++]] != 0 ? k2 : j2;
				ai[i + 1] = ai1[ai2[l2++]] != 0 ? k2 : j2;
				ai[i + 2] = ai1[ai2[l2++]] != 0 ? k2 : j2;
				ai[i + 3] = ai1[ai2[l2++]] != 0 ? k2 : j2;
				i += j;
			}

			return;
		}
		for(int j3 = 0; j3 < 4; j3++)
		{
			if(ai1[ai2[l2++]] != 0)
				ai[i] = k2;
			if(ai1[ai2[l2++]] != 0)
				ai[i + 1] = k2;
			if(ai1[ai2[l2++]] != 0)
				ai[i + 2] = k2;
			if(ai1[ai2[l2++]] != 0)
				ai[i + 3] = k2;
			i += j;
		}

	}

	public static void method310(int i, int j, int k, int l, int ai[])
	{
		anInt495 = 0;
		anInt496 = 0;
		anInt497 = k;
		anInt498 = l;
		anInt493 = k / 2;
		anInt494 = l / 2;
		boolean aflag[][][][] = new boolean[9][32][53][53];
		for(int i1 = 128; i1 <= 384; i1 += 32)
		{
			for(int j1 = 0; j1 < 2048; j1 += 64)
			{
				anInt458 = RSModel.modelIntArray1[i1];
				anInt459 = RSModel.modelIntArray2[i1];
				anInt460 = RSModel.modelIntArray1[j1];
				anInt461 = RSModel.modelIntArray2[j1];
				int l1 = (i1 - 128) / 32;
				int j2 = j1 / 64;
				for(int l2 = -26; l2 <= 26; l2++)
				{
					for(int j3 = -26; j3 <= 26; j3++)
					{
						int k3 = l2 * 128;
						int i4 = j3 * 128;
						boolean flag2 = false;
						for(int k4 = -i; k4 <= j; k4 += 128)
						{
							if(!method311(ai[l1] + k4, i4, k3))
								continue;
							flag2 = true;
							break;
						}

						aflag[l1][j2][l2 + 25 + 1][j3 + 25 + 1] = flag2;
					}

				}

			}

		}

		for(int k1 = 0; k1 < 8; k1++)
		{
			for(int i2 = 0; i2 < 32; i2++)
			{
				for(int k2 = -25; k2 < 25; k2++)
				{
					for(int i3 = -25; i3 < 25; i3++)
					{
						boolean flag1 = false;
label0:
						for(int l3 = -1; l3 <= 1; l3++)
						{
							for(int j4 = -1; j4 <= 1; j4++)
							{
								if(aflag[k1][i2][k2 + l3 + 25 + 1][i3 + j4 + 25 + 1])
									flag1 = true;
								else
								if(aflag[k1][(i2 + 1) % 31][k2 + l3 + 25 + 1][i3 + j4 + 25 + 1])
									flag1 = true;
								else
								if(aflag[k1 + 1][i2][k2 + l3 + 25 + 1][i3 + j4 + 25 + 1])
								{
									flag1 = true;
								} else
								{
									if(!aflag[k1 + 1][(i2 + 1) % 31][k2 + l3 + 25 + 1][i3 + j4 + 25 + 1])
										continue;
									flag1 = true;
								}
								break label0;
							}

						}

						aBooleanArrayArrayArrayArray491[k1][i2][k2 + 25][i3 + 25] = flag1;
					}

				}

			}

		}

	}

	private static boolean method311(int i, int j, int k)
	{
		int l = j * anInt460 + k * anInt461 >> 16;
		int i1 = j * anInt461 - k * anInt460 >> 16;
		int j1 = i * anInt458 + i1 * anInt459 >> 16;
		int k1 = i * anInt459 - i1 * anInt458 >> 16;
		if(j1 < 50 || j1 > 3500)
			return false;
		int l1 = anInt493 + (l << 9) / j1;
		int i2 = anInt494 + (k1 << 9) / j1;
		return l1 >= anInt495 && l1 <= anInt497 && i2 >= anInt496 && i2 <= anInt498;
	}

	public void method312(int i, int j)
	{
		aBoolean467 = true;
		anInt468 = j;
		anInt469 = i;
		anInt470 = -1;
		anInt471 = -1;
	}

	public void method313(int i, int j, int k, int l, int i1, int j1)
	{
		if(i < 0)
			i = 0;
		else
		if(i >= mapSizeX * 128)
			i = mapSizeX * 128 - 1;
		if(j < 0)
			j = 0;
		else
		if(j >= mapSizeY * 128)
			j = mapSizeY * 128 - 1;
		anInt448++;
		anInt458 = RSModel.modelIntArray1[j1];
		anInt459 = RSModel.modelIntArray2[j1];
		anInt460 = RSModel.modelIntArray1[k];
		anInt461 = RSModel.modelIntArray2[k];
		aBooleanArrayArray492 = aBooleanArrayArrayArrayArray491[(j1 - 128) / 32][k / 64];
		anInt455 = i;
		anInt456 = l;
		anInt457 = j;
		anInt453 = i / 128;
		anInt454 = j / 128;
		anInt447 = i1;
		anInt449 = anInt453 - 25;
		if(anInt449 < 0)
			anInt449 = 0;
		anInt451 = anInt454 - 25;
		if(anInt451 < 0)
			anInt451 = 0;
		anInt450 = anInt453 + 25;
		if(anInt450 > mapSizeX)
			anInt450 = mapSizeX;
		anInt452 = anInt454 + 25;
		if(anInt452 > mapSizeY)
			anInt452 = mapSizeY;
		method319();
		anInt446 = 0;
		for(int k1 = currentHeightLevel; k1 < mapSizeZ; k1++)
		{
			GroundTile aclass30_sub3[][] = groundArray[k1];
			for(int i2 = anInt449; i2 < anInt450; i2++)
			{
				for(int k2 = anInt451; k2 < anInt452; k2++)
				{
					GroundTile class30_sub3 = aclass30_sub3[i2][k2];
					if(class30_sub3 != null)
						if(class30_sub3.logicHeight > i1 || !aBooleanArrayArray492[(i2 - anInt453) + 25][(k2 - anInt454) + 25] && anIntArrayArrayArray440[k1][i2][k2] - l < 2000)
						{
							class30_sub3.aBoolean1322 = false;
							class30_sub3.aBoolean1323 = false;
							class30_sub3.anInt1325 = 0;
						} else
						{
							class30_sub3.aBoolean1322 = true;
							class30_sub3.aBoolean1323 = true;
							class30_sub3.aBoolean1324 = class30_sub3.actorCount > 0;
							anInt446++;
						}
				}

			}

		}

		for(int l1 = currentHeightLevel; l1 < mapSizeZ; l1++)
		{
			GroundTile aclass30_sub3_1[][] = groundArray[l1];
			for(int l2 = -25; l2 <= 0; l2++)
			{
				int i3 = anInt453 + l2;
				int k3 = anInt453 - l2;
				if(i3 >= anInt449 || k3 < anInt450)
				{
					for(int i4 = -25; i4 <= 0; i4++)
					{
						int k4 = anInt454 + i4;
						int i5 = anInt454 - i4;
						if(i3 >= anInt449)
						{
							if(k4 >= anInt451)
							{
								GroundTile class30_sub3_1 = aclass30_sub3_1[i3][k4];
								if(class30_sub3_1 != null && class30_sub3_1.aBoolean1322)
									method314(class30_sub3_1, true);
							}
							if(i5 < anInt452)
							{
								GroundTile class30_sub3_2 = aclass30_sub3_1[i3][i5];
								if(class30_sub3_2 != null && class30_sub3_2.aBoolean1322)
									method314(class30_sub3_2, true);
							}
						}
						if(k3 < anInt450)
						{
							if(k4 >= anInt451)
							{
								GroundTile class30_sub3_3 = aclass30_sub3_1[k3][k4];
								if(class30_sub3_3 != null && class30_sub3_3.aBoolean1322)
									method314(class30_sub3_3, true);
							}
							if(i5 < anInt452)
							{
								GroundTile class30_sub3_4 = aclass30_sub3_1[k3][i5];
								if(class30_sub3_4 != null && class30_sub3_4.aBoolean1322)
									method314(class30_sub3_4, true);
							}
						}
						if(anInt446 == 0)
						{
							aBoolean467 = false;
							return;
						}
					}

				}
			}

		}

		for(int j2 = currentHeightLevel; j2 < mapSizeZ; j2++)
		{
			GroundTile aclass30_sub3_2[][] = groundArray[j2];
			for(int j3 = -25; j3 <= 0; j3++)
			{
				int l3 = anInt453 + j3;
				int j4 = anInt453 - j3;
				if(l3 >= anInt449 || j4 < anInt450)
				{
					for(int l4 = -25; l4 <= 0; l4++)
					{
						int j5 = anInt454 + l4;
						int k5 = anInt454 - l4;
						if(l3 >= anInt449)
						{
							if(j5 >= anInt451)
							{
								GroundTile class30_sub3_5 = aclass30_sub3_2[l3][j5];
								if(class30_sub3_5 != null && class30_sub3_5.aBoolean1322)
									method314(class30_sub3_5, false);
							}
							if(k5 < anInt452)
							{
								GroundTile class30_sub3_6 = aclass30_sub3_2[l3][k5];
								if(class30_sub3_6 != null && class30_sub3_6.aBoolean1322)
									method314(class30_sub3_6, false);
							}
						}
						if(j4 < anInt450)
						{
							if(j5 >= anInt451)
							{
								GroundTile class30_sub3_7 = aclass30_sub3_2[j4][j5];
								if(class30_sub3_7 != null && class30_sub3_7.aBoolean1322)
									method314(class30_sub3_7, false);
							}
							if(k5 < anInt452)
							{
								GroundTile class30_sub3_8 = aclass30_sub3_2[j4][k5];
								if(class30_sub3_8 != null && class30_sub3_8.aBoolean1322)
									method314(class30_sub3_8, false);
							}
						}
						if(anInt446 == 0)
						{
							aBoolean467 = false;
							return;
						}
					}

				}
			}

		}

		aBoolean467 = false;
	}

	private void method314(GroundTile class30_sub3, boolean flag)
	{
		aClass19_477.insertHead(class30_sub3);
		do
		{
			GroundTile class30_sub3_1;
			do
			{
				class30_sub3_1 = (GroundTile)aClass19_477.popHead();
				if(class30_sub3_1 == null)
					return;
			} while(!class30_sub3_1.aBoolean1323);
			int i = class30_sub3_1.tileX;
			int j = class30_sub3_1.tileY;
			int k = class30_sub3_1.tileZ;
			int l = class30_sub3_1.anInt1310;
			GroundTile aclass30_sub3[][] = groundArray[k];
			if(class30_sub3_1.aBoolean1322)
			{
				if(flag)
				{
					if(k > 0)
					{
						GroundTile class30_sub3_2 = groundArray[k - 1][i][j];
						if(class30_sub3_2 != null && class30_sub3_2.aBoolean1323)
							continue;
					}
					if(i <= anInt453 && i > anInt449)
					{
						GroundTile class30_sub3_3 = aclass30_sub3[i - 1][j];
						if(class30_sub3_3 != null && class30_sub3_3.aBoolean1323 && (class30_sub3_3.aBoolean1322 || (class30_sub3_1.anInt1320 & 1) == 0))
							continue;
					}
					if(i >= anInt453 && i < anInt450 - 1)
					{
						GroundTile class30_sub3_4 = aclass30_sub3[i + 1][j];
						if(class30_sub3_4 != null && class30_sub3_4.aBoolean1323 && (class30_sub3_4.aBoolean1322 || (class30_sub3_1.anInt1320 & 4) == 0))
							continue;
					}
					if(j <= anInt454 && j > anInt451)
					{
						GroundTile class30_sub3_5 = aclass30_sub3[i][j - 1];
						if(class30_sub3_5 != null && class30_sub3_5.aBoolean1323 && (class30_sub3_5.aBoolean1322 || (class30_sub3_1.anInt1320 & 8) == 0))
							continue;
					}
					if(j >= anInt454 && j < anInt452 - 1)
					{
						GroundTile class30_sub3_6 = aclass30_sub3[i][j + 1];
						if(class30_sub3_6 != null && class30_sub3_6.aBoolean1323 && (class30_sub3_6.aBoolean1322 || (class30_sub3_1.anInt1320 & 2) == 0))
							continue;
					}
				} else
				{
					flag = true;
				}
				class30_sub3_1.aBoolean1322 = false;
				if(class30_sub3_1.tileBelow != null)
				{
					GroundTile class30_sub3_7 = class30_sub3_1.tileBelow;
					if(class30_sub3_7.aClass43_1311 != null)
					{
						if(!method320(0, i, j))
							renderPlainTile(class30_sub3_7.aClass43_1311, 0, anInt458, anInt459, anInt460, anInt461, i, j);
					} else
					if(class30_sub3_7.aClass40_1312 != null && !method320(0, i, j))
						method316(i, anInt458, anInt460, class30_sub3_7.aClass40_1312, anInt459, j, anInt461);
					Wall class10 = class30_sub3_7.wall;
					if(class10 != null)
						class10.actorOne.method443(0, anInt458, anInt459, anInt460, anInt461, class10.x - anInt455, class10.z - anInt456, class10.y - anInt457, class10.uid);
					for(int i2 = 0; i2 < class30_sub3_7.actorCount; i2++)
					{
						InteractiveObject class28 = class30_sub3_7.interactiveObjects[i2];
						if(class28 != null)
							class28.actor.method443(class28.rotation, anInt458, anInt459, anInt460, anInt461, class28.worldX - anInt455, class28.worldZ - anInt456, class28.worldY - anInt457, class28.uid);
					}

				}
				boolean flag1 = false;
				if(class30_sub3_1.aClass43_1311 != null)
				{
					if(!method320(l, i, j))
					{
						flag1 = true;
						renderPlainTile(class30_sub3_1.aClass43_1311, l, anInt458, anInt459, anInt460, anInt461, i, j);
					}
				} else
				if(class30_sub3_1.aClass40_1312 != null && !method320(l, i, j))
				{
					flag1 = true;
					method316(i, anInt458, anInt460, class30_sub3_1.aClass40_1312, anInt459, j, anInt461);
				}
				int j1 = 0;
				int j2 = 0;
				Wall class10_3 = class30_sub3_1.wall;
				WallDecoration class26_1 = class30_sub3_1.wallDecoration;
				if(class10_3 != null || class26_1 != null)
				{
					if(anInt453 == i)
						j1++;
					else
					if(anInt453 < i)
						j1 += 2;
					if(anInt454 == j)
						j1 += 3;
					else
					if(anInt454 > j)
						j1 += 6;
					j2 = anIntArray478[j1];
					class30_sub3_1.anInt1328 = anIntArray480[j1];
				}
				if(class10_3 != null)
				{
					if((class10_3.orientation & anIntArray479[j1]) != 0)
					{
						if(class10_3.orientation == 16)
						{
							class30_sub3_1.anInt1325 = 3;
							class30_sub3_1.anInt1326 = anIntArray481[j1];
							class30_sub3_1.anInt1327 = 3 - class30_sub3_1.anInt1326;
						} else
						if(class10_3.orientation == 32)
						{
							class30_sub3_1.anInt1325 = 6;
							class30_sub3_1.anInt1326 = anIntArray482[j1];
							class30_sub3_1.anInt1327 = 6 - class30_sub3_1.anInt1326;
						} else
						if(class10_3.orientation == 64)
						{
							class30_sub3_1.anInt1325 = 12;
							class30_sub3_1.anInt1326 = anIntArray483[j1];
							class30_sub3_1.anInt1327 = 12 - class30_sub3_1.anInt1326;
						} else
						{
							class30_sub3_1.anInt1325 = 9;
							class30_sub3_1.anInt1326 = anIntArray484[j1];
							class30_sub3_1.anInt1327 = 9 - class30_sub3_1.anInt1326;
						}
					} else
					{
						class30_sub3_1.anInt1325 = 0;
					}
					if((class10_3.orientation & j2) != 0 && !method321(l, i, j, class10_3.orientation))
						class10_3.actorOne.method443(0, anInt458, anInt459, anInt460, anInt461, class10_3.x - anInt455, class10_3.z - anInt456, class10_3.y - anInt457, class10_3.uid);
					if((class10_3.orientation1 & j2) != 0 && !method321(l, i, j, class10_3.orientation1))
						class10_3.actorTwo.method443(0, anInt458, anInt459, anInt460, anInt461, class10_3.x - anInt455, class10_3.z - anInt456, class10_3.y - anInt457, class10_3.uid);
				}
				if(class26_1 != null && !method322(l, i, j, class26_1.aClass30_Sub2_Sub4_504.modelHeight))
					if((class26_1.anInt502 & j2) != 0)
						class26_1.aClass30_Sub2_Sub4_504.method443(class26_1.anInt503, anInt458, anInt459, anInt460, anInt461, class26_1.anInt500 - anInt455, class26_1.anInt499 - anInt456, class26_1.anInt501 - anInt457, class26_1.uid);
					else
					if((class26_1.anInt502 & 0x300) != 0)
					{
						int j4 = class26_1.anInt500 - anInt455;
						int l5 = class26_1.anInt499 - anInt456;
						int k6 = class26_1.anInt501 - anInt457;
						int i8 = class26_1.anInt503;
						int k9;
						if(i8 == 1 || i8 == 2)
							k9 = -j4;
						else
							k9 = j4;
						int k10;
						if(i8 == 2 || i8 == 3)
							k10 = -k6;
						else
							k10 = k6;
						if((class26_1.anInt502 & 0x100) != 0 && k10 < k9)
						{
							int i11 = j4 + anIntArray463[i8];
							int k11 = k6 + anIntArray464[i8];
							class26_1.aClass30_Sub2_Sub4_504.method443(i8 * 512 + 256, anInt458, anInt459, anInt460, anInt461, i11, l5, k11, class26_1.uid);
						}
						if((class26_1.anInt502 & 0x200) != 0 && k10 > k9)
						{
							int j11 = j4 + anIntArray465[i8];
							int l11 = k6 + anIntArray466[i8];
							class26_1.aClass30_Sub2_Sub4_504.method443(i8 * 512 + 1280 & 0x7ff, anInt458, anInt459, anInt460, anInt461, j11, l5, l11, class26_1.uid);
						}
					}
				if(flag1)
				{
					FloorDecoration class49 = class30_sub3_1.floorDecoration;
					if(class49 != null)
						class49.actor.method443(0, anInt458, anInt459, anInt460, anInt461, class49.xPosition - anInt455, class49.zPosition - anInt456, class49.yPosition - anInt457, class49.uid);
					GroundItemTile object4_1 = class30_sub3_1.groundItemTile;
					if(object4_1 != null && object4_1.anInt52 == 0)
					{
						if(object4_1.secondGroundItem != null)
							object4_1.secondGroundItem.method443(0, anInt458, anInt459, anInt460, anInt461, object4_1.x - anInt455, object4_1.z - anInt456, object4_1.y - anInt457, object4_1.uid);
						if(object4_1.thirdGroundItem != null)
							object4_1.thirdGroundItem.method443(0, anInt458, anInt459, anInt460, anInt461, object4_1.x - anInt455, object4_1.z - anInt456, object4_1.y - anInt457, object4_1.uid);
						if(object4_1.firstGroundItem != null)
							object4_1.firstGroundItem.method443(0, anInt458, anInt459, anInt460, anInt461, object4_1.x - anInt455, object4_1.z - anInt456, object4_1.y - anInt457, object4_1.uid);
					}
				}
				int k4 = class30_sub3_1.anInt1320;
				if(k4 != 0)
				{
					if(i < anInt453 && (k4 & 4) != 0)
					{
						GroundTile class30_sub3_17 = aclass30_sub3[i + 1][j];
						if(class30_sub3_17 != null && class30_sub3_17.aBoolean1323)
							aClass19_477.insertHead(class30_sub3_17);
					}
					if(j < anInt454 && (k4 & 2) != 0)
					{
						GroundTile class30_sub3_18 = aclass30_sub3[i][j + 1];
						if(class30_sub3_18 != null && class30_sub3_18.aBoolean1323)
							aClass19_477.insertHead(class30_sub3_18);
					}
					if(i > anInt453 && (k4 & 1) != 0)
					{
						GroundTile class30_sub3_19 = aclass30_sub3[i - 1][j];
						if(class30_sub3_19 != null && class30_sub3_19.aBoolean1323)
							aClass19_477.insertHead(class30_sub3_19);
					}
					if(j > anInt454 && (k4 & 8) != 0)
					{
						GroundTile class30_sub3_20 = aclass30_sub3[i][j - 1];
						if(class30_sub3_20 != null && class30_sub3_20.aBoolean1323)
							aClass19_477.insertHead(class30_sub3_20);
					}
				}
			}
			if(class30_sub3_1.anInt1325 != 0)
			{
				boolean flag2 = true;
				for(int k1 = 0; k1 < class30_sub3_1.actorCount; k1++)
				{
					if(class30_sub3_1.interactiveObjects[k1].anInt528 == anInt448 || (class30_sub3_1.anIntArray1319[k1] & class30_sub3_1.anInt1325) != class30_sub3_1.anInt1326)
						continue;
					flag2 = false;
					break;
				}

				if(flag2)
				{
					Wall class10_1 = class30_sub3_1.wall;
					if(!method321(l, i, j, class10_1.orientation))
						class10_1.actorOne.method443(0, anInt458, anInt459, anInt460, anInt461, class10_1.x - anInt455, class10_1.z - anInt456, class10_1.y - anInt457, class10_1.uid);
					class30_sub3_1.anInt1325 = 0;
				}
			}
			if(class30_sub3_1.aBoolean1324)
				try
				{
					int i1 = class30_sub3_1.actorCount;
					class30_sub3_1.aBoolean1324 = false;
					int l1 = 0;
label0:
					for(int k2 = 0; k2 < i1; k2++)
					{
						InteractiveObject class28_1 = class30_sub3_1.interactiveObjects[k2];
						if(class28_1.anInt528 == anInt448)
							continue;
						for(int k3 = class28_1.tileLeft; k3 <= class28_1.tileRight; k3++)
						{
							for(int l4 = class28_1.tileTop; l4 <= class28_1.tileBottom; l4++)
							{
								GroundTile class30_sub3_21 = aclass30_sub3[k3][l4];
								if(class30_sub3_21.aBoolean1322)
								{
									class30_sub3_1.aBoolean1324 = true;
								} else
								{
									if(class30_sub3_21.anInt1325 == 0)
										continue;
									int l6 = 0;
									if(k3 > class28_1.tileLeft)
										l6++;
									if(k3 < class28_1.tileRight)
										l6 += 4;
									if(l4 > class28_1.tileTop)
										l6 += 8;
									if(l4 < class28_1.tileBottom)
										l6 += 2;
									if((l6 & class30_sub3_21.anInt1325) != class30_sub3_1.anInt1327)
										continue;
									class30_sub3_1.aBoolean1324 = true;
								}
								continue label0;
							}

						}

						interactiveObjects[l1++] = class28_1;
						int i5 = anInt453 - class28_1.tileLeft;
						int i6 = class28_1.tileRight - anInt453;
						if(i6 > i5)
							i5 = i6;
						int i7 = anInt454 - class28_1.tileTop;
						int j8 = class28_1.tileBottom - anInt454;
						if(j8 > i7)
							class28_1.anInt527 = i5 + j8;
						else
							class28_1.anInt527 = i5 + i7;
					}

					while(l1 > 0) 
					{
						int i3 = -50;
						int l3 = -1;
						for(int j5 = 0; j5 < l1; j5++)
						{
							InteractiveObject class28_2 = interactiveObjects[j5];
							if(class28_2.anInt528 != anInt448)
								if(class28_2.anInt527 > i3)
								{
									i3 = class28_2.anInt527;
									l3 = j5;
								} else
								if(class28_2.anInt527 == i3)
								{
									int j7 = class28_2.worldX - anInt455;
									int k8 = class28_2.worldY - anInt457;
									int l9 = interactiveObjects[l3].worldX - anInt455;
									int l10 = interactiveObjects[l3].worldY - anInt457;
									if(j7 * j7 + k8 * k8 > l9 * l9 + l10 * l10)
										l3 = j5;
								}
						}

						if(l3 == -1)
							break;
						InteractiveObject class28_3 = interactiveObjects[l3];
						class28_3.anInt528 = anInt448;
						if(!method323(l, class28_3.tileLeft, class28_3.tileRight, class28_3.tileTop, class28_3.tileBottom, class28_3.actor.modelHeight))
							class28_3.actor.method443(class28_3.rotation, anInt458, anInt459, anInt460, anInt461, class28_3.worldX - anInt455, class28_3.worldZ - anInt456, class28_3.worldY - anInt457, class28_3.uid);
						for(int k7 = class28_3.tileLeft; k7 <= class28_3.tileRight; k7++)
						{
							for(int l8 = class28_3.tileTop; l8 <= class28_3.tileBottom; l8++)
							{
								GroundTile class30_sub3_22 = aclass30_sub3[k7][l8];
								if(class30_sub3_22.anInt1325 != 0)
									aClass19_477.insertHead(class30_sub3_22);
								else
								if((k7 != i || l8 != j) && class30_sub3_22.aBoolean1323)
									aClass19_477.insertHead(class30_sub3_22);
							}

						}

					}
					if(class30_sub3_1.aBoolean1324)
						continue;
				}
				catch(Exception _ex)
				{
					class30_sub3_1.aBoolean1324 = false;
				}
			if(!class30_sub3_1.aBoolean1323 || class30_sub3_1.anInt1325 != 0)
				continue;
			if(i <= anInt453 && i > anInt449)
			{
				GroundTile class30_sub3_8 = aclass30_sub3[i - 1][j];
				if(class30_sub3_8 != null && class30_sub3_8.aBoolean1323)
					continue;
			}
			if(i >= anInt453 && i < anInt450 - 1)
			{
				GroundTile class30_sub3_9 = aclass30_sub3[i + 1][j];
				if(class30_sub3_9 != null && class30_sub3_9.aBoolean1323)
					continue;
			}
			if(j <= anInt454 && j > anInt451)
			{
				GroundTile class30_sub3_10 = aclass30_sub3[i][j - 1];
				if(class30_sub3_10 != null && class30_sub3_10.aBoolean1323)
					continue;
			}
			if(j >= anInt454 && j < anInt452 - 1)
			{
				GroundTile class30_sub3_11 = aclass30_sub3[i][j + 1];
				if(class30_sub3_11 != null && class30_sub3_11.aBoolean1323)
					continue;
			}
			class30_sub3_1.aBoolean1323 = false;
			anInt446--;
			GroundItemTile object4 = class30_sub3_1.groundItemTile;
			if(object4 != null && object4.anInt52 != 0)
			{
				if(object4.secondGroundItem != null)
					object4.secondGroundItem.method443(0, anInt458, anInt459, anInt460, anInt461, object4.x - anInt455, object4.z - anInt456 - object4.anInt52, object4.y - anInt457, object4.uid);
				if(object4.thirdGroundItem != null)
					object4.thirdGroundItem.method443(0, anInt458, anInt459, anInt460, anInt461, object4.x - anInt455, object4.z - anInt456 - object4.anInt52, object4.y - anInt457, object4.uid);
				if(object4.firstGroundItem != null)
					object4.firstGroundItem.method443(0, anInt458, anInt459, anInt460, anInt461, object4.x - anInt455, object4.z - anInt456 - object4.anInt52, object4.y - anInt457, object4.uid);
			}
			if(class30_sub3_1.anInt1328 != 0)
			{
				WallDecoration class26 = class30_sub3_1.wallDecoration;
				if(class26 != null && !method322(l, i, j, class26.aClass30_Sub2_Sub4_504.modelHeight))
					if((class26.anInt502 & class30_sub3_1.anInt1328) != 0)
						class26.aClass30_Sub2_Sub4_504.method443(class26.anInt503, anInt458, anInt459, anInt460, anInt461, class26.anInt500 - anInt455, class26.anInt499 - anInt456, class26.anInt501 - anInt457, class26.uid);
					else
					if((class26.anInt502 & 0x300) != 0)
					{
						int l2 = class26.anInt500 - anInt455;
						int j3 = class26.anInt499 - anInt456;
						int i4 = class26.anInt501 - anInt457;
						int k5 = class26.anInt503;
						int j6;
						if(k5 == 1 || k5 == 2)
							j6 = -l2;
						else
							j6 = l2;
						int l7;
						if(k5 == 2 || k5 == 3)
							l7 = -i4;
						else
							l7 = i4;
						if((class26.anInt502 & 0x100) != 0 && l7 >= j6)
						{
							int i9 = l2 + anIntArray463[k5];
							int i10 = i4 + anIntArray464[k5];
							class26.aClass30_Sub2_Sub4_504.method443(k5 * 512 + 256, anInt458, anInt459, anInt460, anInt461, i9, j3, i10, class26.uid);
						}
						if((class26.anInt502 & 0x200) != 0 && l7 <= j6)
						{
							int j9 = l2 + anIntArray465[k5];
							int j10 = i4 + anIntArray466[k5];
							class26.aClass30_Sub2_Sub4_504.method443(k5 * 512 + 1280 & 0x7ff, anInt458, anInt459, anInt460, anInt461, j9, j3, j10, class26.uid);
						}
					}
				Wall class10_2 = class30_sub3_1.wall;
				if(class10_2 != null)
				{
					if((class10_2.orientation1 & class30_sub3_1.anInt1328) != 0 && !method321(l, i, j, class10_2.orientation1))
						class10_2.actorTwo.method443(0, anInt458, anInt459, anInt460, anInt461, class10_2.x - anInt455, class10_2.z - anInt456, class10_2.y - anInt457, class10_2.uid);
					if((class10_2.orientation & class30_sub3_1.anInt1328) != 0 && !method321(l, i, j, class10_2.orientation))
						class10_2.actorOne.method443(0, anInt458, anInt459, anInt460, anInt461, class10_2.x - anInt455, class10_2.z - anInt456, class10_2.y - anInt457, class10_2.uid);
				}
			}
			if(k < mapSizeZ - 1)
			{
				GroundTile class30_sub3_12 = groundArray[k + 1][i][j];
				if(class30_sub3_12 != null && class30_sub3_12.aBoolean1323)
					aClass19_477.insertHead(class30_sub3_12);
			}
			if(i < anInt453)
			{
				GroundTile class30_sub3_13 = aclass30_sub3[i + 1][j];
				if(class30_sub3_13 != null && class30_sub3_13.aBoolean1323)
					aClass19_477.insertHead(class30_sub3_13);
			}
			if(j < anInt454)
			{
				GroundTile class30_sub3_14 = aclass30_sub3[i][j + 1];
				if(class30_sub3_14 != null && class30_sub3_14.aBoolean1323)
					aClass19_477.insertHead(class30_sub3_14);
			}
			if(i > anInt453)
			{
				GroundTile class30_sub3_15 = aclass30_sub3[i - 1][j];
				if(class30_sub3_15 != null && class30_sub3_15.aBoolean1323)
					aClass19_477.insertHead(class30_sub3_15);
			}
			if(j > anInt454)
			{
				GroundTile class30_sub3_16 = aclass30_sub3[i][j - 1];
				if(class30_sub3_16 != null && class30_sub3_16.aBoolean1323)
					aClass19_477.insertHead(class30_sub3_16);
			}
		} while(true);
	}

	private void renderPlainTile(PlainTile class43, int i, int j, int k, int l, int i1, int j1,
			int k1) // method315
	{
		int l1;
		int i2 = l1 = (j1 << 7) - anInt455;
		int j2;
		int k2 = j2 = (k1 << 7) - anInt457;
		int l2;
		int i3 = l2 = i2 + 128;
		int j3;
		int k3 = j3 = k2 + 128;
		int l3 = anIntArrayArrayArray440[i][j1][k1] - anInt456;
		int i4 = anIntArrayArrayArray440[i][j1 + 1][k1] - anInt456;
		int j4 = anIntArrayArrayArray440[i][j1 + 1][k1 + 1] - anInt456;
		int k4 = anIntArrayArrayArray440[i][j1][k1 + 1] - anInt456;
		int l4 = k2 * l + i2 * i1 >> 16;
		k2 = k2 * i1 - i2 * l >> 16;
		i2 = l4;
		l4 = l3 * k - k2 * j >> 16;
		k2 = l3 * j + k2 * k >> 16;
		l3 = l4;
		if(k2 < 50)
			return;
		l4 = j2 * l + i3 * i1 >> 16;
		j2 = j2 * i1 - i3 * l >> 16;
		i3 = l4;
		l4 = i4 * k - j2 * j >> 16;
		j2 = i4 * j + j2 * k >> 16;
		i4 = l4;
		if(j2 < 50)
			return;
		l4 = k3 * l + l2 * i1 >> 16;
		k3 = k3 * i1 - l2 * l >> 16;
		l2 = l4;
		l4 = j4 * k - k3 * j >> 16;
		k3 = j4 * j + k3 * k >> 16;
		j4 = l4;
		if(k3 < 50)
			return;
		l4 = j3 * l + l1 * i1 >> 16;
		j3 = j3 * i1 - l1 * l >> 16;
		l1 = l4;
		l4 = k4 * k - j3 * j >> 16;
		j3 = k4 * j + j3 * k >> 16;
		k4 = l4;
		if(j3 < 50)
			return;
		int i5 = Rasterizer.textureInt1 + (i2 << 9) / k2;
		int j5 = Rasterizer.textureInt2 + (l3 << 9) / k2;
		int k5 = Rasterizer.textureInt1 + (i3 << 9) / j2;
		int l5 = Rasterizer.textureInt2 + (i4 << 9) / j2;
		int i6 = Rasterizer.textureInt1 + (l2 << 9) / k3;
		int j6 = Rasterizer.textureInt2 + (j4 << 9) / k3;
		int k6 = Rasterizer.textureInt1 + (l1 << 9) / j3;
		int l6 = Rasterizer.textureInt2 + (k4 << 9) / j3;
		Rasterizer.anInt1465 = 0;
		if((i6 - k6) * (l5 - l6) - (j6 - l6) * (k5 - k6) > 0)
		{
			Rasterizer.aBoolean1462 = i6 < 0 || k6 < 0 || k5 < 0 || i6 > DrawingArea.centerX || k6 > DrawingArea.centerX || k5 > DrawingArea.centerX;
			if(aBoolean467 && method318(anInt468, anInt469, j6, l6, l5, i6, k6, k5))
			{
				anInt470 = j1;
				anInt471 = k1;
			}
			if(class43.anInt720 == -1)
			{
				if(class43.anInt718 != 0xbc614e)
					Rasterizer.method374(j6, l6, l5, i6, k6, k5, class43.anInt718, class43.anInt719, class43.anInt717);
			} else
			if(!lowMem)
			{
				if(class43.aBoolean721)
					Rasterizer.method378(j6, l6, l5, i6, k6, k5, class43.anInt718, class43.anInt719, class43.anInt717, i2, i3, l1, l3, i4, k4, k2, j2, j3, class43.anInt720);
				else
					Rasterizer.method378(j6, l6, l5, i6, k6, k5, class43.anInt718, class43.anInt719, class43.anInt717, l2, l1, i3, j4, k4, i4, k3, j3, j2, class43.anInt720);
			} else
			{
				int i7 = anIntArray485[class43.anInt720];
				Rasterizer.method374(j6, l6, l5, i6, k6, k5, method317(i7, class43.anInt718), method317(i7, class43.anInt719), method317(i7, class43.anInt717));
			}
		}
		if((i5 - k5) * (l6 - l5) - (j5 - l5) * (k6 - k5) > 0)
		{
			Rasterizer.aBoolean1462 = i5 < 0 || k5 < 0 || k6 < 0 || i5 > DrawingArea.centerX || k5 > DrawingArea.centerX || k6 > DrawingArea.centerX;
			if(aBoolean467 && method318(anInt468, anInt469, j5, l5, l6, i5, k5, k6))
			{
				anInt470 = j1;
				anInt471 = k1;
			}
			if(class43.anInt720 == -1)
			{
				if(class43.anInt716 != 0xbc614e)
				{
					Rasterizer.method374(j5, l5, l6, i5, k5, k6, class43.anInt716, class43.anInt717, class43.anInt719);
				}
			} else
			{
				if(!lowMem)
				{
					Rasterizer.method378(j5, l5, l6, i5, k5, k6, class43.anInt716, class43.anInt717, class43.anInt719, i2, i3, l1, l3, i4, k4, k2, j2, j3, class43.anInt720);
					return;
				}
				int j7 = anIntArray485[class43.anInt720];
				Rasterizer.method374(j5, l5, l6, i5, k5, k6, method317(j7, class43.anInt716), method317(j7, class43.anInt717), method317(j7, class43.anInt719));
			}
		}
	}

	private void method316(int i, int j, int k, ShapedTile class40, int l, int i1,
						   int j1)
	{
		int k1 = class40.anIntArray673.length;
		for(int l1 = 0; l1 < k1; l1++)
		{
			int i2 = class40.anIntArray673[l1] - anInt455;
			int k2 = class40.anIntArray674[l1] - anInt456;
			int i3 = class40.anIntArray675[l1] - anInt457;
			int k3 = i3 * k + i2 * j1 >> 16;
			i3 = i3 * j1 - i2 * k >> 16;
			i2 = k3;
			k3 = k2 * l - i3 * j >> 16;
			i3 = k2 * j + i3 * l >> 16;
			k2 = k3;
			if(i3 < 50)
				return;
			if(class40.anIntArray682 != null)
			{
				ShapedTile.anIntArray690[l1] = i2;
				ShapedTile.anIntArray691[l1] = k2;
				ShapedTile.anIntArray692[l1] = i3;
			}
			ShapedTile.anIntArray688[l1] = Rasterizer.textureInt1 + (i2 << 9) / i3;
			ShapedTile.anIntArray689[l1] = Rasterizer.textureInt2 + (k2 << 9) / i3;
		}

		Rasterizer.anInt1465 = 0;
		k1 = class40.anIntArray679.length;
		for(int j2 = 0; j2 < k1; j2++)
		{
			int l2 = class40.anIntArray679[j2];
			int j3 = class40.anIntArray680[j2];
			int l3 = class40.anIntArray681[j2];
			int i4 = ShapedTile.anIntArray688[l2];
			int j4 = ShapedTile.anIntArray688[j3];
			int k4 = ShapedTile.anIntArray688[l3];
			int l4 = ShapedTile.anIntArray689[l2];
			int i5 = ShapedTile.anIntArray689[j3];
			int j5 = ShapedTile.anIntArray689[l3];
			if((i4 - j4) * (j5 - i5) - (l4 - i5) * (k4 - j4) > 0)
			{
				Rasterizer.aBoolean1462 = i4 < 0 || j4 < 0 || k4 < 0 || i4 > DrawingArea.centerX || j4 > DrawingArea.centerX || k4 > DrawingArea.centerX;
				if(aBoolean467 && method318(anInt468, anInt469, l4, i5, j5, i4, j4, k4))
				{
					anInt470 = i;
					anInt471 = i1;
				}
				if(class40.anIntArray682 == null || class40.anIntArray682[j2] == -1)
				{
					if(class40.anIntArray676[j2] != 0xbc614e)
						Rasterizer.method374(l4, i5, j5, i4, j4, k4, class40.anIntArray676[j2], class40.anIntArray677[j2], class40.anIntArray678[j2]);
				} else
				if(!lowMem)
				{
					if(class40.aBoolean683)
						Rasterizer.method378(l4, i5, j5, i4, j4, k4, class40.anIntArray676[j2], class40.anIntArray677[j2], class40.anIntArray678[j2], ShapedTile.anIntArray690[0], ShapedTile.anIntArray690[1], ShapedTile.anIntArray690[3], ShapedTile.anIntArray691[0], ShapedTile.anIntArray691[1], ShapedTile.anIntArray691[3], ShapedTile.anIntArray692[0], ShapedTile.anIntArray692[1], ShapedTile.anIntArray692[3], class40.anIntArray682[j2]);
					else
						Rasterizer.method378(l4, i5, j5, i4, j4, k4, class40.anIntArray676[j2], class40.anIntArray677[j2], class40.anIntArray678[j2], ShapedTile.anIntArray690[l2], ShapedTile.anIntArray690[j3], ShapedTile.anIntArray690[l3], ShapedTile.anIntArray691[l2], ShapedTile.anIntArray691[j3], ShapedTile.anIntArray691[l3], ShapedTile.anIntArray692[l2], ShapedTile.anIntArray692[j3], ShapedTile.anIntArray692[l3], class40.anIntArray682[j2]);
				} else
				{
					int k5 = anIntArray485[class40.anIntArray682[j2]];
					Rasterizer.method374(l4, i5, j5, i4, j4, k4, method317(k5, class40.anIntArray676[j2]), method317(k5, class40.anIntArray677[j2]), method317(k5, class40.anIntArray678[j2]));
				}
			}
		}

	}

	private int method317(int j, int k)
	{
		k = 127 - k;
		k = (k * (j & 0x7f)) / 160;
		if(k < 2)
			k = 2;
		else
		if(k > 126)
			k = 126;
		return (j & 0xff80) + k;
	}

	private boolean method318(int i, int j, int k, int l, int i1, int j1, int k1,
			int l1)
	{
		if(j < k && j < l && j < i1)
			return false;
		if(j > k && j > l && j > i1)
			return false;
		if(i < j1 && i < k1 && i < l1)
			return false;
		if(i > j1 && i > k1 && i > l1)
			return false;
		int i2 = (j - k) * (k1 - j1) - (i - j1) * (l - k);
		int j2 = (j - i1) * (j1 - l1) - (i - l1) * (k - i1);
		int k2 = (j - l) * (l1 - k1) - (i - k1) * (i1 - l);
		return i2 * k2 > 0 && k2 * j2 > 0;
	}

	private void method319()
	{
		int j = cullingClusterPointer[anInt447];
		CullingCluster aclass47[] = cullingClusters[anInt447];
		anInt475 = 0;
		for(int k = 0; k < j; k++)
		{
			CullingCluster class47 = aclass47[k];
			if(class47.searchMask == 1)
			{
				int l = (class47.tileStartX - anInt453) + 25;
				if(l < 0 || l > 50)
					continue;
				int k1 = (class47.tileStartY - anInt454) + 25;
				if(k1 < 0)
					k1 = 0;
				int j2 = (class47.tileEndY - anInt454) + 25;
				if(j2 > 50)
					j2 = 50;
				boolean flag = false;
				while(k1 <= j2) 
					if(aBooleanArrayArray492[l][k1++])
					{
						flag = true;
						break;
					}
				if(!flag)
					continue;
				int j3 = anInt455 - class47.worldStartX;
				if(j3 > 32)
				{
					class47.tileDistanceEnum = 1;
				} else
				{
					if(j3 >= -32)
						continue;
					class47.tileDistanceEnum = 2;
					j3 = -j3;
				}
				class47.worldDistanceFromCameraStartY = (class47.worldStartY - anInt457 << 8) / j3;
				class47.worldDistanceFromCameraEndY = (class47.worldEndY - anInt457 << 8) / j3;
				class47.worldDistanceFromCameraStartZ = (class47.worldStartZ - anInt456 << 8) / j3;
				class47.worldDistanceFromCameraEndZ = (class47.worldEndZ - anInt456 << 8) / j3;
				aClass47Array476[anInt475++] = class47;
				continue;
			}
			if(class47.searchMask == 2)
			{
				int i1 = (class47.tileStartY - anInt454) + 25;
				if(i1 < 0 || i1 > 50)
					continue;
				int l1 = (class47.tileStartX - anInt453) + 25;
				if(l1 < 0)
					l1 = 0;
				int k2 = (class47.tileEndX - anInt453) + 25;
				if(k2 > 50)
					k2 = 50;
				boolean flag1 = false;
				while(l1 <= k2) 
					if(aBooleanArrayArray492[l1++][i1])
					{
						flag1 = true;
						break;
					}
				if(!flag1)
					continue;
				int k3 = anInt457 - class47.worldStartY;
				if(k3 > 32)
				{
					class47.tileDistanceEnum = 3;
				} else
				{
					if(k3 >= -32)
						continue;
					class47.tileDistanceEnum = 4;
					k3 = -k3;
				}
				class47.worldDistanceFromCameraStartX = (class47.worldStartX - anInt455 << 8) / k3;
				class47.worldDistanceFromCameraEndX = (class47.worldEndX - anInt455 << 8) / k3;
				class47.worldDistanceFromCameraStartZ = (class47.worldStartZ - anInt456 << 8) / k3;
				class47.worldDistanceFromCameraEndZ = (class47.worldEndZ - anInt456 << 8) / k3;
				aClass47Array476[anInt475++] = class47;
			} else
			if(class47.searchMask == 4)
			{
				int j1 = class47.worldStartZ - anInt456;
				if(j1 > 128)
				{
					int i2 = (class47.tileStartY - anInt454) + 25;
					if(i2 < 0)
						i2 = 0;
					int l2 = (class47.tileEndY - anInt454) + 25;
					if(l2 > 50)
						l2 = 50;
					if(i2 <= l2)
					{
						int i3 = (class47.tileStartX - anInt453) + 25;
						if(i3 < 0)
							i3 = 0;
						int l3 = (class47.tileEndX - anInt453) + 25;
						if(l3 > 50)
							l3 = 50;
						boolean flag2 = false;
label0:
						for(int i4 = i3; i4 <= l3; i4++)
						{
							for(int j4 = i2; j4 <= l2; j4++)
							{
								if(!aBooleanArrayArray492[i4][j4])
									continue;
								flag2 = true;
								break label0;
							}

						}

						if(flag2)
						{
							class47.tileDistanceEnum = 5;
							class47.worldDistanceFromCameraStartX = (class47.worldStartX - anInt455 << 8) / j1;
							class47.worldDistanceFromCameraEndX = (class47.worldEndX - anInt455 << 8) / j1;
							class47.worldDistanceFromCameraStartY = (class47.worldStartY - anInt457 << 8) / j1;
							class47.worldDistanceFromCameraEndY = (class47.worldEndY - anInt457 << 8) / j1;
							aClass47Array476[anInt475++] = class47;
						}
					}
				}
			}
		}

	}

	private boolean method320(int i, int j, int k)
	{
		int l = anIntArrayArrayArray445[i][j][k];
		if(l == -anInt448)
			return false;
		if(l == anInt448)
			return true;
		int i1 = j << 7;
		int j1 = k << 7;
		if(method324(i1 + 1, anIntArrayArrayArray440[i][j][k], j1 + 1) && method324((i1 + 128) - 1, anIntArrayArrayArray440[i][j + 1][k], j1 + 1) && method324((i1 + 128) - 1, anIntArrayArrayArray440[i][j + 1][k + 1], (j1 + 128) - 1) && method324(i1 + 1, anIntArrayArrayArray440[i][j][k + 1], (j1 + 128) - 1))
		{
			anIntArrayArrayArray445[i][j][k] = anInt448;
			return true;
		} else
		{
			anIntArrayArrayArray445[i][j][k] = -anInt448;
			return false;
		}
	}

	private boolean method321(int i, int j, int k, int l)
	{
		if(!method320(i, j, k))
			return false;
		int i1 = j << 7;
		int j1 = k << 7;
		int k1 = anIntArrayArrayArray440[i][j][k] - 1;
		int l1 = k1 - 120;
		int i2 = k1 - 230;
		int j2 = k1 - 238;
		if(l < 16)
		{
			if(l == 1)
			{
				if(i1 > anInt455)
				{
					if(!method324(i1, k1, j1))
						return false;
					if(!method324(i1, k1, j1 + 128))
						return false;
				}
				if(i > 0)
				{
					if(!method324(i1, l1, j1))
						return false;
					if(!method324(i1, l1, j1 + 128))
						return false;
				}
				return method324(i1, i2, j1) && method324(i1, i2, j1 + 128);
			}
			if(l == 2)
			{
				if(j1 < anInt457)
				{
					if(!method324(i1, k1, j1 + 128))
						return false;
					if(!method324(i1 + 128, k1, j1 + 128))
						return false;
				}
				if(i > 0)
				{
					if(!method324(i1, l1, j1 + 128))
						return false;
					if(!method324(i1 + 128, l1, j1 + 128))
						return false;
				}
				return method324(i1, i2, j1 + 128) && method324(i1 + 128, i2, j1 + 128);
			}
			if(l == 4)
			{
				if(i1 < anInt455)
				{
					if(!method324(i1 + 128, k1, j1))
						return false;
					if(!method324(i1 + 128, k1, j1 + 128))
						return false;
				}
				if(i > 0)
				{
					if(!method324(i1 + 128, l1, j1))
						return false;
					if(!method324(i1 + 128, l1, j1 + 128))
						return false;
				}
				return method324(i1 + 128, i2, j1) && method324(i1 + 128, i2, j1 + 128);
			}
			if(l == 8)
			{
				if(j1 > anInt457)
				{
					if(!method324(i1, k1, j1))
						return false;
					if(!method324(i1 + 128, k1, j1))
						return false;
				}
				if(i > 0)
				{
					if(!method324(i1, l1, j1))
						return false;
					if(!method324(i1 + 128, l1, j1))
						return false;
				}
				return method324(i1, i2, j1) && method324(i1 + 128, i2, j1);
			}
		}
		if(!method324(i1 + 64, j2, j1 + 64))
			return false;
		if(l == 16)
			return method324(i1, i2, j1 + 128);
		if(l == 32)
			return method324(i1 + 128, i2, j1 + 128);
		if(l == 64)
			return method324(i1 + 128, i2, j1);
		if(l == 128)
		{
			return method324(i1, i2, j1);
		} else
		{
			System.out.println("Warning unsupported wall type");
			return true;
		}
	}

	private boolean method322(int i, int j, int k, int l)
	{
		if(!method320(i, j, k))
			return false;
		int i1 = j << 7;
		int j1 = k << 7;
		return method324(i1 + 1, anIntArrayArrayArray440[i][j][k] - l, j1 + 1) && method324((i1 + 128) - 1, anIntArrayArrayArray440[i][j + 1][k] - l, j1 + 1) && method324((i1 + 128) - 1, anIntArrayArrayArray440[i][j + 1][k + 1] - l, (j1 + 128) - 1) && method324(i1 + 1, anIntArrayArrayArray440[i][j][k + 1] - l, (j1 + 128) - 1);
	}

	private boolean method323(int i, int j, int k, int l, int i1, int j1)
	{
		if(j == k && l == i1)
		{
			if(!method320(i, j, l))
				return false;
			int k1 = j << 7;
			int i2 = l << 7;
			return method324(k1 + 1, anIntArrayArrayArray440[i][j][l] - j1, i2 + 1) && method324((k1 + 128) - 1, anIntArrayArrayArray440[i][j + 1][l] - j1, i2 + 1) && method324((k1 + 128) - 1, anIntArrayArrayArray440[i][j + 1][l + 1] - j1, (i2 + 128) - 1) && method324(k1 + 1, anIntArrayArrayArray440[i][j][l + 1] - j1, (i2 + 128) - 1);
		}
		for(int l1 = j; l1 <= k; l1++)
		{
			for(int j2 = l; j2 <= i1; j2++)
				if(anIntArrayArrayArray445[i][l1][j2] == -anInt448)
					return false;

		}

		int k2 = (j << 7) + 1;
		int l2 = (l << 7) + 2;
		int i3 = anIntArrayArrayArray440[i][j][l] - j1;
		if(!method324(k2, i3, l2))
			return false;
		int j3 = (k << 7) - 1;
		if(!method324(j3, i3, l2))
			return false;
		int k3 = (i1 << 7) - 1;
		return method324(k2, i3, k3) && method324(j3, i3, k3);
	}

	private boolean method324(int i, int j, int k)
	{
		for(int l = 0; l < anInt475; l++)
		{
			CullingCluster class47 = aClass47Array476[l];
			if(class47.tileDistanceEnum == 1)
			{
				int i1 = class47.worldStartX - i;
				if(i1 > 0)
				{
					int j2 = class47.worldStartY + (class47.worldDistanceFromCameraStartY * i1 >> 8);
					int k3 = class47.worldEndY + (class47.worldDistanceFromCameraEndY * i1 >> 8);
					int l4 = class47.worldStartZ + (class47.worldDistanceFromCameraStartZ * i1 >> 8);
					int i6 = class47.worldEndZ + (class47.worldDistanceFromCameraEndZ * i1 >> 8);
					if(k >= j2 && k <= k3 && j >= l4 && j <= i6)
						return true;
				}
			} else
			if(class47.tileDistanceEnum == 2)
			{
				int j1 = i - class47.worldStartX;
				if(j1 > 0)
				{
					int k2 = class47.worldStartY + (class47.worldDistanceFromCameraStartY * j1 >> 8);
					int l3 = class47.worldEndY + (class47.worldDistanceFromCameraEndY * j1 >> 8);
					int i5 = class47.worldStartZ + (class47.worldDistanceFromCameraStartZ * j1 >> 8);
					int j6 = class47.worldEndZ + (class47.worldDistanceFromCameraEndZ * j1 >> 8);
					if(k >= k2 && k <= l3 && j >= i5 && j <= j6)
						return true;
				}
			} else
			if(class47.tileDistanceEnum == 3)
			{
				int k1 = class47.worldStartY - k;
				if(k1 > 0)
				{
					int l2 = class47.worldStartX + (class47.worldDistanceFromCameraStartX * k1 >> 8);
					int i4 = class47.worldEndX + (class47.worldDistanceFromCameraEndX * k1 >> 8);
					int j5 = class47.worldStartZ + (class47.worldDistanceFromCameraStartZ * k1 >> 8);
					int k6 = class47.worldEndZ + (class47.worldDistanceFromCameraEndZ * k1 >> 8);
					if(i >= l2 && i <= i4 && j >= j5 && j <= k6)
						return true;
				}
			} else
			if(class47.tileDistanceEnum == 4)
			{
				int l1 = k - class47.worldStartY;
				if(l1 > 0)
				{
					int i3 = class47.worldStartX + (class47.worldDistanceFromCameraStartX * l1 >> 8);
					int j4 = class47.worldEndX + (class47.worldDistanceFromCameraEndX * l1 >> 8);
					int k5 = class47.worldStartZ + (class47.worldDistanceFromCameraStartZ * l1 >> 8);
					int l6 = class47.worldEndZ + (class47.worldDistanceFromCameraEndZ * l1 >> 8);
					if(i >= i3 && i <= j4 && j >= k5 && j <= l6)
						return true;
				}
			} else
			if(class47.tileDistanceEnum == 5)
			{
				int i2 = j - class47.worldStartZ;
				if(i2 > 0)
				{
					int j3 = class47.worldStartX + (class47.worldDistanceFromCameraStartX * i2 >> 8);
					int k4 = class47.worldEndX + (class47.worldDistanceFromCameraEndX * i2 >> 8);
					int l5 = class47.worldStartY + (class47.worldDistanceFromCameraStartY * i2 >> 8);
					int i7 = class47.worldEndY + (class47.worldDistanceFromCameraEndY * i2 >> 8);
					if(i >= j3 && i <= k4 && k >= l5 && k <= i7)
						return true;
				}
			}
		}

		return false;
	}

	private boolean aBoolean434;
	public static boolean lowMem = true;
	private final int mapSizeZ; // anInt437
	private int mapSizeX; // anInt438
	private final int mapSizeY; // anInt439
	private final int[][][] anIntArrayArrayArray440;
	private final GroundTile[][][] groundArray;
	private int currentHeightLevel; // anInt442
	private int obj5CacheCurrPos;
	private final InteractiveObject[] obj5Cache;
	private final int[][][] anIntArrayArrayArray445;
	private static int anInt446;
	private static int anInt447;
	private static int anInt448;
	private static int anInt449;
	private static int anInt450;
	private static int anInt451;
	private static int anInt452;
	private static int anInt453;
	private static int anInt454;
	private static int anInt455;
	private static int anInt456;
	private static int anInt457;
	private static int anInt458;
	private static int anInt459;
	private static int anInt460;
	private static int anInt461;
	private static InteractiveObject[] interactiveObjects = new InteractiveObject[100]; // aClass28Array462
	private static final int[] anIntArray463 = {
		53, -53, -53, 53
	};
	private static final int[] anIntArray464 = {
		-53, -53, 53, 53
	};
	private static final int[] anIntArray465 = {
		-45, 45, 45, -45
	};
	private static final int[] anIntArray466 = {
		45, 45, -45, -45
	};
	private static boolean aBoolean467;
	private static int anInt468;
	private static int anInt469;
	public static int anInt470 = -1;
	public static int anInt471 = -1;
	private static final int anInt472;
	private static int[] cullingClusterPointer; // anIntArray473
	private static CullingCluster[][] cullingClusters; // aClass47ArrayArray474
	private static int anInt475;
	private static final CullingCluster[] aClass47Array476 = new CullingCluster[500];
	private static Deque aClass19_477 = new Deque();
	private static final int[] anIntArray478 = {
		19, 55, 38, 155, 255, 110, 137, 205, 76
	};
	private static final int[] anIntArray479 = {
		160, 192, 80, 96, 0, 144, 80, 48, 160
	};
	private static final int[] anIntArray480 = {
		76, 8, 137, 4, 0, 1, 38, 2, 19
	};
	private static final int[] anIntArray481 = {
		0, 0, 2, 0, 0, 2, 1, 1, 0
	};
	private static final int[] anIntArray482 = {
		2, 0, 0, 2, 0, 0, 0, 4, 4
	};
	private static final int[] anIntArray483 = {
		0, 4, 4, 8, 0, 0, 8, 0, 0
	};
	private static final int[] anIntArray484 = {
		1, 1, 0, 0, 0, 8, 0, 0, 8
	};
	private static final int[] anIntArray485 = {
		41, 39248, 41, 4643, 41, 41, 41, 41, 41, 41, 
		41, 41, 41, 41, 41, 43086, 41, 41, 41, 41, 
		41, 41, 41, 8602, 41, 28992, 41, 41, 41, 41, 
		41, 5056, 41, 41, 41, 7079, 41, 41, 41, 41, 
		41, 41, 41, 41, 41, 41, 3131, 41, 41, 41
	};
	private final int[] anIntArray486;
	private final int[] anIntArray487;
	private int anInt488;
	private final int[][] anIntArrayArray489 = {
		new int[16], {
			1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 
			1, 1, 1, 1, 1, 1
		}, {
			1, 0, 0, 0, 1, 1, 0, 0, 1, 1, 
			1, 0, 1, 1, 1, 1
		}, {
			1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 
			0, 0, 1, 0, 0, 0
		}, {
			0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 
			0, 1, 0, 0, 0, 1
		}, {
			0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 
			1, 1, 1, 1, 1, 1
		}, {
			1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 
			1, 1, 1, 1, 1, 1
		}, {
			1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 
			0, 0, 1, 1, 0, 0
		}, {
			0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 
			0, 0, 1, 1, 0, 0
		}, {
			1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 
			1, 1, 0, 0, 1, 1
		}, 
		{
			1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 
			0, 0, 1, 0, 0, 0
		}, {
			0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 
			1, 1, 0, 1, 1, 1
		}, {
			0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 
			1, 0, 1, 1, 1, 1
		}
	};
	private final int[][] anIntArrayArray490 = {
		{
			0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 
			10, 11, 12, 13, 14, 15
		}, {
			12, 8, 4, 0, 13, 9, 5, 1, 14, 10, 
			6, 2, 15, 11, 7, 3
		}, {
			15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 
			5, 4, 3, 2, 1, 0
		}, {
			3, 7, 11, 15, 2, 6, 10, 14, 1, 5, 
			9, 13, 0, 4, 8, 12
		}
	};
	private static boolean[][][][] aBooleanArrayArrayArrayArray491 = new boolean[8][32][51][51];
	private static boolean[][] aBooleanArrayArray492;
	private static int anInt493;
	private static int anInt494;
	private static int anInt495;
	private static int anInt496;
	private static int anInt497;
	private static int anInt498;

	static 
	{
		anInt472 = 4;
		cullingClusterPointer = new int[anInt472];
		cullingClusters = new CullingCluster[anInt472][500];
	}
}
