package lintcode.ladder9.level3;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q364TrappingRainWaterII {
	//jiuzhang's nice solution: http://www.jiuzhang.com/solutions/trapping-rain-water-ii/
	/**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    public int trapRainWater(int[][] heights) {
        // write your code here
        //min-heap + 
        if(heights==null||heights.length<=2||heights[0].length<=2) return 0;
        
        int n = heights.length;
        int m = heights[0].length;
        
        Queue<Point> heap = new PriorityQueue<Point>(m*2+n*2-2, new Comparator<Point>() {
            public int compare(Point p1, Point p2) {
                return p1.val-p2.val;
            } 
        } );
        
        boolean[][] isVisited = new boolean[n][m];
        
        for(int i=0; i<m; i++) {
            heap.offer(new Point(0,i,heights[0][i]));
            heap.offer(new Point(n-1, i, heights[n-1][i]));
            isVisited[0][i] = true;
            isVisited[n-1][i] = true;
        }
        for(int j=1; j<n-1; j++) {
            heap.offer(new Point(j,0,heights[j][0]));
            heap.offer(new Point(j,m-1,heights[j][m-1]));
            isVisited[j][0] = true;
            isVisited[j][m-1] = true;
        }
        
        int[][] indices = new int[2][4];
        indices[0] = new int[]{0,0,1,-1};
        indices[1] = new int[]{1,-1,0,0};
        
        //Point curMin = heap.peek();
        //Point p = curMin;
        int sum = 0;
        
        while(!heap.isEmpty()) {
           
            
            Point curMin = heap.poll();
            
            for(int i=0; i<4; i++) {
                int rIndex = curMin.x + indices[0][i];
                int cIndex = curMin.y + indices[1][i];
                if(rIndex>=0&&rIndex<n&&cIndex>=0&&cIndex<m&&!isVisited[rIndex][cIndex]) {
                    isVisited[rIndex][cIndex] = true;
                   
                    sum += Math.max(0,curMin.val-heights[rIndex][cIndex]);
                    //this line is tricky, we must push back the new point with the new indices (not the really indices for the curMin wall point) and curMin wall height                    
                    Point p = new Point(rIndex,cIndex,Math.max(curMin.val,heights[rIndex][cIndex])); 
                    heap.offer(p);
                    
                }
            }

            
        }
        return sum;
       
        
    }
    
  
    
    class Point {
        int x;
        int y;
        int val;
        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

}
