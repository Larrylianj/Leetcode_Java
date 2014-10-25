import java.util.Arrays;


public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int ratings[] = new int[]{4,4,5,6,7,4,1,1,1,3,1,3,4,4,};
		int ratings[] = new int[]{2,2};
		//int ratings[] = new int[]{1,3,6,4,5,4,4,3,2,1};
		Solution2 s = new Solution2();
		int sum = s.candy(ratings);
		System.out.println(sum);
		
	}
	
	public int candy(int[] ratings) {
        int cur = 0;
        int candy[] = new int[ratings.length];
        boolean tie_pos[] = new boolean[ratings.length];
        Arrays.fill(candy, 1);
        Arrays.fill(tie_pos, false);
        for(int i = 0;i < ratings.length - 1;i++){
        	if(ratings[i] < ratings[i + 1]){
        		candy[i+1] = candy[i] + 1;
        		cur = i+1;
        	}else if( ratings[i] > ratings[i+1]){
        		candy[i+1] = candy[i] - 1;
        		if(candy[i+1] < 1){
        			for(int j = i+1;j >= cur;j --){
        				candy[j]++;
        			}
        		}
        		if(i + 2 == ratings.length && candy[i + 1] > 1){
        			int gap = candy[i + 1] - 1;
        			for(int j = i + 1;j > cur;j--){
        				candy[j] -= gap;
        			}
        		}
        	}else if(ratings[i] == ratings[i+1]){
        		candy[i+1] = 1;
        		cur = i+1;
        	}
        	if(i+2 < ratings.length && ratings[i] >= ratings[i+1] && ratings[i+1] <= ratings[i+2]){
        		if(candy[i + 1] > 1){
    				int gap = candy[i + 1] - 1;
        			for(int j = i + 1;j > cur;j--){
        				candy[j] -= gap;
        			}
    			}
        		//cur = i+2;
    		}
        }
        
		int sum = 0;
		for(int i = 0;i < candy.length;i++){
			sum += candy[i];
		}
		return sum;
	}

}
