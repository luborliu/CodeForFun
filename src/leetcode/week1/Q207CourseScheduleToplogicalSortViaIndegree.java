package leetcode.week1;

import java.util.HashSet;
import java.util.Iterator;

public class Q207CourseScheduleToplogicalSortViaIndegree {
	
		//2nd method, the first one is ok but too much code which needs to be optimized
	   //this method uses the in-degree to check if there is circle
	   //if a graph is not empty && there is no 0-indegree vertices => it has circle
	   
	   //https://leetcode.com/discuss/37134/java-ac-solution-with-top-sort
	
	   
	   public boolean canFinish(int numCourses, int[][] prerequisites) {
	       
	       if(prerequisites==null||prerequisites.length<=1) return true;
	       
	       int[] indegree = new int[numCourses];
	       HashSet<Integer> zeroDegreeSet = new HashSet<Integer>();
	       
	       for(int i=0; i<prerequisites.length; i++) {
	           indegree[prerequisites[i][1]]++;
	       }
	       
	       for(int i=0; i<numCourses; i++) {
	           if(indegree[i]==0) {
	               zeroDegreeSet.add(i);
	           }
	       }
	       
	       if(zeroDegreeSet.isEmpty()) return false;
	   
	       //next: repeatly remove node from zeroDegreeSet
	       while(!zeroDegreeSet.isEmpty()) {
	           Iterator<Integer> it = zeroDegreeSet.iterator();
	           int p = it.next();
	           zeroDegreeSet.remove(p);
	           for(int row=0; row<prerequisites.length; row++) {
	               if(prerequisites[row][0]==p) {
	                   indegree[prerequisites[row][1]]--;
	                   if(indegree[prerequisites[row][1]]==0) zeroDegreeSet.add(prerequisites[row][1]);
	               }
	           }
	       }
	       
	       for(int i=0; i<indegree.length; i++) {
	           if(indegree[i]>0) return false;
	       }
	   
	       return true;
	   }

}
