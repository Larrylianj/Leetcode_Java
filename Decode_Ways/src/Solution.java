import java.util.*;
public class Solution {
	public static void main(String arg[]){
		String s = "1333";
		Solution ss = new Solution();
		System.out.println(ss.numDecodings(s));
	}
	
    public int numDecodings(String s) {
        if(s.length()==0){return 0;}
        if(s.charAt(0) == '0'){return 0;}
        int opt[] = new int[s.length()+1];
        // base case 
        opt[0] = 0;
        opt[1] = 1;
        
        //iteration
        for(int i = 1;i < s.length();i++){
            if(s.charAt(i) == '0'){
                if(s.charAt(i-1) == '0' || s.charAt(i-1) > '2'){return 0;}
                else{
                    opt[i+1] = opt[i-1]>0?opt[i-1]:1;
                }
            }else if(s.charAt(i) > '6'){
                if(s.charAt(i-1) < '2' && s.charAt(i-1) > '0'){
                    opt[i+1] = opt[i]+opt[i-1]>2?opt[i]+opt[i-1]:2;
                }else{
                    opt[i+1] = opt[i];
                }
            }else{
                if(s.charAt(i-1) <= '2' && s.charAt(i-1) > '0'){
                    opt[i+1] = opt[i]+opt[i-1]>2?opt[i]+opt[i-1]:2;
                }else{
                    opt[i+1] = opt[i];
                }
            }
        }
        
        return opt[s.length()];
    }
}