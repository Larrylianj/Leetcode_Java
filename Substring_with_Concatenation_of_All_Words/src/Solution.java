import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Solution {
	
	public static void main(String arg[]){
		String S = "foobarbarfoobarbarfoo";
		String L[] = {"foo","bar","bar"};
//		String S= "aaaaaaaaaaaaaaaaaaaaaaaaaaaa";
//		String L[] = {"a","a","a","a","a","a","a","a","a","a"}; 
		Solution s = new Solution();
		System.out.print(s.findSubstring(S, L));
	}
	
	
	List<Integer> output;
    Map<String, Integer> dict;
    String S;
    int length;
    int numOfString;
    public List<Integer> findSubstring(String S, String[] L) {
        this.S = S;
        output = new ArrayList<Integer>();
        dict = new HashMap<String, Integer>();
        if(L.length==0){return output;}
        length = L[0].length();
        numOfString = L.length;
        // construct the map
        for(int i = 0;i < L.length;i++){
            if(dict.containsKey(L[i]))
                dict.put(L[i],dict.get(L[i])+1);
            else
                dict.put(L[i],1);
        }
        // search for each position
        for(int i = 0;i <= S.length()-length*numOfString;i++)
            search(i);
        return output;
    }
    
    private void search(int k){
        int count = 0;
        Map<String, Integer> appearance = new HashMap<String, Integer>(); 
        boolean match;
        for(int i = k;i <= S.length()-length;i += length){
            String temp = S.substring(i, i+length);
            match = false;
            for(Map.Entry<String, Integer> entry:dict.entrySet()){
                if(temp.equals(entry.getKey())){
                	match = true;
                    if(appearance.containsKey(temp)){
                        if(appearance.get(temp) < dict.get(temp)){
                            appearance.put(temp,appearance.get(temp)+1);
                            count++;
                            if(count == numOfString){
                                output.add(k);
                                return;
                            }
                            break;
                        }else{
                            return;
                        }
                    }else{
                        appearance.put(temp,1);
                        count++;
                        if(count == numOfString){
                            output.add(k);
                            return;
                        }
                        break;
                    }
                }
            }
            if(!match){
            	return;
            }
        }
        return;
    }
	
//	List<Integer> output = new ArrayList<Integer>();
//	public List<Integer> findSubstring(String S, String[] L) {
//        for(int i = 0;i < S.length();i++){
//            search(S,L,i);
//        }
//        return output;
//    }
//    
//    private void search(String S, String[] L, int k){
//        int count = 0;
//        boolean used[] = new boolean[L.length];
//        boolean matched;
//        for(int i = k;i < S.length();){
//            matched = false;
//            for(int j = 0;j < L.length;j++){
//                if(!used[j]){
//                    if(i + L[j].length() < S.length()){
//                        if(S.substring(i,i+L[j].length()).equals(L[j])){
//                            used[j] = true;
//                            matched = true;
//                            count++;
//                            if(count == L.length){
//                                output.add(k);
//                                return;
//                            }
//                            i += L[j].length();
//                        }
//                    }
//                }
//            }
//            if(!matched){
//                return;
//            }
//        }
//        return;
//    }
	
//	public List<Integer> findSubstring(String S, String[] L) {
//        List<Integer> output = new ArrayList<Integer>();
//        Queue<Integer> queue = new LinkedList<Integer>();
//        boolean used[] = new boolean[L.length];
//        boolean valid = false;
//        boolean match = false;
//        boolean butUsed = false;
//        int count = 0;
//        int start = -1;
//        int usedIndex = -1;
//        for(int i = 0;i < S.length();i++){
//            match = false;
//            butUsed = false;
//            for(int j = 0;j < L.length;j++){
//                if(i + L[j].length() <= S.length()){
//                    if(S.substring(i,i+L[j].length()).equals(L[j])){
//                        match = true;
//                        if(!used[j]){
//                            used[j] = true;
//                            butUsed = false;
//                            queue.add(j);
//                            if(!valid){
//                                start = i;
//                                valid = true;
//                            }
//                            count++;
//                            if(count == L.length){
//                                output.add(start);
//                                int removeIndex = queue.poll();
//                                used[removeIndex] = false;
//                                start += L[removeIndex].length();
//                                count--;
//                            }
//                            i += L[j].length()-1;
//                            break;
//                        }else{
//                            butUsed = true;
//                            usedIndex = j;
//                        }
//                    }
//                }
//            }
//            if(!match){
//                valid = false;
//                count = 0;
//                clear(used);
//                queue.clear();
//            }else{
//                if(butUsed){
//                	if(!queue.isEmpty()){
//                		if(L[queue.peek()].equals(L[usedIndex])){
//                			start += L[usedIndex].length();
//                			i += L[usedIndex].length()-1;
//                			queue.poll();
//                			queue.add(usedIndex);
//                		}else{
//                			valid = false;
//                			count = 0;
//                			clear(used);
//                			queue.clear();
//                		}
//                	}
//            	}
//            }
//        }
//        
//        return output;
//    }
//    
//    private void clear(boolean a[]){
//        for(int i = 0;i < a.length;i++)
//            a[i] = false;
//    }
}