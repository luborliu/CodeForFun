package lintcode.ladder9.level4;

public class Q384LongestSubstringWithoutRepeatingCha {

	/**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        
        int[] sHash = new int[256];
        
        int len = 0;
        
        int l = 0;
        
        for(int i=0; i<s.length(); i++) {
            sHash[s.charAt(i)]++;
            while(sHash[s.charAt(i)]>1) {
                sHash[s.charAt(l)]--;
                l++;
            }
            len = Math.max(len, i-l+1);
        }
        return len;
        
    }
}
