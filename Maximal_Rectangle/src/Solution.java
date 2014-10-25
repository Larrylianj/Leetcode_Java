import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] mat = {{'1','1','1'},{'1','1','1'},{'1','1','0'},{'1','1','0'}};
		Solution s = new Solution();
		System.out.println(s.maximalRectangle(mat));
	}
	
	public int maximalRectangle(char[][] matrix) {
		if(matrix.length == 0){return 0;}
		int hist[] = new int[matrix.length];
		int max = 0;
		ArrayList<Integer> rects = new ArrayList<Integer>();
		for(int i = 0; i < matrix[0].length;i++){
			clearToZero(hist);
			for(int x = 0;x < matrix.length;x++){
				int y = i;
				while(matrix[x][y] == '1'){
					hist[x] ++;
					y++;
					if(y >= matrix[x].length){break;}
				}
			}
			rects.add(this.largestRecFromHist(hist));
		}
		for(int i = 0;i < rects.size();i++)
			if(rects.get(i) > max)
				max = rects.get(i);
        return max;
    }
	
	private void clearToZero(int a[]){
		for(int i = 0;i < a.length;i++){a[i] = 0;}
	}
	
	private int largestRecFromHist(int height[]){
		Stack<Integer> stack = new Stack<Integer>();
		int max_area = 0,cur,area;
		int i = 0;
		while(i < height.length){
			if(stack.empty() || height[i] >= height[stack.peek()]){
				stack.push(i++);
			}else{
				cur = stack.pop();
				area = height[cur]*(stack.empty()?i:i-stack.peek()-1);
				if(area > max_area){max_area = area;}
			}
		}
		while(!stack.empty()){
			cur = stack.pop();
			area = height[cur]*(stack.empty()?height.length:height.length-stack.peek()-1);
			if(area > max_area){max_area = area;}
		}
		return max_area;
	}
}
