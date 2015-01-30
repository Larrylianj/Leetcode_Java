public class Solution {
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // DP
        int n = obstacleGrid.length;
        if(n==0){return 0;}
        int m = obstacleGrid[0].length;
        int col[] = new int[m];
        // base case
        col[0] = obstacleGrid[0][0]==1?0:1;
        for(int j = 1;j < m;j++)
            col[j] = obstacleGrid[0][j]==1?0:col[j-1];
        // iteration
        for(int i = 1;i < n;i++){
            col[0] = obstacleGrid[i][0]==1?0:col[0];
            for(int j =1;j < m;j++)
                col[j] = obstacleGrid[i][j]==1?0:(col[j]+col[j-1]);
        }
        return col[m-1];
    }
}