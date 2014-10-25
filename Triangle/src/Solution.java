import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> one = new ArrayList();
		one.add(1);
		List<Integer> two = new ArrayList();
		two.add(2);
		two.add(3);
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		triangle.add(one);
		triangle.add(two);
		Solution s = new Solution();
		System.out.println(s.minimumTotal(triangle));
	}
	
	public int minimumTotal(List<List<Integer>> triangle) {
		int min = triangle.get(0).get(0);
		if(triangle.size() == 1){return min;}
        for(int i = 1;i < triangle.size();i++){
            for(int j = 0;j < triangle.get(i).size();j++){
                if(j-1 >= 0 && j < triangle.get(i-1).size()){
                    triangle.get(i).set(j ,triangle.get(i).get(j) + min(triangle.get(i-1).get(j-1),triangle.get(i-1).get(j)));
                }else if(j-1 >= 0){
                    triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j-1));
                }else{
                	triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i-1).get(j));
                }
            }
        }
        List<Integer> lastRow = new ArrayList<Integer>(triangle.get(triangle.size()-1));
        min = min(lastRow.get(0),lastRow.get(1));
        for(int i = 0;i < lastRow.size();i++)
        	if(lastRow.get(i) < min)
        		min = lastRow.get(i);
        
        return min;
    }
    
    private int min(int a,int b){
        return a > b?b:a;
    }

}
