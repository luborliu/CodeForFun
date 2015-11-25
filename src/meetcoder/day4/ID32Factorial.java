package meetcoder.day4;

public class ID32Factorial {
	
		public static void main(String[] args) {
			
			long n = 1000000;
			n = 11;
			System.out.println(findM(n));
			
		}
		
		
		public static long findM(long n) {
			//this answer might be not the best
		
			//find the upper bound first
			long i = 0;
			while(trailingZerosOfFactorial((long)Math.pow(2,i))<n) i++;
			long upper = (long)Math.pow(2,i);
			
			long lower = 0;		
			long mid = 0;
			
			while(lower<upper) {
				mid = (lower+upper)/2;
				long trailingCount = trailingZerosOfFactorial(mid);
				if(trailingCount<n) lower=mid+1;
				else if(trailingCount>=n) upper = mid;		
				//come one!! it can of course be greater than N, we use pow(2,n) to find upper bound
				//the trailing zeros of pow(2,n)'s factorial can be more than n, so the the value smaller than upper bound can also have 
				//more trailing zeros than n
			}
			return lower;
		
		}
		
		
		public static long trailingZerosOfFactorial(long n) {
		
			long num = 0;
			long base = 5;
			while(n/base>0) {
				num += n/base;
				base *= 5;
			}
			return num;
		}
		
		
	

}
