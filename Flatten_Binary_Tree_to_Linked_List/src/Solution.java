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
    
    // in-place
    public void flatten(TreeNode root) {
        TreeNode head = new TreeNode(0);
        head.right = root;
        TreeNode node = head;
        while(node.right!=null){
            node = node.right;
            if(node.left!=null){
                TreeNode end = node.left;
                while(end.right!=null){
                    end = end.right;
                }
                TreeNode temp = node.right;
                node.right = node.left;
                node.left = null;
                end.right = temp;
            }
        }
        head.right = null;
    }
	
//	public void flatten(TreeNode root) {
//        if(root == null){return;}
//		// dfs
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        ArrayList<TreeNode> arr = new ArrayList<TreeNode>();
//        stack.add(root);
//        while(!stack.isEmpty()){
//        	TreeNode temp = stack.pop();
//        	arr.add(temp);
//        	if(temp.right != null){
//        		stack.add(temp.right);
//        	}
//        	if(temp.left != null){
//        		stack.add(temp.left);
//        	}
//        }
//        for(int i = 0;i < arr.size()-1;i++){
//        	arr.get(i).left = null;
//        	arr.get(i).right = arr.get(i+1);
//        }
//    }

}
