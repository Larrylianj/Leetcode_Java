import java.util.List;
import java.util.ArrayList;

public class Solution {
	
	public static void main(String arg[]){
		Solution s = new Solution();
		String num1 = "999";
		String num2 = "999";
		System.out.print(s.multiply(num1, num2));
	}
	
    int buffer_len = 4;
    int char_size = 8;
    public String multiply(String num1, String num2) {
        // edge case
        if(num1.equals("0") || num2.equals("0")){return "0";}
        List<String> products = new ArrayList<String>();
        String result = "";
        String shortOne = num1.length() < num2.length()?num1:num2;
        String longOne = shortOne == num1?num2:num1;
        int forward = 0;
        int pointAtShortOne = shortOne.length()-1;
        int pointAtLongOne = longOne.length()-1;
        
        // find the point position
        for(int i = 0;i < shortOne.length();i++)
            if(shortOne.charAt(i) == '.')
                pointAtShortOne = i;
        for(int i = 0;i < longOne.length();i++)
            if(longOne.charAt(i) == '.')
                pointAtLongOne = i;   
        
        // multiply one char by one char each time to get products for each layer
        for(int i = shortOne.length()-1;i >= 0;i--){
            String buffer = "";
            forward = 0;
            for(int j = longOne.length()-1;j >= 0;j--){
                forward = char2int(shortOne.charAt(i)) * char2int(longOne.charAt(j)) + forward;
                buffer += int2char(forward%10);
                forward /= 10;
            }
            // last forward
            if(forward != 0)
                buffer += int2char(forward);
            buffer = new StringBuffer(buffer).reverse().toString();
            for(int j = shortOne.length()-1;j > i;j--)
                buffer += '0';
            products.add(buffer);
        }
        
        // sum the products
        forward = 0;
        for(int i = 0;i < products.get(products.size()-1).length();i++){
            for(int j = 0;j < products.size();j++){
                if(products.get(j).length() > i){
                    forward += char2int(products.get(j).charAt(products.get(j).length()-1-i));
                }
            }
            result += int2char(forward%10);
            forward /= 10;
        }
        if(forward != 0)
            result += int2char(forward);
        result = new StringBuffer(result).reverse().toString();
        
        // add point
        if(shortOne.length()-1-pointAtShortOne + longOne.length()-1-pointAtLongOne != 0){
            return result.substring(0,pointAtShortOne+pointAtLongOne)+'.'+result.substring(pointAtShortOne+pointAtLongOne,result.length());
        }else{
            return result;
        }
        
        // delete extra zeros
        
        
    }
    
    private int char2int(char c){
        return (int)(c-'0');
    }
    
    private char int2char(int n){
        return (char)('0'+n);
    }
}