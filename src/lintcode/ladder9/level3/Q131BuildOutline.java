package lintcode.ladder9.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q131BuildOutline {
	
	public static void main(String[] args) {
		int[][] t = new int[3][3];
		t[0] = new int[]{16,20,9};
		t[1] = new int[]{20,25,19};
		t[2] = new int[]{22,31,7};
		
		//buildingOutline(t);
		
	}
	
	
	/**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        
        
        
        ArrayList<Point> al = new ArrayList<Point>();
        for(int i=0; i<buildings.length; i++ ) {
            al.add(new Point(buildings[i][0], buildings[i][2], true));
            al.add(new Point(buildings[i][1],buildings[i][2], false));
        }
        
       Collections.sort(al, new Comparator<Point>() {
           public int compare(Point p1, Point p2) {
               return p1.x-p2.x;
           }
       });
       
       PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
       
       int globalHeight = 0;
       int globalIndex = 0;
       
       int i=0;
       while(i<al.size()) {
           
           Point p = al.get(i);
           handleNewElement(heap,p);
           while(i+1<al.size()&&al.get(i+1).x==p.x) {
               handleNewElement(heap, al.get(i+1));
               i++;
           }
           
           if(heap.isEmpty()) {
               if(globalHeight!=0) {
                   ArrayList<Integer> tmpL = new ArrayList<Integer>();
                   tmpL.add(globalIndex);
                   tmpL.add(p.x);
                   tmpL.add(globalHeight);
                   res.add(tmpL);
               }
               globalHeight = 0;
               globalIndex = p.x;
           } else{
               int curHeight = -heap.peek();
               if(curHeight!=globalHeight) {
                   if(globalHeight!=0) {
                       ArrayList<Integer> tmpL = new ArrayList<Integer>();
                       tmpL.add(globalIndex);
                       tmpL.add(p.x);
                       tmpL.add(globalHeight);
                       res.add(tmpL);
                   }
                   globalHeight = curHeight;
                   globalIndex = p.x;
               }
           }
           i++;
       }
       return res;
        
    }
    
    private void handleNewElement(PriorityQueue<Integer> h, Point p) {
        
        if(p.isStart) {
            h.offer(-p.height);
        } else {
            h.remove(-p.height);
        }
        
    }
    
    
    class Point {
        int x; //position
        int height;
        boolean isStart;
        
        public Point(int x, int h, boolean isStart) {
            this.x = x;
            this.height = h;
            this.isStart = isStart;
        }
    }

}
