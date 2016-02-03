package lintcode.ladder9.level3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Q362SlidingWindowMaximum {
	
	
	/**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        
        if(nums==null||nums.length<k||k==0) return new ArrayList<Integer>();
        
        //store index in the deque
        Deque<Integer> dq = new ArrayDeque<Integer>();
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        for(int i=0; i<nums.length; i++) {
            while(!dq.isEmpty()&&nums[dq.peekLast()]<nums[i]) {
               dq.pollLast();
            }
            dq.offer(i);
            
            if(i>=k-1) {
                if(dq.peekFirst()==i-k) dq.pollFirst();
                res.add(nums[dq.peekFirst()]); 
            }
            
        }
        return res;
        
    }

}
