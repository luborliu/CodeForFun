package leetcode.week3;

public class Q203RemoveLinkedListElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode removeElements(ListNode head, int val) {
        
        if(head==null) return null;
        
        //dummy head
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy;
        while(p!=null&&p.next!=null) {
            while(p.next!=null&&p.next.val == val) p.next = p.next.next; //rmv the node
            p = p.next;
        }
        return dummy.next;
    }

}
