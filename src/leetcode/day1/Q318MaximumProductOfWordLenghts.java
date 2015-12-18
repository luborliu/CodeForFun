package leetcode.day1;

public class Q318MaximumProductOfWordLenghts {
	
	public static void main(String[] args) {
		
		
	}
	
	public int maxProduct(String[] words) {
        
        //idea from discussion
        //Pre-process the word, use bit to represent the words.
        //We can do this because we only need to compare if two words contains the same characters
        
        int[] bytes = new int[words.length];
        
        for(int i=0; i<words.length; i++) {
            int val = 0;
            for(int j=0; j<words[i].length(); j++) {
                val |= 1<<(words[i].charAt(j)-'a');
            }
            bytes[i] = val;
        }
        int max = 0;
        for(int i=0; i<bytes.length; i++) {
            for(int j=i+1; j<bytes.length; j++) {
                if((bytes[i]&bytes[j])==0) max=Math.max(max, words[i].length()*words[j].length());
            }
            
        }
        return max;
    }

}
