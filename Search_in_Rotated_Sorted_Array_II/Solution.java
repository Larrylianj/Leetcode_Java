public class Solution {
    boolean found;
    public boolean search(int[] A, int target) {
        found = false;
        search(A, target, 0, A.length-1);
        return found;
    }
    
    public void search(int[] A, int target, int begin, int end){
        if(end < begin){return;}
        int begin_num = A[begin];
        int end_num = A[end];
        // need to loop over all duplicates
        while(begin < end){
            if(A[begin+1] == begin_num){
                begin++;
            }else{
                break;
            }
        }
        while(end > begin){
            if(A[end-1]==end_num){
                end--;
            }else{
                break;
            }
        }
        
        // binary search
        int middle = (begin+end)/2;
        if(target==A[middle]){
            found = true;
            return;
        }
        if(A[end] > A[middle]){
            if(target < A[middle]){
                search(A,target,begin,middle-1);
            }else{
                if(target > A[end]){
                    search(A,target,begin,middle-1);
                }else{
                    search(A,target,middle+1,end);
                }
            }
        }else{
            if(target < A[middle]){
                if(target > A[end]){
                    search(A,target,begin,middle-1);
                }else{
                    search(A,target,middle+1,end);
                }
                
            }else{
                search(A,target,middle+1,end);
            }
        }
        
    }
}