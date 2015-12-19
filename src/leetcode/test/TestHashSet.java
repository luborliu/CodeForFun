package leetcode.test;

import java.util.HashSet;

public class TestHashSet {
	
	public static void main(String[] args) {
		
		HashSet<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(10);
		set.add(1);
		set.add(101);
		for(int i:set) {
			System.out.println(i);
		}
		int[] nums = new int[]{7,1,2,4};
		for(int i:nums) {
			System.out.println(i);
		}
	}

}
