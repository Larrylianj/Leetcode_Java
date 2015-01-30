public class Solution {
    // 这时的我好强啊，这都想得出来，乘之前先看就行了！
//    public int atoi(String str) {
//        int result = 0;
//        int i = 0;
//        boolean negative = false;
//        int numOfSign = 0;
//        while(i < str.length()){
//            if(str.charAt(i)!=' '){break;}
//            i++;
//        }
//        while(i < str.length()){
//            if(str.charAt(i) == '-'){negative = true;numOfSign++;}
//            else if(str.charAt(i) == '+'){numOfSign++;}
//            else if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
//                if(result < Integer.MIN_VALUE/10){return negative?Integer.MIN_VALUE:Integer.MAX_VALUE;}
//                result *= 10;
//                if(negative){
//                    if(result < Integer.MIN_VALUE+str.charAt(i)-'0'){return Integer.MIN_VALUE;}
//                }else{
//                    if(-result > Integer.MAX_VALUE-(str.charAt(i)-'0')){return Integer.MAX_VALUE;}
//                }
//                result -= str.charAt(i)-'0';
//            }else{
//                return negative?result:-result;
//            }
//            if(numOfSign > 1){return 0;}
//            i++;
//        }
//        return negative?result:-result;
//    }
    
    // modified a little to be more clear
    public int atoi(String str) {
        boolean minus = false, plus = false;
        int value = 0, i = 0;
        while(i < str.length()){
            if(str.charAt(i)!=' ')
                break;
            i++;
        }
        while(i < str.length()){
            char c = str.charAt(i);
            if(c >= '0' && c <= '9'){
                if(-value < Integer.MIN_VALUE/10 || value > Integer.MAX_VALUE/10)
                    return minus?Integer.MIN_VALUE:Integer.MAX_VALUE;
                value *= 10;
                if(minus && -value < Integer.MIN_VALUE + (c-'0'))
                    return Integer.MIN_VALUE;
                if(!minus && value > Integer.MAX_VALUE - (c-'0'))
                    return Integer.MAX_VALUE;
                value += (int)(c-'0');
            }else if(c=='-'){
                if(minus)
                    return 0;
                minus = true;
            }else if(c=='+'){
                if(plus)
                    return 0;
                plus = true;
            }else{
                break;
            }
            i++;
        }
        if(minus && plus)
            return 0;
        return minus?-value:value;
    }
}