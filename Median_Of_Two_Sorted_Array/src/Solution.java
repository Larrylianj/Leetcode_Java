public class Solution {
	public static void main(String arg[]){
		Solution s = new Solution();
		int A[] = {1,1};
		int B[] = {1,2};
		System.out.print(s.findMedianSortedArrays(A,B));
	}
    
	public double findMedianSortedArrays(int A[], int B[]) {
        return findMedianSortedArrays(A,0,A.length-1,B,0,B.length-1);
    }
    
    private double findMedianSortedArrays(int A[], int A_begin, int A_end, int B[], int B_begin, int B_end){
        // base case
        int n = A_end-A_begin+1;
        int m = B_end-B_begin+1;
        
        if(n+m==0){return 0;}
        if(n==0){return findMedian(B,B_begin,B_end);}
        if(m==0){return findMedian(A,A_begin,A_end);}
        
        if(A[A_begin] >= B[B_end])
            return (findKthInArrays(B,B_begin,B_end,A,A_begin,A_end,(n+m)/2)+findKthInArrays(B,B_begin,B_end,A,A_begin,A_end,(n+m-1)/2))/2.0;
        if(A[A_end] <= B[B_begin])
            return (findKthInArrays(A,A_begin,A_end,B,B_begin,B_end,(n+m)/2)+findKthInArrays(A,A_begin,A_end,B,B_begin,B_end,(n+m-1)/2))/2.0;
            
        if(n==1){
            if(m%2!=0){
                if(A[A_begin] <= B[B_begin+(B_end-B_begin)/2-1])
                    return (B[B_begin+(B_end-B_begin)/2-1]+B[B_begin+(B_end-B_begin)/2])/2.0;
                else if(A[A_begin] >= B[B_begin+(B_end-B_begin)/2+1])
                    return (B[B_begin+(B_end-B_begin)/2+1]+B[B_begin+(B_end-B_begin)/2])/2.0;
                else
                    return (A[A_begin]+B[B_begin+(B_end-B_begin)/2])/2.0;
            }else{
                if(A[A_begin] <= B[B_begin+(B_end-B_begin)/2])
                    return B[B_begin+(B_end-B_begin)/2];
                else if(A[A_end] >= B[B_begin+(B_end-B_begin)/2+1])
                    return B[B_begin+(B_end-B_begin)/2+1];
                else
                    return A[A_begin];
            }
        }
        if(m==1){
            if(n%2!=0){
                if(B[B_begin] <= A[A_begin+(A_end-A_begin)/2-1])
                    return (A[A_begin+(A_end-A_begin)/2-1]+A[A_begin+(A_end-A_begin)/2])/2.0;
                else if(B[B_begin] >= A[A_begin+(A_end-A_begin)/2+1])
                    return (A[A_begin+(A_end-A_begin)/2+1]+A[A_begin+(A_end-A_begin)/2])/2.0;
                else
                    return (B[B_begin]+A[A_begin+(A_end-A_begin)/2])/2.0;
            }else{
                if(B[B_begin] <= A[A_begin+(A_end-A_begin)/2])
                    return A[A_begin+(A_end-A_begin)/2];
                else if(B[B_end] >= A[A_begin+(A_end-A_begin)/2+1])
                    return A[A_begin+(A_end-A_begin)/2+1];
                else
                    return B[B_begin];
            }
        }
        
        // general case
        double A_median = findMedian(A,A_begin,A_end);
        double B_median = findMedian(B,B_begin,B_end);
        if(A_median==B_median){return A_median;}
        int cut = Math.min((A_end-A_begin+1)/2,(B_end-B_begin+1)/2);
        int A_left = A[A_begin+(A_end-A_begin-1)/2];
        int A_right = A[A_begin+(A_end-A_begin)/2+1];
        int B_left = B[B_begin+(B_end-B_begin-1)/2];
        int B_right = B[B_begin+(B_end-B_begin)/2+1];
        if(A_left > B_left)
            B_begin += cut;
        else
            A_begin += cut;
        if(A_right > B_right)
            A_end -= cut;
        else
            B_end -= cut;
        return findMedianSortedArrays(A,A_begin,A_end,B,B_begin,B_end);
    }
    
    private double findMedian(int A[], int begin, int end){
        if((end-begin+1)%2==0)
            return (A[begin + (end-begin)/2]+A[begin+(end-begin)/2+1])/2.0;
        else
            return A[begin + (end-begin)/2];
    }
    
    private double findKthInArrays(int A[], int A_begin, int A_end, int B[], int B_begin, int B_end, int k){
        if(k >= A_end-A_begin+1)
            return B[B_begin+k-(A_end-A_begin+1)];
        else
            return A[A_begin+k];
    }
}