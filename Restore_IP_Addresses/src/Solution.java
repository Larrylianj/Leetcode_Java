import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ss = "010010";
		Solution s = new Solution();
		System.out.println(s.restoreIpAddresses(ss));
	}
	public List<String> restoreIpAddresses(String s) {
        List<String> output = new ArrayList<String>();
        if(s.length() < 4){return output;}
        return restoreIpAddresses(s,4);
    }
    
    private List<String> restoreIpAddresses(String s, int n){
        List<String> output = new ArrayList<String>();
        // base case
        if(s.length() == 0){return output;}
        if(n == 1){
        	if(s.charAt(0) == '0' && s.length() > 1){return output;}
            if(s.length() > 0 && s.length() <= 3)
                if(Integer.parseInt(s) >= 0 && Integer.parseInt(s) <= 255)
                    output.add(s);
            return output;
        }
        // iteration
        if(s.charAt(0) == '0'){
            List<String> sublist = restoreIpAddresses(s.substring(1,s.length()),n-1);
            for(int i = 0;i < sublist.size();i++){
                String result = s.substring(0,1)+'.'+sublist.get(i);
                output.add(result);
            }
        }else{
            for(int i = 1;i < Math.min(4,s.length());i++){
                int num = Integer.parseInt(s.substring(0,i));
                if(num > 0 && num <= 255){
                    List<String> sublist = restoreIpAddresses(s.substring(i,s.length()),n-1);
                    for(int j = 0;j < sublist.size();j++){
                        String result = s.substring(0,i)+'.'+sublist.get(j);
                        output.add(result);
                    }
                }
                
            }
        }
        return output;
    }
}
