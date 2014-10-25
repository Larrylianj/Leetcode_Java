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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> gross = new ArrayList<List<Integer>>();
        if(root == null){return gross;}
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        queue.add(root);
        map.put(root,0);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            int layer = map.get(temp);
            if(layer+1 > gross.size()){
                List<Integer> cur_layer = new ArrayList<Integer>();
                cur_layer.add(temp.val);
                gross.add(cur_layer);
            }else{
                gross.get(layer).add(temp.val);
            }
            if(temp.left != null){
                queue.add(temp.left);
                map.put(temp.left, layer+1);
            }
            if(temp.right != null){
                queue.add(temp.right);
                map.put(temp.right, layer+1);
            }
        }
        for(int i = 0;i < gross.size();i++){
            if(i%2 != 0){
                List<Integer> newList = new ArrayList<Integer>();
                for(int j = 0;j < gross.get(i).size();j++){
                    newList.add(gross.get(i).get(gross.get(i).size()-1-j));
                }
                gross.set(i,newList);
            }
        }
        return gross;
    }
}