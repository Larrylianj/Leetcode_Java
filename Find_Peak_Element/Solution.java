public class Solution {
    public int findPeakElement(int[] num) {
        return findPeakElement(num,0,num.length-1);
    }
    
    private int findPeakElement(int[] num, int begin, int end){
        while(begin < end){
            int middle = (begin+end)/2;
            // edge case
            if(middle==0)
                return num[0] > num[1]?0:1;
            if(middle==num.length-1)
                return num[middle] > num[middle+1]?middle:middle+1;
            // normal case
            if(num[middle] > num[middle-1] && num[middle] > num[middle+1])
                return middle;
            if(num[middle] > num[middle-1] && num[middle] < num[middle+1]){
                begin = middle+1;
            }else{
                end = middle-1;
            }
        }
        return begin;
    }
}