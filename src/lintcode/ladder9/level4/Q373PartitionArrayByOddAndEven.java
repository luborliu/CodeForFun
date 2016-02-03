package lintcode.ladder9.level4;

public class Q373PartitionArrayByOddAndEven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x = new int[]{2147483644,2147483645,2147483646,2147483647};
		partitionArray(x);
	}
	
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public static void partitionArray(int[] nums) {
        // write your code here;
        
        
        int index = 0;
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i]%2==1) {
                swap(nums, index, i);
                index++;
            }
        }
        
        
        
    }
    
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
        
    }

}
