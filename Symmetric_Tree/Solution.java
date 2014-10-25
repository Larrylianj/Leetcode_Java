/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){return true;}
        return compareTwoTree(root.left, root.right);
    }
    
    private boolean compareTwoTree(TreeNode a, TreeNode b){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        if(a == null && b == null){return true;}
        if(a == null && b != null){return false;}
        if(a != null && b == null){return false;}
        queue.add(a);
        queue.add(b);
        while(!queue.isEmpty()){
            TreeNode a_temp = queue.poll();
            TreeNode b_temp = queue.poll();
            if(a_temp.val != b_temp.val){return false;}
            // left
            if(a_temp.left != null){
                if(b_temp.right == null){return false;}
                queue.add(a_temp.left);
                queue.add(b_temp.right);
            }else{
                if(b_temp.right != null){return false;}
            }
            // right
            if(a_temp.right != null){
                if(b_temp.left == null){return false;}
                queue.add(a_temp.right);
                queue.add(b_temp.left);
            }else{
                if(b_temp.left != null){return false;}
            }
        }
        return true;
    }
}