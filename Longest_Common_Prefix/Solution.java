public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int pointer = -1;
        if(strs.length==0){return "";}
        boolean valid = true;
        while(valid){
            char c;
            pointer++;
            // get the char at pointer of first string as pivot
            if(pointer < strs[0].length())
                c = strs[0].charAt(pointer);
            else
                break;
                
            // compare the pivot with the rest string at pointer position
            for(int i = 1;i < strs.length;i++){
                if(pointer < strs[i].length()){
                    if(strs[i].charAt(pointer)!=c){
                        valid = false;
                        break;
                    }
                }else{
                   valid = false;
                   break;
                }
            }
        }
        return strs[0].substring(0,pointer);
    }
}