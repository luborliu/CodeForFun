package lintcode.ladder9.level5;

public class Q76LongestIncreasingSubsequence {
	
	/**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        //O(n^2) is the basic dp
        //challenge to do: nlogn
        
        //dp[i] = max(1+dp[j]) where nums[j]<nums[i] and j<i&&j>=0
        if(nums==null||nums.length==0) return 0;
        
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        
        for(int i=1; i<nums.length; i++) {
            dp[i] = 1;
            for(int j=i-1; j>=0; j--) {
                if(nums[i]>=nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        
        return max;
        
    }

}
