public class Solution {
    public int romanToInt(String s) {
        int i = 0;
        int result = 0;
        char romanChar[] = {'I','V','X','L','C','D','M'};
        int romanInt[] = {1,5,10,50,100,500,1000};
        while(i < s.length()){
            for(int j = 0;j < romanChar.length;j++){
                if(s.charAt(i)==romanChar[j]){
                    if(i+1 < s.length()){
                        if(j+1 < romanChar.length){
                            if(s.charAt(i+1)==romanChar[j+1]){
                                result -= romanInt[j];
                                break;
                            }
                        }
                        if(j+2 < romanChar.length){
                            if(s.charAt(i+1)==romanChar[j+2]){
                                result -= romanInt[j];
                                break;
                            }
                        }
                    }
                    result += romanInt[j];
                    break;
                }
            }
            i++;
        }
        return result;
    }
}