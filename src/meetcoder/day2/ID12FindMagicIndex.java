package meetcoder.day2;

import java.util.Stack;

public class ID12FindMagicIndex {
	
	public static void main(String[] args) {
		
		System.out.println(getMagicIndex(new int[]{-3,-2,-1,1,3,4,5,6,7}));
		Stack<Integer> s = new Stack<Integer>();
		
		
	}
	
	
	public static int getMagicIndex(int [] A) {
	
		
		return getMagicIndexHelper(A, 0, A.length-1);		

    }
        
   public static int getMagicIndexHelper(int[] A, int l, int r) {
        
        	if(l>r) return -1;
        	if(l==r) {
        		if(A[l]==l) return l;
        		else return -1;
        	}
        	
        	int mid = (l+r)/2;
        	if(A[mid]==mid) {
        		int leftResult = getMagicIndexHelper(A,l,mid-1);
        		if(leftResult>=0) 
        			return Math.min(mid, leftResult );
        		else return mid;
        	} else if(A[mid]<mid){
        		int leftResult = getMagicIndexHelper(A,l,mid-1);
        		int rightResult = getMagicIndexHelper(A,mid+1,r);
        		if(leftResult>=0&&rightResult>=0) return Math.min(leftResult, rightResult);
        		else if(leftResult>=0||rightResult>=0) return Math.max(leftResult, rightResult);
        		else return -1;
        	} else {
        		return getMagicIndexHelper(A,l,mid-1);
        	}
        	        
        }
   
   //Better Solution Iteration instead of recursion
   /**
    * http://www.meetqun.com/thread-11159-1-1.html
    * class Solution {
		public:
		    int getMagicIndex(vector<int> &A) {
		        if(A.empty()) return -1;
		        int n = A.size();
		        if(A[0] > 0 || A[n-1] < n-1) return -1;
		        int l = -1, r = n-1;
		        while(l+1 < r){
		            int m = (l+r) >> 1;
		            if(A[m] >= m) r = m;
		            else l = m;
		        }
		        return A[r] == r ? r : -1;
		    }
		};
    */

}
