
import java.lang.reflect.Array;
import java.util.*;
public class FindMedianOfArrays {
	
	public FindMedianOfArrays(){
		
	}
	
	public double medianOfSortedArray(int A[]){
		
		int l = Array.getLength(A);
		
		if(l%2 == 0){
			
			System.out.print("Median is ");
			System.out.println(((double)A[l/2]+(double)A[l/2-1])/2.0);
			return ((double)A[l/2]+(double)A[l/2-1])/2.0;
			
		}else{
			
			System.out.print("Median is ");
			System.out.println((double)(A[l/2]));
			return (double)(A[l/2]);
			
		}
	}
	
	public double findMedianSortedArrays(int A[], int B[]) {
        
		int m = Array.getLength(A);
		int n = Array.getLength(B);
		if((m+n)%2 == 0){
			
			return this.findMedian(A,B,0);
		
		}else{
			
			return this.findMedian(A, B, 1);
			
		}
//		System.out.println("A's length =");
//		System.out.println(m);
//		System.out.println("B's length =");
//		System.out.println(n);		
//			
//		if(m == 1 & n == 1){
//				
//			if(A[0] > B[0]){
//				return A[0];
//			}else{
//				return B[0];
//			}
//				
//		}else{
//		
//			if(this.medianOfSortedArray(A) > this.medianOfSortedArray(B)){
//				
//				System.out.println("A forward");
//				System.out.println((int)Math.floor((double)m/2.0));
//				A = Arrays.copyOfRange(A, 0, (int)Math.floor((double)m/2.0));
//				System.out.println("B backward");
//				System.out.println((int)Math.ceil((double)n/2.0));
//				B = Arrays.copyOfRange(B, (int)Math.ceil((double)n/2.0), n);
//				System.out.println("!");
//				return findMedianSortedArrays(A,B);
//				
//			}else if (this.medianOfSortedArray(B) > this.medianOfSortedArray(A)){
//				
//				System.out.println("A backward");
//				System.out.println((int)Math.ceil((double)m/2.0));
//				A = Arrays.copyOfRange(A, (int)Math.ceil((double)m/2.0), m);
//				System.out.println("B forward");
//				System.out.println((int)Math.floor((double)n/2.0));
//				B = Arrays.copyOfRange(B, 0, (int)Math.floor((double)n/2.0));
//				System.out.println("!");
//				return findMedianSortedArrays(A,B);
//				
//			}else{
//				return this.medianOfSortedArray(A);
//			}
//		}
		
    }
	public double findMedian(int A[], int B[], int oddOrEven) {
        
		int m = Array.getLength(A);
		int n = Array.getLength(B);
		System.out.println("A's length =");
		System.out.println(m);
		System.out.println("B's length =");
		System.out.println(n);		
			
		if(m == 1 & n == 1){
				
			if(oddOrEven == 1){ // 1 for odd
				
				if(A[0] > B[0]){
					return A[0];
				}else{
					return B[0];
				}
				
			}else{
				
				return ((double)(A[0]+B[0]))/2;
			}
			
				
		}else{
		
			if(this.medianOfSortedArray(A) > this.medianOfSortedArray(B)){
				
				System.out.println("A forward");
				System.out.println((int)Math.floor((double)m/2.0));
				A = Arrays.copyOfRange(A, 0, (int)Math.floor((double)(m-1)/2.0)+1);
				System.out.println("B backward");
				System.out.println(n/2);
				B = Arrays.copyOfRange(B, n/2, n);
				System.out.println("!");
				return findMedian(A,B,oddOrEven);
				
			}else if (this.medianOfSortedArray(B) > this.medianOfSortedArray(A)){
				
				System.out.println("A backward");
				System.out.println(m/2);
				A = Arrays.copyOfRange(A, m/2, m);
				System.out.println("B forward");
				System.out.println((int)Math.floor((double)(n-1)/2.0));
				B = Arrays.copyOfRange(B, 0, (int)Math.floor((double)(n-1)/2.0)+1);
				System.out.println("!");
				return findMedian(A,B,oddOrEven);
				
			}else{
				return this.medianOfSortedArray(A);
			}
		}
		
    }
}

