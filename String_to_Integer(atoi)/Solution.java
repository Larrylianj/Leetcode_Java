public class Solution {
    public int atoi(String str) {
        int result = 0;
        int i = 0;
        boolean negative = false;
        int numOfSign = 0;
        while(i < str.length()){
            if(str.charAt(i)!=' '){break;}
            i++;
        }
        while(i < str.length()){
            if(str.charAt(i) == '-'){negative = true;numOfSign++;}
            else if(str.charAt(i) == '+'){numOfSign++;}
            else if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                if(result < Integer.MIN_VALUE/10){return negative?Integer.MIN_VALUE:Integer.MAX_VALUE;}
                result *= 10;
                if(negative){
                    if(result < Integer.MIN_VALUE+str.charAt(i)-'0'){return Integer.MIN_VALUE;}
                }else{
                    if(-result > Integer.MAX_VALUE-(str.charAt(i)-'0')){return Integer.MAX_VALUE;}
                }
                result -= str.charAt(i)-'0';
            }else{
                return negative?result:-result;
            }
            if(numOfSign > 1){return 0;}
            i++;
        }
        return negative?result:-result;
    }
}