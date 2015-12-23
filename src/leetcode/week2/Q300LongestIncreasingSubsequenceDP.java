package leetcode.week2;

public class Q300LongestIncreasingSubsequenceDP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int lengthOfLIS(int[] nums) {
        
        //1st dp O(n^2)
        //dp[i] =max(1, max(dp[j]+1)) where j<i &&nums[j]<nums[i];
        if(nums==null||nums.length==0) return 0;
        int curMax =1;
        int[] dp =new int[nums.length];
        dp[0] = 1;
        
        for(int i=1; i<nums.length; i++) {
            dp[i] = 1;
            for(int j=i-1; j>=0; j--) {
                if(nums[j]<nums[i]) dp[i] = Math.max(dp[i],dp[j]+1); 
            }
            curMax = Math.max(curMax,dp[i]);
        }
        return curMax;
    }
}
