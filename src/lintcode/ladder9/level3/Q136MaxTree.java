package lintcode.ladder9.level3;

import java.util.Stack;

public class Q136MaxTree {
	
	/**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        
        if(A==null||A.length==0) return null;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        // stack stores all left branches && every 'root' node of the branch 
        // must have a decreasing trend
        // then finally, we only need to pop all the 'roots' to make stack.pop().right = curRoot (poped before)
        //一个条件，保证stack里存的root们单调递减
        //如果无法保证，就把stack.pop()作为新node的left child，而新node的原来的left child作为stack.pop()的right child
        //this is really tricky! 把p.right = iNode.left&&iNode.left=p 这个很聪明啊, better than 9chapter solution
        
        //stack.push(new TreeNode(A[0]));
        
        for(int i=0; i<A.length; i++) {
            
            TreeNode iNode = new TreeNode(A[i]);
            while(!stack.isEmpty()) {
                TreeNode p = stack.pop();
                if(p.val>iNode.val) {
                    stack.push(p);
                    stack.push(iNode);
                    break;
                } else {
                    p.right = iNode.left;
                    iNode.left = p;
                    //stack.push(iNode);
                }
            }
            if(stack.isEmpty()) stack.push(iNode);
            
        }
        TreeNode res = stack.pop();
        
        while(!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            tmp.right = res;
            res = tmp;
        }
        return res;  
        
    }
    
    class TreeNode {
    	public int val;
    	public TreeNode left, right;
    	public TreeNode(int val) {
    		this.val = val;
    		this.left = this.right = null;
    	}
    }

}
