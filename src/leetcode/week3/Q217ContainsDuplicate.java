package leetcode.week3;

import java.util.HashSet;

public class Q217ContainsDuplicate {
	
	public boolean containsDuplicate(int[] nums) {
        
        //too easy
        //O(n) space O(n) time
        if(nums==null||nums.length==0) return false;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i:nums) {
            if(!set.add(i)) return true;
        }
        return false;
    }

}
