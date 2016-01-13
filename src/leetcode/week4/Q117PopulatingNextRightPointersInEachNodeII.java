package leetcode.week4;

public class Q117PopulatingNextRightPointersInEachNodeII {
	//????????????2ms
	public void connectOptimized(TreeLinkNode root) {
        
        //dfs
        //three pointers
        //first one walk through left side (up-bottom)nodes
        
        //second one walk through left to right (horizontal)
        //third one walk through second one's children level (horizontal)
        TreeLinkNode p1 = root;
     
        while(p1!=null) {
            
            TreeLinkNode p2 = p1; //walk through p1 level
            TreeLinkNode p3 = p1; //walk through children level
            
            //find first left node of children level and assign it to p3, ????????????????????????????????????
            // while(p2!=null) {
            //     if(p2.left!=null) {
            //         p3 = p2.left;
            //         break;
            //     }
            //     if(p2.right!=null) {
            //         p3 = p2.right;
            //         break;
            //     }
            //     p2 = p2.next;
            // }
            //???????????????????????????while??????????????????????????????????????????????????????????????????????????????????????????p1?????????????????????????????????????????????????????????p1.next
            if(p1.left!=null) p3 = p1.left;
            else p3 = p1.right;
            
            while(p2!=null&&p3!=null) {
                if(p2.left!=null&&p2.left!=p3) {//.equals()?
                    p3.next = p2.left;
                    p3 = p3.next;
                }
                if(p2.right!=null&&p2.right!=p3) {
                    p3.next = p2.right;
                    p3 = p3.next;
                }
                p2 = p2.next;
            }
            
            if(p1.left!=null) p1 = p1.left;
            else if(p1.right!=null) p1 = p1.right;
            else p1 = p1.next;
        }
        
    }
	
	
	//???????????????AC??????????????????????????????,5ms??????????????????????????????
	public void connect(TreeLinkNode root) {
        
        //dfs ?????????????????????????????????????????????
        //three pointers
        //first one walk through left side (up-bottom)nodes
        
        //second one walk through left to right (horizontal)
        //third one walk through second one's children level (horizontal)
        TreeLinkNode p1 = root;
   
        while(p1!=null) {
            
            TreeLinkNode p2 = p1; //walk through p1 level
            TreeLinkNode p3 = p1; //walk through children level
            
            //find first left node of children level and assign it to p3
            while(p2!=null) {
                if(p2.left!=null) {
                    p3 = p2.left;
                    break;
                }
                if(p2.right!=null) {
                    p3 = p2.right;
                    break;
                }
                p2 = p2.next;
            }
            
            while(p2!=null){//&&p3!=null) {
                if(p2.left!=null&&p2.left!=p3) {//.equals()?
                    p3.next = p2.left;
                    p3 = p3.next;
                }
                if(p2.right!=null&&p2.right!=p3) {
                    p3.next = p2.right;
                    p3 = p3.next;
                }
                p2 = p2.next;
            }
            
            if(p1.left!=null) p1 = p1.left;
            else if(p1.right!=null) p1 = p1.right;
            else p1 = p1.next;
        }
        
    }

}
