package lintcode.ladder9.level3;

import java.util.PriorityQueue;
import java.util.Queue;

public class Q81DataStreamMedian {
	
	public static void main(String[] args) {
		int[] a = new int[]{2,20};
		
		medianII(a);
	}
	
	/**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public static int[] medianII(int[] nums) {
        // write your code here
        
        //two heaps
        if(nums==null) return nums;
        Queue<Integer> minHeap = new PriorityQueue<Integer>();
        Queue<Integer> maxHeap = new PriorityQueue<Integer>();
        
        int[] res = new int[nums.length];
        //define left cannot be less than right
        for(int i=0; i<nums.length; i++) {
            
            //add to right first
            minHeap.offer(nums[i]);
            
            if(maxHeap.size()<minHeap.size()) {
                maxHeap.offer(-minHeap.poll());
            } else {
                //compare the max of left and min of right
                //determin if the order is right
                int lMax = -maxHeap.poll();
                int rMin = minHeap.poll();
                maxHeap.offer(lMax>rMin?(-rMin):(-lMax));
                minHeap.offer(lMax>rMin?lMax:rMin);
            }
            
//            if(maxHeap.size()!=minHeap.size()) {
//                res[i] = -maxHeap.peek();
//            } else {
//                res[i] = -maxHeap.peek()/2+minHeap.peek()/2;
//            }
            res[i] = -maxHeap.peek();
        }
        
        return res;
        
        
    }

}
