public class Solution {
    
    public List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<String>();
        if(digits.length()==0){
            String zero = "";
            output.add(zero);
            return output;
        }
        for(int i = 0;i < lettersOfChar(digits.charAt(0)).size();i++)
            search(new String(""), digits, 0,i,output);
        return output;
    }
    
    private void search(String current, String digits, int position, int index, List<String> output){
        String str = new String(current);
        str += lettersOfChar(digits.charAt(position)).get(index).toString();
        if(position == digits.length()-1)
            output.add(str);
        else
            for(int i = 0;i < lettersOfChar(digits.charAt(position+1)).size();i++)
                search(str, digits, position+1, i, output);
        return;
    }
    
    public List<Character> lettersOfChar(char c){
        List<Character> lst = new ArrayList<Character>();
        switch(c){
            case '2':
                lst.add('a');
                lst.add('b');
                lst.add('c');
                break;
            case '3':
                lst.add('d');
                lst.add('e');
                lst.add('f');
                break;
            case '4':
                lst.add('g');
                lst.add('h');
                lst.add('i');
                break;
            case '5':
                lst.add('j');
                lst.add('k');
                lst.add('l');
                break;
            case '6':
                lst.add('m');
                lst.add('n');
                lst.add('o');
                break;
            case '7':
                lst.add('p');
                lst.add('q');
                lst.add('r');
                lst.add('s');
                break;
            case '8':
                lst.add('t');
                lst.add('u');
                lst.add('v');
                break;
            case '9':
                lst.add('w');
                lst.add('x');
                lst.add('y');
                lst.add('z');
                break;
            default:
                break;
        }
        return lst;
    }
}