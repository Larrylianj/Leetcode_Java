import java.util.*;

//Definition for binary tree
class TreeNode {
	int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t00 = new TreeNode(1);
		TreeNode t01 = new TreeNode(2);
		TreeNode t02 = new TreeNode(3);
		t00.left = t01;
		t00.right = t02;
		Solution s = new Solution();
		System.out.println(s.maxPathSum(t00));
	}
	
	class GraphNode{
		int val;
		boolean leaf;
		List<GraphNode> neighbor;
		GraphNode(int x)
		{
			leaf = false;
			val  =x;
			neighbor = new ArrayList<GraphNode>();
		}
	}
	
	public int maxPathSum(TreeNode root) {
        
		// Convert Tree to Graph
		Stack<TreeNode> s_tree = new Stack<TreeNode>();
		Stack<GraphNode> s_graph = new Stack<GraphNode>();
		List<GraphNode> gross = new ArrayList<GraphNode>();
		TreeNode temp_tree;
		GraphNode temp_graph;
		
		if(root == null){return -1;}
		GraphNode head = new GraphNode(root.val);
		gross.add(head);
		s_tree.push(root);
		s_graph.push(head);
		while(!s_tree.isEmpty()){
			temp_tree = s_tree.pop();
			temp_graph = s_graph.pop();
			if(temp_tree.right == null && temp_tree.left == null){
				temp_graph.leaf = true;
			}
			if(temp_tree.right != null){
				GraphNode right = new GraphNode(temp_tree.right.val);
				gross.add(right);
				temp_graph.neighbor.add(right);
				right.neighbor.add(temp_graph);
				s_tree.push(temp_tree.right);
				s_graph.push(right);
			}
			if(temp_tree.left != null){
				GraphNode left = new GraphNode(temp_tree.left.val);
				gross.add(left);
				temp_graph.neighbor.add(left);
				left.neighbor.add(temp_graph);
				s_tree.push(temp_tree.left);
				s_graph.push(left);
			}
		}
		
		// for each node in the graph, bfs to get the maximum sum
		ArrayList<Integer> maxs = new ArrayList<Integer>();
		HashSet<GraphNode> visited = new HashSet<GraphNode>();
		int max = root.val;
		for(int i = 0;i < gross.size();i++){
			visited.clear();
			traverse(gross.get(i), 0, maxs, visited);
		}
		for(int i = 0;i < maxs.size();i++)
			if(maxs.get(i) > max)
				max = maxs.get(i);
		
		return max;
    }
	
	private void traverse(GraphNode cur, int cur_sum, ArrayList<Integer> maxs, HashSet<GraphNode> visited){
		cur_sum += cur.val;
		visited.add(cur);
		if(cur.leaf)
			maxs.add(cur_sum);
		for(int i = 0; i < cur.neighbor.size();i++)
			if(!visited.contains(cur.neighbor.get(i)))
				traverse(cur.neighbor.get(i), cur_sum, maxs, visited);
		
	}

}
