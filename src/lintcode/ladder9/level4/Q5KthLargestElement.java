package lintcode.ladder9.level4;

public class Q5KthLargestElement {
	
	public static void main(String[] args) {
		int[] x = new int[]{9,3,2,4,8};
		
		int res = kthLargestElement(3,x);
		
	}
	
	public static int kthLargestElement(int k, int[] nums) {
        // write your code here
        
        
        //sort first O(nlogn)
        //Arrays.sort(nums);
        //return nums[nums.length-k];
        
        if(nums==null||k>nums.length) return 0;
        
        int curIndex = -1;
        int l = 0;
        int r = nums.length-1;
        while(curIndex!=k-1) {
            curIndex = partition(nums, l, r);
            if(curIndex>k-1) {
                r = curIndex-1;
            } else if(curIndex<k-1) {
                l = curIndex+1;
            }
        }
        
        return nums[curIndex];
        
    }
    
    //8 9 3 7 1 5 => 8 9 7 5 1 3 
    //return 3(index of 5 the pivot)
    private static int partition(int[] nums, int l, int r) {
       
        if(l==r) return l;
       
        int tmp = nums[r]; //choose nums[r] as pivot
        //from left to right, 
        
        int index = l;
        for(int i=l; i<r; i++) {
            if(nums[i]>=tmp) {
                swap(nums, i, index);
                index++;
            }
        }
        
        swap(nums, index, r);
        return index;
    }
    
    
    private static void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }

}
