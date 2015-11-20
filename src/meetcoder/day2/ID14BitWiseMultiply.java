package meetcoder.day2;

public class ID14BitWiseMultiply {
	
	public static void main(String[] args) {
		
		long a = 10001;
		long b = a<<1;
		System.out.println((a&1)==0);
		
		System.out.println(aMultiplyb(6,3));
		System.out.println(10001L*330003L);
	}
	
	public static long aMultiplyb(int a,int b) {
		
		
		//this is always hard to me
		//need to first define ADD
		//then get multiply
		
		long x = (long)a;
		long y = (long)b;
		long res = 0;
		while(y!=0) {
			if((y&1)==1) res = add(x,res);
			x = x<<1;
			y = y>>1;		
		}
			
		return res;
	
	}
	
	private static long add(long a, long b) {
		
		long x = a;
		long y = b;
		
		while(x!=0) {
			x = a&b;
			y = a^b;
			a = x<<1;
			b = y;
		}
		return b;
	
	}

}
