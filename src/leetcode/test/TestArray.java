package leetcode.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TestArray {
	
	public static void main(String[] args) {
		int[] x = new int[]{-15,4,-13,0,-8,-2,-1,8,3,-6,2,-12,-7,9,1,-11,13,10,-4,6,14,-3,-10,11,5,-14,-5};
		
		int len  = x.length;
		int key = 3;
		Arrays.binarySearch(x, 0, len, key);
		
		
		LinkedList<Integer>[][] memo;
		memo = new LinkedList[2][2];
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i:al) {
			
			
		}
	
		
		Arrays.sort(x);
		for(int i=0; i<x.length; i++) {
			System.out.println(x[i]);
		}
		
		
		
		int[][] arr = new int[2][4];
		arr[0] = new int[]{1,2,3,4};
		arr[1] = new int[]{2,3,4,5};
		
	}

}
