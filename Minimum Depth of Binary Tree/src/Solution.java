import java.util.*;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t01 = new TreeNode(1);
		TreeNode t02 = new TreeNode(2);
		t01.left = t02;
		Solution s = new Solution();
		System.out.print(s.minDepth(t01));
	}

//Definition for binary tree
	
	public int minDepth(TreeNode root) {
		if(root == null){return 0;}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
		map.put(root, 1);
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode cur = queue.poll();
			int index = map.get(cur);
			// check if it's a leaf node
			if(cur.left == null && cur.right == null){
				return index;
			}
			if(cur.left != null){
				map.put(cur.left, index+1);
				queue.add(cur.left);
			}
			if(cur.right != null){
				map.put(cur.right, index+1);
				queue.add(cur.right);
			}
		}
		return 0;
	}
}
