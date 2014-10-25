import java.util.*;

//Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isBalanced(TreeNode root) {
		if(root == null){return true;}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
		queue.add(root);
		int left_degree,right_degree;
		while(!queue.isEmpty()){
			TreeNode temp = queue.poll();
			if(temp.left != null){
				if(map.containsKey(temp.left)){
					left_degree = map.get(temp.left);
				}else{
					left_degree = depthOf(temp.left, map);
				}
				queue.add(temp.left);
			}else{
				left_degree = 0;
			}
			if(temp.right != null){
				if(map.containsKey(temp.right)){
					right_degree = map.get(temp.right);
				}else{
					right_degree = depthOf(temp.right, map);
				}
				queue.add(temp.right);
			}else{
				right_degree = 0;
			}
			
			if(Math.abs(left_degree - right_degree) > 1){return false;}
		}
		return true;
    }
	
	private int depthOf(TreeNode root, HashMap<TreeNode, Integer> map){
		if(root == null){return 0;}
		int depth = Math.max(depthOf(root.left, map)+1, depthOf(root.right, map)+1);
		map.put(root, depth);
		return depth;
	}
}
