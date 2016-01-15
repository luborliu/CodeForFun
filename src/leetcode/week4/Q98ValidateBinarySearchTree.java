package leetcode.week4;

public class Q98ValidateBinarySearchTree {
	
	//做这个题的时候想起来tail-recursion的问题了，though for this question, it cannot be converted to tail-recursion
	//careful when doing other recursive questions, use tail-recursion at your best
	public boolean isValidBST(TreeNode root) {
        
        return bstHelper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    
    //here the corner case is Integer.MAX_VALUE and Integer.MIN_VALUE
    //to handle it, we use Long, the comparison will be automatically done without explicitly type conversion
    private boolean bstHelper(TreeNode root, long max, long min) {
        if(root==null) return true;
        if(root.val<=min||root.val>=max) return false;
        
        return bstHelper(root.left, root.val,min)&&bstHelper(root.right,max,root.val);
    }

}
