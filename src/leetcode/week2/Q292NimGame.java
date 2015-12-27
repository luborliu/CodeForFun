package leetcode.week2;

public class Q292NimGame {
	
	public boolean canWinNim(int n) {
        
        //this is a math problem
		//as long as it is a multiple of 4, I (the guy who start the game) cannot win
        return n%4!=0;
        
    }

}
