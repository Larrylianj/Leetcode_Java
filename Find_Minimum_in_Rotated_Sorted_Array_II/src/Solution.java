
public class Solution {
	public static void main(String arg[]){
		int num[] = {1,3,3,3};
		Solution s = new Solution();
		System.out.println(s.findMin(num));
	}
    public int findMin(int[] num) {
        // base case
        if(num.length == 1){return num[0];}
        if(num.length == 2){
        	return num[0] >num[1]? num[1]:num[0];
        }
        
        // recursive call
        if(num[num.length/2-1] > num[num.length/2] && num[num.length/2] < num[num.length/2+1]){return num[num.length/2];}
        
        int first[] = new int[num.length/2];
        int second[] = new int[num.length-num.length/2];
        for(int i = 0;i < first.length;i++){first[i] = num[i];}
        for(int i = 0;i < second.length;i++){second[i] = num[i+num.length/2];}
        //return num[0] < num[num.length/2]? findMin(second):findMin(first);
        if(num[0] <= num[num.length/2]){
            return num[num.length/2-1] <= num[num.length-1]?findMin(first):findMin(second);
        }else{
            return num[num.length/2-1] <= num[num.length-1]?findMin(second):findMin(first);
        }
        
        
    }
}