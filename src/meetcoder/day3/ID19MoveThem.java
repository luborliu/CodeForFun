package meetcoder.day3;

public class ID19MoveThem {
	public static void main(String[] args) {
		String str = "a b c  d";
		char[] ar = str.toCharArray();
		moveThem(ar);
		System.out.println(new String(ar));
	}
	
	public static void moveThem(char [] s) {
		
		//a bit tricky, but can be easily done from right to left
		//two pointers
		
		if(s==null||s.length<2) return;
		
		int pR = s.length-1;
		int pL = s.length-2;
		
		while(pL>=0) {
			//pR tries to find the first space
			while(pR>0&&s[pR]!=' ') pR--; 
			if(pL>=pR) pL = pR-1;
			if(pL>=0&&s[pL]!=' ') {
				//swap
				s[pR] = s[pL];
				s[pL] = ' ';
			}
			pL--;
		}
		
		

	}

}
