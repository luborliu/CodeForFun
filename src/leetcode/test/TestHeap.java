package leetcode.test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import leetcode.test.TestCollections.Point;

public class TestHeap {
	
	//Heap in Java is implemented by PriorityQueue class

	//new PriorityQueue();
	//This creates a PriorityQueue with the default initial capacity (11) that orders its elements according to their natural ordering.
	
	
	// time complexity:
	// O(log(n)) time for the enqueing and dequeing methods (offer, poll, remove() and  add); 
	// linear time for the remove(Object) and contains(Object) methods;  this can be optimized using hash-heap to log(n)
	// and constant time for the retrieval methods (peek,  element, and size).
	public static void main(String[] args) {
		
		Queue<Long> small = new PriorityQueue<Long>(); //min heap
		Queue<Long> large = new PriorityQueue<Long>(); //max heap
		
		
		Queue<Point> large2 = new PriorityQueue<Point>(10, new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				//int time1 = p1.time;
				//int time2 = p2.time;
				//return time1-time2;
				return p1.time-p2.time;
			}
		});
		
		
		
		small.offer(5L);
		small.offer(10L);
		small.offer(3L);
		small.poll();
		
		System.out.println(small.peek());
		

	}

}
