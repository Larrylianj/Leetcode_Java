public class Solution {
    public String longestPalindrome(String s) {
        String result = s;
        int longest = 0;
        for(int i = 1;i < s.length();i++){
            int j = 1;
            if(s.charAt(i-1)==s.charAt(i)){
                while(i-1-j >=0 && i+j < s.length()){
                    if(s.charAt(i-1-j)!=s.charAt(i+j))
                        break;
                    j++;
                }
                if(2*j > longest){
                    longest = 2*j;
                    result = s.substring(i-j,i+j);
                }
            }
            j = 1;
            while(i-j >= 0 && i+j < s.length()){
                if(s.charAt(i-j)!=s.charAt(i+j))
                    break;
                j++;
            }
            if(2*j-1 > longest){
                longest = 2*j-1;
                result = s.substring(i-j+1,i+j);
            }
        }
        return result;
    }
}