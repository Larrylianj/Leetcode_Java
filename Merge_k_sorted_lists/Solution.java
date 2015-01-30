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
    
    // 2nd trail merge sort idea
//    public ListNode mergeKLists(List<ListNode> lists) {
//        for(int i = 1;i < lists.size();i *= 2)
//            for(int j = 0;j+i < lists.size();j += 2*i)
//                lists.set(j,mergeTwoLists(lists.get(j),lists.get(j+i)));
//        return lists.size()==0?null:lists.get(0);
//    }
//    
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode head = new ListNode(0);
//        ListNode cur = head;
//        while(l1 != null && l2 != null){
//            if(l1.val < l2.val){
//                cur.next = l1;
//                l1 = l1.next;
//            }else{
//                cur.next = l2;
//                l2 = l2.next;
//            }
//            cur = cur.next;
//        }
//        if(l1 != null)
//            cur.next = l1;
//        if(l2 != null)
//            cur.next = l2;
//        return head.next;
//    }
}

    class ListNodeComparator implements Comparator<ListNode> {
		public int compare(ListNode a, ListNode b) {
			return a.val==b.val?0:(a.val > b.val?1:-1);
		}
	}