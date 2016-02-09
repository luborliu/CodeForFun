package lintcode.ladder9.level4;

public class Q399NutsAndBoltsProblem {
	
	/**
	 * public class NBCompare {
	 *     public int cmp(String a, String b);
	 * }
	 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
	 * if "a" is bigger than "b", it will return 1, else if they are equal,
	 * it will return 0, else if "a" is smaller than "b", it will return -1.
	 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
	*/
	public class Solution {
	    /**
	     * @param nuts: an array of integers
	     * @param bolts: an array of integers
	     * @param compare: a instance of Comparator
	     * @return: nothing
	     */
	    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
	        // write your code here
	        
	        //basically this is doing sorting
	        //here we use quick-sorting
	        
	        if(nuts==null||bolts==null||nuts.length!=bolts.length) return;
	        
	        sortHelper(nuts, bolts, compare, 0, nuts.length-1);
	        
	        
	        
	    }
	    
	    private void sortHelper(String[] nuts, String[] bolts, NBComparator compare, int l, int r) {
	        
	        if(l>=r) return;
	        
	        int pivot = partition(nuts, bolts[r], l, r, compare);
	        partition(bolts, nuts[pivot], l, r, compare);
	        
	        sortHelper(nuts, bolts, compare, l, pivot-1);
	        sortHelper(nuts, bolts, compare, pivot+1, r);
	        
	    }
	    
	    private int partition(String[] str, String pivot, int l, int r, NBComparator compare ) {
	        
	        //partition nuts first
	        
	        int index = l;
	        
	        for(int i=l; i<r; i++) {
	            //following comparison needs to be carefull, first one is -1 while second is +1
	           if(compare.cmp(str[i],pivot)==-1 || compare.cmp(pivot, str[i])==1) {
	               swap(str, index, i);
	               index++;
	           } else if(compare.cmp(str[i],pivot)==0 || compare.cmp(pivot, str[i])==0){
	               //swap it with the rightmost one
	               swap(str, i, r);
	               i--;    //so this cannot handle duplicate case
	           }
	            
	        }
	        
	        swap(str, index, r);
	        return index;
	    }
	    
	    private void swap(String[] s, int l, int r) {
	        String tmp = s[l];
	        s[l] = s[r];
	        s[r] = tmp;
	    }
	    
	};

}
