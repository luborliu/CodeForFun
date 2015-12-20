package leetcode.week1;

import java.util.HashMap;

public class Q207CourseSchedule {
	
	//a better oo-easyread java implementation:
	//https://leetcode.com/discuss/35035/oo-easy-to-read-java-solution
	//only use two flags:visited and tested in the node, such that, we no longer need label(numeric)
	
	
    public static void main(String[] args) {
    	
    	int[][] pre = new int[2][2];
    	pre[0] = new int[]{1,0};
    	pre[1] = new int[]{2,0};
    	
    	System.out.println(canFinish(3, pre));
    }
    
    static int curLabel = -1;
    
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        
        
        //https://class.coursera.org/algo-003/lecture/52
        //topological sort using dfs
        //to find if there is circle
        curLabel = numCourses;
        if(prerequisites==null||prerequisites.length<=1) return true;
        
        //first construct the graph
        HashMap<Integer,Node2> hm = new HashMap<Integer,Node2>(); //id,node
        for(int i=0; i<prerequisites.length; i++) {
            int id0 = prerequisites[i][0];
            int id1 = prerequisites[i][1];
            if(!hm.containsKey(id0)) hm.put(id0,new Node2(id0));
            if(!hm.containsKey(id1)) hm.put(id1,new Node2(id1));
            hm.get(id0).children.add(hm.get(id1));
        }
        
        //int curLabel=numCourses;
        //dfs to assign label and see if there is cycle at the same time
        for(int j:hm.keySet()) {
            Node2 p = hm.get(j);
            if(hasCircle(hm,p)) return false;
        }
        
        return true; 
    }
    
    public static boolean hasCircle(HashMap<Integer,Node2> graph,  Node2 p) {
        if(p.isVisited&&p.label==-1) return true;
        else if(p.isVisited&&p.label!=-1) return false;
        
        
        p.isVisited = true;
        
        boolean res = false;
        if(p.children.size()==0) {
            p.label=curLabel--;
            return false;
        }
        
        for(int i=0; i<p.children.size(); i++) {
            if(hasCircle(graph,p.children.get(i))) {
                res = true;
                break;
            }
        }
        p.label=curLabel--;
        
        return res;
    }
    


}
