package leetcode.week4;

public class Q222CountCompleteTreeNodes {
	
	//这个题已经和陈喵讨论了一个半小时了，再不会做就不能忍了
	public int countNodes(TreeNode root) {
        //first naive solution, TLE, has not made use of the condition of complete binary tree 
        //if(root==null) return 0;
        //return 1+countNodes(root.left)+countNodes(root.right);
        if(root==null) return 0;
        int h = height(root);
        
        int pHeight = height(root.right);
        if(pHeight==(h-1)) return (1<<h) + countNodes(root.right);
        else return (1<<(h-1)) + countNodes(root.left);
        
        
    }
    
    int height(TreeNode root) {
        if(root==null) return -1;
        return 1+height(root.left);
    }

}
