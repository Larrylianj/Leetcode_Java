import java.util.HashSet;
import java.util.Iterator;


public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int ary[] = {2147483646,-2147483647,0,2,2147483644,-2147483645,2147483645};
		int ary[] = {100,4,200,1,3,2};
		//int ary[] = {};
		Solution s = new Solution();
		System.out.println(s.longestConsecutive(ary));
	}

	public int longestConsecutive(int[] num) {
		// use a hash set to store all the integers
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i = 0;i < num.length;i++){set.add(num[i]);}
		
		// for each element, record the maximum consecutive sequence using that element
		
		Integer temp,down,up;
		int cur_length, longest = 0;
		while(!set.isEmpty()){
			Iterator<Integer> itr = set.iterator();
			if(itr.hasNext()){
				cur_length = 1;
				temp = itr.next();
				itr.remove();
				down = temp - 1;
				up = temp + 1;
				set.remove(temp);
				
				// downwards
				while(set.contains(down)){
					set.remove(down);
					down--;
					cur_length++;
				}
				
				// upwards
				while(set.contains(up)){
					set.remove(up);
					up++;
					cur_length++;
				}
				
				if(cur_length > longest){
					longest = cur_length;
				}
			}
		}
		
        return longest;
    }
}
