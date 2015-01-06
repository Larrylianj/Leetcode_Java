public class Solution {
    //private int upperBound = (int)Math.floor(Math.log(Inter.MAX_VALUE)/Math.log(5));
    public int trailingZeroes(int n) {
        // the # of 5 in the factorial = the # of trailing zeros
        if(n==0){return 0;}
        int powers = (int)Math.floor(Math.log(n)/Math.log(5));
        int result = n/5;
        while(powers > 1){
            result += n/(int)Math.pow(5,powers);
            powers--;
        }
        return result;
    }
}