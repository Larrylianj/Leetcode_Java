
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p[] = {1,2,5,6};
		Solution s = new Solution();
		System.out.println(s.maxProfit(p));
	}
	public int maxProfit(int[] prices) {
		if(prices.length == 0){return 0;}
        int opt[] = new int[prices.length];
		int profit = 0,min = prices[0];
		opt[0] = 0;
		for(int i = 1;i < prices.length;i++){
			if(prices[i] > prices[i-1]){
				opt[i] = max(prices[i] - min, opt[i-1]);
				if(i == prices.length-1){profit += opt[i];}
			}else{
				min = prices[i];
				profit += opt[i-1];
				opt[i] = 0;
			}
		}
		return profit;
    }
	
	private int max(int a, int b){
		if(a > b)
		    return a;
		else
		    return b;
	}

}
