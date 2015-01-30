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
	
    // my version
	public class Solution {
        public int largestRectangleArea(int[] height) {
            int max = 0;
            Stack<Integer> stack = new Stack<Integer>();
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for(int i = 0;i < height.length;i++){
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    int t = stack.peek();
                    if(height[i] < height[t]){
                        while(!stack.isEmpty()){
                            int u = stack.peek();
                            int length = t+1-(map.containsKey(u)?map.get(u):u);
                            if(length*height[u] > max)
                                max = length*height[u];
                            if(height[u] <= height[i]){
                                break;
                            }
                            if(map.containsKey(u))
                                map.put(i, map.get(u));
                            else
                                map.put(i,u);
                            stack.pop();
                        }
                    }
                    stack.push(i);
                }
            }
            while(!stack.isEmpty()){
                int t = stack.pop();
                int length = height.length-(map.containsKey(t)?map.get(t):t);
                if(height[t] > height[height.length-1])
                    length--;
                if(length*height[t] > max)
                    max = length*height[t];
            }
            return max;
        }
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
