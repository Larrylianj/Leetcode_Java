import java.math.BigInteger;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sample[] = {43,16,45,89,45,-2147483648,45,2147483646,-2147483647,-2147483648,43,2147483647,-2147483646,-2147483648,89,-2147483646,89,-2147483646,-2147483647,2147483646,-2147483647,16,16,2147483646,43};
		//int sample[] = {2,2,2,1};
		Solution s = new Solution();
		System.out.println(s.singleNumber(sample));
	}
	
	public int singleNumber(int[] A) { 
		
		/***** There is a super easy solution that use bitwise operation *****/
		/*
		 * If you sum the ith bit of all numbers and mod 3, it must be either 0 or 1 due to the constraint of this problem where each number must appear either three times or once. This will be the ith bit of that "single number".
		 */
		
		// 0 case
		int count = 0;
		for(int i = 0;i < A.length;i++){
			if(A[i] == 0){count++;}
		}
		if(count == 1){return 0;}
		
		// general case
		int len = (A.length+2)/3;
		int map[] = new int[len];
		int temp;
		BigInteger sumOfA = new BigInteger("0");
		BigInteger sumOfMap = new BigInteger("0");
		for(int i = 0;i < A.length;i++){
			sumOfA = sumOfA.add(BigInteger.valueOf(A[i]));
			temp = Math.abs(A[i] % len);
			while(map[temp] != 0 && map[temp] != A[i]){
				temp++;
				temp = temp % len;
			}
			if(map[temp] == 0){
				map[temp] = A[i];
				sumOfMap = sumOfMap.add(BigInteger.valueOf(A[i]));
			}
		}
		return (sumOfMap.multiply(BigInteger.valueOf(3)).add(sumOfA.negate())).divide(BigInteger.valueOf(2)).intValue();
	}

}
