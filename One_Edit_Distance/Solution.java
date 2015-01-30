public class Solution{

	public static void main(String args[]){
		Solution s = new Solution();
		String S = "accbc";
		String T = "acccc";
		System.out.println(s.oneEditDistance(S,T));
	}
	public boolean oneEditDistance(String S, String T){
		int Sbegin = -1, Tbegin = -1;
		int Send = S.length(), Tend = T.length();
		// loop from begin until mismatch
		while(Sbegin+1 < S.length() && Tbegin+1 < T.length()){
			if(S.charAt(Sbegin+1)!=T.charAt(Tbegin+1)){
				break;
			}else{
				Sbegin++;
				Tbegin++;
			}
		}
		// loop from end until mismatch
		while(Send-1 >= 0 && Tend-1 >= 0){
			if(S.charAt(Send-1)!=T.charAt(Tend-1)){
				break;
			}else{
				Send--;
				Tend--;
			}
		}
		return (Send-Sbegin<=2)&&(Tend-Tbegin<=2);
	}

}