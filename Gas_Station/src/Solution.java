import java.util.Arrays;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Solution s = new Solution();
		int gas[] = {4,2,1,5,7};
		int cost[] = {3,3,2,4,6};
		System.out.println(s.canCompleteCircuit(gas, cost));
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
        
		int tank = 0, start = 0, total = 0;
		for(int i = 0;i < gas.length;i++){
			tank = tank + gas[i] - cost[i];
			total += gas[i] - cost[i];
			if(tank < 0){
				start = i+1;
				tank = 0;
			}
		}
		
		return total >=0 ?start:-1;
		
//        int[][] opt = new int[gas.length][2*gas.length];
//        for(int i = 0;i < gas.length;i++){Arrays.fill(opt[i], -1);}
//        
//        // base case
//		for(int i = 0;i < gas.length;i++){opt[i][i] = 0;}
//		
//		// iteration
//		int real_j;
//		for(int i = 0;i < gas.length;i++){
//			for(int j = i+1;j <= i+gas.length;j++){
//				real_j = j %gas.length;
//				if(opt[i][j-1] >= 0){
//					if(real_j == 0){
//						opt[i][j] = opt[i][j-1] + gas[j-1] - cost[j-1];
//					}else{
//						opt[i][j] = opt[i][j-1] + gas[real_j-1] - cost[real_j-1];
//					}
//				}
//				if(opt[i][j] < 0){break;}
//			}
//			if(opt[i][i+gas.length] >=0){
//				return i;
//			}
//		}
//		
//		return 0;
    }
}
