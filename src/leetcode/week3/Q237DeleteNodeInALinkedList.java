package leetcode.week3;

public class Q237DeleteNodeInALinkedList {
	
	public void deleteNode(ListNode node) {
        
        //classic one 
        //define delete, this is actually not really deleted, the method will delete the one after curNode and copy value from the deleted node to the curNode
        //one condition cannot be ignored: except tail node
        
        node.val = node.next.val;
        node.next = node.next.next;
        return;
    }

}
