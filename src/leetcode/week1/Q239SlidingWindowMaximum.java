package leetcode.week1;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q239SlidingWindowMaximum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[] nums = new int[]{9,11};
		
		int[] res = maxSlidingWindow(nums, 2);
		
	}
	
	public static int[] maxSlidingWindow(int[] nums, int k) {
        
        //brilliant idea using dequeue
        if(nums==null||nums.length<=1||k==1) return nums;
        
        int[] res = new int[nums.length-(k-1)];
        
        Deque<Integer> dq = new ArrayDeque<Integer>();
        
        for(int i=0; i<nums.length; i++) {
        	
        	if(!dq.isEmpty()&&dq.peekFirst()<(i-(k-1))) dq.pollFirst();	//don't forget this condition, remove the element out of the range
        	
        	while(!dq.isEmpty()&&nums[dq.peekFirst()]<=nums[i]) {
        		dq.pollFirst();
        	}
        	
        	while(!dq.isEmpty()&&nums[dq.peekLast()]<=nums[i]) {
        		dq.pollLast();
        	}
        	
        	dq.add(i);
        	if(i>=(k-1)) res[i-(k-1)]=nums[dq.peekFirst()];	//remember two things: 1st need the 'if' check condition; 2nd dq stores indices not the value
        }
        
        return res;
    }

}
