import java.util.*;


public class AnotherSolution {

	public static void main(String[] args) {
		TreeNode t00 = new TreeNode(5);
		TreeNode t01 = new TreeNode(4);
		TreeNode t02 = new TreeNode(8);
		TreeNode t03 = new TreeNode(11);
		TreeNode t04 = new TreeNode(13);
		TreeNode t05 = new TreeNode(4);
		TreeNode t06 = new TreeNode(7);
		TreeNode t07 = new TreeNode(2);
		TreeNode t08 = new TreeNode(1);
		t00.left = t01;
		t00.right = t02;
		t01.left = t03;
		t03.left = t06;
		t03.right = t07;
		t02.left = t04;
		t02.right = t05;
		t05.right = t08;
		AnotherSolution s = new AnotherSolution();
		System.out.println(s.maxPathSum(t00));		
	}
	public int maxPathSum(TreeNode root) {
		ArrayList<Integer> maxs = new ArrayList<Integer>();
		if(root == null){return 0;}
		if(root.left == null && root.right == null){return root.val;}
		int max = root.val;
		maxSum(root,maxs);
		for(int i = 0;i < maxs.size();i++)
			if(maxs.get(i) > max)
				max = maxs.get(i);
		return max;
	}
    
    private int maxSum(TreeNode root, ArrayList<Integer> maxs){
    	if(root == null)
    		return 0;
    	else{
    		int	right = maxSum(root.right,maxs);
    		int	left = maxSum(root.left,maxs);
    		int max = max(max(right+root.val,left+root.val),max(root.val,right+root.val+left));
    		maxs.add(max);
    		return max(max(right+root.val,left+root.val),root.val);
    	}
    }
    
    
	private int max(int a, int b){
		if(a > b)
		    return a;
		else
		    return b;
	}

}
