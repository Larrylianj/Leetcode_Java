class TreeNode{
	int val;
	TreeNode right;
	TreeNode left;
	TreeNode(int x){val = x;}
}
public class Solution {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0){return null;}
        if(inorder.length == 1){return new TreeNode(inorder[0]);}
        int root_num = postorder[postorder.length-1];
        TreeNode root = new TreeNode(root_num);
        int middle = 0;
        while(inorder[middle] != root_num){
            middle++;
            //if(middleOfInorder > inorder.length){return null;}
        }
        int sub1_inorder[] = new int[middle];
        int sub1_postorder[] = new int[middle];
        for(int i = 0;i < middle;i++){
            sub1_inorder[i] = inorder[i];
        }
        for(int i = 0;i < middle;i++){
            sub1_postorder[i] = postorder[i];
        }
        int sub2_inorder[] = new int[inorder.length -1 -middle];
        int sub2_postorder[] = new int[inorder.length -1 -middle];
        for(int i = middle+1;i < inorder.length;i++){
            sub2_inorder[i-middle-1] = inorder[i];
        }
        for(int i = middle;i < inorder.length-1;i++){
            sub2_postorder[i-middle] = postorder[i];
        }
        root.left = buildTree(sub1_inorder,sub1_postorder);
        root.right = buildTree(sub2_inorder,sub2_postorder);
        return root;
    }
}
