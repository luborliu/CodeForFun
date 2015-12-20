package leetcode.week1;

import java.util.ArrayList;

public class Node2 {
	
	
        int id;
        int label;
        boolean isVisited;
        ArrayList<Node2> children;
        public Node2(int id) {
            this.id = id;
            this.label = -1;
            this.isVisited = false;
            this.children = new ArrayList<Node2>();
        }
    

}
