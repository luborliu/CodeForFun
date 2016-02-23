package lintcode.ladder9.level5;

public class Q395CoinsInALineII {
	
	
	public static void main(String[] args) {
		int[] t = new int[]{1,2,2};
		
		firstWillWin(t);
		
	}
	
	public static boolean firstWillWin(int[] values) {
        // write your code here
        
        //we have N coins in total
        //dp[i] stands for 还剩i个coins的时候，先手甲最多可以拿多少value
        //dp[i] = max { A[N-i]+ min(dp[i-2],dp[i-3]),  甲只拿一个硬币
        //              A[N-i]+A[N-i+1] + min(dp[i-3],dp[i-4]) 甲拿两个硬币
        //            }
        
        if(values==null) return false;
        
        if(values.length<3) return true;
        
        int[] dp = new int[values.length+1];
        int len = values.length;
        dp[0] = 0;
        dp[1] = values[len-1];
        dp[2] = values[len-1]+values[len-2];
        dp[3] = values[len-2]+values[len-3];
        int sum = values[len-1]+values[len-2]+values[len-3];
       
        
        for(int i=3; i<values.length; i++) {
            sum += values[len-i-1];
            
            dp[i+1] = Math.max(values[len-i-1]+Math.min(dp[i+1-2],dp[i+1-3]),
                        values[len-i-1]+values[len-i]+ Math.min(dp[i+1-3],dp[i+1-4]));
        }
        
        if((2*dp[len])>sum) return true;
        return false;
    }

}
