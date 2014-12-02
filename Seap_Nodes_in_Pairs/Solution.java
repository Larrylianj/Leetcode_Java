/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode left = newhead;
        ListNode right = left;
        while(left != null){
            ListNode end = left.next;
            right = right.next;
            if(right == null){return newhead.next;}
            if(right.next == null){return newhead.next;}
            left.next = right.next;
            right.next = right.next.next;
            left.next.next = right;
            
            left = end;
            right = left;
        }
        return newhead.next;
    }
}