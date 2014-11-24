public class Solution {
    public int trap(int[] A) {
        int largest_pre = -1;
	        int rain = 0;
	        int i = 0;
	        Stack<Integer> stack = new Stack<Integer>();
	        while(i < A.length){
	            if(A[i] != 0){
	                if(stack.isEmpty()){
	                    stack.push(i);
	                    largest_pre = i;
	                }else{
	                    if(A[i] < A[largest_pre]){
	                        stack.push(i);
	                    }else{
	                        rain += (i-largest_pre)*A[largest_pre];
	                        while(!stack.isEmpty())
	                            rain -= A[stack.pop()];
	                        largest_pre = i;
	                        stack.push(i);
	                    }
	                }
	            }
	            i++;
	        }
	        
	        // for the rest, reverse it and do the same
	        if(stack.size()>1){
	            int rest[] = new int[A.length-largest_pre];
	            for(i = 0;i < rest.length;i++)
	                rest[i] = A[A.length-1-i];
	            rain += trap(rest);
	        }
	        
	        return rain;
    }
}