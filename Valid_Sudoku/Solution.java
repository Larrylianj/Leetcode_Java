public class Solution {
    int n = 9;
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0;i < n;i++)
            for(int j = 0;j < n;j++)
                if(board[i][j] != '.')
                    if(!validCell(board,i,j))
                        return false;
        return true;
    }
    
    private boolean validCell(char[][] board, int x,int y){
        int center_x = x/3*3+1;
        int center_y = y/3*3+1;
        for(int i = -1;i <= 1;i++)
            for(int j = -1;j <= 1;j++)
                if(center_x+i != x && center_y+j != y)
                    if(board[center_x+i][center_y+j]==board[x][y])
                        return false;
        for(int i = 0;i < n;i++)
            if(i != x)
                if(board[i][y] == board[x][y])
                    return false;
        for(int i = 0;i < n;i++)
            if(i != y)
                if(board[x][i] == board[x][y])
                    return false;
        return true;
    }
}