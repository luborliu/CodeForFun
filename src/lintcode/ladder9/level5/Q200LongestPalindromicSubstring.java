package lintcode.ladder9.level5;

public class Q200LongestPalindromicSubstring {
	
	public String longestPalindrome(String s) {
        // Write your code here
        
        //dp[i][j] = 1 if dp[i+1][j-1]==1 && s[i]==s[j]
        //         = 0 else
        
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        String res = "";
        
        for(int i=0; i<s.length(); i++) {
            for(int j=i; j>=0; j--) {
                
                if(i==j) dp[j][i] = true;
                else if(s.charAt(i)==s.charAt(j)) {
                    if(j+1==i||(j+1!=i&&dp[j+1][i-1])) dp[j][i]=true;
                }
                
                if(dp[j][i]&&(i-j+1)>res.length()) res = s.substring(j,i+1);
            }
        }
        return res;
        
    }

}
