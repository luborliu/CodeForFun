package leetcode.day1;

public class Q264UglyNumberII {
	
	public static void main(String[] args) {
		
	}
	
	public int nthUglyNumber(int n) {
		//dp function:
		//dp[i] = Math.min(2*dp[index2],3*dp[index3],5*dp[index5])
		
		int index2 = 0;
		int index3 = 0;
		int index5 = 0;
		
		int[] dp = new int[n];
		dp[0] = 1;
		
		for(int i=1; i<n; i++) {
			
			int val2 = 2*dp[index2];
			int val3 = 3*dp[index3];
			int val5 = 5*dp[index5];
			
			if(val2==dp[i-1]) val2=2*dp[++index2];
			if(val3==dp[i-1]) val3=3*dp[++index3];
			if(val5==dp[i-1]) val5=5*dp[++index5];
				
			dp[i] = Math.min(Math.min(val2,val3),val5);
			if(dp[i]==val2) index2++;
			else if(dp[i]==val3) index3++;
			else index5++;
			
		}
		
		return dp[n-1];
		
	}

}
