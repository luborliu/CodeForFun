package meetcoder.day3;

public class ID18TwoMissingNumbers {
	
	public static void main(String[] args) {
		
		
		System.out.println(2^15);
		
		int[] res = missing2Numbers(new int[]{1,2,3,5,4,8,7,9});
		System.out.println(res[0]+ " "+ res[1]);
		
		int x = 10;
		System.out.println( x &(~(x-1)));
	}
	
	
	//http://stackoverflow.com/questions/20026243/find-2-missing-numbers-in-an-array-of-integers-with-two-missing-values
	//this can be sovled with only XOR and & operations, no sums
	//xor：相同为0 不同为1
	//假设丢失的两个数字为a 和 b
	//如果可以找到a^b 的最右边的第一个1，即表示： a的那个bit==1 b的那个bit==0 (或者相反)
	//由此就可以把原数组分成两batches, 那个bit==1 or 那个bit==0
	
	
	public static int[] missing2Numbers(int[] a) {
		
		int[] res = new int[2];
		int len = a.length;
		
		int xor = 0;
		
		//xor all the numbers in the array and all the numbers from 1 to N
		for(int i=0; i<len; i++) {
			
			xor ^= a[i];
			xor ^= i+1;
		}
		xor ^= (len+2)^(len+1);
		
		//find the right most 1-bit set
		//e.g. 1000110 => 10
		//	   100010000 =>10000
		
		int oneBitSet = xor&(~(xor-1));
		
		int x = 0;
		int y = 0;
		for(int i=0; i<len; i++) {
			//the bit == 1
			if((oneBitSet&a[i])==oneBitSet) {
				x ^= a[i];
			} else {
				//the bit == 0
				y ^= a[i];
			}
		}
		for(int j=1; j<=len+2; j++) {
			if((oneBitSet&j)==oneBitSet) {
				x ^= j;
			} else {
				y ^= j;
			}
		}
		
		if(x>y) {
			res[0] = y;
			res[1] = x;
		} else {
			res[0] = x;
			res[1] = y;
		}
		return res;
	}
	
	
	
	
	
	
	
	//this cannot AC
	public static int[] missing2Numbers2(int [] a) {
		
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
