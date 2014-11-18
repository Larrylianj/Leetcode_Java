public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!= s2.length()){return false;}
        if(s1.length() == 1 && s2.length() == 1){return s1.charAt(0)==s2.charAt(0)?true:false;}
        if(!shareSameCharSet(s1,s2)){return false;}
            
        for(int i = 0;i < s1.length();i++){
            if(isScramble(s1.substring(0,i),s2.substring(0,i)) && isScramble(s1.substring(i,s1.length()),s2.substring(i,s1.length()))){return true;}
            if(isScramble(s1.substring(0,i),s2.substring(s1.length()-i,s1.length())) && isScramble(s1.substring(i,s1.length()),s2.substring(0,s1.length()-i))){return true;}
        }
        
        return false;
    }
    
    private boolean shareSameCharSet(String s1,String s2){
        int charSet_s1[] = new int[26];
        int charSet_s2[] = new int[26];
        for(int i = 0;i < s1.length();i++){
            for(int j = 0;j < 26;j++){
                if(s1.charAt(i) == ('a'+j))
                    charSet_s1[j]++;
                if(s2.charAt(i) == ('a'+j))
                    charSet_s2[j]++;
            }
        }
        for(int j = 0;j < 26;j++)
            if(charSet_s1[j] != charSet_s2[j]){return false;}
        return true;
    }
}