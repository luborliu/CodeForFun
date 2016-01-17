package lintcode.ladder9.Level1;

import java.util.Arrays;

public class Q382TirangleCount {
	
	public static void main(String[] args) {
		int[] x = new int[]{3,4,7,6};
		//[4,4,4,4]
		triangleCount(x);
		
	}
	
	public static int triangleCount(int S[]) {
        // write your code here
        
        Arrays.sort(S);
        reverseArray(S);
        
        int count = 0;
        
        for(int i=0; i<S.length-2; i++) {
            int l=i+1;
            int r=S.length-1;
            while(l<r) {
                if(S[l]+S[r]>S[i]) {
                    count += (r-l);
                    l++;
                } else {
                    r--;
                }
            }
        }
        return count;
    }
    private static void reverseArray(int A[]) {
        int i = 0; 
        int j = A.length-1;
        while(i<j) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
            i++;
            j--;
        }
    }

}
