package lintcode.ladder9.level4;

import java.util.HashMap;

public class Q56TwoSum {
	
	public static void main(String[] args) {
		
		int[] a = new int[]{2,7,11,15};
		int[] res = twoSum(a, 9);
		System.out.println(res[0]+ " -" + res[1]);
	}
	
	/*
     * @param numbers : An array of Integer
     * @param target : target = numbers[index1] + numbers[index2]
     * @return : [index1 + 1, index2 + 1] (index1 < index2)
     */
    public static int[] twoSum(int[] numbers, int target) {
        // write your code here
        
        //hm: val, index
        HashMap<Integer,Integer> hm  = new HashMap<Integer,Integer>();
        int[] res = new int[2];
        for(int i=0; i<numbers.length; i++) {
            if(hm.containsKey(target-numbers[i])) {
                res[0] = hm.get(target-numbers[i])+1;
                res[1] = i+1;
                break;
            } else hm.put(numbers[i],i);
        }
        
        return res;
    }

}
