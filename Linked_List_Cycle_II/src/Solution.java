
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(3);
		ListNode node01 = new ListNode(4);
		ListNode node02 = new ListNode(5);
		head.next = node01;
		node01.next = node02;
		node02.next = node01;
		Solution s = new Solution();
		
		ListNode target = s.detectCycle(head);
		if(target != null){
			System.out.println(target.val);
		}
		
		
		//s.show(head);
	}

	// Try Hare and Tortoise Algorithm
	public ListNode detectCycle(ListNode head) {
		boolean flag = false;
        ListNode hare = null;
        ListNode tortoise = null;
        
        if (head == null || head.next == null || head.next.next == null){
        	return null;
        }
        hare = head.next.next;
        tortoise = head.next;
        while(hare != null && tortoise != null){
        	if ( hare == tortoise){
        		flag = true;
        		break;
        	}
        	tortoise = tortoise.next;
        	hare = hare.next;
        	if ( hare == null){
        		return null;
        	}
        	hare = hare.next;
        }
        
        if(flag){
        	hare = head;
        	while ( hare != tortoise){
        		hare = hare.next;
        		tortoise = tortoise.next;
        	}
        	return hare;
        }else{
        	return null;
        }
        
		
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
