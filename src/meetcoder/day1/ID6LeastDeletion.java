package meetcoder.day1;

public class ID6LeastDeletion {
	
	public int leastDeletion(String s) {
		
		//is there anything tricky??
		if(s==null||s.length()<=1) return 0;
		int count =0;
		char cur = s.charAt(0);
		for(int i=1; i<s.length(); i++) {
			if(s.charAt(i)==cur) count++;
			else {
				cur = s.charAt(i);				
			}
		}
		return count;

        }

}
