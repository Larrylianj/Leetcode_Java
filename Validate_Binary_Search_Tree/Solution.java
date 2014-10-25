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
    public boolean isValidBST(TreeNode root) {
        if(root == null){return true;}
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node.left != null){
                if(!detectErrorNode(node.left, node.val, true)){
                    return false;
                }
                queue.add(node.left);
            }
            if(node.right != null){
                if(!detectErrorNode(node.right, node.val, false)){
                    return false;
                }
                queue.add(node.right);
            }
        }
        return true;
    }
    
    private boolean detectErrorNode(TreeNode root, int bound, boolean isLeft){
        if(root == null){return true;}
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(isLeft){
                if(temp.val >= bound){return false;}
            }else{
                if(temp.val <= bound){return false;}
            }
            if(temp.left != null){queue.add(temp.left);}
            if(temp.right != null){queue.add(temp.right);}
        }
        return true;
    } 
    
}