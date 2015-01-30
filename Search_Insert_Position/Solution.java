public class Solution {
    // O(n)
    public int searchInsert(int[] A, int target) {
        for(int i = 0;i < A.length;i++){
            if(A[i] == target){return i;}
            if(A[i] > target){return i;}
        }
        return A.length;
    }
    
    // O(logn)
    public int searchInsert(int[] A, int target) {
        if(A.length==0){return 0;}
        int begin = 0, end = A.length-1;
        int middle = 0;
        if(target <= A[begin]){return 0;}
        if(target >= A[end]){return end+1;}
        while(begin < end){
            middle = (begin+end)/2;
            if(A[middle]==target)
                return middle;
            if(A[middle] < target && A[middle+1] >= target)
                return middle+1;
            if(A[middle] > target)
                end = middle;
            if(A[middle+1] < target)
                begin = middle+1;
        }
        return 0;
    }
}