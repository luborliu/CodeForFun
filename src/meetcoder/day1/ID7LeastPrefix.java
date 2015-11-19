package meetcoder.day1;

import java.util.HashSet;

public class ID7LeastPrefix {
	
	public int leastPrefix(int [] A) {
		//to find the smallest subscript of the array A
		//first idea is to use HashSet
		HashSet<Integer> hs = new HashSet<Integer>();
		int prefix = 0;
		for(int i=0; i<A.length; i++) {
			if(!hs.contains(A[i])) {
				hs.add(A[i]);
				prefix = i;
			}
		}
		return prefix;

	}

}
