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
	
	public void flatten(TreeNode root) {
        if(root == null){return;}
		// dfs
        Stack<TreeNode> stack = new Stack<TreeNode>();
        ArrayList<TreeNode> arr = new ArrayList<TreeNode>();
        stack.add(root);
        while(!stack.isEmpty()){
        	TreeNode temp = stack.pop();
        	arr.add(temp);
        	if(temp.right != null){
        		stack.add(temp.right);
        	}
        	if(temp.left != null){
        		stack.add(temp.left);
        	}
        }
        for(int i = 0;i < arr.size()-1;i++){
        	arr.get(i).left = null;
        	arr.get(i).right = arr.get(i+1);
        }
    }

}
