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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        if(root == null){return output;}
        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);
        for(int i = 0;i < left.size();i++)
            output.add(left.get(i));
        output.add(root.val);
        for(int i = 0;i < right.size();i++)
            output.add(right.get(i));
        return output;
    }
}