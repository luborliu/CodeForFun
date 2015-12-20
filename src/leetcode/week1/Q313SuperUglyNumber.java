package leetcode.week1;

public class Q313SuperUglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p = new int[]{2,3,5,9,13};
		System.out.println(nthSuperUglyNumber(100, p));

	}

	public static int nthSuperUglyNumber(int n, int[] primes) {
	    
        // my idea: HashSet based
        // write function to see if a number is an ugly number
        // then use a for-loop until we meet the nth ugly number        
        
        //now better idea is to us dp, the idea is based on UglyNumberII
        //dp[i]= min(dp[index[j]]*primes[j]) where j in [0,primes.length)
        int[] dp = new int[n];
        int[] index = new int[primes.length];
        dp[0] = 1;
        for(int i=1; i<n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j=0; j<primes.length; j++) {
                //if(dp[i-1]==dp[index[j]]*primes[j]) index[j]++;
                dp[i]=Math.min(dp[i],dp[index[j]]*primes[j]);
            }
            
            for(int j=0; j<primes.length; j++) {
                
                if(dp[i]==dp[index[j]]*primes[j]) {
                    index[j]++;
                }
            }
            
        }
        return dp[n-1];
    
    } 
	
	
}
