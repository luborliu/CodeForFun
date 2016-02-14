package lintcode.ladder9.level5;

public class Q41MaximumSubarray {
	
	 /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code
        
        //rolling array
        //dp[i] = max(dp[i-1]+nums[i],nums[i])
        
        if(nums==null||nums.length==0) return 0;
        
        int max = nums[0];
        
        int curMax = nums[0];
        
        for(int i=1; i<nums.length; i++) {
            curMax = Math.max(curMax+nums[i],nums[i]);
            max = Math.max(max, curMax);
        }
        return max;
    }

}
