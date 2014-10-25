public class Solution {
    public int numTrees(int n) {
        if(n == 0){return 0;}
        if(n == 1){return 1;}
        int count = 0;
        for(int i = 0;i < n;i++){
            if(i == 0 || i == n-1)
                count += (numTrees(i)+numTrees(n-1-i));
            else
                count += (numTrees(i)*numTrees(n-1-i));
        }
        return count;
    }
}