
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int A[] = {-2,1,-3,4,-1,2,1,-5,4};
		//int A[] = {1,2,-1,-2,2,1,-2,1,4,-5,4};
		//int A[] = {3,-2,-3,-3,1,3,0};
		int A[] = {1};
		Solution s = new Solution();
		System.out.println(s.maxSubArray(A));
	}
	
	public int maxSubArray(int[] A) {
		boolean negative = true;
		int max = A[0];
		for(int i = 0;i < A.length;i++){
			if(A[i] > max)
				max = A[i];
			if(A[i] >= 0){
				negative = false;
				break;
			}
		}
		if(negative){return max;}
		int sum = 0;
		for(int i = 0;i < A.length;i++){
			if(A[i] >= 0){
				sum += A[i];
			}else{
				// check if max
				if(sum > max){max = sum;}
				if(sum + A[i] < 0){
					if(i < A.length){
						sum = 0;
					}else{
						break;
					}
				}else{
					sum += A[i];
				}
			}
		}
		// check the last sum
		if(sum > max){max = sum;}
		return max;
	}
	
	private int max(int a, int b){
		if(a > b)
		    return a;
		else
		    return b;
	}
	
	private int min(int a, int b){
		if(a > b)
		    return b;
		else
		    return a;
	}
}
