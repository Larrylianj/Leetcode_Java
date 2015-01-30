import java.util.Stack;

public class Solution {
	
	public static void main(String arg[]){
		Solution s = new Solution();
		String s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
		String s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
		String s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
		System.out.println(s.isInterleave(s1, s2, s3));
	}
	
	// DP O(nml)
//	public boolean isInterleave(String s1, String s2, String s3) {
//        
//        boolean opt[][][] = new boolean[s1.length()+1][s2.length()+1][s3.length()+1];
//        // base case
//        opt[0][0][0] = true;
//        // iteration
//        for(int i = 0;i <= s1.length();i++)
//            for(int j = 0;j <= s2.length();j++)
//                for(int k = 1;k <= s3.length();k++)
//                    if(i+j==k){
//                        if(i!=0)
//                            opt[i][j][k] = opt[i-1][j][k-1] && s1.charAt(i-1)==s3.charAt(k-1) || opt[i][j][k];
//                        if(j!=0)
//                            opt[i][j][k] = opt[i][j-1][k-1] && s2.charAt(j-1)==s3.charAt(k-1) || opt[i][j][k];
//                    }
//        return opt[s1.length()][s2.length()][s3.length()];
//    }
	
	// DP improved to O(nm)
	public boolean isInterleave(String s1, String s2, String s3) {
        // DP O(nm)
        boolean opt[][] = new boolean[s1.length()+1][s2.length()+1];
        // base case
        opt[0][0] = true;
        // iteration
        for(int i = 0;i <= s1.length();i++)
            for(int j = 0;j <= s2.length();j++)
                if(i+j <= s3.length()){
                    if(i!=0)
                        opt[i][j] = opt[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1) || opt[i][j];
                    if(j!=0)
                        opt[i][j] = opt[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1) || opt[i][j];
                }
        return s1.length()+s2.length()==s3.length()?opt[s1.length()][s2.length()]:false;
    }
    
	
	// DFS O(2^(n+m))
//    class Node{
//        int k; // the position in s3
//        int p; // the position in s1
//        int q; // the position in s2
//        Node(int a, int b, int c){
//            k = a;
//            p = b;
//            q = c;
//        }
//    }
//    
//    public boolean isInterleave(String s1, String s2, String s3) {
//        // DFS
//        Stack<Node> stack = new Stack<Node>();
//        Node zero = new Node(0,0,0);
//        stack.push(zero);
//        while(!stack.isEmpty()){
//            Node node = stack.pop();
//            if(node.k==s3.length() && node.p==s1.length() && node.q==s2.length())
//                return true;
//            if(node.k < s3.length()){
//            if(node.p < s1.length()){
//                if(s1.charAt(node.p)==s3.charAt(node.k)){
//                    Node node1 = new Node(node.k+1,node.p+1,node.q);
//                    stack.push(node1);
//                }
//            }
//            if(node.q < s2.length()){
//                if(s2.charAt(node.q)==s3.charAt(node.k)){
//                    Node node2 = new Node(node.k+1, node.p, node.q+1);
//                    stack.push(node2);
//                }
//            }
//            }
//        }
//        return false;
//    }
}