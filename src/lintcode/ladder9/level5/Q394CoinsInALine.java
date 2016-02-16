package lintcode.ladder9.level5;

public class Q394CoinsInALine {
	
	
	 /**
     * @param n: an integer
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int n) {        
        //dp[i] = (dp[i-2]&&dp[i-3]) || (dp[i-4]&&dp[i-3])
        if(n==0) return false;
        if(n<=2) return true;
        
        //boolean[] dp = new boolean[n];
        boolean[] dp = new boolean[5]; //rolling array
        
        dp[0] = true;
        dp[1] = true;
        dp[2] = false;
        
        
        for(int i=3; i<n; i++) {
            
            dp[i%5] = (dp[(i-2)%5]&&dp[(i-3)%5]) || (dp[(i-4)%5]&&dp[(i-3)%5]);
        }
        
        return dp[(n-1)%5];
    }

}
