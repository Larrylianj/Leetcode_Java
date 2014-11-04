
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		String a = "100";
		String b = "110010";
		System.out.print(s.addBinary(a, b));

	}
	    public String addBinary(String a, String b) {
	        boolean forward =false;
	        String rslt = "";
	        int i = a.length()-1;
	        int j = b.length()-1;
	        while(i >= 0 && j >= 0){
	            if(a.charAt(i) == '1' && b.charAt(j) == '1' && forward){
	                rslt += '1';
	                forward = true;
	            }else if(((a.charAt(i) == '1' || b.charAt(j) == '1') && forward) || (a.charAt(i) == '1' && b.charAt(j) == '1')){
	                rslt += '0';
	                forward = true;
	            }else if(a.charAt(i) == '1' || b.charAt(j) == '1' || forward){
	                rslt += '1';
	                forward = false;
	            }else{
	                rslt += '0';
	                forward = false;
	            }
	            i--;
	            j--;
	        }
	        while(i >= 0){
	            if(a.charAt(i) == '1' && forward){
	                rslt += '0';
	                forward = true;
	            }else{
	                rslt += (a.charAt(i) == '1'||forward)?'1':'0';
	                forward = false;
	            }
	            i--;
	        }
	        while(j >= 0){
	            if(b.charAt(j) == '1' && forward){
	                rslt += '0';
	                forward = true;
	            }else{
	                rslt += (b.charAt(j) == '1'||forward)?'1':'0';
	                forward = false;
	            } 
	            j--;
	        }
	        if(forward){rslt += '1';}
	        
	        // reverse the rslt
	        String reverse = new StringBuffer(rslt).reverse().toString();
	        return reverse;
	    }

}
