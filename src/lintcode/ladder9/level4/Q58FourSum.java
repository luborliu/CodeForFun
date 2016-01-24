package lintcode.ladder9.level4;

import java.util.ArrayList;
import java.util.Arrays;

public class Q58FourSum {
	
	//corner case: there are duplicates
	
	/**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        /* your code */
        Arrays.sort(numbers);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        for(int i=0; i<numbers.length-3; i++) { //don't forget 'length-3'
            if(i!=0&&numbers[i]==numbers[i-1]) continue;
            
            for(int j=i+1; j<numbers.length-2; j++) {
                if(j!=i+1&&numbers[j]==numbers[j-1]) continue;
                int tmpTarget = target -(numbers[i]+numbers[j]);
                
                int l=j+1;
                int r = numbers.length-1;
                
                while(l<r) {
                    
                    if(numbers[l]+numbers[r]>tmpTarget) {
                        r--;
                    } else if(numbers[l]+numbers[r]<tmpTarget) {
                        l++;
                    } else {
                        ArrayList<Integer> tmpList = new ArrayList<Integer>();
                        tmpList.add(numbers[i]);
                        tmpList.add(numbers[j]);
                        tmpList.add(numbers[l]);
                        tmpList.add(numbers[r]);
                        res.add(tmpList);
                        l++;
                        r--;
                        while(l<r&&numbers[l]==numbers[l-1]) l++;
                        while(l<r&&numbers[r]==numbers[r+1]) r--;
                    }
                    
                }
                
            }
        }
        return res;
    }
	
	

}
