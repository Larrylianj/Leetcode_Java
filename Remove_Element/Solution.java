public class Solution {
    public int removeElement(int[] A, int elem) {
        int i = 0, j = A.length-1;
        while(j >= 0){
            if(A[j] == elem)
                j--;
            else
                break;
        }
        while(i < j){
            if(A[i] == elem){
                swap(A,i,j);
                while(j >= 0){
                    if(A[j] == elem)
                        j--;
                    else
                        break;
                }
            }
            i++;
        }
        
        return j+1;
    }
    
    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp; 
    }
}