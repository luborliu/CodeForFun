package lintcode.ladder9.level5;

public class Q191MaximumProductSubarray {
	
	/**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        
        //curMax = max(preMax*nums[i],preMin*nums[i], nums[i])
        //curMin = min(preMax*nums[i],preMin*nums[i], nums[i])
        
        int preMax = 1;
        int preMin = 1;
        int curMax = 0;
        int curMin = 0;
        int res = Integer.MIN_VALUE;
        
        for(int i=0; i<nums.length; i++) {
            
            curMax = Math.max(Math.max(preMax*nums[i],preMin*nums[i]), nums[i]);
            
            curMin = Math.min(Math.min(preMax*nums[i],preMin*nums[i]), nums[i]);
            
            preMax = curMax;
            preMin = curMin;
            
            res = Math.max(curMax, res);
        }
        
        return res;
    }

}
