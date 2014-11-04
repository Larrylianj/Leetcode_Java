public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int rows[] = new int[m+1];
        int cols[] = new int[n+1];
        //base case
        if(m == 1 && n == 1){return obstacleGrid[0][0] == 1?0:1;}
        if(obstacleGrid[0][0] == 1){return 0;}
        for(int i = 0;i <= m;i++){rows[i] = i==2?1:0;}
        for(int j = 0;j <= n;j++){cols[j] = j==2?1:0;}
        //iteration
        for(int i = 1;i <= m;i++){
            for(int j = 1;j <= n;j++){
                if(obstacleGrid[i-1][j-1] == 1){
                    cols[j] = 0;
                    rows[i] = 0;
                }else{
                    cols[j] = cols[j]+rows[i];
                    rows[i] = cols[j];
                }
            }
        }
        
        return cols[n];
    }
}