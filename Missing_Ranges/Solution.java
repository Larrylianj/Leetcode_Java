import java.util.List;
import java.util.ArrayList;

public class Solution{

	public static void main(String[] args){
		Solution s = new Solution();
		int[] n = {3,4,5,6,98};
		List<List<Integer>> rlst = s.missingRanges(n);
		for(int i = 0;i < rlst.size();i++)
			System.out.println(rlst.get(i));
	}
	public int begin = 0;
	public int end = 99;
	public List<List<Integer>> missingRanges(int[] n){
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		int pre = begin-1;
		for(int i = 0;i < n.length;i++){
			if(n[i]!=pre+1){
				List<Integer> list = new ArrayList<Integer>();
				list.add(pre+1);
				if(n[i] - pre > 2)
					list.add(n[i]-1);
				output.add(list);
			}
			pre = n[i];
		}
		if(pre!=end){
			List<Integer> list = new ArrayList<Integer>();
			list.add(pre+1);
			if(end - pre > 2)
				list.add(end);
			output.add(list);
		}
		return output;
	}
}