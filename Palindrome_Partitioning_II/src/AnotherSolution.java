import java.util.Arrays;


public class AnotherSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aabca";
		AnotherSolution ss = new AnotherSolution();
		System.out.print(ss.minCut(s));
	}
	
	public int minCut(String s) { //This method is O(n^2), in Solution.java, there is a O(n^3) solution
		int len = s.length();
        int opt[] = new int[len+1]; // Optimal minCut for first n characters
        
        // base case
        for(int i = 0;i <= len;i++){
        	opt[i] = i-1;
        }
        
        // recurrence
        for(int i = 0;i < len;i++){ // odd number palindrome
        	for(int j = 0;i-j >= 0 && i+j < len;j++){
        		if(s.charAt(i-j)==s.charAt(i+j)){
        			opt[i+j+1] = min(opt[i+j+1],opt[i-j]+1);
        		}
        	}
        	for(int j = 1;i-j+1 >= 0 && i+j < len;j++){
        		if(s.charAt(i-j+1)==s.charAt(i+j)){
        			opt[i+j+1] = min(opt[i+j+1],opt[i-j+1]+1);
        		}
        	}
        }
        return opt[len];
        
    }

	private int min(int i, int j) {
		// TODO Auto-generated method stub
		return i>j?j:i;
	}

}
