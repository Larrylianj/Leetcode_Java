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
		TreeNode t09 = new TreeNode(5);
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
		t05.left = t09;
		t10.right = t11;
		
		Solution s = new Solution();
		System.out.print(s.pathSum(t00, 22));

	}
	
	 public List<List<Integer>> pathSum(TreeNode root, int sum) {
	        List<List<Integer>> output = new ArrayList<List<Integer>>();
	        List<Integer> track = new ArrayList<Integer>();
	        if(root == null){return output;}
	        traverse(root,0,sum,track,output);
	        return output;
	    }
	 
	 private void traverse(TreeNode node, int cur_sum, int sum, List<Integer> track, List<List<Integer>> output){
		 List<Integer> new_track = new ArrayList<Integer>(track);
		 new_track.add(node.val);
		 cur_sum += node.val;
		 if(node.left == null && node. right == null)
			 if(cur_sum == sum)
				 output.add(new_track);
		 if(node.left != null)
			 traverse(node.left, cur_sum, sum, new_track, output);
		 if(node.right != null)
			 traverse(node.right, cur_sum, sum, new_track, output);
	 }
}
