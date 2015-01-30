public class Solution {
    public int findMin(int[] num) {
        return findMin(num,0,num.length-1);
    }
    
    private int findMin(int[] num, int begin, int end){
        // go all the way until no duplicates
        while(begin < end-1){
            if(num[begin]==num[begin+1])
                begin++;
            else
                break;
        }
        while(begin < end-1){
            if(num[end]==num[end-1])
                end--;
            else
                break;
        }
        // binary approach
        if(begin > end){return 0;}
        if(begin==end){return num[begin];}
        int middle = (begin+end)/2;
        if(num[middle] < num[end])
            return findMin(num, begin, middle);
        else
            return findMin(num, middle+1, end);
    }
}