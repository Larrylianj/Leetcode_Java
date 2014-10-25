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
		TreeNode t00 = new TreeNode(5);
		TreeNode t01 = new TreeNode(4);
		TreeNode t02 = new TreeNode(8);
		TreeNode t03 = new TreeNode(11);
		TreeNode t04 = new TreeNode(13);
		TreeNode t05 = new TreeNode(4);
		TreeNode t06 = new TreeNode(7);
		TreeNode t07 = new TreeNode(2);
		TreeNode t08 = new TreeNode(1);
		TreeNode t10 = new TreeNode(-2);
		TreeNode t11 = new TreeNode(-3);
		
		t00.left = t01;
		t00.right = t02;
		t01.left = t03;
		t02.left = t04;
		t02.right = t05;
		t03.left = t06;
		t03.right = t07;
		t05.right = t08;
		t10.right = t11;
		
		Solution s = new Solution();
		System.out.print(s.hasPathSum(t10, -5));

	}
	
	public boolean hasPathSum(TreeNode root, int sum) {
        Map<TreeNode, Integer> buffer = new HashMap<TreeNode, Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode cur;
        int cur_sum;
        
        if(root == null){return false;}
        queue.add(root);
        buffer.put(root, root.val);
        while(!queue.isEmpty()){
        	cur = queue.poll();
        	cur_sum = buffer.get(cur);
        	if(cur_sum == sum && cur.left == null && cur.right == null){return true;}
        	if(cur.left != null){
        		queue.add(cur.left);
        		buffer.put(cur.left, cur_sum+cur.left.val);
        	}
        	if(cur.right != null){
        		queue.add(cur.right);
        		buffer.put(cur.right, cur_sum+cur.right.val);
        	}
        }
        
        return false;
    }

}
