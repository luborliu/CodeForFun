package leetcode.week3;

import java.util.HashSet;
import java.util.Set;

public class Q127WordLadder {
	
	
	public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {
	    
        //geiguile!!!!! two-end bfs
        //之前one-end一年前也可以过，现在不行了。。
        //
        //同时要用 hashMap to store distance so far 
        // and use a-z to search for if a neighbor word exists in the wordList, this will optimize the search time complexity from O(n) to O(k*26)
        
        //two integers to store two directions' steps
        //if(beginWord.equals(endWord)) return 1;
        
        int step = 2;
        Set<String> beginSet = new HashSet<String>();
        Set<String> endSet = new HashSet<String>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        boolean flag = true; //true from begin, false from end
        while(!wordList.isEmpty()&&(!beginSet.isEmpty()||!endSet.isEmpty())) {
            
            // Set<String> tmpSet1 = null;
            // Set<String> tmpSet2 = null;
            // if(flag) {
            //     tmpSet1 = endSet;
            //     tmpSet2 = beginSet;
            // }
            // else {
            //     tmpSet1 = beginSet;
            //     tmpSet2 = endSet;
            // }
            
            Set<String> tmpSet1 = flag? endSet:beginSet; // to make it more concise
            Set<String> tmpSet2 = flag? beginSet:endSet;
            
            Set<String> next = new HashSet<String>();
            
            for(String tmp:tmpSet2) {
                for(int i=0; i<tmp.length(); i++) {
                    for(char c='a'; c<='z'; c++) {
                        if(c!=tmp.charAt(i)) {
                            //String nStr = tmp.substring(0,i)+c+tmp.substring(i+1,tmp.length());
                            StringBuilder sb = new StringBuilder(tmp); //this can optimize the time from 165ms to 106ms
                            sb.setCharAt(i,c);
                            String nStr = sb.toString();
                            if(tmpSet1.contains(nStr)) return step;
                            else if(wordList.contains(nStr)) {
                                next.add(nStr);
                                wordList.remove(nStr);
                            } 
                        }
                    }
                }
            }
            if(flag) beginSet = next;
            else endSet = next;
            step++;
            flag = !flag;
        }
        return 0;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String b = "a";
		String e = "c";
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");
		set.add("c");
		ladderLength(b, e, set);

	}

}
