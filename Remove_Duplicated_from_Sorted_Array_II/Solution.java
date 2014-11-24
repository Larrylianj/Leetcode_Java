public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length==0){return 0;}
        int i,j;
        int count = 1;
        i = 1;
        j = 0;
        while(i < A.length){
            if(A[i] == A[j]){
                if(count < 2){
                    A[++j] = A[i++];
                    count++;
                }else{
                    i++;
                }
            }else{
                A[++j] = A[i++];
                count = 1;
            }
        }
        
        return j+1;
    }
}