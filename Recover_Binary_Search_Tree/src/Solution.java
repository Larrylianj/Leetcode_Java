import java.util.*;

//Definition for binary tree
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
	public static void main(String[] args){
		TreeNode t01 = new TreeNode(3);
		TreeNode t02 = new TreeNode(2);
		TreeNode t03 = new TreeNode(1);
		t01.left = t02;
		t01.right = t03;
		//t03.right = t02;
		Solution s = new Solution();
		s.recoverTree(t01);
		System.out.print(1);
		
	}
	public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> set = new ArrayList<TreeNode>();
        if(root == null){return;}
        checkCorrect(root, Integer.MAX_VALUE, Integer.MIN_VALUE,set);
        if(set.size() == 2){
            int value = set.get(0).val;
            set.get(0).val = set.get(1).val;
            set.get(1).val = value;
        }else if(set.size() == 1){
            // find the father node
            boolean isRoot = true;
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.add(root);
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node.left != null){
                    if(node.left == set.get(0)){
                        isRoot = false;
                        int value = node.left.val;
                        node.left.val = node.val;
                        node.val = value;
                        break;
                    }
                    queue.add(node.left);
                }
                if(node.right != null){
                    if(node.right == set.get(0)){
                        isRoot = false;
                        int value = node.right.val;
                        node.right.val = node.val;
                        node.val = value;
                        break;
                    }
                    queue.add(node.right);
                }
            }
            if(isRoot){
                int value = root.val;
                root.val = set.get(0).val;
                set.get(0).val = value;
            }
            
        }
        return;
    }
    
    private void checkCorrect(TreeNode node, int upperBound, int lowerBound, ArrayList<TreeNode> found){
        if(node == null){return;}
        if(found.size() == 2){return;}
        if(node.val <= upperBound && node.val >= lowerBound){
            checkCorrect(node.left, node.val, lowerBound, found);
            checkCorrect(node.right, upperBound, node.val, found);
        }else{
            found.add(node);
        }
        return;
    }
}