
public class Solution {
	public static void main(String arg[]){
		Solution s = new Solution();
		//System.out.print(Math.ceil(Integer.MAX_VALUE/2.0));
		System.out.println(s.pow(0.0001, Integer.MAX_VALUE));
	}
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