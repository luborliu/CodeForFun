package lintcode.ladder9.level4;

public class Q406MinimumSizeSubarraySum {
	
	/**
     * @param nums: an array of integers
     * @param s: an integer
     * @return: an integer representing the minimum size of subarray
     */
    public int minimumSize(int[] nums, int s) {
        // write your code here
        
        //two pointers
        
        int l = 0;
        
        int size = Integer.MAX_VALUE;
        int sum = 0;
        
        boolean flag = false;
        
        for(int i=0; i<nums.length; i++) {
            sum+= nums[i];
            while(sum>= s) {
                flag = true;
                size = Math.min(i-l+1,size);
                sum -= nums[l];
                l++;
            }
        }
        if(!flag) return -1;
        
        return size;
    }

}
