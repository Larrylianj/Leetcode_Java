import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,length;
		ListNode head = new ListNode(0);
		ListNode cur,temp;
		Solution s = new Solution();
		
		i = 0;length = 8;
		cur = head;
		while(i < length){
			i ++;
			temp = new ListNode(i);
			cur.next = temp;
			cur = temp;
		}
		s.show(head);
		s.reorderList(head);
		s.show(head);
	}
	
	public void reorderList(ListNode head) {
        
		Queue<ListNode> q = new LinkedList<ListNode>();
		Stack<ListNode> s = new Stack<ListNode>();
		
		int length,i;
		ListNode temp,previous;
		
		// get the length of the linkedlist
		length = 0;
		temp = head;
		while(temp != null){
			length ++;
			temp = temp.next;
		}
		
		if (length < 2){
			return;
		}
		// put first half into a queue, second half into a stack
		i = 0;
		temp = head;
		q.add(head);
		while(temp != null){
			i++;
			temp = temp.next;
			if(i < Math.ceil((double)length/2.0)){
				q.add(temp);
			}else{
				s.push(temp);
			}
		}
		
		// take out elements from queue and stack in order
		if(q.peek() != null){
			head = q.poll();
		}
		while(s.peek() == null){ // I don't why i have to clear the stack's null value
			s.pop();
		}
		
		temp = head;
		i = 0;
		while(!s.empty() && q.peek() != null){
			previous = temp;
			i ++;
			if(i%2 == 0){
				temp = q.poll();
			}else{
				temp = s.pop();
			}
			
			previous.next = temp;
			
		}
		while(q.peek() != null){
			previous = temp;
			temp = q.poll();
			previous.next = temp;
		}
		while(!s.empty()){
			temp = temp.next;
			temp = s.pop();
		}
		temp.next = null;	
		
    }
	
	public void show(ListNode head){
		ListNode cur = null;
		int i;
		cur = head;
		i = 0;
		while(cur != null){
			i++;
			System.out.println(i+"th is "+cur.val);
			cur = cur.next;
		}
	}

}
