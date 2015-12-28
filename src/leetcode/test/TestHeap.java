package leetcode.test;

import java.util.PriorityQueue;
import java.util.Queue;

public class TestHeap {
	
	//Heap in Java is implemented by PriorityQueue class

	//new PriorityQueue();
	//This creates a PriorityQueue with the default initial capacity (11) that orders its elements according to their natural ordering.
	
	
	// time complexity:
	// O(log(n)) time for the enqueing and dequeing methods (offer, poll, remove() and  add); 
	// linear time for the remove(Object) and contains(Object) methods; 
	// and constant time for the retrieval methods (peek,  element, and size).
	public static void main(String[] args) {
		
		Queue<Long> small = new PriorityQueue<Long>(); //min heap
		Queue<Long> large = new PriorityQueue<Long>(); //max heap
		
		small.offer(5L);
		small.offer(10L);
		small.offer(3L);
		
		System.out.println(small.peek());
		

	}

}
