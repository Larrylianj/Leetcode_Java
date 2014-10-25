import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.print(s.generateTrees(3));
		
	}
	
	public List<TreeNode> generateTrees(int n) {
        List<TreeNode> output = new ArrayList<TreeNode>();
        if(n == 0){
            output.add(null);
            return output;
        }
        output = subTrees(1,n);
        return output;
    }
    
    private ArrayList<TreeNode> subTrees(int begin, int end){
        ArrayList<TreeNode> output = new ArrayList<TreeNode>();
        if(begin == end){
            TreeNode node = new TreeNode(begin);
            output.add(node);
            return output;
        }
        for(int i = begin;i <= end;i++){
            TreeNode node;
            if(i == begin){
                ArrayList<TreeNode> temp = subTrees(begin+1,end);
                for(int j = 0;j < temp.size();j++){
                    node = new TreeNode(i);
                    node.right = temp.get(j);
                    output.add(node);
                }
            }else if(i == end){
                List<TreeNode> temp = subTrees(begin,end-1);
                for(int j = 0;j < temp.size();j++){
                	node = new TreeNode(i);
                    node.left = temp.get(j);
                    output.add(node);
                }
            }else{
                List<TreeNode> forward = subTrees(begin,i-1);
                List<TreeNode> back = subTrees(i+1,end);
                for(int j = 0;j < forward.size();j++){
                    for(int k = 0;k < back.size();k++){
                    	node = new TreeNode(i);
                        node.left = forward.get(j);
                        node.right = back.get(k);
                        output.add(node);
                    }
                }
            }
        }
        return output;
    }

}
