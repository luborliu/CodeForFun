package meetcoder.day2;

public class ID15BitWiseAdd {
	
	//for the question as well as the ID14, I have to code once a day to remember this

	public static void main(String[] args) {
		
	}
	
	public static int aPlusB(int a, int b) {
		
		int x = a;
		int y = b;
		
		while(x!=0) {	//x!=0
			x = a&b; 	//找到需要进位的位
			y = a^b;	
			a = x<<1;
			b = y;			
		}
		
		return b;
	}
	
}
