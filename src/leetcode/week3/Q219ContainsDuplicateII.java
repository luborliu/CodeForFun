package leetcode.week3;

import java.util.HashSet;

public class Q219ContainsDuplicateII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	//a better and more concise code
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		 //hashset with two pointers
        
        if(nums==null||k<=0) return false;
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int i=0; i<nums.length; i++) {
            if(i>k) set.remove(nums[i-k-1]);    //i-k-1
            if(!set.add(nums[i])) return true;
        }
        
        return false;
	}
	
	//my first solution which is not concise
	public boolean containsNearbyDuplicateBad(int[] nums, int k) {
        
        //hashset with two pointers
        if(nums==null||nums.length<=1||k==0) return false; //corner case k==0
        HashSet<Integer> set = new HashSet<Integer>();
        
        int i=0;
        while(i<=k&&i<nums.length) {
            //set.add(sth) return true if the element was not in the set
            if(!set.add(nums[i])) return true;
            i++;
        }
        
        int p=0;
        
        while(i<nums.length) {
            set.remove(nums[p]);
            if(!set.add(nums[i])) return true;
            p++;
            i++;
        }
        return false;
        
    }	
	

}
