import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public static void main(String arg[]){
		Solution s = new Solution();
		int num[] = {0,1};
		System.out.print(s.permute(num));
	}
	
    public List<List<Integer>> permute(int[] num) {
        
        Arrays.sort(num);
        
        List<List<Integer>> opt = new ArrayList<List<Integer>>();
        if(num.length == 0){return opt;}
        List<Integer> initialLst = new ArrayList<Integer>();
        initialLst.add(num[0]);
        opt.add(initialLst);
        for(int i = 1;i < num.length;i++){
            if(num[i] == num[i-1]){
                if(opt.size() != 1){
                    List<Integer> lastlst = new ArrayList<Integer>(opt.get(opt.size()-1));
                    lastlst.add(0,num[i]);
                    opt.add(lastlst);
                }
                for(int j = 0;j < opt.size();j++){
                    opt.get(j).add(num[i]);
                }
            }else{
                int numOfLastOpt = opt.size();
                int positions = opt.get(0).size();
                for(int j = 0;j < numOfLastOpt;j++){
                    for(int u = 0;u <= positions;u++){
                        List<Integer> newlst = new ArrayList<Integer>(opt.get(j));
                        newlst.add(u,num[i]);
                        opt.add(newlst);
                    }
                }
                for(int j = 0;j < numOfLastOpt;j++){
                    opt.remove(0);
                }
            }
        }
        
        return opt;
    }
}