import java.util.*;

class ListNode {
int val;
ListNode next;
ListNode(int x) {
val = x;
next = null;
}
}

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		ListNode t00 = new ListNode(1);
		ListNode t01 = new ListNode(3);
		ListNode t02 = new ListNode(2);
		t00.next = t01;
		t01.next = t02;
		s.partition(t00, 3);
		

	}
	public ListNode partition(ListNode head, int x) {
        Queue<ListNode> queue = new LinkedList<ListNode>();
        // get the new head node
        ListNode cur = head;
        ListNode pre;
        while(cur != null){
            if(cur.val >= x){
                queue.add(cur);
            }else{
                break;
            }
            cur = cur.next;
        }
        head = cur;
        // first half (<)
        cur = head;
        pre = cur;
        while(cur != null){
            cur = cur.next;
            if(cur == null){break;}
            if(cur.val >= x){
                queue.add(cur);
            }else{
                pre.next = cur;
                pre = cur;
            }
        }
        // second half(>=)
        if(head == null){
            if(queue.isEmpty()){return head;}
            else{
                head = queue.poll();
                pre = head;
            }
        }
        while(!queue.isEmpty()){
            pre.next = queue.poll();
            pre = pre.next;
        }
        pre.next = null;
        return head;
    }
}
