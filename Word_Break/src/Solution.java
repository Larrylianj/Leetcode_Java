import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = new String("leetcode");
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		Solution solu = new Solution();
		System.out.println(solu.wordBreak(s, dict));
	}
	
	public boolean wordBreak(String s, Set<String> dict) {
		// vars
		boolean flag;
		int i,j;
		int strLen = s.length();
        boolean opt[] = new boolean[strLen + 1];
        
        // base case
        opt[0] = true;
        
        // recursive
        for (i = 1;i < strLen + 1;i++){
        	flag = false;
        	for(j = 0;j < i; j++){
//        		System.out.println("i = "+i+" "+s.substring(j, i));
//        		System.out.println(dict.contains(s.substring(j, i)));
        		if (opt[j] && dict.contains(s.substring(j, i))){
        			flag = true;
        			break;
        		}
        	}
        	opt[i] = flag;
        }
        
        return opt[strLen];
        
    }

}
