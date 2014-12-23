public class Solution {
    public String convert(String s, int nRows) {
        if(nRows==1){return s;}
        int i = 0;
        String result = "";
        for(int j = 0;j < nRows;j++){
            i = 0;
            if(j == 0 || j == nRows-1){
                i += j;
                while(i < s.length()){
                    result += s.charAt(i);
                    i += 2*(nRows-1);
                }
            }else{
                while(i + j < s.length()){
                    result += s.charAt(i+j);
                    if(i+2*(nRows-1)-j < s.length())
                        result += s.charAt(i+2*(nRows-1)-j);
                    else
                        break;
                    i += 2*(nRows-1);
                }
            }
        }
        return result;
    }
}