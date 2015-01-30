import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Solution{

	public static void main(String args[]){
		Solution s = new Solution();
		int n[] = {1,2};
		System.out.println(s.twoSum2(n, 3));
	}

	public List<Integer> twoSum2(int n[], int target){
		List<Integer> list = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0;i < n.length;i++){
			if(map.containsKey(target - n[i])){
				list.add(map.get(target - n[i]));
				list.add(i+1);
				return list;
			}
			map.put(n[i],i+1);
		}
		return list;
	}
}