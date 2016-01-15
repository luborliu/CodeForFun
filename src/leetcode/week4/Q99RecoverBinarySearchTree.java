package leetcode.week4;

public class Q99RecoverBinarySearchTree {
	//a hard question with requirement of O(1) extra space
	//a relatively easy method is to use in-order traversal to generate the 'sorted nodes' (because it is a BST)
    //e.g. 1,2,3,4,5 (expected)
    //     but we get 5,2,3,4,1
    //so we need to swap 5 and 1 s.t. it is a sorted array
    //one optimization in the discussion method is to use 3 variables to store the elements instead of using an arraylist to store the whole sequence
    //but still, this is not best method since it will take O(logn) space (O(n) worst case)
    //try Moris-traversal later
    
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode previousElement = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree(TreeNode root) {
        
        inOrderTraverse(root);
        int tmpVal = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = tmpVal;
        
    }
    
    public void inOrderTraverse(TreeNode root) {
        if(root==null) return;
        inOrderTraverse(root.left);
        
        //do something
        if(firstElement==null&&previousElement.val>=root.val) {   //note: here should be ">=" rather than ">"
            firstElement = previousElement; //find the first node to be swapped (left most)
            //previousElement = root;
        } 
        //note: here we cannot use else if, or it will not work for case "2,1,3,4,5"
        if(firstElement!=null&&previousElement.val>=root.val) {
            secondElement = root;
        }
        previousElement = root; //this cannot be written in the above condition
        
        
        inOrderTraverse(root.right);
        
    }

}
