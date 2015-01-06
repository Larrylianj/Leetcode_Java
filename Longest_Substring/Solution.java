public class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> visited = new HashSet<Character>();
        Queue<Character> queue = new LinkedList<Character>();
        int longest = 0;
        char temp;
        for(int i = 0;i < s.length();i++){
            if(!visited.contains(s.charAt(i))){
                visited.add(s.charAt(i));
                queue.add(s.charAt(i));
            }else{
                if(queue.size() > longest)
                    longest = queue.size();
                while(!queue.isEmpty()){
                    temp = queue.poll();
                    if(temp == s.charAt(i)){break;}
                    visited.remove(temp);
                }
                queue.add(s.charAt(i));
            }
        }
        if(queue.size() > longest)
            longest = queue.size();
        return longest;
    }
}