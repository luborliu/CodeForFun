package leetcode.week2;

public class Q299BullsAndCows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public String getHint(String secret, String guess) {
        
        //use a length-10 array to store the # of digits in secret
        //then one pass on guess
        //O(n) time and O(10)->O(1) space
        
        
        int[] digits = new int[10];
        for(int i=0; i<secret.length(); i++) {
            digits[secret.charAt(i)-'0']++;
        }
        
        int bullNum = 0;
        int cowNum = 0;
        for(int j=0; j<secret.length(); j++) {
            char s = secret.charAt(j);
            char g = guess.charAt(j);
            if(s==g) bullNum++;
            if(digits[g-'0']>0) {
                cowNum++;
                digits[g-'0']--;
            }
        }
        
        cowNum -= bullNum;
        return bullNum+"A"+cowNum+"B";
    }

}
