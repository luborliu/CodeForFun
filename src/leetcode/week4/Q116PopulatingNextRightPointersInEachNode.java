package leetcode.week4;

public class Q116PopulatingNextRightPointersInEachNode {
	
	
	
	
	public void connect(TreeLinkNode root) {
        
        //recursion, gosh I finnaly ace one by myself without peeking the discussion
        //the idea is based on Q199, connect all left tree's right nodes to right tree's left nodes
		//then recursively run the routine
        if(root!=null) {
            //root.left.next = root.right; this is not needed, my code is elegant ahaha
            
            TreeLinkNode pL = root.left;
            TreeLinkNode pR = root.right;
            
            while(pL!=null&&pR!=null) {
                pL.next = pR;
                pL = pL.right;
                pR = pR.left;
            }
            
            connect(root.left);
            connect(root.right);
        }
        
        
        
    }

}
