package leetcode.week4;

import java.util.Stack;

public class Q277BasicCalculatorII {
	
	public static void main(String[] args) {
		//String a = "3+2*2";
		String a = "0-2147483647";
		System.out.println(calculate(a));
	}
	
	
	public static int calculate(String s) {
        
        // a much better idea as follows, borrowed from the hottest discussion
        // and faster!!!
        char operator = '+';    //store the previous operator, initialized as +
        int curNum = 0;
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c<='9'&&c>='0') curNum = curNum*10 + c - '0';
            if(c=='+'||c=='-'||c=='*'||c=='/'||i==s.length()-1) {
                if(operator=='+') stack.push(curNum);
                if(operator=='-') stack.push(-curNum);
                if(operator=='*') stack.push(stack.pop()*curNum);
                if(operator=='/') stack.push(stack.pop()/curNum);
                operator = c;
                curNum = 0;         //why do you always forget this??
            }
        }
        
        
        //remove following in terms of code reuse
        // if(operator!='+') {
        //     if(operator=='-') curNum = -curNum;
        //     if(operator=='*') curNum = stack.pop()*curNum;
        //     if(operator=='/') curNum = stack.pop()/curNum;
        // }
        while(!stack.isEmpty()) curNum += stack.pop();
                
        return curNum;
    }
	
	public static int calculateUgly(String s) {
        
        //after coding calculatorI, thought was narrowed
        //????????????????????????????????????AC??????????????????
		
        char operator = ' ';
        Stack<Integer> stack = new Stack<Integer>();
        int result = 0;
        int curNum = 0;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c<='9'&&c>='0') curNum = curNum*10+c-'0';
            else if(c=='+'||c=='-'||c=='*'||c=='/') {
                if(operator=='*') result *= curNum;
                else if(operator=='/') result /= curNum;
                else result = curNum;
                operator = c;
                curNum = 0;
                if(c=='+'||c=='-') {
                    if(!stack.isEmpty()) stack.push(stack.pop()*result+stack.pop());
                    else stack.push(result);
                    stack.push(c=='+'?1:-1);
                    result = 0;
                    operator = ' ';
                } 
             }
        }
        
        if(operator=='*') result *= curNum;
        if(operator=='/') result /= curNum;
        if(operator==' ') result = curNum;
        if(!stack.isEmpty()) result = stack.pop()*result+stack.pop();
                
        return result;
    }	

}
