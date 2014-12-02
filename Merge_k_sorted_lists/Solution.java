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

    public ListNode mergeKLists(List<ListNode> lists) {
        ListNodeComparator comparator = new ListNodeComparator();
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(Math.max(lists.size(),1), comparator);
        ListNode head = null;
        ListNode cur = head;
        // add the first element of each list into heap
        for(int i = 0;i < lists.size();i++)
            if(lists.get(i) != null)
                heap.add(lists.get(i));
        // each time, pop min from heap and add its next element into heap
        while(!heap.isEmpty()){
            ListNode min = heap.poll();
            if(min.next != null)
                heap.add(min.next);
            if(cur != null)
                cur.next = min;
            else
                head = min;
            cur = min;
        }
        return head;
    }
}

    class ListNodeComparator implements Comparator<ListNode> {
		public int compare(ListNode a, ListNode b) {
			return a.val==b.val?0:(a.val > b.val?1:-1);
		}
	}