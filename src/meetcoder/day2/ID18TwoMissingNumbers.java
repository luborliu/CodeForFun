package meetcoder.day2;

public class ID18TwoMissingNumbers {
	
	public static void main(String[] args) {
		
		
		System.out.println(2^15);
		
		int[] res = missing2Numbers(new int[]{1,2,3,5,4,8,7,9});
		System.out.println(res[0]+ " "+ res[1]);
		
		int x = 10;
		System.out.println( x &(~(x-1)));
	}
	
	
	
	//this cannot AC
	public static int[] missing2Numbers(int [] a) {
		
		//binary linear equations
				// sum of 1...n
				// XOR
				if(a==null||a.length<1) return null;
				
				int[] res = new int[2];
				
				int n = a.length + 2;
				
				long remainder = 0;
				int xorA = 0;
				for(int i=0; i<a.length; i++) {
					remainder += (long)i+1-(long)a[i];
					xorA = xorA ^ a[i] ^(i+1);
				}
				remainder += (long)n+(long)n-1;
				xorA = xorA^(n-1)^(n);
				
				for(int j=1; j<n; j++) {
					int m = xorA^j;
					if(((long)m+(long)j)==remainder&&m<=n) {
						res[0] = j;
						res[1] = m;
						break;
					}
				}
				return res;
	}
}
