
import java.util.Arrays;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aab";
		Solution ss = new Solution();
		System.out.print(ss.minCut(s));
	}
	
	public int minCut(String s) { //This method is O(n^3), in AnotherSolution.java, there is a O(n^2) solution
		int len = s.length();
        boolean opt[][] = new boolean[len][len];
        int min[][] = new int[len][len];
        int temp_min;
        
        // initialize
        for(int i = 0;i < len;i++){Arrays.fill(opt[i], false);Arrays.fill(min[i], len);}
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
        
        // fill in min[][]
        for(int i = 0;i < len;i++){
        	for(int j = 0;j < len;j++){
        		if(opt[i][j]){min[i][j] = 1;}
        	}
        }
        
        for(int i = 0;i < len;i++){
        	for(int j = 0;j < len;j++){
        		if(!opt[i][j]){
        			temp_min = len;
        			for(int t = i;t < j;t++){
        				if(temp_min > min[i][t]+min[t+1][j]){
        					temp_min = min[i][t]+min[t+1][j];
        				}
        			}
        			min[i][j] = temp_min;
        		}
        	}
        }
        
        return min[0][len-1];
        
    }
}
