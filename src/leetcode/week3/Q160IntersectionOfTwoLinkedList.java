package leetcode.week3;

public class Q160IntersectionOfTwoLinkedList {
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        //O(n) time with O(1) space cannot use stack
        //a genius idea in discussion hot post, but seems not that meaningful to read, while do it next round
        ListNode pA = headA;
        ListNode pB = headB;
        
        int lenA = 0;
        int lenB = 0;
        while(pA!=null) {
            lenA++;
            pA = pA.next;
        } 
        while(pB!=null) {
            lenB++;
            pB = pB.next;
        }
        
        pA = headA;
        pB = headB;
        while(lenA>lenB) {
            pA = pA.next;
            lenA--;
        }
        while(lenB>lenA) {
            pB = pB.next;
            lenB--;
        }
        while(pA!=null&&pB!=null) {
            if(pA.equals(pB)) return pA;
            pA = pA.next;
            pB = pB.next;
            
        }
        return null;
        
    }

}
