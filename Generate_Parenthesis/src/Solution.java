import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;


	
	public class Solution {
	    public List<String> generateParenthesis(int n) {
	        List<List<String>> opt = new ArrayList<List<String>>();
	        // base case
	        List<String> zero = new ArrayList<String>();
	        List<String> one = new ArrayList<String>();
	        one.add("()");
	        opt.add(zero);
	        opt.add(one);
	        // iteration
	        for(int i = 2;i <= n;i++){
	            List<String> current = new ArrayList<String>();
	            HashSet<String> visited = new HashSet<String>();
	            for(int j = 1;j <= i/2;j++){
	                List<String> lst = combine(opt.get(j), opt.get(i-j), visited);
	                for(int u = 0;u < lst.size();u++)
	                    current.add(lst.get(u));
	            }
	            for(int j = 0;j < opt.get(i-1).size();j++){
	                String outer = "("+opt.get(i-1).get(j)+")";
	                current.add(outer);
	            }
	            opt.add(current);
	        }
	        
	        return opt.get(n);
	    }
	    
	    private List<String> combine(List<String> a, List<String> b, HashSet<String> visited){
	        List<String> output = new ArrayList<String>();
	        for(int i = 0;i < a.size();i++){
	            for(int j = 0;j < b.size();j++){
	                String left = a.get(i) + b.get(j);
	                String right = b.get(j) + a.get(i);
	                if(!visited.contains(left)){
	                    visited.add(left);
	                    output.add(left);
	                }
	                if(!visited.contains(right)){
	                    visited.add(right);
	                    output.add(right);
	                }
	            }
	        }
	        return output;
	    }
	    
	    // DFS version, COOL!
//	    public List<String> generateParenthesis(int n) {
//	        List<String> output = new ArrayList<String>();
//	        Stack<Node> stack = new Stack<Node>();
//	        Node initial = new Node("(",1,1);
//	        stack.push(initial);
//	        while(!stack.isEmpty()){
//	            Node node = stack.pop();
//	            // check valid
//	            if(node.used == n && node.left == 0){
//	                output.add(node.str);
//	            }
//	            
//	            // push in next possible Node
//	            if(node.used < n){
//	                Node leftParenNode = new Node(node.str+"(",node.used+1,node.left+1);
//	                stack.push(leftParenNode);
//	            }
//	            if(node.left > 0){
//	                Node rightParenNode = new Node(node.str+")",node.used,node.left-1);
//	                stack.push(rightParenNode);
//	            }
//	        }
//	        
//	        return output;
//	    }
	}

	class Node{
	    
	    String str; // "(" , ")"s
	    int used; // # of "("s used
	    int left; // # of "("s need to be matched
	    Node(String c,int x, int y){
	        str = new String(c);
	        used = x;
	        left = y;
	    }
	}
