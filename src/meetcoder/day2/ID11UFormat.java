package meetcoder.day2;

public class ID11UFormat {
	
	
    		
	public static void main(String[] args) {
		String[] output = uFormat("jf;kd");
		for(int i=0; i<output.length; i++) {
			System.out.println(output[i]);
		}
	}
	
	public static String[] uFormat(String s) {
    	//this is a math problem?
    	
    	//x>=(2+l)/3
    	//argmin((3x-l-2)/2)>=0 dandiaozeng
    	if(s==null||s.length()<=3) {
    		String[] res = new String[]{s};
    		return res;
    	}
    	
    	int len = s.length();
    	//bottom
    	int x = 0;
    	if((2+len)%3==0) x = (2+len)/3;
    	else x = (2+len)/3+1;
    	
    	//two sides
    	int n1 = (len-x+2)/2;
    	String[] res = new String[n1];
    	
    	for(int i=0; i<n1-1; i++) {
    		StringBuilder entry = new StringBuilder();
    		entry.append(s.charAt(i));
    		for(int j=0; j<x-2; j++) {
    			entry.append(" ");
    		}
    		entry.append(s.charAt(len-i-1));
    		res[i] = entry.toString();
    	}
    	res[n1-1] = s.substring(n1-1,len-n1+1);
    	
    	return res;
    }

}
