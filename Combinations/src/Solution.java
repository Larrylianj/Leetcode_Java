import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        // base case
        if(k == 0 || n == 0){return output;}
        if(k == 1){
            for(int i = 1;i <= n;i++){
                List<Integer> lst = new ArrayList<Integer>();
                lst.add(i);
                output.add(lst);
            }
            return output;
        }
        
        // recursive
        for(int i = 1;i <= n;i++){
            List<List<Integer>> lst = combine(n-i,k-1);
            // add offset i to each
            for(int x = 0;x < lst.size();x++){
                lst.get(x).add(0,i);
                for(int y = 1;y < lst.get(x).size();y++)
                    lst.get(x).set(y,lst.get(x).get(y)+i);
            }
            
            output.addAll(lst);
        }
        
        return output;
        
    }
}
