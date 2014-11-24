public class Solution {
    static final int integerBits = 31;
    public int divide(int dividend, int divisor) {
        int i,shifted = divisor;
        boolean positive = true;
        
        // extra case Integer.MIN_VALUE
        if(dividend == Integer.MIN_VALUE){
            if(divisor == Integer.MIN_VALUE){return 1;}
            if(divisor==1 || divisor==-1){return divisor==1?dividend:Integer.MAX_VALUE;}
            if(divisor==2 || divisor==-2){return divisor==2?-1073741824:1073741824;}
            dividend++;
        }
        if(divisor == Integer.MIN_VALUE){
            return 0;
        }
        
        // turn to positive
        if(dividend < 0 && divisor > 0){
            positive = false;
            dividend = -dividend;
        }
        if(dividend > 0 && divisor < 0){
            positive = false;
            divisor = -divisor;
        }
        if(dividend < 0 && divisor < 0){
            divisor = -divisor;
            dividend = -dividend;
        }
        
        // base case
        if(divisor == 1){return positive?dividend:-dividend;}
        if(dividend < divisor){return 0;}
        if(dividend == divisor){return positive?1:-1;}
        
        // recursive
        for(i = 0;i < integerBits-1;i++){
            shifted = divisor << i;
            if(shifted <= dividend && ((shifted << 1) > dividend || (shifted << 1) < 0)){
                break;
            }
        }
        
        return positive?((int)Math.pow(2,i) + divide(dividend-shifted, divisor)):-((int)Math.pow(2,i) + divide(dividend-shifted, divisor));
    }
}