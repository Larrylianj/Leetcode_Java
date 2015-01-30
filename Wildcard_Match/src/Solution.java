import java.util.Stack;

public class Solution {
	
	public static void main(String arg[]){
		Solution sol = new Solution();
		//String s = "babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb";
		//String p = "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a";
		String s = "aaa";
		String p = "aaa*";
		System.out.print(sol.isMatch(s, p));
	}
	
	// O(n!)
//    public boolean isMatch(String s, String p) {
//        int i,j;
//        
//        // pre-processing for p
//        j = 0;
//        while(j < p.length()-1){
//            if(p.charAt(j) == '*' && p.charAt(j+1) == '*'){
//                p = p.substring(0,j)+p.substring(j+1,p.length());
//            }else{
//                j++;
//            }
//        }
//        
//        i = 0;
//        j = 0;
//        while(i < s.length() && j < p.length()){
//            if(p.charAt(j) == '*' && j != p.length()-1){
//                int begin = i;
//                for(;begin < s.length();begin++){
//                    if(isMatch(s.substring(begin,s.length()), p.substring(j+1,p.length())))
//                        return true;
//                }
//                return false;
//            }else if(p.charAt(j) == '*'){ // the last char in p is *
//                return true;
//            }else if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
//                i++;
//                j++;
//            }else{ // s[i] and p[j] are normal chars and don't match
//                return false;
//            }
//        }
//        if(i < s.length()){
//            return false;
//        }else if(j < p.length()){
//            for(;j < p.length();j++)
//                if(p.charAt(j) != '*')
//                    return false;
//            return true;
//        }else{
//            return true;
//        }
//    }
    
    // O(mn)
	public boolean isMatch(String s, String p) {
        // DP O(n^2 m)
        boolean pre[] = new boolean[s.length()+1];
        boolean cur[] = new boolean[s.length()+1];
        // base case
        pre[0] = true;
        for(int i = 1;i < s.length()+1;i++)
            pre[i] = false;
        // iteration
        for(int j = 1;j < p.length()+1;j++){
        	for(int i = 1;i < s.length()+1;i++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='|')
                    cur[i] = pre[i-1];
                else
                    cur[i] = false;
                if(p.charAt(j-1)=='*'){
                    for(int t = 0;t <= i;t++)
                        cur[i] |= pre[t];
                }
            }
            for(int t = 0;t < s.length()+1;t++)
                pre[t] = cur[t];
        }
        
        return cur[s.length()];
    }
	
//    public boolean isMatch(String s, String p) {
//        // DFS
//        int i = 0, j = 0;
//        Stack<Integer> p_stack = new Stack<Integer>();
//        Stack<Integer> s_stack = new Stack<Integer>();
//        while(i < s.length()){
//            if(j >= p.length()){
//                if(p_stack.isEmpty()){
//                    return false;
//                }else{
//                    int index = s_stack.pop();
//                    s_stack.push(index+1);
//                    if(index >= s.length()){
//                        p_stack.pop();
//                        s_stack.pop();
//                    }else{
//                        i = index;
//                        j = p_stack.peek()+1;
//                    }
//                }
//            }else{
//                if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
//                    i++;
//                    j++;
//                }else if(p.charAt(j)=='*'){
//                    p_stack.push(++j);
//                    s_stack.push(i+1);
//                }else{
//                    if(p_stack.isEmpty()){
//                        return false;
//                    }else{
//                        int index = s_stack.pop();
//                        s_stack.push(index+1);
//                        if(index >= s.length()){
//                            p_stack.pop();
//                            s_stack.pop();
//                        }else{
//                            i = index;
//                            j = p_stack.peek()+1;
//                        }
//                    }
//                }
//            }
//        }
//        while(j < p.length()){
//            if(p.charAt(j)!='*')
//                return false;
//            j++;
//        }
//        return true;
//    }
}
