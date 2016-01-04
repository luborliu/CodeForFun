package leetcode.week3;

public class Q242ValidAnagram {
	
	//follow up: how to handle unicode????? noideayet
	public boolean isAnagram(String s, String t) {
        if(s==null||t==null) return false;
        if(s.length()!=t.length()) return false;
        
        //two array
        int[] count = new int[26];
        
        for(int i=0; i<s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }
        for(int i=0; i<t.length(); i++) {
            if(--count[t.charAt(i)-'a']<0) return false;
        }
        return true;
        
    }

}
