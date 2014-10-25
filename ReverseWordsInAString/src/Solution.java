
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = new String("1");
		System.out.println(reverseWords(str));

	}
	
	static public String reverseWords(String s){
		
		String temp[] = s.split(" ");
		String result = "";
		
		int i = temp.length - 1;
		while(i >= 0){
			result += temp[i--];
			if(i >= 0){
				while(temp[i].length() == 0){
					i --;
					if(i < 0){
						break;
					}
				}
			}
			if(i < 0){
				break;
			}
			result += " ";
		}
		
		return result;
		
//		boolean flag;
//		int i,j,u,t;
//		int len = s.length();
//		char out[] = new char[len];
//		
//		
//		i = 0;
//		j = len;
//		flag = false;
//		while(i < len){
//			
//			while (i < len && s.charAt(i) == ' '){
//				i++;
//				j--;	
//			}
//			
//			u = i;
//			while(i < len){
//				if (s.charAt(i) == ' '){
//					break;
//				}
//				flag = true;
//				i++;
//				j--;
//			}
//			for (t = 0;t < i - u;t++){
//				out[j + t] = s.charAt(u + t);
//			}
//			
//			while (i < len && s.charAt(i) == ' '){
//				i++;
//				j--;	
//			}
//			
//			if(i < len){
//				out[j] = ' ';
//			}
//		}
//		if(flag == false){
//			return "";
//		}
//		String ss = new String(out);
//		return ss;
		
	}

}
