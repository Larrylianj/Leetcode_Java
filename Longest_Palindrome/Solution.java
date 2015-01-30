public class Solution {
    
    // O(n^2)
//    public String longestPalindrome(String s) {
//        String result = s;
//        int longest = 0;
//        for(int i = 1;i < s.length();i++){
//            int j = 1;
//            if(s.charAt(i-1)==s.charAt(i)){
//                while(i-1-j >=0 && i+j < s.length()){
//                    if(s.charAt(i-1-j)!=s.charAt(i+j))
//                        break;
//                    j++;
//                }
//                if(2*j > longest){
//                    longest = 2*j;
//                    result = s.substring(i-j,i+j);
//                }
//            }
//            j = 1;
//            while(i-j >= 0 && i+j < s.length()){
//                if(s.charAt(i-j)!=s.charAt(i+j))
//                    break;
//                j++;
//            }
//            if(2*j-1 > longest){
//                longest = 2*j-1;
//                result = s.substring(i-j+1,i+j);
//            }
//        }
//        return result;
//    }
    
    
    // O(n)
    public String longestPalindrome(String s) {
        String str = preProcess(s);
        int f[] = new int[str.length()];
        int longest = 0;
        int begin = 0, end = 0;
        
        // initialize
        int p = 0; // pivot
        f[0] = 1;
        
        // general case
        for(int i = 1;i < str.length();i++){
            
            int right = p+f[p]; // get pivot's right most range
            f[i] = 1; // if pivot's range not covers i, start from 1
            if(right > i){ // if pivot's range covers i
                if(right - i > f[2*p-i]) // if mirror's range is within pivot's range
                    f[i] = f[2*p-i];
                else // if pivot's range gives out but the right side still not decided
                    f[i] = right - i;
            }
            
            while(i-f[i] >= 0 && i + f[i] < str.length()){
                if(str.charAt(i-f[i])!=str.charAt(i+f[i]))
                    break;
                f[i]++;
            }
            
            if(f[i] + i > f[p] + p)
                p = i;
        }
        
        for(int i = 0;i < f.length;i++){
            if(f[i] > longest){
                longest = f[i];
                begin = (i-f[i]+1)/2;
                end = (i+f[i]-1)/2;
            }
        }
        
        return s.substring(begin,end);
    }
    
    private String preProcess(String s){
        StringBuilder str = new StringBuilder();
        str.append('#');
        for(int i = 0;i < s.length();i++){
            str.append(s.charAt(i));
            str.append('#');
        }
        return str.toString();
    }
}