package lintcode.ladder9.level5;

public class Q397LongestIncreasingContinuousSubsequence {
	
	
	public static void main(String[] args) {
		
		int[] s = new int[]{5,1,2,3,4};
		int r = longestIncreasingContinuousSubsequence(s);
	}

	public static int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        
		//following cannot handle two equal nums
		
        if(A==null) return 0;
        if(A.length<=2) return A.length; 
        
        
        int len = 2;
        
        int curL = 2;
        boolean flag = (A[1]>A[0]);
        
        for(int i=2; i<A.length; i++) {
            if(A[i]>A[i-1]) {
                if(flag) curL++;
                else {
                    if(curL>len) len = curL;
                    curL = 2;
                    flag = true;
                }
            } else if(A[i]<A[i-1]) {
                if(!flag) curL++;
                else {
                    if(curL>len) len = curL;
                    curL=2;
                    flag = false;
                }
            }
        }
        
        return len;
    }
}
