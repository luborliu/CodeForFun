package leetcode.week3;

import java.util.HashMap;

public class Q220ContainsDuplicateIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        
        //bucket solution
        //https://leetcode.com/discuss/38206/ac-o-n-solution-in-java-using-buckets-with-explanation
		//similar idea like II, but more tricky
        //another idea is to use BST s.t. time complexity will be O(n*logk) with space O(k)
		
		
        if(nums==null||k<=0||t<0) return false; //corner case t<0||k<0
        HashMap<Long,Long> hm = new HashMap<Long,Long>();
        
        for(int i=0; i<nums.length; i++) {
            if(i>k) hm.remove(((long)nums[i-k-1]-Integer.MIN_VALUE)/((long)t+1)); //using (long)t+1 is because t can be Integer.MAX_VALUE
            long remappedNum = ((long)nums[i]-Integer.MIN_VALUE)/((long)t+1); //ask yourself why long, why minus MIN_VALUE, why (t+1)?
            if(hm.containsKey(remappedNum)||
               (hm.containsKey(remappedNum-1)&&nums[i]-hm.get(remappedNum-1)<=t)||
               (hm.containsKey(remappedNum+1)&&hm.get(remappedNum+1)-nums[i]<=t)) return true;
            hm.put(remappedNum, (long)nums[i]);
        }
        
        return false;
        
    }
	

}
