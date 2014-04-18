package com.runescape;

import com.runescape.revised.model.RSModel;
import com.runescape.revised.model.VertexNormal;
import com.runescape.revised.util.node.QueueNode;

public class Renderable extends QueueNode {

	public void method443(int i, int j, int k, int l, int i1, int j1, int k1, 
			int l1, int i2)
	{
		RSModel model = getRotatedModel();
		if(model != null)
		{
			modelHeight = model.modelHeight;
			model.method443(i, j, k, l, i1, j1, k1, l1, i2);
		}
	}

	public RSModel getRotatedModel() {
		return null;
	}

	public Renderable() {
		modelHeight = 1000;
	}

	public VertexNormal aClass33Array1425[];
	public int modelHeight;
}