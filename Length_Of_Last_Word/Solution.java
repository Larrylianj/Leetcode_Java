public class Solution {
    public int lengthOfLastWord(String s) {
        int pos = -1;
        int end = s.length()-1;
        while(end >= 0){
            if(s.charAt(end) == ' ')
                end--;
            else
                break;
        }
        for(int i = 0;i < end;i++){
            if(s.charAt(i) == ' ')
                pos = i;
        }
        return end-pos;
    }
}