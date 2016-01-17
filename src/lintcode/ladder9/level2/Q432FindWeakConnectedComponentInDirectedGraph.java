package lintcode.ladder9.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Q432FindWeakConnectedComponentInDirectedGraph {
	
	/**
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // Write your code here
        HashMap<Integer,Integer> father = new HashMap<Integer,Integer>(); 
        //initialize union-find set
        for(DirectedGraphNode node:nodes) {
            father.put(node.label, node.label);
        }
        
        for(DirectedGraphNode n:nodes) {
            for(DirectedGraphNode nei:n.neighbors) {
                union(father, n.label, nei.label);
            }
        }
        // the union-find set has been filled, but it cannot guarantee that all the values have pointed to their root father
        
        
        
        HashMap<Integer,List<Integer>> hm = new HashMap<Integer,List<Integer>>();
        
        Set<Integer> set = father.keySet();
        for(int k:set) {
            //int kFather = father.get(k); 
            int kFather = find(father, k); //this is important! coz currently it cannot guarantee that all the valuese have pointed to their root father 
            if(hm.containsKey(kFather)) {
                //hm.put(kFather, hm.get(kFather).add(k));
                hm.get(kFather).add(k);
            } else {
                List<Integer> tmpL = new ArrayList<Integer>();
                tmpL.add(k);
                hm.put(kFather, tmpL);
            }
        }
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(List<Integer> l: hm.values()) {
            Collections.sort(l);
            res.add(l);
        }
        return res;
        
        
    }
    
    
    
    
    //union-find
    
    private int find(HashMap<Integer,Integer> father, int x) {
        int parent = father.get(x);
        
        while(parent!=father.get(parent)) {
            parent = father.get(parent);
        }
        //compress the path
        int tmp = -1;
        int fa = x;
        while(fa!=parent) {
            tmp = father.get(fa);
            father.put(fa,parent);
            fa = tmp;
        }
        return parent;
    }
    
    private void union(HashMap<Integer,Integer> father, int x, int y) {
        int xFather = find(father,x);
        int yFather = find(father,y);
        if(xFather!=yFather) father.put(xFather,yFather);
    }

}
