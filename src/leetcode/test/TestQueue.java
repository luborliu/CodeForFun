package leetcode.test;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {
	public static void main(String[] args) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.peek();
		q.add(1);
		q.poll();
		q.offer(2); //better than add
		
		
	}

}
