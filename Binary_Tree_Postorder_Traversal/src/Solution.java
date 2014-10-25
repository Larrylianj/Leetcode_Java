import java.util.*;

//public class TreeNode {
//
//	int val;
//	TreeNode left;
//	TreeNode right;
//	TreeNode(int x) { val = x; }
//}

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node0 = new TreeNode(5);
		TreeNode node1 = new TreeNode(6);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(9);
		TreeNode node4 = new TreeNode(1);
		node0.left = node1;
		node0.right = node2;
		node1.left = node3;
		node1.right = node4;
		
		List<Integer> lst = new ArrayList();
		Solution s = new Solution();
		lst = s.postorderTraversal(node0);
		System.out.println(lst);
		
	}

//	public List<Integer> postorderTraversal(TreeNode root) {
//		Stack s = new Stack<Integer>();
//		List<Integer> lst = new ArrayList();
//		Integer buf = null;
//		
//		s = this.postorderT(root, s);
//		while(!s.empty()){
//			
//			buf = (Integer)s.pop();
//			lst.add(buf);
//			
//		}
//		
//		return lst;
//    }
	
	public List<Integer> postorderTraversal(TreeNode root) { //iterative version
		Stack s = new Stack<TreeNode>();
		List<Integer> lst = new ArrayList();
		Integer buf = null;
		
		while(true){
			if(root == null){
				if(!s.empty()){
					root = (TreeNode)s.peek();
					s.pop();
					continue;
				}else{
					break;
				}
			}
			lst.add(0,root.val);
			s.push(root.left);
			root = root.right;
		}
		
		return lst;
    }
	
	public Stack postorderT(TreeNode root, Stack s){
		if(root != null){
			// postorder
//			s.push(root.val);
//			s = postorderT(root.right,s);
//			s = postorderT(root.left,s);
			// preorder
			s = postorderT(root.right,s);
			s = postorderT(root.left,s);
			s.push(root.val);
		}
		return s;
	}
	
}
