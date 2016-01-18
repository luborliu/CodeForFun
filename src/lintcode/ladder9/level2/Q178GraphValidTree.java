package lintcode.ladder9.level2;

import java.util.HashMap;

public class Q178GraphValidTree {
	
	/**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        
        //union-find to check circles
        //coner case to consider or talk with interviewers: if there are repeated edges between two nodes
        
        if(edges==null) return false;
        if(n-1>edges.length) return false; //there are multiple components
        
        UnionFind uf = new UnionFind();
        //initialize uf
        for(int i=0; i<n; i++) uf.father.put(i,i);
        
        for(int i=0; i<edges.length; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            if(uf.find(node1)!=uf.find(node2)) uf.union(node1,node2);
            else return false;
        }
        
        return true;
        
        
    }
    
    
    
    class UnionFind {
        HashMap<Integer, Integer> father;
        
        public UnionFind() {
            father = new HashMap<Integer,Integer>();
        }
        
        public int find(int x) {
            int parent = father.get(x);
            while(parent!=father.get(parent)) parent = father.get(parent);
            
            //compress the paths
            int temp = -1;
            int fa = x;
            while(parent != fa) {
                temp = father.get(fa);
                father.put(fa,parent);
                fa = temp;
            }
            return parent;
        }
        
        public void union(int x, int y) {
            int xFather = find(x);
            int yFather = find(y);
            if(xFather!=yFather) father.put(xFather,yFather);
        }
    }

}
