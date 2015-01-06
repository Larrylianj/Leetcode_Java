public class Solution {
    private static final int base = 26;
    public int titleToNumber(String s) {
        int result = 0;
        for(int i = 0;i < s.length();i++)
            result += (int)(s.charAt(i)-'A'+1)*(int)Math.pow(base,s.length()-1-i);
        return result;
    }
}