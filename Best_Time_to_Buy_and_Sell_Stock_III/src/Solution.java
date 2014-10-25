import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int p[] = {1,2,4,2,5,7,2,4,9,0};
		Solution s = new Solution();
		System.out.println(s.maxProfit(p));
	}
	
	public int maxProfit(int[] prices) {
		if(prices.length <= 3){
			return subProfit(prices);
		}
		int max = 0;
		for(int i = 1;i < prices.length-1;i++){
			int sub1[] = new int[i];
			int sub2[] = new int[prices.length - i];
			for(int j = 0;j < i;j++)
				sub1[j] = prices[j];
			for(int j = i;j < prices.length;j++)
				sub2[j-i] = prices[j];
			int cur = subProfit(sub1)+subProfit(sub2);
			if(cur > max)
				max = cur;
		}
		return max;
    }
	
	private int subProfit(int[] prices) {
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
