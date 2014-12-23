public class Solution {
    private static final char romanChar[] = {'I','V','X','L','C','D','M'};
    private static final int romanInt[] = {1,5,10,50,100,500,1000};
    public String intToRoman(int num) {
        String result = "";
        while(num != 0){
            // go through romanInt from right to left 
            for(int i = romanInt.length-1;i >= 0;i--){
                // if the divide result is non-zero, means find one
                if(num/romanInt[i] != 0){
                    // add the corresponding romanChar
                    for(int j = 0;j < num/romanInt[i];j++)
                        result += romanChar[i];
                    //  set remainder to num
                    num %= romanInt[i];
                    break;
                }else{
                    // 4 case
                    if(i-1 >= 0){
                        if(romanInt[i] - num <= romanInt[i-1] && num/romanInt[i-1] == 4){
                            result += romanChar[i-1];
                            result += romanChar[i];
                            num %= romanInt[i-1];
                            break;
                        }
                    }
                    // 9 case
                    if(i-2 >= 0){
                        if(romanInt[i] - num <= romanInt[i-2] && num/romanInt[i-2] == 9){
                            result += romanChar[i-2];
                            result += romanChar[i];
                            num %= romanInt[i-2];
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
}