package leetcode.week2;

public class Q303NumArray {
	
	int[] sumArr = null;
    
    public Q303NumArray(int[] nums) {
        
        if(nums==null||nums.length==0) return;
        this.sumArr = new int[nums.length];
        this.sumArr[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            sumArr[i] = sumArr[i-1]+nums[i];
        }
        
    }

    public int sumRange(int i, int j) {
        if(i==0) return this.sumArr[j];
        else return this.sumArr[j]-this.sumArr[i-1];        
    }

}
