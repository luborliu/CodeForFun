package leetcode.week2;

public class Q306AddictiveNumber {

	public static void main(String[] args) {

		String s1 = "112358";
		String s = "198019823962";
		String s2 = "8917";
		String s3 = "211738";
		String s4 = "12012122436";
		System.out.print(isAdditiveNumber(s4));
		
		
		//unit test
		System.out.println(plusTwoStrings("117", "3"));		
	}
	
	
	 public static boolean isAdditiveNumber(String num) {
	        
	        //1st idea: dfs
	        if(num.length()<3) return false;
	        
	        for(int i=1; i<num.length()-1; i++) {//can be optimized
	            for(int j=i+1; j<num.length(); j++) {
	                if(isAddictiveHelper(num, 0, i ,j)) return true;
	            }
	        }
	        return false;
	    }
	    
	    
	 private static boolean isAddictiveHelper(String num, int index, int mid_index, int lst_index) {
	        
	        if(mid_index-index>1&&num.charAt(index)=='0') return false;
	        if(lst_index-mid_index>1&&num.charAt(mid_index)=='0') return false;
	        
	        String num1 = num.substring(index,mid_index);
	        String num2 = num.substring(mid_index,lst_index);
	        
	        String sumStr = plusTwoStrings(num1,num2);
	        
	        if(sumStr.length()+lst_index>num.length()) return false;
	        
	        String followingStr = num.substring(lst_index,sumStr.length()+lst_index);
	        if(followingStr.equals(sumStr)) {
	            if(lst_index+sumStr.length()==num.length()) return true;
	            return isAddictiveHelper(num,mid_index,lst_index,sumStr.length()+lst_index);
	        }
	        else return false;
	    }
	    
	    
	     private static String plusTwoStrings(String x, String y) {
	    	StringBuilder sb = new StringBuilder();
	    	
	    	String a = new StringBuilder(x).reverse().toString();
	    	String b = new StringBuilder(y).reverse().toString();
	    	
	    	int cur = 0; //补位
	    	int i = 0;
	    	
	    	while(i<a.length()||i<b.length()) {
	    	    int sum = 0;
	    	    if(i>=a.length()) sum = b.charAt(i)+cur-'0';
	    	    else if(i>=b.length()) sum = a.charAt(i)+cur-'0';
		    	else  sum = a.charAt(i)+b.charAt(i)-2*'0'+cur;
		    	
	    		if(sum>9) {
	    			cur =1;
	    			sum = sum-10;
	    		} else cur = 0;
	    		sb.insert(0,sum);
	    		i++;
	    	}
	    	if(cur==1) sb.insert(0,cur);
	    	return sb.toString();
		}

}
