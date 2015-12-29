package leetcode.week3;

public class Q268MissingNumber {
	
	
	public int missingNumber(int[] nums) {
        
        //use sum to handle which is naive        
        if(nums==null||nums.length==0) return 0;
        int len = nums.length;
        
        int sum = len*(1+len)/2;
        for(int i=0; i<len; i++) {
            sum -= nums[i];
        }
        return sum;
        
    }
	
	
	 public int missingNumber2nd(int[] nums) {	      
	        //2nd use xor
	        int res = nums.length;
	        for(int i=0; i<nums.length; i++) {
	            res ^= i;
	            res ^=nums[i];
	        }
	        return res;
	    }
	
	

}
