
public class Solution {
	public static void main(String args[]){
		Solution ss = new Solution();
		String s = "aaa";
		String p = "ab*ac*a";
		System.out.print(ss.isMatch(s, p));
	}
	public boolean isMatch(String s, String p) {
        //DP
        boolean opt[][] = new boolean[s.length()+1][p.length()+1];
        //base case
        opt[0][0] = true;
        for(int i = 1;i < s.length()+1;i++){opt[i][0] = false;}
        for(int j = 1;j < p.length()+1;j++){
            if(j >= 2){
                opt[0][j] = p.charAt(j-1)=='*'?opt[0][j-2]:false;
                continue;
            }
            opt[0][j] = false;
        }
        // iteration
        for(int i = 1;i < s.length()+1;i++){
            for(int j = 1;j < p.length()+1;j++){
                if(j >= 2 && p.charAt(j-1)=='*'){
                    opt[i][j] = (s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.')?(opt[i-1][j-2] || opt[i-1][j-1] || opt[i-1][j]):false;
                    opt[i][j] = opt[i][j-2] || opt[i][j];
                    continue;
                }
                opt[i][j] = (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.')?opt[i-1][j-1]:false;
            }
        }
        
        return opt[s.length()][p.length()];
    }
}
