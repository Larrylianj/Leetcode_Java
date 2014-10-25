
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int i,length;
		ListNode head = new ListNode(3);
		ListNode cur,temp;
		Solution s = new Solution();
		
		i = 0;length = 8;
		cur = head;
		while(i < length){
			i ++;
			temp = new ListNode((int)(Math.random()*length*2));
			cur.next = temp;
			cur = temp;
		}
		
		s.show(head);
		head = s.insertionSortList(head);
		s.show(head);
	}
	
	public ListNode insertionSortList(ListNode head) {
		
		ListNode root = null;
		ListNode cur = null;
		
		while(head != null){
			cur = head;
			head = head.next;
			root = this.insert(root, cur);
		}
        return root;
    }
	
	public ListNode insert(ListNode head, ListNode node){
		
		boolean flag;
		
		flag = false;
		if(head == null){
			head = node;
			head.next = null;
		}else{
			ListNode cur = null;
			ListNode pre = null;
			cur = head;
			pre = cur;
			while(cur != null){
				if(cur.val < node.val){
					flag = true;
					pre = cur;
					cur = cur.next;
				}else{
					break;
				}
			}

			
			if(flag == false){
				node.next = head;
				head = node;
			}else{
				pre.next = node;
				node.next = cur;
			}
			
		}
		return head;
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
