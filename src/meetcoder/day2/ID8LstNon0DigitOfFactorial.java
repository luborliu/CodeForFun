package meetcoder.day2;

public class ID8LstNon0DigitOfFactorial {
	
	public static void main(String[] args) {
		System.out.println(lastDigit(9987));
		
		//System.out.println(powerOfTwo(3));
	}
	
	//inspired by
	//http://www.campusgate.co.in/2013/10/finding-right-most-non-zero-digit-of.html
	
	public static int lastDigit(int n) {

		if(n==0) return 1;
		if(n<=2) return n;
		if(n==3) return 6;
		if(n==4) return 4;
				
		int closestNum = n/5*5;
		int reminder = n-closestNum;
		
		//(n/5)! * 2^(n/5)
		int lstDigit = (lastDigit(closestNum/5)* (lstDigitOfPower(closestNum/5)%10) *lastDigit(reminder) )%10 ;
			
		return lstDigit;
        }
        
        //to prevent from too big pow
	public static int lstDigitOfPower( int pow) {	
		
		
		int[] table = new int[]{6,2,4,8};
		if(pow==0) return 1;
		if(pow<3) return table[pow];
		return table[pow%4];
		
		
	}
}
