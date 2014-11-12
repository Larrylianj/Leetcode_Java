import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int m[][] = {{1,2,3},{5,4,6},{7,8,9}};
		System.out.println(s.spiralOrder(m));
	}
	
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> lst = new ArrayList<Integer>();
        if(matrix.length == 0){return lst;}
        int m = matrix.length-1;
        int n = matrix[0].length;
        
        int dir =0;
        int i=0,j=0;
        int len;
        while(m > 0 || n > 0){
            switch(dir){
                case 0:
                	len = 0;
                    while(len < n){
                        lst.add(matrix[i][j]);
                        j++;
                        len++;
                    }
                    n--;
                    j--;
                    i++;
                    dir++;
                    dir %= 4;
                    if(m <= 0){return lst;}
                    break;
                case 1:
                	len = 0;
                    while(len < m){
                        lst.add(matrix[i][j]);
                        i++;
                        len++;
                    }
                    m--;
                    i--;
                    j--;
                    dir++;
                    dir %= 4;
                    if(n <= 0){return lst;}
                    break;
                case 2:
                	len = 0;
                    while(len < n){
                        lst.add(matrix[i][j]);
                        j--;
                        len++;
                    }
                    n--;
                    j++;
                    i--;
                    dir++;
                    dir %= 4;
                    if(m <= 0){return lst;}
                    break;
                case 3:
                	len = 0;
                    while(len < m){
                        lst.add(matrix[i][j]);
                        i--;
                        len++;
                    }
                    m--;
                    i++;
                    j++;
                    dir++;
                    dir %= 4;
                    if(n <= 0){return lst;}
                    break;
                default:
                    break;
            }
            
        }
        
        return lst;
        
    }
}
