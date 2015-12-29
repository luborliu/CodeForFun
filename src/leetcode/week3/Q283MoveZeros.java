package leetcode.week3;

public class Q283MoveZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void moveZeroes(int[] nums) {        
        //two pointers from left to right
        if(nums==null||nums.length<=1) return;
        
        int pL = 0;
        int pR = 1;
        
        while(pR<nums.length) {
            while(nums[pL]!=0&&pL<pR) pL++;
            
            if(pR!=pL&&nums[pR]!=0) {
                //swap
                int tmp = nums[pL];
                nums[pL] = nums[pR];
                nums[pR] = tmp;
            } 
            pR++;
        }

    }

}
