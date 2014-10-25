import java.util.Arrays;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ratings[] = new int[]{1,2,6,6,6,4,2,5,3,2,1};
		Solution s = new Solution();
		int sum = s.candy(ratings);
		System.out.println(sum);
		
	}
	
	public int candy(int[] ratings) {
        int cur = 0;
        int candy[] = new int[ratings.length];
        boolean tie_pos[] = new boolean[ratings.length];
        Arrays.fill(candy, 1);
        Arrays.fill(tie_pos, false);
        for(int i = 0; i < ratings.length - 1;i++){
        	if(ratings[i] < ratings[i + 1]){
        		candy[i + 1] = candy[i] + 1;
        		cur ++;
        	}else if(ratings[i] == ratings[i + 1]){
        		candy[i + 1] = candy[i];
        		tie_pos[i + 1] = true;
        		cur ++;
        	}else{
        		candy[i + 1] = candy[i] - 1;
        		if(candy[i + 1] < 1){
        			for(int j = i + 1;j >= cur;j--){
        				candy[j] ++;
        			}
        			int j = cur;
        			while(tie_pos[j]){
        				candy[j - 1] = candy[j];
        				j--;
        			}
        		}
        		if(i + 2 == ratings.length && candy[i + 1] > 1){
        			int gap = candy[i + 1] - 1;
        			for(int j = i + 1;j > cur;j--){
        				candy[j] -= gap;
        			}
        		}
        		if(i + 2 < ratings.length && ratings[i + 1] < ratings[i + 2]){
        			if(candy[i + 1] > 1){
        				int gap = candy[i + 1] - 1;
            			for(int j = i + 1;j > cur;j--){
            				candy[j] -= gap;
            			}
        			}
        			cur = i + 1;
        		}
        	}
        }
		int sum = 0;
		for(int i = 0;i < candy.length;i++){
			sum += candy[i];
		}
		return sum;
    }

}
