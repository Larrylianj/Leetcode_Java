import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int A[] = {0,-1,4,-4,5,-2,-1,-1,-2,-3,0,-3,0,1,-1,-4,4,6,2,3,0,-5,2,1,-4,-2,-1,3,-4,-6,0,2,2,-1,-5,1,1,5,-6,2,1,-3,-6,-6,-3,4,0,-2,0,2};
		//int A[] ={6,3,6,-2,3,1,1,1,-1,4,2,4,-1,-4,0,-5,-2,6,4,-1,-3,0,5,5,1,0,0,1,5,-4,0,6,4,-4,-3,-6,-2,-2,-4,3,5,-5,-1,-3,-1,-1,-6,-5,-1,-1,-1,0,-6,2,1,-1,5,-6,-5,-3,6,4,3,-2,4,-2,-3,-1,0,-1,-1,-1,4,0,6,-1,4,4,-3,4,-3,-2,0,4,-3,-1,1,-2,0,-4,6,0,2,2,0,0,-2,1,4,-3};
		int A[] = {-2,0,-1};
		Solution s = new Solution();
		System.out.println(A.length);
		System.out.println(s.maxProduct(A));

	}
	
	public int maxProduct(int[] A) {
		if(A.length == 0){return 0;}
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> index = new Stack<Integer>();

		int begin = 0;
		while(A[begin] == 0){
			begin++;
			if(begin > A.length-1){return 0;}
		}
		int max = A[begin];
		int product = A[begin];
		if(product < 0){stack.add(product);index.add(begin);}
		for(int i = begin+1;i < A.length;i++){
			if(A[i] < 0){
				// check if max
				if(product > max){max = product;}
				stack.add(product*A[i]);
				index.add(i);
				product *= A[i];
			}else if(A[i] == 0){
				// check if max
				if(0 > max){max = 0;}
				if(product > max){max = product;}
				while(!stack.isEmpty()){
					int cur = stack.pop();
					int cur_index = index.pop();
					if(i-1 != cur_index){
						if(product/cur > max){max = product/cur;}
					}
				}
				while(A[i] == 0){
					i++;
					if(i >= A.length-1){break;}
				}
				if(i <= A.length-1){
					if(A[i] < 0){
						stack.add(A[i]);
						index.add(i);
					}
					product = A[i];
				}
			}else{
				product *= A[i];
			}
		}
		if(product > max){max = product;}
		while(!stack.isEmpty()){
			int cur = stack.pop();
			int cur_index = index.pop();
			if(A.length-1 != cur_index){
				if(product/cur > max){max = product/cur;}
			}
		}

		return max;
		
		
		
		
//		if(A.length == 0){return 0;}
//		int max = A[0];
//		int product = 1;
//		for(int i = 0;i < A.length;i++){
//			if(A[i] == 0){
//				int sub1[] = new int[i];
//				for(int j = 0;j < i;j++){sub1[j] = A[j];}
//				if(i != A.length-1){
//					int sub2[] = new int[A.length-1-i];
//					for(int j = 0;j < A.length-1-i;j++){sub2[j] = A[i+1+j];}
//					return max(maxProduct(sub1),maxProduct(sub2));
//				}else{
//					return maxProduct(sub1);
//				}
//			}else{
//				if(A[i] < 0){
//					int sub1[] = new int[i];
//					int sub2[] = new int[A.length-1-i];
//					for(int j = 0;j < i;j++){sub1[j] = A[j];}
//					for(int j = 0;j < A.length-1-i;j++){sub2[j] = A[i+1+j];}
//					int max1 = maxProduct(sub1);
//					int max2 = maxProduct(sub2);
//					if(max1 > max){max = max1;}
//					if(max2 > max){max = max2;}
//				}
//				product *= A[i];
//			}
//		}
//		
//        return max(max(max(product/A[0],product/A[A.length-1]),product),max);
    }
	
	private int max(int a,int b){
		return a > b?a:b;
	}

}
