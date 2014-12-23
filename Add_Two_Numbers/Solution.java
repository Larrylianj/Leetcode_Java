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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean carry = false;
        ListNode head = new ListNode(0);
        head.next = l1;
        l1 = head;
        while(l1.next != null && l2 != null){
            l1 = l1.next;
            l1.val += carry?1:0;
            carry = l1.val+l2.val>=10?true:false;
            l1.val = (l1.val+l2.val)%10;
            l2 = l2.next;
        }
        while(l2 != null){
            l2.val += carry?1:0;
            carry = l2.val>=10?true:false;
            l2.val = l2.val%10;
            l1.next = l2;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(carry){
            while(l1.next != null){
                l1 = l1.next;
                l1.val += carry?1:0;
                carry = l1.val>=10?true:false;
                l1.val = l1.val%10;
            }
        }
        if(carry){
            ListNode last = new ListNode(1);
            l1.next = last;
        }
        return head.next;
    }
}