package meetcoder.day1;

import java.util.Arrays;

public class ID2MakePairs {
	
	public boolean makePair(int [] a, int [] b, int k) {
		//first do a subtraction
		//then sort the both lists
		//compare one by one greedily
		
		if(a==null||b==null||a.length==0||b.length==0) return true;
		
		for(int i=0; i<a.length; i++) {
			a[i] = k-a[i];	
		}
		Arrays.sort(a);
		Arrays.sort(b);
		boolean res = true;
		
		//add optimization
		if(a[a.length-1]<=b[0]) return res;
		
		for(int j=0; j<a.length; j++) {
			if(a[j]>b[j]) {
				res = false;
				break; 
			}
		}
		return(res);

	}

}
