package leetcode.week2;

import java.util.Iterator;

public class Q284PeekingIterator implements Iterator<Integer>{
	Iterator<Integer> it;
    //boolean hasNext;
    //int next;
    Integer next;

	public Q284PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.it = iterator;
	    //this.hasNext = iterator.hasNext();
	    if(iterator.hasNext()) this.next = iterator.next();
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return this.next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int res = this.next;
        if(it.hasNext()) {
            this.next = this.it.next();
            //this.hasNext = true;
        } else this.next = null;//this.hasNext = false;
        return res;
	}

	@Override
	public boolean hasNext() {
	    return next!=null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
