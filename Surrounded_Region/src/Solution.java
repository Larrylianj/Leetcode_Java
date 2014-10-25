import java.util.Arrays;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		//char[][] test = {{'O','O','O'},{'O','X','O'},{'O','O','O'}};
		char[][] test = {{'X','O','X','X'},{'O','X','O','X'},{'X','O','X','O'},{'O','X','O','X'},{'X','O','X','O'}};
		for(int i = 0;i < test.length;i++){
			for(int j = 0;j < test[0].length;j++){
				System.out.print(test[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		s.solve(test);
		for(int i = 0;i < test.length;i++){
			for(int j = 0;j < test[0].length;j++){
				System.out.print(test[i][j]);
			}
			System.out.println();
		}
	}
	
	public void solve(char[][] board) {
        int len = board.length;
        int wid = board[0].length;
        boolean opt[][] = new boolean[len][wid];
        for(int i = 0;i < len;i++){
        	Arrays.fill(opt[i], true);
        }
        
        // base case
        for(int i = 0;i < wid;i ++){
        	if(board[0][i] == 'O'){
        		opt[0][i] = false;
        		expand(1,i,1,board,opt);
        	}
        	if(board[len-1][i] == 'O'){
        		opt[len-1][i] = false;
        		expand(len-2,i,4,board,opt);
        	}
        }
        
        for(int i = 0;i < len;i++){
        	if(board[i][wid-1] == 'O'){
        		opt[i][wid-1] = false;
        		expand(i,wid-2,2,board,opt);
        	}
        	if(board[i][0] == 'O'){
        		opt[i][0] = false;
        		expand(i,1,3,board,opt);
        	}
        }
        
        // recurrence
        for(int i = 1;i < len -1;i++){
        	for(int j = 1;j < len - 1;j++){
        		if(opt[i][j] && board[i][j] == 'O'){board[i][j] = 'X';}
        	}
        }
        
    }
	
	private boolean expand(int x, int y, int direction, char[][] board, boolean opt[][]){
		// for the direction: 1 means downward; 2 means left to right; 3 means right to left; 4 means upward
		int len = board.length;
		int wid = board[0].length;
		boolean exit = true;
		if(x >= len-1 || x <= 0 || y >= wid-1 || y <= 0){ return exit;}
		if(board[x][y] == 'O'){
			opt[x][y] = false;
			switch(direction){
			case 1:{
				if(expand(x+1,y,1,board,opt) && expand(x,y-1,1,board,opt) && expand(x,y+1,1,board,opt)){
					exit = false;
				}
				break;
			}
			case 2:{
				if(expand(x-1,y,2,board,opt) && expand(x+1,y,2,board,opt) && expand(x,y+1,2,board,opt)){
					exit = false;
				}
				break;
			}
			case 3:{
				if(expand(x-1,y,3,board,opt) && expand(x+1,y,3,board,opt) && expand(x,y-1,3,board,opt)){
					exit = false;
				}
				break;
			}
			case 4:{
				if(expand(x-1,y,4,board,opt) && expand(x,y-1,4,board,opt) && expand(x,y+1,4,board,opt)){
					exit = false;
				}
				break;
			}
			}
		}
		return exit;
	}
}
