package leetcode.test;

import java.util.HashSet;

public class TestHashSet {
	
	public static void main(String[] args) {
		
		//set.add() if the set already contains the element, won't add the element and return false
		
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(10);
		set.add(1);
		set.add(101);
		for(int i:set) {
			System.out.println(i);
			set.remove(i);
		}
		int[] nums = new int[]{7,1,2,4};
		for(int i:nums) {
			System.out.println(i);
			
		}
		
		HashSet<Integer> set2 = new HashSet<Integer>();
		set2.addAll(set);
		set2.removeAll(set);
	}

}
