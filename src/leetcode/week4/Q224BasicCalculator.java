package leetcode.week4;

import java.util.Stack;

public class Q224BasicCalculator {
	
	public int calculate(String s) {
        
        //the solution should not change s to string array which is not efficient
        //the solution should not store + - into stack
		
		//left parenthesis: start a new space, store the current level of variables in stack
		//each stack level contains a number and its following operator (+ or -)
        //in an active space, there are three variables: result (left hand side number), operator, curNum (right hand side number)
        
		Stack<Integer> stack = new Stack<Integer>();
        
        int curNum = 0;
        int result = 0;
        int sign = 1;  //this idea is genius, such that we no longer need to store parenthesis
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)==' ') continue;
            if(s.charAt(i)<='9'&&s.charAt(i)>='0') curNum = curNum*10+s.charAt(i)-'0';//s.t. no need to use string array
            if(s.charAt(i)=='+'||s.charAt(i)=='-') {
                result += curNum*sign;
                sign = s.charAt(i)=='+'?1:-1;
                curNum = 0;
            }
            if(s.charAt(i)=='(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }
            if(s.charAt(i)==')') {
                result += curNum*sign;
                curNum = 0;
                
                result *= stack.pop();
                result += stack.pop();
            }
        }
        
        if(curNum!=0) result += sign * curNum;
        return result;
        
    }

}
