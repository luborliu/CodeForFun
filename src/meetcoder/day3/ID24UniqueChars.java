package meetcoder.day3;

import java.util.Arrays;

public class ID24UniqueChars {
	
	public static void main(String[] args) {
		
		String s = "axdbs";
		char[] c = s.toCharArray();
		
		int n =45750630*5;
		int n2 = 228753150;
		System.out.println(n2/5);
		
		System.out.print(hasUniqueCharacters(c));
	}
	
	
	public static boolean hasUniqueCharacters(char[] str){
    	//sort first
    	//linear scan then
    	//do we need to consider lower or upper cases?
    	//nlogn
    	
    	if(str==null||str.length<=1) return true;
    	
    	Arrays.sort(str);
    	char cur = str[0];
    	for(int i=1; i<str.length; i++) {
    		if(str[i]==cur) return false;
    		else cur = str[i];
    	}
    	return true;

    }

}
