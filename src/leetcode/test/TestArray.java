package leetcode.test;

import java.util.Arrays;

public class TestArray {
	
	public static void main(String[] args) {
		int[] x = new int[]{1,2,3};
		
		int len  = x.length;
		int key = 3;
		Arrays.binarySearch(x, 0, len, key);

	}

}
