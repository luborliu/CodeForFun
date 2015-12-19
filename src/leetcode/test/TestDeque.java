package leetcode.test;

import java.util.ArrayDeque;
import java.util.Deque;

public class TestDeque {
	
	public static void main(String[] args) {
		
		Deque<Integer> d = new ArrayDeque<Integer>();
		
		//push will insert the element into front of the deque
		d.push(1);
		d.push(2);
		d.push(3);
		d.push(4);
		d.push(5);
		d.push(6);
		
		//add will insert the element into tail of the deque 
		d.add(100);
		d.add(1000);//equivalant to d.offer(1000);
		
		
		
		d.peekFirst(); //equivalant to d.peek();
		d.peekLast();
		
		d.pollFirst();
		d.pollLast();
	}

}
