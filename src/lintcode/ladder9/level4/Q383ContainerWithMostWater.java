package lintcode.ladder9.level4;

public class Q383ContainerWithMostWater {
	
	/**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        
        //two pointers
        
        int l = 0;
        int r = heights.length-1;
        
        int curH = 0;
        
        int res = 0;
        
        while(l<r) {
            curH = Math.min(heights[l], heights[r]);
            res = Math.max(curH * (r-l), res);
            
            if(heights[l]<heights[r]) l++;
            else r--;
            
        }
        
        return res;
    }

}
