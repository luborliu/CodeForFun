package leetcode.week3;

public class Q273IntegerToEnglishWords {
	
	//detailed question （细节题）
	private final String[] midDigitName = new String[]{"","Ten ","Twenty ","Thirty ","Forty ","Fifty ","Sixty ","Seventy ","Eighty ","Ninety "};
    //nums less than 20
	private final String[] names = new String[]{"","One ","Two ","Three ","Four ","Five ","Six ","Seven ","Eight ","Nine ","Ten ","Eleven ","Twelve ","Thirteen ","Fourteen ","Fifteen ","Sixteen ","Seventeen ","Eighteen ","Nineteen "};
	private final String[] units = new String[]{"","Thousand ","Million ","Billion "};
	
	public String numberToWords(int num) {
	    
	    if(num==0) return "Zero";  //corner case
	    
	    int k = 0;
	    StringBuilder sb = new StringBuilder();
	    while(num!=0) {
	        int part = num%1000;
	        if(part!=0) sb.insert(0,threeDigitToString(part)+units[k]);
	        num = num/1000;
	        k++;
	    }
	    
	    return sb.toString().trim();
	    
	}
	
	
	
	private String threeDigitToString(int num) {
	    int lstDigit = num%10;
	    int midDigit = (num/10)%10;
	    int firstDigit = num/100;
	    
	    StringBuilder sb = new StringBuilder();
	    
	    if(lstDigit==0) {
	        sb.append(midDigitName[midDigit]);
	    } else if(midDigit==1) {
	        sb.append(names[num%100]);
	    } else {
	        sb.append(midDigitName[midDigit]+names[lstDigit]);
	    }
	    if(firstDigit!=0) sb.insert(0,names[firstDigit]+"Hundred ");
	    
	    return sb.toString();
	}

}
