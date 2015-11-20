package meetcoder.day2;

public class ID17CountOnes {

	public static void main(String[] args) {

	}
	
	public int count1(int x) {
		
		//why the question is easier and easier, this should be the first, 
		//then the previous, then the plus, then the multiply...
		int count = 0;
		while(x!=0) {
			if((x&1)==1) count++;
			x = x>>1;
		}
		return count;	
    }

}
