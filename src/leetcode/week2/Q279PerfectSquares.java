package leetcode.week2;

public class Q279PerfectSquares {
	
	public int numSquares(int n) {
        //dp[i] = min(dp[i-j]+1) where j in squareNums
		//in your second shuati, please refer to the discussion, there is better solution with less time consumed
        //https://leetcode.com/discuss/58056/summary-of-different-solutions-bfs-static-and-mathematics
		
        if(n<=0) return 0;
        
        int[] dp = new int[n+1];      
        
        for(int i=1; i<n+1; i++) {
            dp[i] = Integer.MAX_VALUE;
            int x = 1;
            while(x*x<=i) {
                dp[i] = Math.min(dp[i-x*x]+1,dp[i]);
                x++;
            }
        }
        return dp[n];
    }

}
