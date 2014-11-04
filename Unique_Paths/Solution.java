public class Solution {
    public int uniquePaths(int m, int n) {
        int rows[] = new int[m+1];
        int cols[] = new int[n+1];
        //base case
        if(m == 1 && n == 1){return 1;}
        for(int i = 0;i <= m;i++){rows[i] = i==2?1:0;}
        for(int j = 0;j <= n;j++){cols[j] = j==2?1:0;}
        //iteration
        for(int i = 1;i <= m;i++){
            for(int j = 1;j <= n;j++){
                cols[j] = cols[j]+rows[i];
                rows[i] = cols[j];
            }
        }
        
        return cols[n];
    }
}