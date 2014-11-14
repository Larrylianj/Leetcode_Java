public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int i = 0;i < n/2;i++){
            for(int j = i;j < n-1-i;j++){
                // do the switch
                int pre = matrix[i][j];
                int temp;
                for(int u = 0;u < 4;u++){
                    switch(u){
                        case 0:
                            temp = matrix[j][n-1-i];
                            matrix[j][n-1-i] = pre;
                            pre = temp;
                            break;
                        case 1:
                            temp = matrix[n-1-i][n-1-j];
                            matrix[n-1-i][n-1-j] = pre;
                            pre = temp;
                            break;
                        case 2:
                            temp = matrix[n-1-j][i];
                            matrix[n-1-j][i] = pre;
                            pre = temp;
                            break;
                        case 3:
                            matrix[i][j] = pre;
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        
    }
}