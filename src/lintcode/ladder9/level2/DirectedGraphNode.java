package lintcode.ladder9.level2;

import java.util.ArrayList;

public class DirectedGraphNode {
	
	int label;
	ArrayList<DirectedGraphNode> neighbors;
	
	public DirectedGraphNode(int val) {
		this.label = val;
		this.neighbors = new ArrayList<DirectedGraphNode>();
	}

}
