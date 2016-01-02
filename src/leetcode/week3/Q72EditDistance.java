package leetcode.week3;

public class Q72EditDistance {
	
	
	public int minDistance(String word1, String word2) {
                
        //dp
        //if(word1[i]=word2[j]) dp[i][j] = dp[i-1][j-1]
        //dp[i][j] = min(dp[i-1][j]+1,      //delete c
        //               dp[i][j-1]+1,      //insert c 
        //               dp[i-1][j-1]+1)    //replace
        //needs to be optimized for space
        
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i=1; i<word1.length()+1; i++) dp[i][0] = i;
        for(int j=1; j<word2.length()+1; j++) dp[0][j] = j;
        
        for(int i=1; i<word1.length()+1; i++) {
            for(int j=1; j<word2.length()+1; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                if(word1.charAt(i-1)==word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min(Math.min(dp[i-1][j]+1,dp[i][j-1]+1),dp[i-1][j-1]+1);
            } 
        }
        return dp[word1.length()][word2.length()];
    }

}
