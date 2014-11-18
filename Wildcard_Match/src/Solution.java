public class Solution {
	
	public static void main(String arg[]){
		Solution sol = new Solution();
		String s = "babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb";
		String p = "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a";
		System.out.print(sol.isMatch(s, p));
	}
	
	// O(n!)
    public boolean isMatch(String s, String p) {
        int i,j;
        
        // pre-processing for p
        j = 0;
        while(j < p.length()-1){
            if(p.charAt(j) == '*' && p.charAt(j+1) == '*'){
                p = p.substring(0,j)+p.substring(j+1,p.length());
            }else{
                j++;
            }
        }
        
        i = 0;
        j = 0;
        while(i < s.length() && j < p.length()){
            if(p.charAt(j) == '*' && j != p.length()-1){
                int begin = i;
                for(;begin < s.length();begin++){
                    if(isMatch(s.substring(begin,s.length()), p.substring(j+1,p.length())))
                        return true;
                }
                return false;
            }else if(p.charAt(j) == '*'){ // the last char in p is *
                return true;
            }else if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
                i++;
                j++;
            }else{ // s[i] and p[j] are normal chars and don't match
                return false;
            }
        }
        if(i < s.length()){
            return false;
        }else if(j < p.length()){
            for(;j < p.length();j++)
                if(p.charAt(j) != '*')
                    return false;
            return true;
        }else{
            return true;
        }
    }
    
    // O(mn)
}