public class Solution {
    public void nextPermutation(int[] num) {
        int i = num.length-1;
        int j;
        while(i > 0){
            if(num[i] > num[i-1])
                break;
            i--;
        }
        if(i != 0){
            for(j = i;j < num.length;j++)
                if(num[j] <= num[i-1])
                    break;
            swap(num, i-1, j-1);
        }
            
        reverse(num, i, num.length-1);
    }
    
    private void reverse(int[] A, int begin, int end){
        for(int i = begin;i <= (end+begin)/2;i++)
            swap(A,i,end+begin-i);
    }
    
    private void swap(int[] A, int a, int b){
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
        
}