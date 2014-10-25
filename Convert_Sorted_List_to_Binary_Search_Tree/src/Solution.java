import java.util.*;
//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}


//Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
	public static void main(){
		ListNode t01 = new ListNode(3);
		ListNode t02 = new ListNode(5);
		ListNode t03 = new ListNode(8);
		t01.next = t02;
		t02.next = t03;
		Solution s = new Solution();
		TreeNode root = s.sortedListToBST(t01);
	}
	public TreeNode sortedListToBST(ListNode head) {
        if(head == null){return null;}
    	ArrayList<TreeNode> arr = new ArrayList<TreeNode>();
        ListNode cur = head;
        while(cur != null){
        	TreeNode temp = new TreeNode(cur.val);
        	arr.add(temp);
        	cur = cur.next;
        }
        TreeNode root = arrayToBST(arr);
        
        return root;
    }
    
    private TreeNode arrayToBST(ArrayList<TreeNode> arr){
    	if(arr.size() == 1){
    		return arr.get(0);
    	}
    	if(arr.size() == 0){
    	    return null;
    	}
    	int middle = arr.size()/2;
    	ArrayList<TreeNode> sub1 = new ArrayList<TreeNode>();
    	for(int i = 0;i < middle;i++){sub1.add(arr.get(i));}
    	ArrayList<TreeNode> sub2 = new ArrayList<TreeNode>();
    	for(int i = middle+1;i < arr.size();i++){sub2.add(arr.get(i));}
    	arr.get(middle).left = arrayToBST(sub1);
    	arr.get(middle).right = arrayToBST(sub2);
    	return arr.get(middle);
    }
}
