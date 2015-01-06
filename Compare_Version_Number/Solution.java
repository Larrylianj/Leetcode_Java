public class Solution {
    public int compareVersion(String version1, String version2) {
        int i = 0,j = 0;
        int pre1 = i, pre2 = j;
        while(i < version1.length() || j < version2.length()){
            while(i < version1.length()){
                if(version1.charAt(i)=='.')
                    break;
                i++;
            }
            while(j < version2.length()){
                if(version2.charAt(j)=='.')
                    break;
                j++;
            }
            int int1 = pre1 < i?Integer.parseInt(version1.substring(pre1,i)):0;
            int int2 = pre2 < j?Integer.parseInt(version2.substring(pre2,j)):0;
            if(int1 > int2)
                return 1;
            else if(int1 < int2)
                return -1;
            pre1 = ++i;
            pre2 = ++j;
        }
        return 0;
    }
}