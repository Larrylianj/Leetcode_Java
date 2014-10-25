
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String ss = "A man, a plan, a canal: Panama";
		String ss = ".";
		Solution s = new Solution();
		System.out.println(s.isPalindrome(ss));

	}
	
	public boolean isPalindrome(String s) {
        for(int i = 0,j = s.length()-1; i < j;i++,j--){
        	while(!validChar(s.charAt(i)) && i < s.length()-1)
        		i++;
        	while(!validChar(s.charAt(j)) && j > 0)
        		j--;
        	if(i >= j)
        		break;
        	if(LowerCase(s.charAt(i)) != LowerCase(s.charAt(j))){
        		return false;
        	}
        }
        
        return true;
    }
	
	private boolean validChar(char c){
		if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0' && c <= '9'){
			return true;
		}
		return false;
	}
	
	private char LowerCase(char c){
		if(c >= 'A' && c <= 'Z'){
			c -= 'A'-'a';
		}
		return c;
	}

}
