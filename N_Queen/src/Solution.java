import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class Solution {
	public static void main(String arg[]){
		Solution s = new Solution();
		String[] str = {"ABC","BRD"};
		System.out.println(str);
		List<String[]>result = s.solveNQueens(5);
		for(int i = 0;i < result.size();i++)
			System.out.println(result.get(i));
	}
	public List<String[]> solveNQueens(int n) {
        List<String[]> output = new ArrayList<String[]>();
        Stack<Integer> x = new Stack<Integer>();
        Stack<Integer> y = new Stack<Integer>();
        String[] solution = new String[n];
        boolean hasOne;
        
        // dfs
        if(n == 0){return output;}
        for(int start = 0;start < n;start++){
            int visited[][] = new int [n][n];
            visited[0][start]++;
            x.push(0);y.push(start);
            while(!x.isEmpty()){
                int cur_x = x.pop();
                int cur_y = y.pop();
                
                // horizontal and vertical
                for(int i = 0;i < n;i++){if(i != cur_x){visited[i][cur_y]++;}if(i != cur_y){visited[cur_x][i]++;}}
                
                // diagonal
                for(int i = -n;i < n;i++){if(cur_x+i >= 0 && cur_x+i < n && cur_y+i >= 0 && cur_y+i < n){if(i != 0){visited[cur_x+i][cur_y+i]++;}}if(cur_x+i >= 0 && cur_x+i < n && cur_y-i >= 0 && cur_y-i < n){if(i != 0){visited[cur_x+i][cur_y-i]++;}}}
                
                // generate result
                String newline = "";
                for(int i = 0;i < n;i++){
                    newline += i==cur_y?'Q':'.';
                }
                solution[cur_x] = newline;
                if(cur_x == n-1){
                    String[] copy = new String[n];
                    for(int i = 0;i < n;i++){
                        copy[i] = solution[i];
                    }
                    output.add(copy);
                    if(!x.isEmpty()){
                    int lastRow = x.peek();
                    for(int i = lastRow;i < n;i++){
                        for(int j = 0;j < n;j++){
                            if(copy[i].charAt(j) == 'Q'){
                                // visited-1
                                visited[i][j]--;
                                for(int ii = 0;ii < n;ii++){if(ii != i){visited[ii][j]--;}if(ii != j){visited[i][ii]--;}}
                                for(int ii = -n;ii < n;ii++){if(i+ii >= 0 && i+ii < n && j+ii >= 0 && j+ii < n){if(ii != 0){visited[i+ii][j+ii]--;}}if(i+ii >= 0 && i+ii < n && j-ii >= 0 && j-ii < n){if(ii != 0){visited[i+ii][j-ii]--;}}}
                            }
                        }
                    }
                    }
                }
                
                // check correctness
                if(cur_x < n-1){
                    hasOne = false;
                    for(int i = 0;i < n;i++){
                        if(visited[cur_x+1][i] == 0){
                            hasOne = true;
                            visited[cur_x+1][i]++;
                            x.push(cur_x+1);y.push(i);
                        }
                    }
                    if(!hasOne){
                    	if(!x.isEmpty()){
                            int lastRow = x.peek();
                            for(int i = lastRow;i <= cur_x;i++){
                                for(int j = 0;j < n;j++){
                                    if(solution[i].charAt(j) == 'Q'){
                                        // visited-1
                                        visited[i][j]--;
                                        for(int ii = 0;ii < n;ii++){if(ii != i){visited[ii][j]--;}if(ii != j){visited[i][ii]--;}}
                                        for(int ii = -n;ii < n;ii++){if(i+ii >= 0 && i+ii < n && j+ii >= 0 && j+ii < n){if(ii != 0){visited[i+ii][j+ii]--;}}if(i+ii >= 0 && i+ii < n && j-ii >= 0 && j-ii < n){if(ii != 0){visited[i+ii][j-ii]--;}}}
                                    }
                                }
                            }
                    	}
                    }
                }
            }
        }
        return output;
    }
}