package lintcode.ladder9.level5;

public class Q396CoinsInALineIII {
	
	/**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        //f[i][j] = max { A[i]+min(f[i+2][j], f[i+1][j-1]),
        //              { A[j]+min(f[i+1][j-1], f[i][j-2]) 
        
        if(values==null||values.length==0) return false;
        
        int[][] dp = new int[values.length][values.length];
        int sum = 0;
        
        for(int j=0; j<dp.length; j++) {
            sum += values[j];
            
            for(int i=j; i>=0; i--) {
                
                if(i==j) dp[i][j] = values[i];
                else if(i+1==j) dp[i][j]= Math.max(values[i],values[j]);
                else dp[i][j] = Math.max(values[i]+Math.min(dp[i+2][j], dp[i+1][j-1]), values[j]+Math.min(dp[i+1][j-1], dp[i][j-2]));
                
            }
            
        }
        
        if(dp[0][values.length-1]*2<sum) return false;
        else return true;
        
    }

}
