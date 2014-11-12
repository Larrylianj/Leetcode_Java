public class Solution {
    public int sqrt(int x) {
        int middle;
        int low = 0, high = Math.min(46340,x);
        while(low < high){
            middle = (low+high)/2;
            int product = middle*middle;
            if(product <= x && product+middle+middle+1 > x){return middle;}
            if(product < x)
                low = middle+1;
            if(product > x)
                high = middle-1;
        }
        return low;
    }
}