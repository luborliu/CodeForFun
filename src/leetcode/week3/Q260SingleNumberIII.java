package leetcode.week3;

public class Q260SingleNumberIII {

	public static void main(String[] args) {

	}
	
	public int[] singleNumber(int[] nums) {
        
        //come on! you have done this before, how come you forget it!
        //idea: use xor to get two distinct numbers (a,b)  a^b
        //then get lst 1 bit of a^b => that is, lstOneBit = a^b & -(a^b);; note not ~
        //lastly separate the nums into two groups, the same bit(lstOneBit) with 1 and the bit with 0
        //finally do twice xor operations on the two groups
        if(nums==null||nums.length<2) return null;
           
        int xor = 0;
        for(int i:nums) {
            xor ^= i;
        }
        
        int lstOneBit = xor&(-xor);
        
        int[] res = new int[2];
        //two groups
        for(int i:nums) {
            if((i&lstOneBit)==0) res[0] ^= i; //kuohao!bad operand types for binary operator '&'
            else res[1] ^= i;
        }
        return res;
    }

}
