package leetcode.week3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q15ThreeSum {
	
	public static void main(String[] args) {
		
		List<List<Integer>> res = threeSum(new int[]{3,0,-2,-1,1,2});
		
	}
	
	//this question needs to be patient and careful
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new LinkedList<List<Integer>>();        
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++) {
            if(i==0||(nums[i]!=nums[i-1])) {               
                int pL = i+1;
                int pR = nums.length-1;
                while(pL<pR) {
                    if(nums[pL]+nums[pR]==-nums[i]) {
                        List<Integer> tmpL = new LinkedList<Integer>();
                        tmpL.add(nums[i]);
                        tmpL.add(nums[pL]);
                        tmpL.add(nums[pR]);
                        res.add(tmpL);
                        while(pL<pR&&nums[pL]==nums[pL+1]) pL++;
                        while(pL<pR&&nums[pR]==nums[pR-1]) pR--;
                        pL++;
                        pR--;
                    } else if(nums[pL]+nums[pR]>-nums[i]) pR--;
                    else pL++;
                }
                
            }
            
        }
        
        return res;
        
        
    }

}
