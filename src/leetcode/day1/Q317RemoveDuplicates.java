package leetcode.day1;

import java.util.Stack;

public class Q317RemoveDuplicates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(removeDuplicateLetters("ccacbaba"));

		System.out.println(removeDuplicateLetters("cbacdcbc"));
	}
	
	public static String removeDuplicateLetters(String s) {
        
        // idea from discussion
        // use stack
        
        boolean[] inStack = new boolean[26];
        int[] count = new int[26];
        
        for(int i=0; i<s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }
        
        Stack<Character> stack = new Stack<Character>();
        
        //go through the string
        int i=0;
        while(i<s.length()) {
            char c = s.charAt(i);
            int cIndex = c-'a';
            if(stack.isEmpty()||(c>stack.peek()&&!inStack[cIndex])) {
                stack.push(c);
                inStack[cIndex] = true;
                count[cIndex]--;
                i++;
            } else if(c<stack.peek()&&!inStack[cIndex]) { //pop
                if(count[stack.peek()-'a']>0) {
                    char tmp = stack.pop();
                    inStack[tmp-'a']=false;
                } else {                   
                    stack.push(c);
                    inStack[cIndex] = true;
                    count[cIndex]--;
                    i++;
                }
                
            } else {
                count[cIndex]--;
                i++;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString();
    }

}
