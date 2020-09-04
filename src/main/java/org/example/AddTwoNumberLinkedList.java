package org.example;

/**
 * https://leetcode.com/problems/add-two-numbers/
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumberLinkedList {



	private static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		int carry = 0, result = 0;
		ListNode dummyHead = new ListNode(0);
		//We will need a head for create the list while going
		ListNode resultNode = dummyHead;

		//Or if the size of the two list is different
		while(l1 != null || l2 != null){

			//Check which one are null
			int x = (l1 != null) ? l1.val : 0;
			int y = (l2 != null) ? l2.val : 0;
			result =carry + x + y;


			carry= result / 10;
			result = result % 10;


			resultNode.next = new ListNode(result);
			resultNode = resultNode.next;

			//As one may be null check which one
			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
		}
		//Add the last carry to the end
		if (carry > 0) {
			resultNode.next = new ListNode(carry);
		}
		//Send the reference of the dummy head
		return dummyHead.next;
	}

	public static void main( String[] args )
	{
		ListNode l1 = new ListNode( 2, new ListNode(4 , new ListNode( 3)));
		ListNode l2 = new ListNode( 5, new ListNode(6 , new ListNode( 4)));
		System.out.println(addTwoNumbers(l1, l2).val);
	}
}
