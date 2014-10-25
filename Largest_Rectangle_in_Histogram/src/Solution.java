import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int h[] = {2,1,5,6,2,3};
		int h[] = {5,4,4,6,3,2,9,5,4,8,1,0,0,4,7,2};
		//int h[] = {0,1,0,1};
		Solution s = new Solution();
		System.out.print(s.largestRectangleArea(h));
	}
	
	// divide and conquer
	public int largestRectangleArea(int[] height){
		//base case
		if(height.length == 0){return 0;}
        if(height.length == 1){return height[0];}
        if(height.length == 2){
			int big = max(height[0],height[1]);
			int small = min(height[0],height[1]);
			return max(big,2*small);
		}
		if(height.length == 3){
			int first = max(max(height[0],height[1]),height[2]);
			int third = min(min(height[0],height[1]),height[2]);
			int second;
			if(first == height[0] && third == height[2] || first == height[2] && third == height[0])
				second = height[1];
			else if(first == height[0] && third == height[1] || first == height[1] && third == height[0])
				second = height[2];
			else
				second = height[0];
			if(third == height[1])
				return max(max(height[0],height[2]),height[1]*3);
			else
				return max(max(3*third,2*second),first); 
		}
		// edge condition
		int middle = height.length/2;
		int sub1[] = new int[middle];
		int sub2[] = new int[height.length - middle];
		for(int i = 0;i < middle;i++){sub1[i] = height[i];}
		for(int i = 0;i < height.length - middle;i++){sub2[i] = height[i + middle];}
		int area_down,area_up;
		int i = middle-1,j = middle+1;
		while(i >= 0){
			if(height[i] >= height[middle])
				i--;
			else
				break;
		}
		while(j < height.length){
			if(height[j] >= height[middle])
				j++;
			else
				break;
		}
		area_up = (j-i-1)*height[middle];
		i = middle-2;j = middle;
		while(i >= 0){
			if(height[i] >= height[middle-1])
				i--;
			else
				break;
		}
		while(j < height.length){
			if(height[j] >= height[middle-1])
				j++;
			else
				break;
		}
		area_down = (j-i-1)*height[middle-1];
		
		return max(max(this.largestRectangleArea(sub1),this.largestRectangleArea(sub2)),max(area_down,area_up));
	}
	
	// only O(n), perfect one
//	public int largestRectangleArea(int[] height){
//		Stack<Integer> stack = new Stack<Integer>();
//		int max_area = 0,cur,area;
//		int i = 0;
//		while(i < height.length){
//			if(stack.empty() || height[i] >= height[stack.peek()]){
//				stack.push(i++);
//			}else{
//				cur = stack.pop();
//				area = height[cur]*(stack.empty()?i:i-stack.peek()-1);
//				if(area > max_area){max_area = area;}
//			}
//		}
//		while(!stack.empty()){
//			cur = stack.pop();
//			area = height[cur]*(stack.empty()?height.length:height.length-stack.peek()-1);
//			if(area > max_area){max_area = area;}
//		}
//		return max_area;
//	}
	
	
//	public int largestRectangleArea(int[] height) {
//		HashSet<Integer> lib = new HashSet<Integer>();
//		ArrayList<Integer> lens = new ArrayList<Integer>();
//		ArrayList<Integer> rects = new ArrayList<Integer>();
//		for(int i = 0;i < height.length;i++){
//			if(!lib.contains(height[i])){
//				lens.clear();
//				int len = 0;
//				for(int j = 0; j < height.length;j++){
//					if(height[j] >= height[i]){
//						len ++;
//					}else{
//						lens.add(len);
//						len = 0;
//					}
//				}
//				lens.add(len);
//				int max = 0;
//				for(int j = 0;j < lens.size();j++)
//					if(lens.get(j) > max)
//						max = lens.get(j);
//				rects.add(max*height[i]);
//				lib.add(height[i]);
//			}
//		}
//		int max = 0;
//		for(int i = 0;i < lib.size();i++)
//			if(rects.get(i) > max)
//				max = rects.get(i);
//        return max;
//    }
	
	private int max(int a,int b){
		return a>b?a:b;
	}
	
	private int min(int a,int b){
		return a>b?b:a;
	}

}
