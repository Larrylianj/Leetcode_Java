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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode cur = null;
        ListNode cur_l1 = null;
        ListNode cur_l2 = null;
        // corner case
        if(l1 == null && l2 == null){return null;}
        if(l1 == null){return l2;}
        if(l2 == null){return l1;}
        // get the head node
        if(l1.val < l2.val){
            head = l1;
            cur_l1 = l1.next;
            cur_l2 = l2;
            cur = head;
        }else{
            head = l2;
            cur_l2 = l2.next;
            cur_l1 = l1;
            cur = head;
        }
        // merge 
        while(cur_l1 != null && cur_l2 != null){
            if(cur_l1.val < cur_l2.val){
                cur.next = cur_l1;
                cur_l1 = cur_l1.next;
            }else{
                cur.next = cur_l2;
                cur_l2 = cur_l2.next;
            }
            cur = cur.next;
        }
        while(cur_l1 != null){
            cur.next = cur_l1;
            cur_l1 = cur_l1.next;
            cur = cur.next;
        }
        while(cur_l2 != null){
            cur.next = cur_l2;
            cur_l2 = cur_l2.next;
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }
}