package meetcoder.day2;

import java.util.Arrays;

public class ID9CountTriangleTripleIndex {

	public static void main(String[] args) {

	}
	
	
	int countTriangleTripleIndex(int [] A) {
		
		int count =0;
		Arrays.sort(A);
		
		//scan
		for(int i=0; i<A.length-2; i++) {
			if(A[i]<=0) continue;
			for(int j=i+2; j<A.length; j++) {
				for(int m= i+1; m<j; m++) {
					if(A[i]+A[m]>A[j]) {
						//this is the essential part for optimization
						count += (j-m);
						break;
					}			
				}
			}
		}
		
		return count;

	}
}
