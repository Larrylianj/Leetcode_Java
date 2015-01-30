import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;

public class Solution{

	public static void main(String args[]){
		Solution s = new Solution();
		s.add(3);
		s.add(4);
		s.add(3);
		System.out.println(s.find(7));
		System.out.println(s.find(6));
		System.out.println(s.find(8));
	}

	// add O(n), find O(1), space O(n^2)
	Set<Integer> twoSums = new HashSet<Integer>();
	Set<Integer> ints = new HashSet<Integer>();
	// public void add(int n){
	// 	Iterator<Integer> iter = ints.iterator();
	// 	while(iter.hasNext()){
	// 		twoSums.add(iter.next()+n);
	// 	}
	// 	ints.add(n);
	// }

	// public boolean find(int n){
	// 	return twoSums.contains(n);
	// }

	// add O(1), find O(n), space O(n)
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	public void add(int n){
		if(map.containsKey(n))
			map.put(n,map.get(n)+1);
		else
			map.put(n,1);
	}

	public boolean find(int n){
		Iterator iter = map.entrySet().iterator();
		while(iter.hasNext()){
			Entry cur = (Entry)iter.next();
			if(map.containsKey(n-(int)cur.getKey())){
				if(n == 2*(int)cur.getKey())
					return (int)cur.getValue()>=2;
				else
					return true;
			}
		}
		return false;
	}
}