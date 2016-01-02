package leetcode.week3;

import java.util.LinkedList;
import java.util.List;

public class Q229MajorityElementII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{1,2,3};
		List<Integer> res = majorityElement(a);

	}
	
	public static List<Integer> majorityElement(int[] nums) {
        
        //similar idea as I
        // use two numbers to store two potential frequent numbers and two counts to store the current counts 
        // if a third number appear, deduce both counts for the two potential frequent numbers
        // finally walk through nums array again to get the count of the two (or one) frequent number(s)
        // return result
        
        LinkedList<Integer> res = new LinkedList<Integer>();
        
        int a=0;
        int b=0;
        int ca = 0;
        int cb = 0;
        
        for(int i:nums) {
            if(i==a) ca++;
            else if(i==b) cb++;
            else if(ca==0) {
                a = i;
                ca++;
            } else if(cb==0) {
                b = i;
                cb++;
            } else {
                ca--;
                cb--;
            }
        }
        ca=cb=0;
        for(int i:nums) {
            if(i==a) ca++;
            else if(i==b) cb++;
        }
        if(ca>nums.length/3) res.add(a);
        if(cb>nums.length/3) res.add(b);
        return res;
    }
	
	

}
