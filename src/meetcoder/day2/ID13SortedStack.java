package meetcoder.day2;

import java.util.Stack;

public class ID13SortedStack {
	
	public Stack<Integer> sortStack(Stack<Integer> s) {
		
		//O(n^2)
		Stack<Integer> helperStack = new Stack<Integer>();		
						
		int size = s.size();
		
		while(size>0) {
			int index = 0;
			int max = Integer.MIN_VALUE;
			int count = 0;
			while(!s.isEmpty()) {
				int tmp = s.pop();
				count++;
				if(tmp>max) {
				   max = tmp;
				   index = count;
				}
				helperStack.push(tmp);
			}
			int tmp2 = 0;
			while(count!=0) {
				if(count==index) {
				    tmp2 = helperStack.pop();
				    count--;
				    continue;
				}
				count--;
				s.push(helperStack.pop());
			}
			helperStack.push(tmp2);
			size--;
		}
		
		while(!helperStack.isEmpty()) {
			s.push(helperStack.pop());
		}
		return s;
		

        }

}
