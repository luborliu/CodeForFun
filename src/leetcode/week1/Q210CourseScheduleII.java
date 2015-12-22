package leetcode.week1;

import java.util.ArrayList;
import java.util.HashMap;

public class Q210CourseScheduleII {

	public static int[] orders;
    public static int curIndex;
    
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        
        if(prerequisites==null||prerequisites.length<=1) return new int[0];
        
        curIndex = 0;
        
        orders = new int[numCourses];
        
        HashMap<Integer,Course> graph = buildGraph(prerequisites);
        
        for(int i:graph.keySet()) {
            Course c = graph.get(i);
            if(!labelCourses(graph,c)) return null;
        }
        
        return orders;
    }
    
    
    private static HashMap<Integer,Course> buildGraph(int[][] prerequisites) {
        HashMap<Integer,Course> graph = new HashMap<Integer,Course>();
        
        for(int i=0; i<prerequisites.length; i++) {
            int id0 = prerequisites[i][0];
            int id1 = prerequisites[i][1];
            if(!graph.containsKey(id0)) graph.put(id0,new Course(id0));
            if(!graph.containsKey(id1)) graph.put(id1,new Course(id1));
            
            graph.get(id0).children.add(graph.get(id1));
        }
        
        return graph;
        
    }
    
    // return false if there is cycles 
    // return true if there is no cycle
    private static boolean labelCourses(HashMap<Integer,Course> graph, Course c) {
        if(c.isVisited&&!c.isLabeled) return false;
        if(c.isVisited&&c.isLabeled) return true;
        
        c.isVisited = true;
        if(c.children.size()==0) {
            orders[curIndex++]=c.id;
            c.isLabeled = true;
            return true;
        }
        
        //int id = c.id;
        ArrayList<Course> children = c.children;
        //boolean res = true;
        for(Course ch:children) {
            if(!labelCourses(graph,ch)) return false;
        }
        
        c.isLabeled = true;
        orders[curIndex++] = c.id;
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] pre = new int[4][2];
    	pre[0] = new int[]{1,0};
    	pre[1] = new int[]{2,0};
    	pre[2] = new int[]{3,1};
    	pre[3] = new int[]{3,2};
    	
    	int[] res = findOrder(4, pre);
    	for(int i:res) {
    		System.out.println(i);
    	}

	}

}
