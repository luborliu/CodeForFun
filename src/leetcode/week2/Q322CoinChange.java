package leetcode.week2;

public class Q322CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = null;
		int amount = 10;
		System.out.println(coinChange(coins, amount));

	}
	
	public static int coinChange(int[] coins, int amount) {
        
        //classic dp problem
        //dp[i] = min(dp[i-x])+1 where x is in coins[] and i-x>=0
        
        if(amount<=0) return 0;
        
        if(coins==null||coins.length==0) return -1;
        
        int[] dp = new int[amount+1];
        for(int i=1; i<amount+1; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int c : coins) {
                if(i-c>=0&&dp[i-c]!=Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i-c]+1,dp[i]);
                }
            }
        }
        
        if(dp[amount]==Integer.MAX_VALUE) return -1;
        return dp[amount];
        
    }

}
