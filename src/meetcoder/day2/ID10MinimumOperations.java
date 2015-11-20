package meetcoder.day2;

public class ID10MinimumOperations {
	
	public int minimumOperations(String s) {
		 
	 	//two pointers??
	 	
	 	if(s==null) return 0;
	 	
	 	int p0 = 0;
	 	int p1 = s.length()-1; //pay attention to this, length()-1
	 	int count = 0;
	 	while(p0<p1) {
	 		char l = s.charAt(p0);
	 		char r = s.charAt(p1);
	 		count += Math.abs(l-r);	 		
	 		p0++;
	 		p1--;
	 	}
	 	return count;

        }

}
