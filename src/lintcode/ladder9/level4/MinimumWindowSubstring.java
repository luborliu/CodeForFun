package lintcode.ladder9.level4;

public class MinimumWindowSubstring {
	
	public static void main(String[] args) {
		//minWindow("","a=");
	}
  	
	/**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        // write your code
        
        int[] tHash = new int[256]; //need to consider all the ascii, like &(1243)abdAWEFG
        int[] sHash = new int[256];
        
        for(int i=0; i<target.length(); i++) {
            tHash[target.charAt(i)]++;
        }
        int leftIndex = 0;
        int rightIndex = Integer.MAX_VALUE;
        
        boolean flag = false;
        
        int p0 = 0;
        int p1 = 0;
        while(p1<source.length()) {
            sHash[source.charAt(p1)]++;
            while(p0<=p1&&isValid(sHash, tHash)) {
                if(p1-p0<rightIndex-leftIndex) {
                    leftIndex = p0;
                    rightIndex = p1;
                    flag = true;
                }
                sHash[source.charAt(p0)]--;
                p0++;
            }
            p1++;
        }
        if(!flag) return "";
        return source.substring(leftIndex, rightIndex+1);
        
    }
    
    private boolean isValid(int[] sHash, int[] tHash) {
        for(int i=0; i<256; i++) {
            if(sHash[i]<tHash[i]) return false;
        }
        return true;
    }

}
