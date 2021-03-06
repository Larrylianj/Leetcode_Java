
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
//		String a = "123";
//		a += (char)('1'+1);
//		System.out.print(a);
		System.out.print(s.getPermutation(2, 2));
	}
	
	public String getPermutation(int n, int k) {
        String output ="";
        // base case
        if(k==1){
            for(char i = '1';i < '1'+n;i++)
                output += i;
            return output;
        }
        
        // recursive
        int first_num = (k-1)/factorial(n-1);
        output += (char)('1'+first_num);
        int res_k = k - first_num*factorial(n-1);
        String temp = getPermutation(n-1,res_k);
        for(int i = 0;i < temp.length();i++)
            output += temp.charAt(i) >= '1'+first_num?(char)(temp.charAt(i)+1):temp.charAt(i);
            
        return output;
    }
    
    private int factorial(int n){
        return n<=0?1:n*factorial(n-1);
    }

}
