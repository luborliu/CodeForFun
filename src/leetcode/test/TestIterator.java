package leetcode.test;

import java.util.Iterator;

public class TestIterator implements Iterator<Integer>{
	
	
	
	public TestIterator(Iterator<Integer> it) {
		
		it.next();
		it.hasNext();
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
