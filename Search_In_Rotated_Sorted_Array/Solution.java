public class Solution {
    int result;
    public int search(int[] A, int target) {
        result = -1;
        search(A, 0, A.length-1,target);
        return result;
    }
    
    private void search(int[] A, int begin, int end, int target){
        if(begin > end){return;}
        int middle = (begin+end)/2;
        if(A[middle] == target){
            result = middle;
            return;
        }
        // two situations
        if(A[middle] < A[end]){
            if(A[middle] > target)
                search(A,begin,middle-1,target);
            else
                if(target > A[end])
                    search(A,begin,middle-1,target);
                else
                    search(A,middle+1,end,target);
        }else if(A[middle] > A[end]){
            if(A[middle] > target)
                if(target > A[end])
                    search(A,begin,middle-1,target);
                else
                    search(A,middle+1,end,target);
            else
                search(A,middle+1,end,target);
        }
    }
}