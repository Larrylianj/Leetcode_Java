public class Solution {
    public double pow(double x, int n) {
        if(n == 0){return 1.0;}
        if(n == 1){return x;}
        if(n < 0){
            double half = pow(x,-n/2);
            return n%2 == 0?(1/(half*half)):(1/(half*half*x));
        }else{
            double half = pow(x,n/2);
            return n%2 == 0?half*half:half*half*x;
        }
    }
}

// better using x^7 = x^4*x^2*x^1
    public double pow(double x, int n) {
        int bit = 1;
        int absN = n >0?n:-n;
        int curBit = 0;
        double result = 1.0;
        double cur_product = x;
        for(int i = 0;i < 31;i++){
            if((absN & (bit << i)) != 0){
                for(;curBit < i;curBit++)
                    cur_product *= cur_product;
                result *= cur_product;
            }
        }
        return n > 0?result:1/result;
    }