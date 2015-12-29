package leetcode.week3;

public class Q319BulbSwitcher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}
	
	public int bulbSwitch(int n) {
        
        //classic math issue
        // the num which is perfect square num will be on
        // for any num N we know N=1*N or N=a*b where a!=b, then N will be toggled even times in total (including the very first time- turn all on)
        // then for num which N = x*x, it will be toggled odd times (1,N,x,other pairs) -> finally be on
        
        int count = 0;
        int i = 1;
        while(i*i<=n) {
            count++;
            i++;
        }
        return count;
        
    }

}
