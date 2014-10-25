public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean opt[][][] = new boolean[s1.length()+1][s2.length()+1][s3.length()+1];
        
        for(int i = 0;i < s1.length()+1;i++){
            for(int j = 0;j < s2.length()+1;j++){
                for(int k = 0;k < s3.length()+1;k++){
                    if(i == 0 && j == 0 && k== 0){
                        opt[i][j][k] = true;
                    }else if((i == 0 && j == 0 && k != 0)||(i==0 && j!=0 && k==0)||(i!=0 && j==0 && k==0)){
                        opt[i][j][k] = false;
                    }else {
                        if(i == 0){
                            opt[i][j][k] = opt[i][j-1][k-1] && s2.charAt(j-1) == s3.charAt(k-1);
                        }else if(j == 0){
                            opt[i][j][k] = opt[i-1][j][k-1] && s1.charAt(i-1) == s3.charAt(k-1);
                        }else if(k == 0){
                            opt[i][j][k] = false;
                        }else{
                            opt[i][j][k] = (opt[i][j-1][k-1] && s2.charAt(j-1) == s3.charAt(k-1)) || (opt[i-1][j][k-1] && s1.charAt(i-1) == s3.charAt(k-1));
                        }
                    }
                }
            }
        }
        
        return opt[s1.length()][s2.length()][s3.length()];
    }
}