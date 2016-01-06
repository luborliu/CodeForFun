package A.test;

public class DebugTest {
	
	
	
	public static void main(String[] args) {
		printPattern();
	}




	public static void printPattern() {
	
		char ch = 'a';
		char print = ch;
		for(int i=0; i<10; i++) {
		  System.out.print((print++));
		}
		System.out.println("");
	
	}

}