package leetcode.week1;

public class Q263UglyNumberI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isUgly(int num) {
		//non-recursion
        for (int i=2; i<6 && num>0; i++) {
        	while (num % i == 0) num /= i;
        }
        return num == 1;
    }
	 public boolean isUglyRec(int num) {
		 //recursion
		 if(num==0) return false;
		 if(num==1) return true;
	 
		 if(num%2==0) return(isUgly(num/2)); 
		 else if(num%3==0) return(isUgly(num/3));
		 else if(num%5==0) return(isUgly(num/5));
		 else return false;
	 }

}
