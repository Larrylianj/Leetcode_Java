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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // edge case
        if(headA == null || headB == null){return null;}
        // connect list A into a circle
        ListNode temp = headA;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = headA;
        // find the start node of the circle
        ListNode hare = headB;
        ListNode tortoise = headB;
        while(true){
            // hare step 2 forward
            if(hare.next != null){
                hare = hare.next;
                if(hare.next != null){
                    hare = hare.next;
                }else{
                    temp.next = null;
                    return null;
                }
            }else{
                temp.next = null;
                return null;
            }
            // tortoise step 1 forward
            if(tortoise.next != null){
                tortoise = tortoise.next;
            }else{
                temp.next = null;
                return null;
            }
            // check if they meet
            if(hare == tortoise){
                break;
            }
        }
        hare = headB;
        while(hare != tortoise){
            hare = hare.next;
            tortoise = tortoise.next;
        }
        // break list A into singly list
        temp.next = null;
        
        return hare;
    }
}