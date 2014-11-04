import java.util.*;
public class Solution {
	static public void main(String arg[]){
		Solution s = new Solution();
		String[] words = {"What","must","be","shall","be."};
		System.out.print(s.fullJustify(words, 12));
	}
	
	public List<String> fullJustify(String[] words, int L) {
        Queue<String> queue = new LinkedList<String>();
        List<String> lst = new ArrayList<String>();
        int i = 0;
        int cur_len = 0;
        int cur_count = 0;
        while(i < words.length){
            cur_len += words[i].length();
            cur_len++;
            cur_count++;
            if(cur_len > L+1){ // construct a line
                String newline = "";
                cur_count--;
                cur_len--;
                cur_len -= words[i].length();
                int skip_space = cur_count <= 1?L - (cur_len-cur_count):(L - (cur_len-cur_count))/(cur_count-1); // length of average space
                int res_space = cur_count <= 1?0:(L - (cur_len-cur_count))%(cur_count-1); // length of additional space
                // build the line
                if(cur_count == 1){
                    newline += queue.poll();
                    cur_count--;
                    for(int j = 0;j < skip_space;j++)
                        newline += " ";
                }else{
                    while(!queue.isEmpty()){
                        newline += queue.poll();
                        cur_count--;
                        if(cur_count > 0)
                            for(int j = 0;j < skip_space;j++)
                                newline += " ";
                        if(res_space > 0){
                            newline += " ";
                            res_space--;
                        }
                    }
                }
                lst.add(newline);
                cur_len = 0;
                cur_count = 0;
            }else{ // collect words
                queue.add(words[i]);
                i++;
            }
        }
        if(!queue.isEmpty()){ // last line
            String newline = "";
            while(!queue.isEmpty()){
                newline += queue.poll();
                cur_count--;
                if(cur_count > 0)
                    newline += " ";
            }
            for(int j = 0;j < L-(cur_len-1);j++)
                newline += " ";
            lst.add(newline);
        }
        
        return lst;
    }
}