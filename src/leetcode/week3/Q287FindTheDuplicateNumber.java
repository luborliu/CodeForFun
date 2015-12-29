package leetcode.week3;

public class Q287FindTheDuplicateNumber {
	
	public int findDuplicate(int[] nums) {
        
        //understand first how to detect start point of a circle in linkedlist
        //Just make a easier understanding. Suppose the first meet at step k,the distance between the start node of list and the start node of cycle is s, and the distance between the start node of cycle and the first meeting node is m. Then 2k = (s + m + n1r) = 2(s + m + n2r) ==> s + m = nr. Steps moving from start node to the start of the cycle is just s, moving from m by s steps would be the start of the cycle, covering n cycles. In other words, they meet at the entry of cycle.
        
        int slow = 0;    //here it can be "slow=nums[0] fast = nums[0]" result will be same
        int fast = 0;
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
            } while(nums[fast]!=nums[slow]);
            
        fast = 0; //note: this should not be 'fast = nums[0]'
        while(nums[fast]!=nums[slow]) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return nums[fast];
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MAX_VALUE);

	}

}
