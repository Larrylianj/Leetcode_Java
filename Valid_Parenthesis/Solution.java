public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        if(s.length()==0){return true;}
        stack.add(s.charAt(0));
        for(int i = 1;i < s.length();i++){
            if(stack.isEmpty()){stack.add(s.charAt(i));}
            else{
            char peek = stack.peek();
            switch(peek){
                case '(':
                    if(s.charAt(i)==')')
                        stack.pop();
                    else
                        stack.push(s.charAt(i));
                    break;
                case '[':
                    if(s.charAt(i) ==']')
                        stack.pop();
                    else
                        stack.push(s.charAt(i));
                    break;
                case '{':
                    if(s.charAt(i)=='}')
                        stack.pop();
                    else
                        stack.push(s.charAt(i));
                    break;
                default:
                    return false;
            }
            }
        }
        return stack.isEmpty()?true:false;
    }
}