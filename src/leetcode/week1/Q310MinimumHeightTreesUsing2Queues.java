package leetcode.week1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q310MinimumHeightTreesUsing2Queues {
	//please see the optimized version using only 1 queue
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
	        
	        //inspired by the idea of CourseScheduleI and II which use topological sorting
	        ArrayList<Integer> res = new ArrayList<Integer>();
	        if(n<=2) {
	            for(int i=0; i<n; i++) {
	                res.add(i);
	            } 
	            return res;
	        }
	        
	        int[] degrees = new int[n];
	        Queue<Integer> oneDegreeQ1 = new LinkedList<Integer>();
	        Queue<Integer> oneDegreeQ2 = new LinkedList<Integer>();
	        
	        ArrayList[] graph = buildGraph(n,edges,degrees);
	        
	        for(int i=0; i<degrees.length; i++) {
	            if(degrees[i]==1) oneDegreeQ1.add(i);
	        }
	        int curNodeNum = n;
	        boolean flag = true; //true for Q1 while false for Q2
	        while(!oneDegreeQ1.isEmpty()||!oneDegreeQ2.isEmpty()){
	            curNodeNum--;
	            if(flag) {
	                int node = oneDegreeQ1.poll();
	                for(int i:(ArrayList<Integer>)graph[node]) {
	                    degrees[i]--;
	                    if(degrees[i]==1) {
	                        oneDegreeQ2.add(i);
	                    }
	                }
	                if(oneDegreeQ1.isEmpty()) {
	                    flag = false;
	                    if(curNodeNum<=2) break;
	                }
	            } else {
	                int node = oneDegreeQ2.poll();
	                for(int i:(ArrayList<Integer>)graph[node]) {
	                    degrees[i]--;
	                    if(degrees[i]==1) {
	                        oneDegreeQ1.add(i);
	                    }
	                }
	                if(oneDegreeQ2.isEmpty()) {
	                    flag = true;
	                    if(curNodeNum<=2) break;
	                }
	            }
	            
	        }
	        
	       
	        while(!oneDegreeQ1.isEmpty()) {
	            res.add(oneDegreeQ1.poll());
	        }
	        while(!oneDegreeQ2.isEmpty()) {
	            res.add(oneDegreeQ2.poll());
	        }
	        return res;
	    }
	    
	    
	    public ArrayList[] buildGraph(int n, int[][] edges, int[] degrees) {
	        
	        ArrayList[] graph = new ArrayList[n];
	        for(int[] row:edges) {
	            if(graph[row[0]]==null) graph[row[0]]=new ArrayList<Integer>();
	            if(graph[row[1]]==null) graph[row[1]]=new ArrayList<Integer>();
	            graph[row[0]].add(row[1]);
	            graph[row[1]].add(row[0]);
	            degrees[row[0]]++;
	            degrees[row[1]]++;
	        }
	        
	        return graph;
	    }

}
