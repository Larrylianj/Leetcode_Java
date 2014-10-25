

public class Solution 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int length = 10;
		RandomListNode ranNode[] = new RandomListNode[length];
		RandomListNode result = new RandomListNode(0);
		Solution s = new Solution();
		
//		for(int i = 0;i < length; i++)
//		{
//			ranNode[i] = new RandomListNode(i);
//		}
//		for(int i = 0;i < length; i++)
//		{
//			if(i == length - 1)
//			{
//				ranNode[i].next = null;
//			}
//			else
//			{
//				ranNode[i].next = ranNode[i+1];
//			}
//		}
//		
//		ranNode[1].random = ranNode[5];
//		ranNode[2].random = ranNode[0];
//		ranNode[3].random = ranNode[9];
//		ranNode[5].random = ranNode[4];
//		ranNode[7].random = ranNode[8];
//		ranNode[8].random = ranNode[7];
//		ranNode[9].random = ranNode[6];
		
		ranNode[0] = new RandomListNode(-1);
		ranNode[0].next = null;
		//ranNode[0].random = ranNode[0];
		ranNode[0].random = null;
		
		result = s.copyRandomList(ranNode[0]);
		
	}

	public RandomListNode copyRandomList(RandomListNode head) 
	{
		if(head == null){
			return head;
		}
		
		// insert a new node between each pair
		RandomListNode newHead = null;
        RandomListNode temp = null;
        RandomListNode temp2 = null;
        RandomListNode cur = null;
        RandomListNode cur2 = null;
        
        temp = head;
        while(temp != null){
        	cur = temp.next;
        	temp.next = new RandomListNode(temp.label);
        	temp.next.next = cur;
        	temp = cur;
        }
		
        // assign random pointer
        temp = head;
        while(temp != null){
        	if(temp.random != null){
        		temp.next.random = temp.random.next;
        	}else{
        		temp.next.random = null;
        	}
        	temp = temp.next.next;
        }
        
        // get the new list
		newHead = head.next;
		temp = newHead;
		temp2 = head;
		
		if(temp.next == null){
			temp2.next = null;
		}
		while(temp.next != null){
			cur = temp.next.next;
			cur2 = temp2.next.next;
			temp.next = cur;
			temp2.next = cur2;
			temp = cur;
			temp2 = cur2;
		}
		temp2.next = null;
		
//		while(temp2.next != null){
//			temp2.next = temp.next;
//			temp2 = temp2.next;
//			if(temp2 == null) break;
//			temp.next = temp2.next;
//			temp = temp.next;
//		}
		
		return newHead;
        
//        ArrayList<RandomListNode> arr_node = new ArrayList<RandomListNode>();
//        ArrayList<RandomListNode> arr_cur = new ArrayList<RandomListNode>();
//        RandomListNode cur = null;
//        RandomListNode temp = head;
//        
//        while(temp != null){
//        	cur = new RandomListNode(temp.label);
//        	arr_cur.add(cur);
//        	arr_node.add(temp);
//        	temp = temp.next;
//        }
//        
//        for(int i = 0;i<arr_node.size();i++){
//        	if(i < arr_node.size() - 1){
//        		arr_cur.get(i).next = arr_cur.get(i+1);
//        	}else{
//        		 arr_cur.get(arr_cur.size() -1).next = null;
//        	}
//        	if(arr_node.get(i).random == null){
//        		arr_cur.get(i).random = null;
//        	}else{
//        		arr_cur.get(i).random = arr_cur.get(arr_node.indexOf(arr_node.get(i).random));
//        	}
//        }  
//		  return arr_cur.get(0);
        
    }
}
