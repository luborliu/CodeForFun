package meetcoder.day3;

public class ID30CountTrailingZerioOfFactorial {
	
	public int countTrailingZeros(int n) {
		
		//this is easy to ignore the situations of 25, 125, 5*5*5*5.....		
		//return n/5;
		
		//so the right answer should be :
		
		int count = 0;
		int base = 5;
		
		while(n/base!=0) {
			count += n/base;
			base *= 5;
		}
		return count;

        }

}
