package leetcode.day1;

import java.util.ArrayList;
import java.util.List;

public class Q315CountOfSmallerNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = new int[]{5,2,6,1};
		List<Integer> al = countSmaller(nums);

		for(int i=0; i<al.size(); i++) {
			System.out.println(al.get(i));
		}
	}

	
	
	    
    public static List<Integer> countSmaller(int[] nums) {
	        
        //idea from discussion, bst! that's so brilliant idea
        //https://leetcode.com/discuss/73762/9ms-short-java-bst-solution-get-answer-when-building-bst
	        
    	List<Integer> res = new ArrayList<Integer>();
        if(nums==null||nums.length==0) return res;
	        
        int len = nums.length;
        Node root = new Node(nums[len-1],0);
        
        int[] ans = new int[len];
        
        for(int i=len-2; i>=0; i--) {
        	insertToBst(root,nums[i],ans,i,0);
    	}
	        
        for(int j=0; j<len; j++) {
            res.add(ans[j]);
        }
        return res;
    }
	    
	    
	    public static Node insertToBst(Node root, int num, int[] ans, int index, int preSum) {
	        
	    	if(root==null) {
	            root = new Node(num,0);
	            ans[index] = preSum;
	        } else if(num==root.val) {
	            root.dup++;
	            ans[index]=preSum +root.sum; //this should be noted, not ignored. sum is recording # of nums in the left brunch
	        } else if(num<root.val) {
	            root.sum++;
	            root.left = insertToBst(root.left,num,ans,index,preSum);
	        } else if(num>root.val) {
	            preSum += (root.sum+root.dup);
	            root.right = insertToBst(root.right,num,ans,index,preSum);
	        }
	        return root;
	        
	    }
}
