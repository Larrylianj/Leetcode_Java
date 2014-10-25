import java.util.ArrayList;
import java.util.List;

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
		TreeNode temp01 = new TreeNode(1);
		TreeNode temp02 = new TreeNode(2);
		TreeNode temp03 = new TreeNode(3);
		temp01.left = temp02;
		temp02.right = temp03;
		Solution s = new Solution();
		System.out.println(s.sumNumbers(temp01));
	}

	public int sumNumbers(TreeNode root) {
		List<List<TreeNode>> lst_nodes = new ArrayList<List<TreeNode>>();
		List<List<Integer>> lst_numbers = new ArrayList<List<Integer>>();
		TreeNode temp = null;
		int sum = 0;
		
		// base case check
		if(root == null){return sum;}
		
		List<TreeNode> lst00 = new ArrayList<TreeNode>();
		List<Integer> lst_numbers00 = new ArrayList<Integer>();
		lst00.add(root);
		lst_numbers00.add(root.val);
		lst_nodes.add(lst00);
		lst_numbers.add(lst_numbers00);
		
		// bfs on the tree
		int i = 0;
		while(!lst_nodes.get(i).isEmpty()){
			List<TreeNode> lst_nodes_temp = new ArrayList<TreeNode>();
			List<Integer> lst_numbers_temp = new ArrayList<Integer>();
			for(int j = 0;j < lst_nodes.get(i).size();j++){
				temp = lst_nodes.get(i).get(j);
				if(temp.left != null){
					lst_nodes_temp.add(temp.left);
					lst_numbers_temp.add(lst_numbers.get(i).get(j)*10 + lst_nodes.get(i).get(j).left.val);
				}
				if(temp.right != null){
					lst_nodes_temp.add(temp.right);
					lst_numbers_temp.add(lst_numbers.get(i).get(j)*10 + lst_nodes.get(i).get(j).right.val);
				}
				// when comes to leaf node, add to sum
				if(temp.right == null && temp.left == null){
					sum += lst_numbers.get(i).get(j);
				}
			}
			lst_nodes.add(lst_nodes_temp);
			lst_numbers.add(lst_numbers_temp);
			i++;
		}
		return sum;
	}
}
