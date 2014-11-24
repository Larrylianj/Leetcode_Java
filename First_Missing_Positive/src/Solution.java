public class Solution {
	
	public static void main(String arg[]){
		Solution s = new Solution();
		int A[] = {3,4,-1,1};
		System.out.print(s.firstMissingPositive(A));
	}
    public int firstMissingPositive(int[] A) {
        int totalPositive = 0;
        int temp = -1;
        int median;
        for(int i = 0;i < A.length;i++){
            if(A[i] > 0)
                totalPositive++;
            else
                A[i] = -1;
        }
        for(int i = 0;i < A.length;i++){
            if(temp == -1){
                if(A[i] > 0){
                    // if the integer is larger than totalPositive, it means there must be gap before it
                    if(A[i] > totalPositive){
                        A[i] = -1;
                    }else{
                        if(A[A[i]-1] != A[i]){
                            temp = A[A[i]-1];
                            A[A[i]-1] = A[i];
                            A[i] = -1;
                        }else{
                            if(A[i]-1 != i)
                                A[i] = -1;
                            temp = -1;
                        }
                    }
                }
            }else{
                if(temp <= totalPositive){
                    if(A[temp-1] != temp){
                        median = A[temp-1];
                        A[temp-1] = temp;
                        temp = median;
                    }else{
                        temp = -1;
                    }
                }else{
                    temp = -1;
                }
                i--;
            }
        }
        
        for(int i = 0;i < A.length;i++)
            if(A[i] == -1)
                return i+1;
        return totalPositive+1;
    }
}
