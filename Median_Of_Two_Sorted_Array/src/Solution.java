public class Solution {
	public static void main(String arg[]){
		Solution s = new Solution();
		int A[] = {2};
		int B[] = {1,3,4,5,6};
		System.out.print(s.findMedianSortedArrays(A,B));
	}
    public double findMedianSortedArrays(int A[], int B[]) {
        return findMedianSortedArrays(A,0,A.length-1,B,0,B.length-1);
    }
    
    public double findMedianSortedArrays(int A[], int A_start, int A_end, int B[], int B_start, int B_end){
        int A_len = A_end-A_start+1;
        int B_len = B_end-B_start+1;
        if(A_len==0&&B_len==0){return 0;}
        if(A_len==0){return B_len%2==0?(B[(B_start+B_end)/2]+B[(B_start+B_end)/2+1])/2.0:B[(B_start+B_end)/2];}
        if(B_len==0){return A_len%2==0?(A[(A_start+A_end)/2]+A[(A_start+A_end)/2+1])/2.0:A[(A_start+A_end)/2];}
        if(A[A_end] <= B[B_start]){
            int middle = (A_len+B_len-1)/2;
            if((A_len+B_len)%2==0){
                if(middle <= A_len-1){
                    if(middle+1 <= A_len-1){
                        return (A[middle+A_start]+A[middle+1+A_start])/2.0;
                    }else{
                        return (A[middle+A_start]+B[B_start])/2.0;
                    }
                }else{
                    return (B[middle-A_len+B_start]+B[middle-A_len+1+B_start])/2.0;
                }
            }else{
                if(middle <= A_len-1){
                    return A[middle+A_start];
                }else{
                    return B[middle-A_len+B_start];
                }
            }
        }else if(A[A_start] >= B[B_end]){
            int middle = (A_len+B_len-1)/2;
            if((A_len+B_len)%2==0){
                if(middle <= B_len-1){
                    if(middle+1 <= B_len-1){
                        return (B[middle+B_start]+B[middle+1+B_start])/2.0;
                    }else{
                        return (B[middle+B_start]+A[A_start])/2.0;
                    }
                }else{
                    return (A[middle-B_len+A_start]+A[middle-B_len+1+A_start])/2.0;
                }
            }else{
               if(middle <= B_len-1){
                   return B[middle+B_start];
               }else{
                   return A[middle-B_len+A_start];
               }
            }
        }else{ // A and B overlap
            if(A_len == 1 && B_len == 1){
                return (A[A_start]+B[B_start])/2.0;
            }else if(A_len == 1){
                int middle = (B_start+B_end)/2;
                if(A[A_start] <= B[middle]){
                    if((A_len+B_len)%2==0){
                        return (A[A_start]+B[middle])/2.0;
                    }else{
                        return B[middle];
                    }
                }else{
                    if((A_len+B_len)%2==0){
                        if(A[A_start] > B[middle+1]){
                            return (B[middle]+B[middle+1])/2.0;
                        }else{
                            return (B[middle]+A[A_start])/2.0;
                        }
                    }else{
                        if(A[A_start] > B[middle+1]){
                            return B[middle+1];
                        }else{
                            return A[A_start];
                        }
                    }
                }
            }else if(B_len == 1){
               int middle = (A_start+A_end)/2;
                if(B[B_start] <= A[middle]){
                    if((A_len+B_len)%2==0){
                        return (B[B_start]+A[middle])/2.0;
                    }else{
                        return A[middle];
                    }
                }else{
                    if((A_len+B_len)%2==0){
                        if(B[B_start] > A[middle+1]){
                            return (A[middle]+A[middle+1])/2.0;
                        }else{
                            return (A[middle]+B[B_start])/2.0;
                        }
                    }else{
                        if(B[B_start] > A[middle+1]){
                            return A[middle+1];
                        }else{
                            return B[B_start];
                        }
                    }
                } 
            }else{ // general case
                double A_middle,B_middle;
                A_middle = A_len%2 == 0?(A[(A_end+A_start)/2]+A[(A_end+A_start)/2+1])/2.0:A[(A_start+A_end)/2];
                B_middle = B_len%2 == 0?(B[(B_end+B_start)/2]+B[(B_end+B_start)/2+1])/2.0:B[(B_start+B_end)/2];
                if(A_middle > B_middle){
                    A_end = (A_start+A_end)/2;
                    B_start = B_len%2==0?(B_start+B_end)/2+1:(B_start+B_end)/2;
                }else if(A_middle < B_middle){
                    B_end = (B_start+B_end)/2;
                    A_start = A_len%2==0?(A_start+A_end)/2+1:(A_start+A_end)/2;
                }else{
                    return A_middle;
                }
                return findMedianSortedArrays(A,A_start,A_end,B,B_start,B_end);
            }
        }
    }
}