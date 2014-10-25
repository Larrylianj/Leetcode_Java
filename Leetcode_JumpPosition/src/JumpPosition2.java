import java.lang.reflect.Array;


public class JumpPosition2 {

	public static void main(String[] args){
		
		int A[] = {2,3,1,1,4,1,1,1,3,2,5,3,1,2,9,0,3,3};
		int steps = canJump(A);
		System.out.print(steps);
		
	}
    public static int canJump(int[] A) {
    	int VeryBig = 100000;
    	int mini = VeryBig;
        int len;
        int i,j;
        boolean flag = false;
        len = Array.getLength(A);
        boolean opt[] = new boolean[len];
        int min[] = new int[len];
        
        // base case
        opt[0] = true;
        min[0] = 0;
        
        // get true of false
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
        
        for(i = 0;i < len; i++){
        	System.out.println("opt["+i+"] ="+opt[i]);
        }
        
        
        	// get minimun jumps
            
            for(i = 1; i < len; i++){
                for(j = i; j < i; j++){
                    if(opt[j] == true && i-j <= A[j]){
                        if(mini > min[j]){
                        	mini = min[j];
                        }
                    }
                }
                min[i] = mini + 1; 
                mini = VeryBig;
                System.out.println(min[i]);
            }
            
            return min[len - 1];
            
        
        
    }

}
