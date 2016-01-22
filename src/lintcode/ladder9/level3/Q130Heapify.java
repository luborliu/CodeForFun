package lintcode.ladder9.level3;

public class Q130Heapify {
	
	 //needs to be done second time later!!!!! sift down, this is important!!!
	 /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        
        //solution 1: sort the array directly -> O(nlogn)
        //solution 2: sift down, this is brilliant
        
        for(int i=A.length/2; i>=0; i--) {
            siftDown(A, i);
        }
        
    }
    
    // k is the index which starts from the first element of last level to the root 

    private void siftDown(int[] A, int k) {
        
        while(k<A.length) {
        
            int smallest = k;
            
            if(k*2+1<A.length&&A[k*2+1]<A[k]) {
                smallest = k*2+1;
            }
            if(k*2+2<A.length&&A[k*2+2]<A[smallest]) {//note: here is A[smallest]
                smallest = k*2+2;
            }
            
            if(k==smallest) break;
            
            else {
                //swap
                int tmp = A[k];
                A[k] = A[smallest];
                A[smallest] = tmp;
                
                k = smallest; // continue to go deep down the branch
            }
        }
        
    }

}
