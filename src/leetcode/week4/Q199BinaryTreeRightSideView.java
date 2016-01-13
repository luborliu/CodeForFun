package leetcode.week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Q199BinaryTreeRightSideView {
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		rightSideView(root);
	}
	
	public static List<Integer> rightSideView(TreeNode root) {
        
        //dfs 
        //4ms after using the new TNode
        Stack<TNode> stack = new Stack<TNode>();
        //HashMap<TreeNode, Integer> hm = new HashMap<TreeNode, Integer>();
        List<Integer> res = new ArrayList<Integer>();
        
        int curDepth = 0;
      
        
        TNode p = new TNode(root, 1);
        
        while(!stack.isEmpty()||p.treeNode!=null) {
            if(p.treeNode==null) p = stack.pop();
            else {
                if(p.depth>curDepth) {
                    res.add(p.treeNode.val);
                    curDepth++;
                }
                if(p.treeNode.left!=null) stack.push(new TNode(p.treeNode.left,p.depth+1));
                p = new TNode(p.treeNode.right,p.depth+1);
            }
            
        }
        return res;
    }
	public static List<Integer> rightSideView1(TreeNode root) {
        
        //dfs
        //6ms using hashmap, I guess it is because I store treenode.rightchild everytime?
        Stack<TreeNode> stack = new Stack<TreeNode>();
        HashMap<TreeNode, Integer> hm = new HashMap<TreeNode, Integer>();
        List<Integer> res = new ArrayList<Integer>();
        
        int curDepth = -1;
        hm.put(root,0);
        
        while(!stack.isEmpty()||root!=null) {
            
            if(root==null) {
                root = stack.pop();
                continue;
            }
            int nodeDepth = hm.get(root);
            
            if(curDepth<nodeDepth) {
                res.add(root.val);
                curDepth++;
            }
            
           
            if(root.left!=null) {
                hm.put(root.left,nodeDepth+1);  
                stack.push(root.left);
            }
            if(root.right!=null) {
                hm.put(root.right,nodeDepth+1);
            }
            root = root.right;
        }
        return res;
        
        
    }

}
