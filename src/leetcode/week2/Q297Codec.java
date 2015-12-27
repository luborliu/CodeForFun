package leetcode.week2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q297Codec {
	
// idea is to use level-order traversal
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuilder sb = new StringBuilder();
        TreeNode p = null;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()) {
            p = q.poll();
            if(p!=null) {
                sb.append(p.val);
                sb.append(",");
                q.offer(p.left);
                q.offer(p.right);
            } else sb.append("#,");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // TreeNode res = null;
        // TreeNode p = res;
        String[] arr= data.split(",");
        ArrayList<TreeNode> al = new ArrayList<TreeNode>();
        
        for(String s:arr) {
            
            if(!s.equals("#")) {
                int val = Integer.parseInt(s);
                TreeNode cur = new TreeNode(val);
                al.add(cur);
            } else {
                al.add(null);
            }
        }
        
        //two pointers
        int p0 = 0;
        int p1 = 1;
        while(p1<al.size()&&p0<al.size()) {
            if(al.get(p0)!=null) {
                al.get(p0).left = al.get(p1++);
                al.get(p0).right = al.get(p1++);
            }
            p0++;
        }
        
        return al.get(0);
    }
    
    public static void main(String[] args) {
    	Q297Codec codec = new Q297Codec();
    	codec.deserialize(codec.serialize(new TreeNode(1)));
    }

}
