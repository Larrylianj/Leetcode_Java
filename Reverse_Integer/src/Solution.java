
public class Solution {
	public static void main(String args[]){
		Solution s = new Solution();
		System.out.print(s.reverse(Integer.MIN_VALUE));
	}
	public int reverse(int x) {
        // edge case
        if(x == Integer.MIN_VALUE){return 0;}
        
        int result = 0;
        int digit = (int)Math.floor(Math.log10(Math.abs(x)));
        for(int i = digit;i >= 0;i--){
            // edge case
            if(digit == (int)Math.floor((Math.log10(Integer.MAX_VALUE))) && x <= 10 && x >= -10){
                if(x > 0){
                    if(x > 2){
                        return 0;
                    }else{
                        if(result > Integer.MAX_VALUE%(int)Math.pow(10,(int)Math.floor(Math.log10(Integer.MAX_VALUE)))){return 0;}
                    }
                }else{
                    if(x < -2){
                        return 0;
                    }else{
                        if(result < Integer.MIN_VALUE%(int)Math.pow(10,(int)Math.floor(Math.log10(Integer.MAX_VALUE)))){return 0;}
                    }
                }
            }
            // normal case
            result += x/(int)Math.pow(10,i) * Math.pow(10,digit-i);
            x = x%(int)Math.pow(10,i);
        }
        return result;
    }
}
