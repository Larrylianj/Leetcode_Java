import java.util.Queue;
import java.util.LinkedList;

public class Solution{

	public static void main(String args[]){
		Solution sol = new Solution();
		String s = "aabbbabababcababababbababababbbbab";
		System.out.println(sol.longestSubstringWith2UniqueChar(s));
	}

	public String longestSubstringWith2UniqueChar(String s){
		if(s.length() < 1){return s;}
		int begin = 0, end = 0; // mark the start position and end position of resulting substring
		int p1 = 0; // the last position first unique char appears
		int p2 = p1; // the last position second unique char appears
		int longest = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(0);
		// find the position for p2
		while(++p2 < s.length()){
			queue.add(p2);
			if(s.charAt(p2)!=s.charAt(p1))
				break;
			else
				p1++;
		} 
		// main process
		for(int i = p2+1;i < s.length();i++){
			if(s.charAt(i)==s.charAt(p1)){
				p1 = i;
			}else if(s.charAt(i)==s.charAt(p2)){
				p2 = i;
			}else{
				if(queue.size() > longest){
					longest = queue.size();
					begin = queue.peek();
					end = i;
				}
				if(s.charAt(i-1)==s.charAt(p1)){
					while(!queue.isEmpty()){
						if(p2==queue.poll())
							break;
					}
					p2 = i;
				}else{
					while(!queue.isEmpty()){
						if(p1==queue.poll())
							break;
					}
					p1 = i;
				}
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