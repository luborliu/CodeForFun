package lintcode.ladder9.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q434NumberOfIslandII {
	
	/**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Q: can the island be returned back from island to sea? Assumes no
        // union-find        
        
        List<Integer> res = new ArrayList<Integer>();
        int count = 0;
        UnionFind uf = new UnionFind();
        for(int i=0; i<n*m; i++) {
            uf.initializeFather(i);
        }
        
        if(operators==null||operators.length==0) {
            //res.add(count);
            return res;
        }
        
        
        int[][] indices = new int[2][4];
        indices[0] = new int[]{1,-1,0,0};
        indices[1] = new int[]{0,0,1,-1};
        
        
        
        for(int i=0; i<operators.length; i++) {
            Point p = operators[i];
            count++;
            uf.father.put(p.x*m+p.y,p.x*m+p.y);
            
            for(int a=0; a<4; a++) {
                int rIndex = p.x+indices[0][a];
                int cIndex = p.y+indices[1][a];
                if(rIndex>=0&&rIndex<n&&cIndex>=0&&cIndex<m&&uf.find(rIndex*m+cIndex)!=-1) {
                    if(uf.find(rIndex*m+cIndex)!=uf.find(p.x*m+p.y)) {
                        count--;
                        uf.union(rIndex*m+cIndex,p.x*m+p.y);
                    }
                }
            }
             
            
            res.add(count);
        }
        return res;
        
        
        
    }
    
    
    
    
    //union-find class
    
    class UnionFind {
        HashMap<Integer,Integer> father;
        
        public UnionFind() {
            this.father = new HashMap<Integer,Integer>();
            father.put(-1,-1); //sea element point to sea itself
        }
        
        public void initializeFather(int x) {
            father.put(x,-1); //-1 means sea, otherwise point to themselves or other elements
        }
        
        
        //find the father of x
        public int find(int x) {
            int parent = father.get(x);
            while(parent!=father.get(parent)) {
                parent = father.get(parent);
            }
            
            //compressed paths
            int temp = -1;
            int fa = x;
            while(fa!=parent) {
                temp = father.get(fa);
                father.put(fa,parent);
                fa = temp;
            }

            return parent;
        }
        
        //union
        public void union(int x, int y) {
            
            int xFather = find(x);
            int yFather = find(y);
            if(xFather!=yFather) father.put(xFather, yFather);
            
        }
        
    }
    
    
    class Point{
    	int x;
    	int y;
    	Point() {
    		x = 0;
    		y = 0;
    	}
    	Point(int x, int y) {
    		this.x = x;
    		this.y = y;
    	}
    }

}
