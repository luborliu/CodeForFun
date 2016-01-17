package leetcode.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(12);
		al.add(134);
		al.add(3);
		Collections.sort(al);
		
		ArrayList<List<Integer>> all = new ArrayList<List<Integer>>();
		System.out.println(all.isEmpty());
		
		for(int i: al) {
			System.out.println(i);
		}
	}

}
