package leetcode.week2;

public class NumArray {
	//http://www.geeksforgeeks.org/segment-tree-set-1-sum-of-given-range/   
    // a pretty hard one! the following is to get O(logn) time complexity for both operations
    // use segmentation tree: new data structure to learn from here
    // segmentation tree is represented by an array A. A[i]'s left child is A[2*i+1] while right child is A[2*i+2]
    // total number of elements in array is 2*len-1 (len+(len-1)) because the tree is full binary tree
	// --len is the num of leaves and (len-1) is the num of internal nodes
	// --BUT we need to allocate more space for the array, becase we need to consider the tree as a complete(or perfect) tree
	// -- To calculate the space we can follow this:
	// --- -- height=Ceiling(log2(len))
	// --- -- size = 2*2^height-1;
    
    int[] tree = null;
    int[] arr = null;   //store nums array
    
    public NumArray(int[] nums) {
        
        if(nums==null||nums.length==0) return;
        
        int len = nums.length;
        //Height of segment tree
        int h = (int) (Math.ceil(Math.log(len) / Math.log(2)));
        //maximum size of the tree
        int max_size = 2*(int)Math.pow(2,h)-1;
        this.tree = new int[max_size];
        this.arr = new int[len];
        for(int i=0; i<nums.length; i++) this.arr[i]=nums[i];
        
        buildSegmentationTree(this.tree,0,nums,0,len-1);
    }
    
    private int buildSegmentationTree(int[] tree, int curIndex, int[] nums, int left, int right) {
        if(left==right) {
            tree[curIndex]=nums[left];
            return tree[curIndex];
        }
        
        //else
        int mid = (left+right)/2;
        tree[curIndex] = buildSegmentationTree(tree,curIndex*2+1,nums,left,mid)     //left child
                         + buildSegmentationTree(tree,curIndex*2+2,nums,mid+1,right);   //right child
        return tree[curIndex];
        
    }

    void update(int i, int val) {
        int dif = val-this.arr[i];
        if(dif!=0) {
            upd(i,dif,this.tree,0,0,this.arr.length-1);
        }
        this.arr[i] += dif;
    }
    
    private void upd(int i, int dif, int[] tree, int curIndex, int curL, int curR) {
//        if(curL<=i&&curR>=i) tree[curIndex]+=dif;
//        else return;		//please do not forget this condition!!!!!        
//        if(curL==curR) return;
        
    	if(curL>i||curR<i) return;
    	tree[curIndex] += dif;
    	if(curL==curR) return;
    	
        int mid = (curL+curR)/2;
        //update left child
        upd(i,dif,tree,curIndex*2+1,curL,mid);
        //update right child
        upd(i,dif,tree,curIndex*2+2,mid+1,curR);
    }

    public int sumRange(int i, int j) {
        
        return sumRangeHelper(i,j,this.tree,0,0,this.arr.length-1);
    }
    
    private int sumRangeHelper(int i, int j, int[] tree, int curIndex, int curL, int curR) {
        if(curL==i&&curR==j) return tree[curIndex];
        int mid = (curL+curR)/2;
        int leftSum = 0;
        int rightSum = 0;
        if(i<=mid) {
            leftSum = sumRangeHelper(i,Math.min(j,mid),tree,curIndex*2+1,curL,mid);
        }
        if(j>=mid+1) {
            rightSum = sumRangeHelper(Math.max(i,mid+1),j,tree,curIndex*2+2,mid+1,curR);
        }
        
        return (leftSum+rightSum);
        
    }
    
    
    public static void main(String[] args) {
    	int[] test = new int[]{0,9,5,7,3};
    	NumArray n = new NumArray(test);
    	n.update(1, 7);
    	//n.update(3, 8);
    	System.out.println(n.sumRange(1, 2));
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);