package leetcode.week4;

public class Q235LowestCommonAncestorOfABST {
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        int smaller = p.val>q.val?q.val:p.val;
        int bigger = p.val>q.val?p.val:q.val;
        TreeNode pt = root;
        
        while(!(pt.val>=smaller&&pt.val<=bigger)) {
            if(pt.val<smaller) pt = pt.right;
            else pt = pt.left;
        }   
        return pt;
    }

}
