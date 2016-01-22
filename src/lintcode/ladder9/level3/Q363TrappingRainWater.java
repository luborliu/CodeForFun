package lintcode.ladder9.level3;

public class Q363TrappingRainWater {
	
	/**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        
        //like two pointers from left and right to get collision
        
        if(heights==null||heights.length<=2) return 0;
        
        int l = 0;
        int r = heights.length-1;
        
        int sum = 0;
        int curMin = -1;
        
        while(l<r) {
            
            if(heights[l]<curMin) sum += (curMin-heights[l]);
            else if(heights[r]<curMin) sum += (curMin-heights[r]);
            else curMin = Math.min(heights[l],heights[r]);
            
            if(heights[l]<heights[r]) l++;
            else r--;
        }
        
        return sum;
        
    }

}
