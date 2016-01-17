package lintcode.ladder9.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q431FindConnectedComponentInUndirectedGraph {
	
	
	//this is pure BFS, don't think too much, 
	//careful, union-find is not always the right method
	
	//9chapter answer: 
	//http://www.jiuzhang.com/solutions/find-the-connected-component-in-the-undirected-graph/
	
	public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
	    
        HashSet<Integer> isVisited = new HashSet<Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        for(UndirectedGraphNode node:nodes) {
            if(!isVisited.contains(node.label)) {
                List<Integer> tmpL = bfs(node, isVisited);
                res.add(tmpL);
            }
        }
        return res;
        
    }
    
    private List<Integer> bfs(UndirectedGraphNode node, HashSet<Integer> isVisited) {
        List<Integer> res = new ArrayList<Integer>();
        
        Queue<UndirectedGraphNode> que = new LinkedList<UndirectedGraphNode>();
        
        UndirectedGraphNode p = node;
        res.add(p.label);
        que.offer(p);
        isVisited.add(p.label);
        
        while(!que.isEmpty()) { 
            p = que.poll();
            for(UndirectedGraphNode nei: p.neighbors) {
                if(!isVisited.contains(nei.label)) {
                    res.add(nei.label);
                    que.offer(nei);
                    isVisited.add(nei.label);
                }
            }
        }
        Collections.sort(res);
        return res;
    }

}
