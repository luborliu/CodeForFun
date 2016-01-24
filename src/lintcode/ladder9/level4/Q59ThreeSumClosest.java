package lintcode.ladder9.level4;

import java.util.Arrays;

public class Q59ThreeSumClosest {
	
	/**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        // write your code here
        
        //sort then two pointers
        Arrays.sort(numbers);
        int dif = Integer.MAX_VALUE;
        for(int i=0; i<numbers.length; i++) {
            int tmpTarget = target-numbers[i];
            int pL = i+1;
            int pR = numbers.length-1;
            while(pL<pR) {
                if(Math.abs(dif)>Math.abs(numbers[pL]+numbers[pR]-tmpTarget)) {
                    dif = numbers[pL]+numbers[pR]-tmpTarget;
                }
                if(numbers[pL]+numbers[pR]<tmpTarget) {
                    pL++;
                } else {
                    pR--;
                }
            }
            
        }
        return target+dif;
    }

}
