
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String s1 = "xstjzkfpkggnhjzkpfjoguxvkbuopi";
		String s2 = "xbouipkvxugojfpkzjhnggkpfkzjts";
		System.out.print(s.isScramble(s1, s2));

	}
	public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()){return false;}
        if(s1.length() == 1){return s1.charAt(0)==s2.charAt(0)?true:false;}
        if(s1.length() == 2){return (s1.charAt(0)==s2.charAt(1) && s1.charAt(1)==s2.charAt(0)) ||s1.equals(s2)?true:false;}
	    for(int i = 1;i < s1.length();i++){
	    	if(s1.substring(0, i).equals(s2.substring(0,i))){return isScramble(s1.substring(i, s1.length()-1),s2.substring(i,s2.length()-1));}
	    	
	    	if(s1.substring(i, s1.length()-1).equals(s2.substring(i,s2.length()-1))){return isScramble(s1.substring(0,i),s2.substring(0,i));}
	    	
	    	if(s1.substring(0, i).equals(s2.substring(s2.length()-1-i, s2.length()-1))){return isScramble(s1.substring(i, s1.length()-1),s2.substring(0,s2.length()-1-i));}
	    	
	    	if(s1.substring(s1.length()-1-i,s1.length()-1).equals(s2.substring(0,i))){return isScramble(s1.substring(0,s1.length()-1-i),s2.substring(i, s2.length()-1));}
	    	
	        if(isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i,s1.length()),s2.substring(i,s2.length()))){return true;}
	        if(isScramble(s1.substring(0,i),s2.substring(s2.length()-1-i,s2.length()-1)) && isScramble(s1.substring(s1.length()-1-i,s1.length()-1),s2.substring(0,i))){return true;}
	    }
	    return false;
    }
}
