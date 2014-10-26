import java.util.Arrays;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = new String();
		s = ")()(())(";
		System.out.print(longestValidParentheses(s));
	}

	public static int longestValidParentheses(String s) {
		
		boolean[][] opt = new boolean[s.length()][s.length()];
		int i,j;
		int count = 0;
		for(i = 0; i < s.length(); i++){
			for(j = 0; j < s.length(); j ++){
				if(j > i){
					opt[i][j] = Opt(s,i,j);
				}else{
					opt[i][j] = false;
				}
			}
		}
//		for(i = 0; i < s.length(); i++){
//			for(j = 0; j < s.length(); j ++){
//				if(i == j-1){
//					if((s.charAt(i) == '(') && (s.charAt(j) == ')')){
//						opt[i][j] = true;
//					}else{
//						opt[i][j] = false;
//					}
//				}else{
//					if((s.charAt(i) == '(') && (s.charAt(j) == ')')){
//						flag = false;
//						for(k = i+1; k < j - 1; k++){
//							if ((opt[i + 1][k] == true) && (opt[k+1][j - 1] == true)){
//								flag = true;
//							}
//						}
//						opt[i][j] = flag;
//					}
//				}
//			}
//		}
		
		
		for(i = 0; i < s.length(); i++){
			for(j = 0; j < s.length(); j ++){
			
				System.out.println("opt["+i+"]["+j+"]="+opt[i][j]);
				if(opt[i][j] == true && j > i){
					if(count < j-i+1){
						count = j-i+1;
					}
				}
			}
		}
		
		return count;
		
    }
	
	public static boolean Opt(String s, int i, int j){
		boolean flag;
		int k;
		if(i == j){
			return false;
		}
		if(i == j-1){
			if((s.charAt(i) == '(') && (s.charAt(j) == ')')){
				return true;
			}else{
				return false;
			}
		}else{
			if((s.charAt(i) == '(') && (s.charAt(j) == ')')){
				flag = false;
				if (Opt(s,i+1,j-1)){
					flag = true;
				}
				for(k = i; k < j ; k++){
					if (Opt(s,i,k) && Opt(s,k+1,j)){
						flag = true;
					}
				}
				return flag;
			}
			return false;
		}
	}
	
}
