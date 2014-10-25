
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String S = "adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc";
		//String S = "daacaedaceacabbaabdccdaaeaebacddadcaeaacadbceaecddecdeedcebcdacdaebccdeebcbdeaccabcecbeeaadbccbaeccbbdaeadecabbbedceaddcdeabbcdaeadcddedddcececbeeabcbecaeadddeddccbdbcdcbceabcacddbbcedebbcaccac";
		//String T = "ceadbaa";
		//String T = "bcddceeeebecbc";
		String S = "deccdbebedabedecedebeccdebbaddddecacdbdeaabebcbaaccaaeabcccccadbeaaecaecacdbebeeedbeeecedebcbeaaaaaecbbcdebeacabccabddadeecbacbcebbbceacddbbaccebabbadebebcaaececbccac";
		String T = "bbbdedc";
		Solution s = new Solution();
		System.out.println(S.length());
		System.out.print(s.numDistinct(S, T));

	}
	public int numDistinct(String S, String T) {
		
		return 0;
	}
	
//	public int numDistinct(String S, String T) {
//		if(S.length() < T.length()){return 0;}
//		int count = 0;
//		if(T.length() == 1){
//			for(int i = 0;i < S.length();i++){
//				if(S.charAt(i) == T.charAt(0)){count++;}
//			}
//		}else{
//			for(int i = 0;i < S.length();i++){
//				if(S.charAt(i) == T.charAt(0)){
//					String subS = (String) S.subSequence(i+1, S.length());
//					String subT = (String) T.subSequence(1, T.length());
//					count += numDistinct(subS, subT);
//				}
//			}
//		}
//        return count;
//    }

}
