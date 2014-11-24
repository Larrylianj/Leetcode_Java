public class Solution {
    int result[];
    public int[] searchRange(int[] A, int target) {
        result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if(A.length==1){
            result[0] = A[0]==target?0:-1;
            result[1] = A[0]==target?0:-1;
            return result;
        }
        searchStart(A,0,A.length-1,target);
        searchEnd(A,0,A.length-1,target);
        
        return result;
    }
    
    private void searchStart(int[] A,int begin, int end, int target){
        int middle;
        while(begin < end){
            middle = (begin+end)/2;
            if(A[middle+1] == target){
                if(A[middle] < target){
                    result[0] = middle+1;
                    return;
                }else{
                    end = middle;
                }
            }else if(A[middle+1] < target){
                begin = middle+1;
            }else{
                end = middle;
            }
        }
        if(A[begin] == target){
            result[0] = begin;
            return;
        }
    }
    
    private void searchEnd(int[] A, int begin, int end, int target){
        int middle;
        while(begin < end){
            middle = (begin+end)/2;
            if(A[middle] == target){
                if(A[middle+1] > target){
                    result[1] = middle;
                    return;
                }else{
                    begin = middle+1;
                }
            }else if(A[middle] > target){
                end = middle;
            }else{
                begin = middle+1;
            }
        }
        if(A[begin] == target){
            result[1] = begin;
            return;
        }
    }
}