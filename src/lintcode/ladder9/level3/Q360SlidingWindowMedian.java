package lintcode.ladder9.level3;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Q360SlidingWindowMedian {
	
	public static void main(String[] args) {
		int[] x = new int[]{1,2,7};
		medianSlidingWindow(x, 2);
	}
	
	/**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    public static ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        
        //questions to ask interviewer: if k is even, what is median
        
        //two heaps to solve, like stream median, but need to use hash-heap to make remove logn time
        
        if(nums==null||nums.length<k) return null;
        
        if(k==0) return new ArrayList<Integer>();
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for(int i=0; i<k; i++) {
            addValueToHeaps(maxHeap, minHeap, nums, i, k);
        }
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(-maxHeap.peek());
        
        for(int j=k; j<nums.length; j++) {
            addValueToHeaps(maxHeap, minHeap, nums, j, k);
            res.add(-maxHeap.peek());
        }
        return res;
    }
    
    private static void addValueToHeaps(PriorityQueue<Integer> maxHeap, PriorityQueue<Integer> minHeap, int[] nums, int i, int k) {
        
        if(i>=k) {
            if(nums[i-k]<= -maxHeap.peek()) maxHeap.remove(-nums[i-k]);
            else minHeap.remove(nums[i-k]);
        }
        
        minHeap.offer(nums[i]);
        
        // here, the tricky part is after removing one elment from either heap, we can still use the following to maitain the balance of the two heaps
        // but during interview, need to prove this is true using different cases
        int lSize = maxHeap.size();
        int rSize = minHeap.size();
        if(lSize<rSize) {
            maxHeap.offer(-minHeap.poll());
        } else {
            int tmpL = -maxHeap.poll();
            int tmpR = minHeap.poll();
            maxHeap.offer(tmpL<tmpR?-tmpL:-tmpR);
            minHeap.offer(tmpL<tmpR?tmpR:tmpL);
        }
        
    }

}
