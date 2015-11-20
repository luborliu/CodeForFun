package meetcoder.day2;

public class ID16CountConversions {

	public static void main(String[] args) {

	}
	
	public int countConversions(int x,int y) {
		
		//XOR first
		//then use &1 and >> operations to count how many 1s there are
		
		int z = x^y; //the number of 1s is the result we need
		int count = 0;
		while(z!=0) {
			if((z&1)==1) count++;
			z = z>>1;
		}
		return count;
        }

}
