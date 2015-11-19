package meetcoder.day1;

import java.util.Arrays;

public class ID5MinimizeUnfairness {

	public int minimizeUnfairness(int [] a, int k) {
		
		//this is easy
		//sort first, then use two pointers
		if(k>a.length) return -1;
		Arrays.sort(a);
		
		int minFairness = Integer.MAX_VALUE;
		for(int i=0; i<=a.length-k; i++) {
			int j =i+k-1;
			minFairness = Math.min(minFairness, a[j]-a[i]); 
		}
		return minFairness;
	}
}
