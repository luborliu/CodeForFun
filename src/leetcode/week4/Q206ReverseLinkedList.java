package leetcode.week4;

public class Q206ReverseLinkedList {
	
	public static void main(String[] args) {
		ListNode n = new ListNode(1);
		//n.next = new ListNode(2);
		
		ListNode res = reverseList2(n);
		System.out.println(res.val);
	}
	
	
	public ListNode reverseList(ListNode head) {
        
        //3 pointers? 
        if(head==null||head.next==null) return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        head.next = null;
        
        while(p2!=null) {
            ListNode p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3; //order, order, order 3 times for the important thing!!!!
            
        }
        return p1;
    }
	
	//recursion
	public static ListNode reverseList2(ListNode head) {
        
        //solution recursive
        //recursion has two types: following is the better
		//??????????????????????????????????????????????????????????????????????????????recursion?????????????????????iteration???????????????,????????????
        return reverseHelper(head,null);
    }
    
    //return lstNode
    private static ListNode reverseHelper(ListNode head, ListNode newHead) {
        if(head==null) return newHead;
        
        ListNode next = head.next;
        head.next = newHead;
        newHead = head;
        head = next;
        //newHead = newHead.next;
        return reverseHelper(head,newHead);
    }	

}
