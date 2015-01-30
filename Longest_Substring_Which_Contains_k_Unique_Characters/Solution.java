import java.util.Queue;
import java.util.LinkedList;

public class Solution{

	public static void main(String args[]){
		Solution sol = new Solution();
		String s = "aabcbcbcebcabeffbebfedbbe";
		System.out.println(sol.longestSubstringWith2UniqueChar(s,4));
	}

	public String longestSubstringWith2UniqueChar(String s, int k){
		if(s.length() < 1){return s;}
		int begin = 0, end = 0; // mark the start position and end position of resulting substring
		int p[] = new int[k]; // mark the last position k-th character appears
		int longest = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
		// find the position for p[]
		for(int i = 0;i < k;i++)
			p[i] = 0;
		for(int i = 1;i < k;i++){
			p[i] = p[i-1];
			while(++p[i] < s.length()){
				queue.add(p[i]);
				boolean find = false;
				for(int j = 0;j < i;j++){
					if(s.charAt(p[i])==s.charAt(p[j])){
						p[j] = p[i];
						find = true;
					}
				}
				if(!find)
					break;
			}
		}
		// main process
		for(int i = p[k-1]+1;i < s.length();i++){
			boolean find = false;
			for(int j = 0;j < k;j++){
				if(s.charAt(i)==s.charAt(p[j])){
					p[j] = i;
					find = true;
				}
			}
			if(!find){
				if(queue.size() > longest){
					longest = queue.size();
					begin = queue.peek();
					end = i;
				}
				// find the earliest appeared character
				int min = s.length();
				int index = 0;
				for(int j = 0;j < k;j++){
					if(p[j] < min){
						min = p[j];
						index = j;
					}
				}
				while(!queue.isEmpty()){
					if(p[index]==queue.poll())
						break;
				}
				p[index] = i;
			}
			queue.add(i);
		}

		if(queue.size() > longest){
			begin = queue.peek();
			end = s.length();
		}


		return s.substring(begin,end);
	}
}