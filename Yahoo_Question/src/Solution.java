import java.util.Stack;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		this.val = x;
		left = null;
		right = null;
	}
}
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t01 = new TreeNode(1);
		TreeNode t02 = new TreeNode(-10);
		TreeNode t03 = new TreeNode(10);
		TreeNode t04 = new TreeNode(100);
		TreeNode t05 = new TreeNode(1);
		TreeNode t06 = new TreeNode(20);
		TreeNode t07 = new TreeNode(15);
		t01.left = t02;
		t01.right = t03;
		t02.left = t04;
		t02.right = t05;
		t03.left = t06;
		t03.right = t07;
		
		Solution s = new Solution();
		System.out.print(s.maxSumToLeaf(t01));

	}
	
	public int maxSumToLeaf(TreeNode root){
		//edge case
		if(root == null){return 0;}
		
		//dfs
		int max = Integer.MIN_VALUE;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Integer> sums = new Stack<Integer>();
		
		stack.push(root);
		sums.push(root.val);
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			int sum = sums.pop();
			// check if leaf node
			if(node.left == null && node.right == null){
				if(sum > max)
					max = sum;
			}
			if(node.left != null){
				stack.push(node.left);
				sums.push(node.left.val+sum);
			}
			if(node.right != null){
				stack.push(node.right);
				sums.push(node.right.val+sum);
			}
		}
		
		return max;
	}

}
