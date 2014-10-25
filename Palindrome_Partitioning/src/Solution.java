import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;


public class Solution {
	public static void main(String[] args){
		String s = "aabcdfsas";
		Solution ss = new Solution();
		ss.partition(s);
	}
	public List<List<String>> partition(String s) {
        List<List<String>> lst = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<String>();
        int len = s.length();
        boolean opt[][] = new boolean[len][len];
        
        // initialize
        for(int i = 0;i < len;i++){Arrays.fill(opt[i], false);}
        for(int i = 0;i < len;i++){opt[i][i] = true;}
        
        // recurrence
        for(int u = 1;u < len;u++){
        	for(int i = 0;i+u < len;i++){
        		if(u >= 2){
        			opt[i][i+u] = (opt[i+1][i+u-1] && s.charAt(i)==s.charAt(i+u));
        		}else if(u == 1){
        			opt[i][i+u] = s.charAt(i) == s.charAt(i+u)? true:false;
        		}
        	}
        }
        
        // generate result according to opt
        generateList(0,len,s,opt,temp,lst);
        
        //show result
        //System.out.print(lst);
        return lst;
    }
	
	private boolean generateList(int i, int len, String s, boolean opt[][], List<String> temp,List<List<String>> lst){
		for(int j = 0;j < len; j ++){
			if(opt[i][j]){
				List<String> newCombo = new ArrayList<String>(temp);
				newCombo.add(s.substring(i, j+1));
				if(j == len-1){
					lst.add(newCombo);
				}else{
					generateList(j+1,len,s,opt,newCombo,lst);
				}
			}
		}
		return true;
	}
}
