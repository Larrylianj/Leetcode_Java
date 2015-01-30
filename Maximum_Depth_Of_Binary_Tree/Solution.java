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
    public int maxDepth(TreeNode root) {
        if(root == null){return 0;}
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        map.put(root,1);
        queue.add(root);
        int max = 1;
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            int layer = map.get(temp);
            if(layer > max){max = layer;}
            if(temp.left != null){
                map.put(temp.left, layer+1);
                queue.add(temp.left);
            }
            if(temp.right != null){
                map.put(temp.right, layer+1);
                queue.add(temp.right);
            }
        }
        return max;
    }
    
    // 2nd trial
//    int maxDepth;
//    public int maxDepth(TreeNode root) {
//        maxDepth = 0;
//        traversal(root,0);
//        return maxDepth;
//    }
//    
//    private void traversal(TreeNode root, int depth){
//        if(root==null)
//            return;
//        if(root.left==null && root.right==null)
//            maxDepth = Math.max(depth+1,maxDepth);
//        if(root.left!=null)
//            traversal(root.left, depth+1);
//        if(root.right!=null)
//            traversal(root.right, depth+1);
//        return;
//    }
}