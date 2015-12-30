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
		//put(k,v) method returns 
		//the previous value associated with key, or null if there was no mapping for key. (A null return can also indicate that the map previously associated null with key.)
		
		HashMap h = new HashMap();
		h.put("s", 1);
		h.put("st", 3);
		
		h.remove("s");
		
		h.size();
		
		
		for(int i:ids) {
			
		}
	}

}
