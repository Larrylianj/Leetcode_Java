import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Arrays;

public class Solution {
	
	public static void main(String arg[]){
		int num[] = {10,1,2,7,6,1,5};
		Solution s = new Solution();
		System.out.print(s.combinationSum2(num, 8));
	}
	
    int finalTarget;
    HashSet<List<Integer>> visited;
    List<List<Integer>> output; 
    
    // This method use got time limited
//    public List<List<Integer>> combinationSum2(int[] num, int target) {
//        finalTarget = target;
//        visited = new HashSet<List<Integer>>();
//        return search(num, target);
//    }
    
    // This method got accepted
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        finalTarget = target;
        visited = new HashSet<List<Integer>>();
        output = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        search(new ArrayList<Integer>(), num, target, 0);
        return output;
    }
    
    private void search(List<Integer> lst,int[] num, int target, int begin){
        if(target == 0){
            if(!visited.contains(lst)){
                visited.add(lst);
                output.add(lst);
            }
        }else{
            for(int i = begin;i < num.length;i++){
                if(target >= num[i]){
                    List<Integer> newLst = new ArrayList<Integer>(lst);
                    newLst.add(num[i]);
                    search(newLst, num, target-num[i], i+1);
                }else{
                    break;
                }
            }
        }
    }
    
    public List<List<Integer>> search(int[] num, int target){
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        for(int i = 0;i < num.length;i++){
            if(target - num[i] > 0){
                int newNum[] = new int[num.length-1];
                for(int j = 0;j < i;j++){newNum[j] = num[j];}
                for(int j = i+1;j < num.length;j++){newNum[j-1] = num[j];}
                List<List<Integer>> lst = search(newNum, target-num[i]);
                for(int j = 0;j < lst.size();j++){
                    List<Integer> newLst = new ArrayList<Integer>(lst.get(j));
                    // insert num[j] at the correct position
                    for(int u = 0;u < lst.get(j).size();u++){
                        if(num[i] <= lst.get(j).get(u)){
                            newLst.add(u,num[i]);
                            break;
                        }
                        if(u == lst.get(j).size()-1){
                            newLst.add(num[i]);
                            break;
                        }
                    }
                    
                    if(target == finalTarget){
                        if(!visited.contains(newLst)){
                            visited.add(newLst);
                            output.add(newLst);
                        }
                    }else{
                        output.add(newLst);
                    }
                }
            }else if(target == num[i]){
                List<Integer> oneNumLst = new ArrayList<Integer>();
                oneNumLst.add(num[i]);
                if(target==finalTarget){
                    if(!visited.contains(oneNumLst)){
                        visited.add(oneNumLst);
                        output.add(oneNumLst);
                    }
                }else{
                    output.add(oneNumLst);
                }
            }
        }
        return output;
    }
}
