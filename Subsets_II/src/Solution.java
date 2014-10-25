import java.util.*;

public class Solution {
	//private Set<List<Integer>> gotIt;
	private Set<Integer> gotIt;
	private List<List<Integer>> gross;
	Solution(){
		//gotIt = new HashSet<List<Integer>>();
		gotIt = new HashSet<Integer>();
		gross = new ArrayList<List<Integer>>();
	}
	
	public static void main(String[] args){
		Solution s = new Solution();
		int num[] = {2,1,2,2};
		System.out.print(s.subsetsWithDup(num));
	}
	public List<List<Integer>> subsetsWithDup(int[] num) {
		Arrays.sort(num);
        for(int i = 0;i < num.length;i++){
            List<List<Integer>> lst = new ArrayList<List<Integer>>();
            // copy the original list
            for(int j = 0;j < gross.size();j++){
            	List<Integer> newlst = new ArrayList<Integer>(gross.get(j));
                lst.add(newlst);
            }
            	
            // add the new number to each sub list
            for(int j = 0;j < lst.size();j++)
                lst.get(j).add(num[i]);
            
            // add the element itself
            List<Integer> curNum = new ArrayList<Integer>();
            curNum.add(num[i]);
            lst.add(curNum);
            
            // add the previous element conditionally
            if(!gotIt.contains(num[i])){
                gotIt.add(num[i]);
                for(int j = 0;j < gross.size();j++){
                	List<Integer> newlst = new ArrayList<Integer>(gross.get(j));
                    lst.add(newlst);
                }
            }else{
               for(int j = 0;j < gross.size();j++){
                    boolean contain = false;
                    for(int u = 0;u < gross.get(j).size();u++)
                        if(gross.get(j).get(u) == num[i])
                            contain = true;
                    if(!contain){
                    	List<Integer> newlst = new ArrayList<Integer>(gross.get(j));
                        lst.add(newlst);
                    }
                } 
            }
            
            // copy current list
            gross = new ArrayList<List<Integer>>(lst);
        }
        
        List<Integer> empty = new ArrayList<Integer>();
        gross.add(empty);
        return gross;
    }
	
//    public List<List<Integer>> subsetsWithDup(int[] num) {
//        subsets(num);
//        List<Integer> empty = new ArrayList<Integer>();
//        gross.add(empty);
//        return gross;
//    }
    
//    private List<List<Integer>> subsets(int[] num){
//        List<List<Integer>> output = new ArrayList<List<Integer>>();
//        // base case
//        if(num.length == 0){
//            List<Integer> empty = new ArrayList<Integer>();
//            output.add(empty);
//            return output;
//        }
//        //recursive
//        for(int i = 0; i < num.length;i++){
//            int cur = num[i];
//            int sub[] = new int[num.length-1];
//            for(int j = 0;j < i;j++){sub[j] = num[j];}
//            for(int j = i+1;j < num.length;j++){sub[j-1] = num[j];}
//            List<List<Integer>> curOutput = subsets(sub);
//            for(int j = 0;j < curOutput.size();j++){
//                List<Integer> lst = new ArrayList<Integer>(curOutput.get(j));
//                // find the correct position
//                int pos = 0;
//                while(pos < lst.size()){
//                    if(cur < lst.get(pos)){
//                        break;
//                    }
//                    pos++;
//                }
//                lst.add(pos,new Integer(cur));
//                
//                if(!gotIt.contains(lst)){
//                    gotIt.add(lst);
//                    gross.add(lst);
//                }
//                output.add(lst);
//            }
//        }
//        return output;
//    }
}