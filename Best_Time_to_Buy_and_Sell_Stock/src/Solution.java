
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p[] = {2,5,1,3,5};
		Solution s = new Solution();
		System.out.println(s.maxProfit(p));
	}
	
	public int maxProfit(int[] prices) {
		if(prices.length == 0){return 0;}
        int opt[] = new int[prices.length];
        int min = prices[0];
        opt[0] = 0;
        for(int i = 1;i < prices.length;i++){
        	if(prices[i] < min)
        		min = prices[i];
        	opt[i] = max(prices[i] - min, opt[i-1]);
        }
		return opt[opt.length-1];
    }
	
	private int max(int a, int b){
		if(a > b)
		    return a;
		else
		    return b;
	}
}
