
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,length;
		ListNode head = new ListNode(2);
		ListNode t01 = new ListNode(1);
		ListNode cur,temp;
		Solution s = new Solution();
		
//		i = 0;length = 8;
//		cur = head;
//		while(i < length){
//			i ++;
//			temp = new ListNode((int)(Math.random()*length*2));
//			cur.next = temp;
//			cur = temp;
//		}
		
		head.next = t01;
		
		s.show(head);
		head = s.sortList(head);
		s.show(head);

	}
	
	public ListNode sortList(ListNode head) {
		// base case null
		if(head == null){return null;}
		int len = lengthOfList(head);
		// base case 1
		if(len == 1){return head;}
		// divide half and half
		ListNode second_head = head;
		ListNode previous = second_head;
		int i = 0;
		while(i < len/2){
			previous = second_head;
			second_head = second_head.next;
			i++;
		}
		previous.next = null;
		
		head= sortList(head);
		second_head = sortList(second_head);
		head = merge(head,second_head);
		return head;
    }
	
	public ListNode merge(ListNode head1, ListNode head2){
		ListNode head = null;
		ListNode cur = null;
		if(head1.val > head2.val){
			head = head2;
			head2 = head2.next;
		}else{
			head = head1;
			head1 = head1.next;
		}
		cur = head;
		while(head1 != null && head2 != null){
			if(head1.val > head2.val){
				cur.next = head2;
				cur = cur.next;
				head2 = head2.next;
			}else{
				cur.next = head1;
				cur = cur.next;
				head1 = head1.next;
			}
		}
		while(head1 != null){
			cur.next = head1;
			cur = cur.next;
			head1 = head1.next;
		}
		while(head2 != null){
			cur.next = head2;
			cur = cur.next;
			head2 = head2.next;
		}
		
		return head;
	}
	
	public int lengthOfList(ListNode head){
		
		int length;
        
        ListNode temp = head;
        length = 0;
        while(temp != null){
        	length++;
        	temp = temp.next;
        }
        
        return length;
        
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
