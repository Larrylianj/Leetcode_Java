public class Solution {
    // my first version was great
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
    
    // a tedious version
    public int removeDuplicates(int[] A) {
        int p1 = 0;
        int p2 = 0;
        int begin, end;
        if(A.length==0){return 0;}
        // points p2 to a next element;
        while(p2 < A.length){
            if(A[p1]!=A[p2])
                break;
            p2++;
        }
        end = p2;
        
        // set p1 ~ end
        begin = p1+1;
        while(begin < end && p2 < A.length){
            if(A[begin]==A[p1]){
                A[begin] = A[p2];
                // shift p2
                int temp = A[p2];
                while(p2 < A.length){
                    if(A[p2] != temp)
                        break;
                    p2++;
                }
            }else{
                p1 = begin;
            }
            begin++;
        }
        
        // set the rest according to p2
        while(p2 < A.length){
            A[begin++] = A[p2];
            int temp = A[p2];
            while(p2 < A.length){
                if(A[p2] != temp)
                    break;
                p2++;
            }
        }
        
        return begin;
    }
}