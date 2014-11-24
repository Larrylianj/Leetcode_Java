public class Solution {
    public String countAndSay(int n) {
        // base case
        if(n==1){return "1";}
        // recursive
        String output = "";
        String preStr = countAndSay(n-1);
        int count = 1;
        int cur_len = 1;
        char preChar = preStr.charAt(0);
        while(count < preStr.length()){
            if(preStr.charAt(count) == preChar){
                cur_len++;
            }else{
                output += Integer.toString(cur_len);
                output += preChar;
                cur_len = 1;
            }
            preChar = preStr.charAt(count);
            count++;
        }
        output += Integer.toString(cur_len);
        output += preChar; 
        return output;
    }
}