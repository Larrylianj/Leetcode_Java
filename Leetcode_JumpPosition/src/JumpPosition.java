import java.lang.reflect.Array;


public class JumpPosition {
    public boolean canJump(int[] A) {
        int len;
        int i,j;
        boolean flag = false;
        len = Array.getLength(A);
        boolean opt[] = new boolean[len];
        
        // base case
        opt[0] = true;
        for(i = 1; i < len; i++){
            for(j = 0; j < i; j++){
                if(opt[j] == true && i-j <= A[j]){
                    flag = true;
                    break;
                }
            }
            if(flag == true){
                opt[i] = true;
                flag = false;
            }else{
                opt[i] = false;
            }
        }
        return opt[len - 1];
    }
}
