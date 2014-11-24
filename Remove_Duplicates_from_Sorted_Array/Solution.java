public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length == 0){return 0;}
        int i, j;
        i = 1;
        j = 0;
        while(i < A.length){
            if(A[i] == A[j]){
                i++;
            }else{
                A[++j]=A[i++];
            }
        }
        return j+1;
    }
}