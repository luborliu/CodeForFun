package meetcoder.day1;

public class ID4MaximizeIntegerBySwapping {
	
	public static void main(String[] args) {
		
		
		System.out.println(maximizeResult(124511));
		
	}
	
	public static int maximizeResult(int n) {
		
		String str = String.valueOf(n);
		char[] digits = str.toCharArray();
		int res = 0;
		for(int i=0; i<digits.length-1; i++) {
			for(int j=i+1; j<digits.length; j++) {
				swap(digits, i, j);
				res = Math.max(res, Integer.parseInt(String.valueOf(digits)));
				swap(digits, i, j);
			}
		}
		return res;
	}
	
	private static void swap(char[] digits, int p1, int p2) {
		char tmp = digits[p1];
		digits[p1] = digits[p2];
		digits[p2] = tmp;
	}
}
