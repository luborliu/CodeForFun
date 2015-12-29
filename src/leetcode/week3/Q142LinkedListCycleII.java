package leetcode.week3;

public class Q142LinkedListCycleII {
	
	//Just make a easier understanding. 
	//Suppose the first meet at step k,
	//the distance between the start node of list and the start node of cycle is s, 
	//and the distance between the start node of cycle and the first meeting node is m. 
	//Then 2k = (s + m + n1r) = 2(s + m + n2r) ==> s + m = nr. 
	//Steps moving from start node to the start of the cycle is just s, 
	//moving from m by s steps would be the start of the cycle, covering n cycles. 
	//In other words, they meet at the entry of cycle.
	public ListNode detectCycle(ListNode head) {
		
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast!=null&&fast.next!=null) {
			
			fast = fast.next.next;
			slow = slow.next;
			
			if(fast!=null&&fast.equals(slow)) {
				fast = head;
				while(!fast.equals(slow)) {
					fast = fast.next;
					slow = slow.next;
				}
				return fast;
			}
			
		}
		return null;
	}

}
