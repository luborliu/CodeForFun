package leetcode.week3;

public class Q236LowestCommonAncestorOfABinaryTree {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //my first idea is to use two stacks to store the path from root to two different nodes
        //then pop until they meet
        
        //then the smart guy only use several lines to solve this!! what can I say?!
        
        if(root==null||root==p||root==q) return root;
        
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        
        return left==null?right:right==null?left:root; //this is tooo hard to come up with
    }
	

}
