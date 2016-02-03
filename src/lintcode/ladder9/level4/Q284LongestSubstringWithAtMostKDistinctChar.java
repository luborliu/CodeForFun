package lintcode.ladder9.level4;

public class Q284LongestSubstringWithAtMostKDistinctChar {
	
	
	public static void main(String[] args) {
		String s = "eceba";
		int k =3;
		lengthOfLongestSubstringKDistinct(s, k);
		
	}
	
	/**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        
        if(k==0) return 0;
        
        int count = 0;
        int[] sHash = new int[256];
        int p0 = 0;
        int p1 = 0;
        
        int range = 0;
        
        while(p1<s.length()) {
            
            if(count<=k) {
                
                sHash[s.charAt(p1)]++;
                if(sHash[s.charAt(p1)]==1) count++;
                
                if(count<=k) range = Math.max(range,p1-p0+1);
                
                p1++;
            } else if(count>k&&p0<p1) {
                sHash[s.charAt(p0)]--;
                if(sHash[s.charAt(p0)]==0) count--;
                p0++;
            }
           
        }
        return range;
        
    }
	
	

}
