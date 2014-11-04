public class Solution {
    public boolean isNumber(String s) {
        int dot_pos = -1;
        int exp_pos = -1;
        int begin = 0,end = s.length()-1;
        boolean numeric = false;
        // skip all space at head or at back
        while(s.charAt(begin) == ' '){
            begin++;
            if(begin >= s.length()){return false;}
        }
        while(s.charAt(end) == ' '){
            end--;
            if(end < 0){return false;}
        }
        // go through the rest
        for(int i = begin;i <= end;i++){
            // find the dot position
            if(s.charAt(i) == '-' || s.charAt(i) == '+'){
                if(i != begin && i != exp_pos+1 || i == end)
                    return false;
            }else if(s.charAt(i) == '.'){
                if(dot_pos != -1 || exp_pos != -1)
                    return false;
                else
                    dot_pos = i;
            }else if(s.charAt(i) == 'e'){
                if(exp_pos != -1)
                    return false;
                else
                    exp_pos = i;
            }else if(s.charAt(i) < '0' || s.charAt(i) > '9'){
                return false;
            }else{
                numeric = true;
            }
        }
        // check if no numeric number
        if(!numeric){return false;}
        // check if -e or +e only
        if((s.charAt(begin) == '-' || s.charAt(begin) == '+') && exp_pos == begin+1){return false;}
        // check if .e 
        if(dot_pos == begin && exp_pos == begin+1){return false;}
        // check if eXXX or XXXe
        if(exp_pos == begin || exp_pos == end){return false;}
        return true;
    }
}