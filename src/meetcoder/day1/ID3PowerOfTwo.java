package meetcoder.day1;

public class ID3PowerOfTwo {

	public static void main(String[] args) {

	}
	
	public static boolean isPowerOfTwo3(int n) {
		//best answer
		//n==(n&-n) -n in two's complement is the inverse +1
		//e.g.
		//n    0000010000...0
		//-n   1111110000...0
		//n&-n 0000010000...0
		
		if(n==0) return false;
		return n==(n&-n);
		
	}
	
	
	public static boolean isPowerOfTwo(int n) {
		//2nd idea bit wise
		
		if(n<=0) return false;
		
		int n1= n;
		int n2 = 1;
		while(n1!=1) {
			n1 = n1>>1;
			n2 = n2<<1;
		}
		return((n2^n) == 0);
				
	}
	
	public static boolean isPowerOfTwo2(int n) {
		//1st idea recursion
		
		if(n<=0) return false;
		
		if(n==1) return true;
		if(n%2==0) return (isPowerOfTwo(n));
		else return false;		
	}
	
	

}
