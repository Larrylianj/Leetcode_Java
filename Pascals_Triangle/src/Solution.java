import java.math.BigInteger;
import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.print(s.getRow(13));
	}
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		if(numRows == 0){return triangle;}
		List<Integer> firstRow = new ArrayList<Integer>();
		firstRow.add(1);
		triangle.add(firstRow);
		for(int i = 1;i < numRows;i++){
			List<Integer> row = new ArrayList<Integer>();
			for(int j = 0; j < i+1;j++){
				if(j-1 >= 0 && j < triangle.get(i-1).size()){
					row.add(triangle.get(i-1).get(j-1)+triangle.get(i-1).get(j));
				}else if(j-1 >= 0){
					row.add(triangle.get(i-1).get(j-1));
				}else{
					row.add(triangle.get(i-1).get(j));
				}
			}
			triangle.add(row);
		}
		return triangle;
        
    }
	
	public List<Integer> getRow(int rowIndex) {
        List<BigInteger> row = new ArrayList<BigInteger>();
        List<Integer> result = new ArrayList<Integer>();
        ArrayList<BigInteger> com = new ArrayList<BigInteger>();
        BigInteger product = new BigInteger("1");
        com.add(product);
        for(int i = 1;i <= rowIndex;i++){
        	product = product.multiply(new BigInteger(String.valueOf(i)));
        	com.add(product);
        }
        for(int i = 0;i <= rowIndex;i++){
        	row.add(com.get(rowIndex).divide(com.get(rowIndex-i).multiply(com.get(i))));
        	result.add(row.get(i).intValue());
        }
        return result;
    }

}
