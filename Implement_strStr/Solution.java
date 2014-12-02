public class Solution {
    public int strStr(String haystack, String needle) {
        // trival case
        if(needle.length() == 0){return 0;}
        
        // KMP Algorithm
        int n = haystack.length();
        int m = needle.length();
        int table[] = new int[m];
        
        // construct table
        if(m > 0){table[0] = -1;}
        if(m > 1){table[1] = 0;}
        for(int i = 2,j = 0;i < m;){
            // when current position matches previous 
            if(needle.charAt(i-1)==needle.charAt(j)){
                table[i++] = ++j;
            }
            
            // when current position doesn't match, back trace until match
            else{
                if(j > 0)
                    j = table[j];
                else
                    table[i++] = 0;
            }
        }
        
        // kmp match
        for(int i = 0,j = 0;i < haystack.length() && j < needle.length();){
            if(haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
                if(j == needle.length()){return i-needle.length();}
            }else{
                if(j == 0){
                    i++;
                }else{
                    j = table[j];
                }
            }
        }
        
        return -1;
    }
}