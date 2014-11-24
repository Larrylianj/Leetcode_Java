import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {
	
	public static void main(String arg[]){
		String s = ")(((((()())()()))()(()))(";
		Solution ss = new Solution();
		System.out.print(ss.longestValidParentheses(s));
	}
	
	
	// DP get time limited
//	public int longestValidParentheses(String s) {
//        int n = s.length();
//        boolean opt[][] = new boolean[n][n];
//        int max = 0;
//        
//        // base case
//        
//        // iteration
//        for(int offset = 1;offset < n;offset++){
//            for(int i = 0;i < n;i++){
//                int j = i+offset;
//                if(j < n){
//                    if(s.charAt(i)=='(' && s.charAt(j)==')'){
//                        if(opt[i+1][j-1] || i+1==j){opt[i][j] = true;}
//                        for(int t = i;t < j-1;t++)
//                            if(opt[i][t] && opt[t+1][j])
//                                opt[i][j] = true;
//                    }
//                    if(opt[i][j]){
//                        if(j-i+1 > max)
//                            max = j-i+1;
//                    }
//                }
//            }
//        }
//        return max;
//    }
	
	public int longestValidParentheses(String s) {
        boolean isValid[] = new boolean[s.length()];
        Stack<Integer> stack = new Stack<Integer>();
        int count = 0;
        int max = 0;
        
        // give all position isValid confirm
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                if(!stack.isEmpty()){
                    int begin = stack.pop();
                    isValid[begin] = true;
                    isValid[i] = true;
                }
            }
        }
        
        // find longest consecutive valid range
        for(int i = 0;i < isValid.length;i++){
            if(isValid[i]){
                count++;
            }else{
                if(count > max)
                    max = count;
                count = 0;
            }
        }
        if(count > max)
            max = count;
        
        return max;
    }
}

class Range{
    int begin;
    int end;
    Range(int x,int y){
        begin = x;
        end = y;
    }
}
