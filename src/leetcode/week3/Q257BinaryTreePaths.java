package leetcode.week3;

import java.util.ArrayList;
import java.util.List;

public class Q257BinaryTreePaths {
	
	
	
	
	
	// currently no idea how to handle this non-recursively
	 	public List<String> binaryTreePaths(TreeNode root) {
	        return treePathHelper(root,"");
	    }
	    
	    private ArrayList<String> treePathHelper(TreeNode root, String sb) {
	        
	        ArrayList<String> res = new ArrayList<String>();
	        if(root!=null) {
	            if(sb.length()==0) sb=""+root.val;
	            else sb+="->"+root.val;
	            if(root.left==null&&root.right==null) res.add(sb);
	            if(root.left!=null) res.addAll(treePathHelper(root.left,sb));
	            if(root.right!=null) res.addAll(treePathHelper(root.right,sb));
	        } 
	        return res;
	       
	    }
}
