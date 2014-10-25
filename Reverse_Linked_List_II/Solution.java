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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        Stack<ListNode> stack = new Stack<ListNode>();
        int count = 1;
        ListNode cur = head;
        ListNode pre = cur;
        ListNode leftDot, rightDot;
        while(count != m){
            pre =cur;
            cur = cur.next;
            count ++;
        }
        leftDot = pre;
        while(count != n+1){
            stack.add(cur);
            pre = cur;
            cur = cur.next;
            count++;
        }
        rightDot = cur;
        // reverse
        if(m==1){
            head = stack.pop();
            cur = head;
            pre = cur;
            while(!stack.isEmpty()){
                cur = stack.pop();
                pre.next = cur;
                pre = cur;
            }
            cur.next = rightDot;
        }else{
            cur = leftDot;
            pre = cur;
            while(!stack.isEmpty()){
                cur = stack.pop();
                pre.next = cur;
                pre = cur;
            }
            cur.next = rightDot;
        }
        return head;
    }
}