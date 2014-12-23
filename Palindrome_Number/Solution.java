public class Solution {
    private static final int maxBit = (int)Math.floor(Math.log10(Integer.MAX_VALUE));
    public boolean isPalindrome(int x) {
        if(x < 0){return false;}
        if(x == 0){return true;}
        int i = 0,j = maxBit;
        while(x / (int)Math.pow(10,j) == 0){j--;}
        while(i < j){
            if((x % (int)Math.pow(10,i+1) - x % (int)Math.pow(10,i))/(int)Math.pow(10,i) != x / (int)Math.pow(10,j)){return false;}
            x = x % (int)Math.pow(10,j);
            i++;
            j--;
        }
        return true;
    }
}