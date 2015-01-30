public class Solution{
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
            left = null;
            right = null;
        }
    }

    // Iteration version
    public TreeNode upsideDownBinaryTree(TreeNode root){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode head = new TreeNode(0);
        TreeNode cur = head;
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            cur.right = node;
            if(!stack.isEmpty())
                node.left = stack.peek().right;
            cur = cur.right;
        }
        return head.right;
    }

    // Recursive version
    // public TreeNode upsideDownBinaryTree(TreeNode root){
    //     Treenode newRoot = root;
    //     while(newRoot.left!= null){
    //         newRoot = newRoot.left;
    //     }
    //     traversal(root);
    //     return newRoot;
    // }

    // private TreeNode traversal(TreeNode root){
    //     // base case
    //     if(root.left==null)
    //         return root;
    //     // general case
    //     Node node = traveral(root.left);
    //     node.right = root;
    //     node.left = root.right;
    //     root.left = null;
    //     root.right = null;
    //     return node.right;
    // }
}