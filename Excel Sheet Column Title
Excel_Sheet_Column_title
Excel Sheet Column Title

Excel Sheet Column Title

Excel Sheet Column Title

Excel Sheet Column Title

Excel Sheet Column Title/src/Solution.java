public class Solution {
	
	public static void main(String args[]){
		Solution s = new Solution();
		System.out.println(s.convertToTitle(702));
	}
	
    private static final int base = 26;
    public String convertToTitle(int n) {
    	String result = "";
        int digits = (int)Math.floor(Math.log(n)/Math.log(base));
        int lowerPart = 0;
        for(int i = 0;i < digits;i++)
            lowerPart += (int)Math.pow(base,i);
        while(n != 0){
            int divisor = (int)Math.pow(base,digits);
            int number = (n-lowerPart)/divisor;
            if(number!= 0)
                result += (char)(number+'A'-1);
            n -= number*divisor;
            digits--;
            lowerPart -= (int)Math.pow(base,digits);
        }
        return result;
    }
}