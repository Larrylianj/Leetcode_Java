import java.util.*;
class TreeNode{
	int val;
	TreeNode right;
	TreeNode left;
	TreeNode(int x){val = x;}
}
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t01 = new TreeNode(1);
		TreeNode t02 = new TreeNode(2);
		t01.left = t02;
		Solution s = new Solution();
		int in[] = {1,2,3,4,5};
		int post[] = {1,4,2,3,5};
		s.buildTree(post,in);
	}
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> gross = new ArrayList<List<Integer>>();
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(root == null){return gross;}
        // bfs
        HashMap<TreeNode, Integer> map = new HashMap<TreeNode, Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        map.put(root, 0);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            int layer = map.get(temp);
            if(gross.size() < layer+1){
                List<Integer> cur_layer = new ArrayList<Integer>();
                cur_layer.add(temp.val);
                gross.add(cur_layer);
            }else{
                gross.get(layer).add(temp.val);
            }
            if(temp.left != null){
                map.put(temp.left, layer+1);
                queue.add(temp.left);
            }
            if(temp.right != null){
                map.put(temp.right, layer+1);
                queue.add(temp.right);
            }
        }
        for(int i = 0;i < gross.size();i++)
            output.add(gross.get(gross.size()-1-i));
        return output;
    }
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length == 0){return null;}
        if(inorder.length == 1){return new TreeNode(inorder[0]);}
        int root_num = preorder[0];
        TreeNode root = new TreeNode(root_num);
        int middle = 0;
        while(inorder[middle] != root_num){
            middle++;
            //if(middle > inorder.length){return null;}
        }
        int sub1_inorder[] = new int[middle];
        int sub1_preorder[] = new int[middle];
        for(int i = 0;i < middle;i++){
            sub1_inorder[i] = inorder[i];
        }
        for(int i = 0;i < middle;i++){
            sub1_preorder[i] = preorder[i+1];
        }
        int sub2_inorder[] = new int[inorder.length -1 -middle];
        int sub2_preorder[] = new int[inorder.length -1 -middle];
        for(int i = middle+1;i < inorder.length;i++){
            sub2_inorder[i-middle-1] = inorder[i];
        }
        for(int i = middle+1;i < inorder.length;i++){
            sub2_preorder[i-middle-1] = preorder[i];
        }
        root.left = buildTree(sub1_preorder,sub1_inorder);
        root.right = buildTree(sub2_preorder,sub2_inorder);
        return root;
    }

}
