package leetcode.week1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q310MinimumHeightTreesOptimizingWithOneQueue {
	
public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        
        //inspired by the idea of CourseScheduleI and II which use topological sorting
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(n==1) res.add(0);    //for corner case: n==1&&edges=={}
        
        int[] degrees = new int[n];
        Queue<Integer> oneDegreeQ = new LinkedList<Integer>();
        
        ArrayList[] graph = buildGraph(n,edges,degrees);
        
        for(int i=0; i<degrees.length; i++) {
            if(degrees[i]==1) oneDegreeQ.add(i);
        }
        int curNodeNum = n;
        int qCount = 0; //if qCount==0, it is the time to initialize it using q.size(); qCount is the count of current level's nodes in the queue
        while(!oneDegreeQ.isEmpty()&&(qCount!=0||curNodeNum>2)){
            if(qCount==0) qCount=oneDegreeQ.size();
            curNodeNum--;
            qCount--;
            int node = oneDegreeQ.poll();
            for(int i:(ArrayList<Integer>)graph[node]) {
                degrees[i]--;
                if(degrees[i]==1) {
                    oneDegreeQ.add(i);
                }
            }
        }
        
        while(!oneDegreeQ.isEmpty()) {
            res.add(oneDegreeQ.poll());
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
