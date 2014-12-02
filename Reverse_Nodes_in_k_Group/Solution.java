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
    public ListNode reverseKGroup(ListNode head, int k) {
        int swap_times = k/2;
        ListNode newhead = new ListNode(0);
        newhead.next = head;
        ListNode left = newhead;
        ListNode right = left;
        ListNode end = null;
        
        while(left != null){
            int count  = 0;
            while(count < k-1){
                count ++;
                right = right.next;
                if(right == null){return newhead.next;}
            }
            if(right.next == null){return newhead.next;}
            end = left.next;
            count = 0;
            while(count < k/2){
                ListNode fatherRight = null;
                if(count != k/2-1 || k%2 != 0){
                    fatherRight = findFather(newhead, right);
                    // swap left's son and right's son
                    ListNode temp = left.next.next;
                    left.next.next = right.next.next;
                    right.next.next = temp;
                    
                    temp = left.next;
                    left.next = right.next;
                    right.next = temp;
                }else{
                    left.next = right.next;
                    right.next = right.next.next;
                    left.next.next = right;
                    break; // never executed
                }
                count++;
                left = left.next;
                right = fatherRight;
            }
            left = end;
            right = left;
        }
        return newhead.next;
    }
    
    private ListNode findFather(ListNode head, ListNode son){
        while(head != null){
            if(son == head.next){
                return head;
            }
            head = head.next;
        }
        return null;
    }
}