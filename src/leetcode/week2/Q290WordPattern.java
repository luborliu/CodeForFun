package leetcode.week2;

import java.util.HashMap;
import java.util.HashSet;

public class Q290WordPattern {

	public boolean wordPattern(String pattern, String str) {
        
        //easy to handle with a hashmap
        
        HashMap<Character,String> hm = new HashMap<Character,String>();
        String[] strArr = str.split(" ");
        
        if(pattern.length()!=strArr.length) return false;
        for(int i=0; i<pattern.length(); i++) {
            Character c = pattern.charAt(i);
            String s = strArr[i];
            if(hm.containsKey(c)) {
                if(!hm.get(c).equals(s)) return false;
            } else {
                hm.put(c,s);
            }
        }
        
        //use hashset to see if there is duplicate key-value pairs in the hashmap
        //e.g. a->dog, b->dog
        HashSet<String> hs = new HashSet<String>();
        for(Character c: hm.keySet()) {
            if(hs.contains(hm.get(c))) return false;
            else hs.add(hm.get(c));
        }
        
        return true;
    }
}
