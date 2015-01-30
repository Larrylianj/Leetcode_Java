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
    // naive version
//    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//        List<List<Integer>> gross = new ArrayList<List<Integer>>();
//        if(root == null){return gross;}
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
//        queue.add(root);
//        map.put(root,0);
//        while(!queue.isEmpty()){
//            TreeNode temp = queue.poll();
//            int layer = map.get(temp);
//            if(layer+1 > gross.size()){
//                List<Integer> cur_layer = new ArrayList<Integer>();
//                cur_layer.add(temp.val);
//                gross.add(cur_layer);
//            }else{
//                gross.get(layer).add(temp.val);
//            }
//            if(temp.left != null){
//                queue.add(temp.left);
//                map.put(temp.left, layer+1);
//            }
//            if(temp.right != null){
//                queue.add(temp.right);
//                map.put(temp.right, layer+1);
//            }
//        }
//        for(int i = 0;i < gross.size();i++){
//            if(i%2 != 0){
//                List<Integer> newList = new ArrayList<Integer>();
//                for(int j = 0;j < gross.get(i).size();j++){
//                    newList.add(gross.get(i).get(gross.get(i).size()-1-j));
//                }
//                gross.set(i,newList);
//            }
//        }
//        return gross;
//    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> gross = new ArrayList<List<Integer>>();
        // BFS
        Stack<TreeNode> forward = new Stack<TreeNode>();
        Stack<TreeNode> backward = new Stack<TreeNode>();
        if(root==null){return gross;}
        forward.add(root);
        while(!forward.isEmpty() || !backward.isEmpty()){
            if(!forward.isEmpty()){
                List<Integer> list = new ArrayList<Integer>();
                while(!forward.isEmpty()){
                    TreeNode node = forward.pop();
                    list.add(node.val);
                    if(node.left!=null)
                        backward.add(node.left);
                    if(node.right!=null)
                        backward.add(node.right);
                }
                gross.add(list);
            }
            if(!backward.isEmpty()){
                List<Integer> list = new ArrayList<Integer>();
                while(!backward.isEmpty()){
                    TreeNode node = backward.pop();
                    list.add(node.val);
                    if(node.right!=null)
                        forward.add(node.right);
                    if(node.left!=null)
                        forward.add(node.left);
                }
                gross.add(list);
            }
        }
        
        return gross;
    }
}