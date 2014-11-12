public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        for(int i = 0;i < n;i++)
            for(int j = 0;j < n;j++)
                matrix[i][j] = 0;
        
        int dir = 0;
        int loop = 0;
        int num = 1;
        int i = 0,j = 0;
        while(loop <= 2*n){
            switch(dir){
                case 0:
                    while(j < n){
                        if(matrix[i][j] == 0){
                            matrix[i][j] = num++;
                            j++;
                        }else{
                            break;
                        }
                    }
                    dir++;
                    dir %= 4;
                    j--;
                    i++;
                    loop++;
                    if(loop == 2*n){
                        return matrix;
                    }
                    
                    break;
                case 1:
                    while(i < n){
                        if(matrix[i][j] == 0){
                            matrix[i][j] = num++;
                            i++;
                        }else{
                            break;
                        }
                    }
                    dir++;
                    dir %= 4;
                    i--;
                    j--;
                    loop++;
                    if(loop == 2*n){
                        return matrix;
                    }
                    
                    break;
                case 2:
                    while(j >= 0){
                        if(matrix[i][j] == 0){
                            matrix[i][j] = num++;
                            j--;
                        }else{
                            break;
                        }
                    }
                    dir++;
                    dir %= 4;
                    j++;
                    i--;
                    loop++;
                    if(loop == 2*n){
                        return matrix;
                    }
                    
                    break;
                case 3:
                    while(i >= 0){
                        if(matrix[i][j] == 0){
                            matrix[i][j] = num++;
                            i--;
                        }else{
                            break;
                        }
                    }
                    dir++;
                    dir %= 4;
                    i++;
                    j++;
                    loop++;
                    if(loop == 2*n){
                        return matrix;
                    }
                    
                default:
                    break;
            }
        }
        return matrix;
    }
}