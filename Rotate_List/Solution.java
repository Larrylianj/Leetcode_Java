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
    public ListNode rotateRight(ListNode head, int n) {
        int len = 0;
        int i = 0;
        ListNode cur = head;
        ListNode newhead = null;
        
        // get the length
        while(cur != null){
            len++;
            cur = cur.next;
        }
        if(len == 0){return null;}
        
        // get the new head
        n = n%len;
        cur = head;
        while(cur != null){
            if(i == len-n-1){
                newhead = cur.next;
                cur.next = null;
                break;
            }
            i++;
            cur = cur.next;
        }
        
        // connect them
        cur = newhead;
        if(cur == null){return head;}
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = head;
        
        return newhead;
    }
}