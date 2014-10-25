
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sample[] = {10,186,-49,176,118,167,-61,189,6,-24,7,-93,71,112,187,45,-36,38,82,108,-46,112,51,165,-37,159,1,-53,7,38,90,181,-23,91,-42,172,-95,130,84,149,-47,68,126,-67,175,22,121,131,84,114,60,64,182,-75,-17,-71,69,-92,103,-91,-91,86,126,166,33,-36,-80,-37,118,-80,-18,127,36,-71,-82,-82,144,12,57,149,71,91,-83,-100,-30,45,186,16,-51,-72,-83,107,140,-97,-93,1,12,189,-61,-50,180,98,96,-29,193,167,57,-45,16,6,-76,4,109,-23,22,144,190,-97,193,-51,-99,-79,-47,142,107,175,109,121,190,90,34,32,63,-24,41,-53,41,89,130,-18,-99,103,86,127,-30,102,32,-49,181,-60,114,60,-29,182,-75,168,96,51,33,142,108,69,10,-57,166,48,82,161,-17,-50,102,63,-45,140,180,176,-95,36,-46,168,187,161,-72,-100,-42,165,-76,-67,89,159,64,34,98,4,-60,172,-79,68,48,131,-57};
		//int sample[] = {2,2,1};
		Solution s = new Solution();
		System.out.println(s.singleNumber(sample));

	}
	
	public int singleNumber(int[] A) { 
		
		int result = 0;
		for(int i = 0;i < A.length;i++){
			result ^= A[i];
		}
		return result;
		
//		int map[] = new int[(A.length+1)/2];
//		int len = map.length;
//		int temp;
//		
//		// 0 case && 1 case
//		int count0 = 0;
//		int count1 = 0;
//		for(int i = 0;i < A.length;i++){
//			if(A[i] == 0){
//				count0++;
//			}
//			if(A[i] == 1){
//				count1++;
//			}
//		}
//		if(count0 == 1){
//			return 0;
//		}
//		if(count1 == 1){
//			return 1;
//		}
//		
//		// general case
//		for(int i = 0;i < A.length;i++){
//			temp = Math.abs(A[i]%len);
//			while(map[temp] != 0 && map[temp] != A[i]){
//				temp++;
//				temp = temp%len;
//			}
//			if(map[temp] == 0){
//				map[temp] = A[i];
//			}else if(map[temp] == A[i]){
//				map[temp] = 1;
//			}
//		}
//		
//		for(int i = 0;i < len;i++){
//			if(map[i] != 0 && map[i] != 1){
//				return map[i];
//			}
//		}
//		
//		return 0;
	}

}
