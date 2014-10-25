import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
//import java.util.Stack;


public class AnotherSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnotherSolution s = new AnotherSolution();
		//char[][] test = {{'O','O'},{'O','O'}};
		char[][] test = {{'X','O','X','X','X'},{'O','X','O','X','X'},{'X','O','X','O','X'},{'O','X','X','O','X'},{'X','X','O','X','O'}};
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
		int m = board.length;
		int n = board[0].length;
		int a,b;
		boolean mark[][] = new boolean[m][n];
		Queue<Integer> x = new LinkedList<Integer>();
		Queue<Integer> y = new LinkedList<Integer>();
		
		// initialize mark[][]
		for(int i = 0;i < m;i++){Arrays.fill(mark[i], false);}
		
		// find the boundary 'O's and push them into stack
		for(int i = 0;i < m;i++){
			if(board[i][0] == 'O'){x.add(i);y.add(0);}
			if(board[i][n-1] == 'O'){x.add(i);y.add(n-1);}
		}
		for(int i = 0;i < n;i++){
			if(board[0][i] =='O'){x.add(0);y.add(i);}
			if(board[m-1][i] =='O'){x.add(m-1);y.add(i);}
		}
		
		// dfs on the boundary 'O's
		while(!x.isEmpty()){
			a = x.poll();b = y.poll();
			mark[a][b] = true;
			board[a][b] = 'A';
			if(a-1 > 0){if(board[a-1][b] == 'O' && !mark[a-1][b])  {x.add(a-1);y.add(b);}}
			if(a+1 < n-1){if(board[a+1][b] == 'O' && !mark[a+1][b])  {x.add(a+1);y.add(b);}}
			if(b-1 > 0){if(board[a][b-1] == 'O' && !mark[a][b-1])  {x.add(a);y.add(b-1);}}
			if(b+1 < n-1){if(board[a][b+1] == 'O' && !mark[a][b+1])  {x.add(a);y.add(b+1);}}
		}
		
		// change the 'O's
		for(int i = 0;i < m;i++){
			for(int j = 0;j < n;j++){
				if(board[i][j] == 'O'){board[i][j] = 'X';}
				if(board[i][j] == 'A'){board[i][j] = 'O';}
			}
		}
		
	}

}
