
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] sample = {"2", "1", "+", "3", "*"};
		System.out.print(evalRPN(sample));
		
	}

	static public int evalRPN(String[] tokens) {
        
		boolean flag;
		char symbol = '0';
		int i,j, value1, value2;
		flag = false;
		if(tokens.length == 1){
			return Integer.valueOf(tokens[0]);
		}
		for(i = 0;i < tokens.length;i++){
			if(tokens[i].equals("*") || tokens[i].equals("/") || tokens[i].equals("+") || tokens[i].equals("-")){
				symbol = tokens[i].charAt(0);
				flag = true;
				
			}
			
			if(flag == true){
				if(i > 1){
					value1 = Integer.valueOf(tokens[i - 2]);
					value2 = Integer.valueOf(tokens[i - 1]);
					switch(symbol){
						case '*': value1 = value1 * value2;
						break;
						case '/': value1 = value1 / value2;
						break;
						case '+': value1 = value1 + value2;
						break;
						case '-': value1 = value1 - value2;
						break;
						default: return 0;
					}	
					tokens[i] = Integer.toString(value1);
					String sub[] = new String[tokens.length - 2];
					for(j = 0;j < i - 2; j ++){
						sub[j] = tokens[j];
					}
					for(j = i - 2;j < tokens.length - 2;j++){
						sub[j] = tokens[j + 2];
					}
					return evalRPN(sub);
				}else{
					return 0;
				}
				
			}
		}
		return 0;
    }
}
