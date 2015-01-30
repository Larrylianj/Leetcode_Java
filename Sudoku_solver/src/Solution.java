import java.util.ArrayList;
import java.util.Stack;

public class Solution {
	
	public static void main(String arg[]){
		char board[][] = new char[9][9];
		String[] str = {".265...9.","5...79..4","3...1....","6.....8.7",".75.2..1.",".1....4..","...3.89.2","7...6..4.",".3.2..1.."};
		for(int i = 0;i < 9;i++){for(int j = 0;j < 9;j++){board[i][j] = str[i].charAt(j);}}
		
//		for(int i = 0;i < 9;i++){
//			for(int j = 0;j < 9;j++){
//				System.out.print(board[i][j]);
//				System.out.print(" ");
//			}
//			System.out.println();
//		}
		
		Solution s = new Solution();
		s.solveSudoku(board);
		
		System.out.println();
		for(int i = 0;i < 9;i++){
			for(int j = 0;j < 9;j++){
				System.out.print(board[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}
	
    int n = 9;
    char[][] copy;
    Stack<Node> stack;
    public void solveSudoku(char[][] board) {
        int x = -1,y = -1;
        stack = new Stack<Node>();
        // keep a copy of original board
        copy = new char[n][n];
        for(int i = 0;i < n;i++){for(int j = 0;j < n;j++){copy[i][j] = board[i][j];}}
        // find the first missing node
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(board[i][j] == '.'){
                    x = i;
                    y = j;
                    break;
                }
            }
            if(x != -1){break;}
        }
        if(x == -1){return;}
        ArrayList<Integer> initialCandidates = findPossibleValue(x,y);
        for(int i = 0;i < initialCandidates.size();i++){
            Node initialNode = new Node(x,y,initialCandidates.get(i));
            stack.add(initialNode);
        }
        
        // dfs
        while(!stack.isEmpty()){
            Node node = stack.pop();
            copy[node.x][node.y] = Integer.toString(node.value).charAt(0);
            if(isSuccess()){
                copyResult(board);
                return;
            }
            // find the next node to push into stack
            // check the current row first
            boolean pushed = false;
            for(int j = node.y+1;j < n;j++){
            	if(copy[node.x][j] == '.'){
                    pushed = true;
                    ArrayList<Integer> lst = findPossibleValue(node.x,j);
                    // if no candidate-> wrong hypothesis-> back trace copy 
                    if(lst.size()==0){
                        if(stack.isEmpty()){
                        	copyResult(board);
                            return;
                        }
                        Node lastNode = stack.peek();
                        if(lastNode.x == node.x){
                        	for(int q = node.y;q > lastNode.y;q--)
                            	if(board[node.x][q] == '.')
                                    copy[node.x][q] = '.';
                        }else{
                            for(int q = node.y;q >= 0;q--)
                            	if(board[node.x][q] == '.')
                                    copy[node.x][q] = '.';
                            for(int p = node.x-1; p > lastNode.x;p--)
                            	for(int q = n-1;q > 0;q--)
                            			if(board[p][q] == '.')
                            				copy[p][q] = '.';
                            for(int q = n-1;q > lastNode.y;q--)
                            	if(board[lastNode.x][q] == '.')
                        			copy[lastNode.x][q] = '.';
                        }
                    }
                    // otherwise push all candidates into stack
                    for(int p = 0;p < lst.size();p++){
                        Node newNode = new Node(node.x,j,lst.get(p));
                        stack.add(newNode);
                    }
                    break;     
                }
            }
            // check the rest row
            if(!pushed){
            	for(int i = node.x+1;i < n;i++){
            		boolean stop = false;
            		for(int j = 0;j < n;j++){
            			if(copy[i][j] == '.'){
            				ArrayList<Integer> lst = findPossibleValue(i,j);
            				// if no candidate-> wrong hypothesis-> back trace copy 
            				if(lst.size()==0){
            					if(stack.isEmpty()){
                                	copyResult(board);
                                    return;
                                }
            					Node lastNode = stack.peek();
            					if(lastNode.x == node.x){
            						for(int q = node.y;q > lastNode.y;q--)
            							if(board[node.x][q] == '.')
            								copy[node.x][q] = '.';
            					}else{
            						for(int q = node.y;q >= 0;q--)
            							if(board[node.x][q] == '.')
            								copy[node.x][q] = '.';
            						for(int p = node.x-1; p > lastNode.x;p--)
            							for(int q = n-1;q > 0;q--)
            								if(board[p][q] == '.')
            									copy[p][q] = '.';
            						for(int q = n-1;q > lastNode.y;q--)
            							if(board[lastNode.x][q] == '.')
            								copy[lastNode.x][q] = '.';
            					}
            				}
            				// otherwise push all candidates into stack
            				for(int p = 0;p < lst.size();p++){
            					Node newNode = new Node(i,j,lst.get(p));
            					stack.add(newNode);
            				}
            				stop = true;
            				break;     
            			}
            		}
            		if(stop){break;}
            	}
            }
                        
        }
        copyResult(board);
        return;
    }
    
    private ArrayList<Integer> findPossibleValue(int x, int y){
        int center_x = x/3*3+1;
        int center_y = y/3*3+1;
        boolean candidates[] = new boolean[9];
        ArrayList<Integer> output = new ArrayList<Integer>();
        // check its own box area
        for(int p = -1;p <= 1;p++)
            for(int q = -1;q <= 1;q++)
                if(copy[center_x+p][center_y+q] != '.')
                    candidates[(int)(copy[center_x+p][center_y+q]-'0')-1] = true;
        // check its row and column area
        for(int p = 0;p < n;p++){
            if(copy[x][p] != '.')
                candidates[(int)(copy[x][p]-'0')-1] = true;
            if(copy[p][y] != '.')
                candidates[(int)(copy[p][y]-'0')-1] = true;
        }
        // return all candidates
        for(int p = 0;p < n;p++)
            if(!candidates[p])
                output.add(p+1);
        return output;
    }
    
    private boolean isSuccess(){
        for(int i = 0;i < n;i++)
            for(int j = 0;j < n;j++)
                if(copy[i][j] == '.')
                    return false;
        return true;
    }
    
    private void copyResult(char[][] board){
        for(int i = 0;i < n;i++)
            for(int j = 0;j < n;j++)
                board[i][j] = copy[i][j];
    }
    
    // 2nd Trial
//    public void solveSudoku(char[][] board) {
//        Stack<Node> stack = new Stack<Node>();
//        // make a copy of board
//        char[][] origin = new char[9][9];
//        Node last = new Node(0,0,'.');
//        for(int i = 0;i < 9;i++)
//            for(int j = 0;j < 9;j++)
//                origin[i][j] = board[i][j];
//        // push the first empty grid node into stack
//        boolean find = false;
//        for(int i = 0;i < 9;i++){
//            for(int j = 0;j < 9;j++){
//                if(board[i][j] == '.'){
//                    List<Node> list = validNumber(board,i,j);
//                    for(int t = 0;t < list.size();t++)
//                        stack.push(list.get(t));
//                    find = true;
//                    break;
//                }
//            }
//            if(find)
//                break;
//        }
//        // find the last empty grid node
//        find = false;
//        for(int i = 8;i >=0;i--){
//            for(int j = 8;j >= 0;j--){
//                if(board[i][j] == '.'){
//                    last = new Node(i,j,'.');
//                    find = true;
//                    break;
//                }
//            }
//            if(find)
//                break;
//        }
//        
//        // DFS
//        while(!stack.isEmpty()){
//            Node node = stack.pop();
//            board[node.x][node.y] = node.val;
//            if(node.x == last.x && node.y == last.y)
//                return;
//            
//            // find the next position
//            boolean isFound = false;
//            boolean hasNext = false;
//            for(int j = node.y+1;j < 9;j++){ // find on current row
//                if(board[node.x][j]=='.'){
//                    isFound = true;
//                    List<Node> list = validNumber(board,node.x,j);
//                    for(int t = 0;t < list.size();t++)
//                        stack.push(list.get(t));
//                    
//                    if(list.size()!=0)
//                        hasNext = true;
//                    break;
//                }
//            }
//            if(!isFound){ // find on next rows
//                for(int i = node.x+1;i < 9;i++){
//                    for(int j = 0;j < 9;j++){
//                        if(board[i][j]=='.'){
//                            isFound = true;
//                            List<Node> list = validNumber(board,i,j);
//                            for(int t = 0;t < list.size();t++)
//                                stack.push(list.get(t));
//                            
//                            if(list.size()!=0)
//                                hasNext = true;
//                            break;
//                        }
//                    }
//                    if(isFound)
//                        break;
//                }
//            }
//            if(!isFound) // should never happen
//                return;
//            
//            // if no char can be filled, BACK TRACE
//            if(!hasNext){
//                if(stack.isEmpty()){
//                    return;
//                }else{
//                    Node peek = stack.peek();
//                    if(peek.x==node.x){ // back trace current row
//                        for(int j = node.y;j >= peek.y;j--)
//                            board[node.x][j] = origin[node.x][j];
//                    }else{ // back trace previous row
//                        for(int j = node.y;j >= 0;j--)
//                            board[node.x][j] = origin[node.x][j];
//                        for(int i = node.x-1;i >= peek.x+1;i--)
//                            for(int j = 8;j >= 0;j--)
//                                board[i][j] = origin[i][j];
//                        for(int j = 8;j >= peek.y;j--)
//                            board[peek.x][j] = origin[peek.x][j];
//                    }
//                }
//            }
//            
//        }
//        return;
//    }
//    
//    class Node{
//        int x;
//        int y;
//        char val;
//        Node(int a,int b, char v){
//            x = a;
//            y = b;
//            val = v;
//        }
//    }
//    
//    private List<Node> validNumber(char[][] board, int x, int y){
//        List<Node> output = new ArrayList<Node>();
//        boolean seq[] = new boolean[9];
//        // its block
//        int center_x = x/3 * 3 + 1;
//        int center_y = y/3 * 3 + 1;
//        for(int i = -1;i <= 1;i++)
//            for(int j = -1;j <= 1;j++)
//                if(board[center_x+i][center_y+j]!='.')
//                    seq[(int)(board[center_x+i][center_y+j]-'1')] = true;
//        // its col and row
//        for(int i = 0;i < 9;i++)
//            if(board[i][y]!='.')
//                seq[(int)(board[i][y]-'1')] = true;
//        for(int j = 0;j < 9;j++)
//            if(board[x][j]!='.')
//                seq[(int)(board[x][j]-'1')] = true;
//        // construct Nodes
//        for(int i = 0;i < 9;i++)
//            if(!seq[i]){
//                Node node = new Node(x,y,(char)(i+'1'));
//                output.add(node);
//            }
//        return output;
//    }
}

class Node{
    int x;
    int y;
    int value;
    Node(int x,int y,int value){
        this.x = x;
        this.y = y;
        this.value = value;
    }
}