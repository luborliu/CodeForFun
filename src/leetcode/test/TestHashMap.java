package leetcode.test;

import java.util.HashMap;
import java.util.Set;

public class TestHashMap {
	
	public static void main(String[] args) {
		
		
		
		
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		System.out.println(hm==null);
		Set<Integer> ids = hm.keySet();
		
		hm.containsKey(1);
		hm.put(1, 1);
		for(int i:ids) {
			
		}
	}

}
