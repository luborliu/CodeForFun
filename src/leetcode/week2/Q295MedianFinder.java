package leetcode.week2;

import java.util.PriorityQueue;
import java.util.Queue;

public class Q295MedianFinder {
	
	//use max and min heap for this question
    Queue<Long> minHeap = new PriorityQueue<Long>();
    Queue<Long> maxHeap = new PriorityQueue<Long>();

    // Adds a number into the data structure.
    public void addNum(int num) {
        
        minHeap.offer((long)num);
        if(minHeap.size()>maxHeap.size()) {
            maxHeap.offer(-minHeap.poll());
        }
        
        //exchange the two heap's top element if minHeap.peek()<(-maxHeap.peek())
        if(!minHeap.isEmpty()&&minHeap.peek()<(-maxHeap.peek())) {
            maxHeap.offer(-minHeap.poll());
            minHeap.offer(-maxHeap.poll());
        }
        
    }

    // Returns the median of current data stream
    public double findMedian() {
        
        //min value of the maxHeap
        //long minMax = -maxHeap.peek();
        //max value of the minHeap
        //long maxMin = minHeap.peek();
        
        if(maxHeap.size()>minHeap.size()) return (double)(-maxHeap.peek());
        else return -maxHeap.peek()/2.0+minHeap.peek()/2.0;
        
    }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Q295MedianFinder mf = new Q295MedianFinder();
		mf.addNum(2);
		System.out.print(mf.findMedian());
		mf.addNum(3);
		System.out.println(mf.findMedian());
		

	}

}
