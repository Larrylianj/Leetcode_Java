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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode begin = newhead;
        ListNode end = begin;
        // put end away from begin by n units
        int i = 0;
        while(i < n && end.next != null){
            end = end.next;
            i++;
        }
        
        // let end reach to end of linked list and shift begin asynchronously
        while(end.next != null){
            begin = begin.next;
            end = end.next;
        }
        
        // remove begin->next
        if(begin != null && begin.next != null){
            begin.next = begin.next.next;
        }
        return newhead.next;
    }
}