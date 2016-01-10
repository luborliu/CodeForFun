package leetcode.week4;

public class Q320WiggleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = new int[]{1,2,2,1,2,1,1,1,1,2,2,2};
		wiggleSort(x);
		System.out.println();
	}
	
	
	public static void wiggleSort(int[] nums) {
        
        if(nums==null||nums.length<=1) return;
        
        for(int i=1; i<nums.length; i++) {
            if(i%2==1) {
                if(nums[i]<nums[i-1]) swap(nums, i, i-1); 
            } else {
                if(nums[i]>nums[i-1]) swap(nums, i, i-1);
            }
        }
        
    }
    
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
	
	

}
