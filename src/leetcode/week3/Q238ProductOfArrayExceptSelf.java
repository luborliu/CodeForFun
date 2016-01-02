package leetcode.week3;

public class Q238ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] a = new int[]{1,0};
		int[] res = productExceptSelf(a);

	}
	
	public static int[] productExceptSelf(int[] nums) {
        
        // a better idea from discussion, use only one constant to store the products from right to left, s.t.
        // we don't need to modify nums array and we need 1 less loop
        //
        if(nums==null||nums.length<=1) return null;
        int[] output = new int[nums.length];
        output[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            output[i] = output[i-1]*nums[i];
        }
        int rightToLeft = 1;
        
        for(int j=nums.length-1; j>0; j--) {
            output[j] = output[j-1] * rightToLeft;
            rightToLeft *= nums[j];
        }
        output[0] = rightToLeft;
        return output;
    }
	
	
	public static int[] productExceptSelfBad(int[] nums) {
        //withou division
        //two arrays to store product from left to right and right to left
        //then output[i] = p1[i-1]*p2[i+1]
        //to use no extra space, we need to make use of nums and output
        //that is, use output to store product from left to right while modify nums to store products from right to left
        if(nums==null||nums.length<=1) return null;
        int[] output = new int[nums.length];
        output[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            output[i] = output[i-1]*nums[i];
        }
        for(int j=nums.length-2; j>=0; j--) {
            nums[j] = nums[j+1]*nums[j];
        }
        ///need to pay attention to the following 3 orders as well as the for loop order, 
        //output[i] relies on output[i-1]
        //so we need to first modify output[i] before change output[i-1]
        output[nums.length-1] = output[nums.length-2];
        
        for(int i=nums.length-2; i>0; i--) {
            output[i] = output[i-1]*nums[i+1];
        }
        
        output[0] = nums[1];
        return output;
    }

}
