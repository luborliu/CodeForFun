package lintcode.ladder9.level5;

public class Q392HouseRobber {
	
	 /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        //easier than coins in a line II and III
        
        //f[i] stands for, we have i houses left, how much the robber can get at most
        //f[i] = max(A[n-i]+f[i-2], f[i-1])
        
        
        if(A==null||A.length==0) return 0;
        long[] dp = new long[2];
        int len = A.length;
        dp[0] = 0;
        for(int i=1; i<=A.length; i++) {
            if(i==1) dp[1] = A[len-i];
            else dp[i%2] = Math.max(A[len-i]+dp[(i-2)%2],dp[(i-1)%2]);
        }
        return dp[(len)%2];
    }

}
