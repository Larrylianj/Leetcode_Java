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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode pre = cur;
        while(cur != null){
            pre = cur;
            cur = cur.next;
            if(cur == null){return head;}
            while(cur.val == pre.val){
                cur = cur.next;
                if(cur == null){break;}
            }
            pre.next = cur;
        }
        return head;
    }
}