
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] = {{1,2},{1,1}};
		Solution s = new Solution();
		System.out.print(s.minPathSum(grid));

	}
    
    // O(mn)
//	public int minPathSum(int[][] grid) {
//        int opt[][] = new int[grid.length+1][grid[0].length+1];
//        // base case
//        opt[0][0] = 0;
//        for(int i = 1;i <= grid.length;i++){opt[i][0] = i == 1?0:Integer.MAX_VALUE;}
//        for(int j = 1;j <= grid[0].length;j++){opt[0][j] = j == 1?0:Integer.MAX_VALUE;}
//        //iteration
//        for(int i = 1;i <= grid.length;i++)
//            for(int j = 1;j <= grid[0].length;j++)
//                opt[i][j] = Math.min(opt[i-1][j], opt[i][j-1])+grid[i-1][j-1];
//                
//        return opt[grid.length][grid[0].length];
//    }
    
    // )(m+n)
    public int minPathSum(int[][] grid) {
        int row[] = new int[grid[0].length+1];
        int col[] = new int[grid.length+1];
        // base case
        row[0] = 0;
        for(int j = 1;j <= grid[0].length;j++){row[j] = j==1?0:Integer.MAX_VALUE;}
        col[0] = 0;
        for(int i = 1;i <= grid.length;i++){col[i] = i==1?0:Integer.MAX_VALUE;}
        
        // iteration
        for(int i = 1;i <= grid.length;i++){
            for(int j = 1;j <= grid[0].length;j++){
                row[j] = Math.min(col[i],row[j])+grid[i-1][j-1];
                col[i] = row[j];
            }
        }
        return col[grid.length];
    }
}
