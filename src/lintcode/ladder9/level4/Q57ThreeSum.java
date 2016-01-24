package lintcode.ladder9.level4;

import java.util.ArrayList;
import java.util.Arrays;

public class Q57ThreeSum {
	
	/**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        Arrays.sort(numbers);
        
        for(int i=0; i<numbers.length-2; i++) {
            
            if(i>0&&numbers[i]==numbers[i-1]) continue;
            
            int tmpTarget = -numbers[i];
            int l = i+1;
            int r = numbers.length-1;
            
            while(l<r) {
                
                if(numbers[l]+numbers[r]<tmpTarget) {
                    l++;
                } else if(numbers[l]+numbers[r]>tmpTarget) {
                    r--;
                } else {
                    ArrayList<Integer> tmpL = new ArrayList<Integer>();
                    tmpL.add(numbers[i]);
                    tmpL.add(numbers[l]);
                    tmpL.add(numbers[r]);
                    res.add(tmpL);
                    l++;
                    r--;
                    while(l<r&&numbers[l]==numbers[l-1]) l++;
                    while(l<r&&numbers[r]==numbers[r+1]) r--;
                }
            }
            
        }
        return res;
        
    }

}
