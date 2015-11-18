package meetcoder;

public class ID1ReadSumOfDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(readSum("123456789"));
		
		String[] s = new String []{"1"};
	}
	
	public static String readSum(String n) {
	
		String res = "";		
		String[] dict = new String[]{"zero","one","two","three","four","five","six","seven","eight","nine"};
				
		int sum = 0;
		
		for(int i=0; i<n.length(); i++) {
			
			sum += n.charAt(i)-'0';
		}
		
		String sumStr = String.valueOf(sum);
		
		for(int i=0; i<sumStr.length(); i++) {
			res += dict[sumStr.charAt(i)-'0'] + " ";
		}
		res = res.trim();
		return (res);
	}
//	public static String readSum(String n) {
//		
//		char[] digits = n.toCharArray();
//		int sum = 0;
//		
//		for(int i=0; i<digits.length; i++) {
//			sum += (digits[i]-'0');
//		}
//		String sumStr = String.valueOf(sum);
//		
//		String res = "";
//		
//		for(int i=0; i<sumStr.length(); i++) {
//			res += convertDigitToString(sumStr.charAt(i)) + " ";
//		}
//		res = res.trim();
//		
//		return(res);
//	}
//	
//	private static String convertDigitToString(char i) {
//		
//		String res = "";
//		
//		switch(i) {
//		case '0': 
//			res = "zero";
//			break;
//		case '1':
//			res = "one";
//			break;
//		case '2':
//			res = "two";
//			break;
//		case '3':
//			res = "three";
//			break;
//		case '4':
//			res = "four";
//			break;
//		case '5':
//			res= "five";
//			break;
//		case '6':
//			res = "six";
//			break;
//		case '7':
//			res = "seven";
//			break;
//		case '8':
//			res = "eight";
//			break;
//		case '9':
//			res = "nine";
//			break;
//		}
//		return res;
//		
//	}
//
}
