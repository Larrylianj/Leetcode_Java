public class Solution {
    
	public static void main(String args[]){
		int num[] = {27,271};
		Solution s = new Solution();
		System.out.println(s.largestNumber(num));
	}
	public String largestNumber(int[] num) {
        StringBuilder str = new StringBuilder();
        for(int i = 1;i < num.length;i = 2*i){
            for(int j = 0;j <= num.length-i;j+=2*i){
                merge(num, j,j+i,j+i,Math.min(j+2*i,num.length));
            }
        }
        for(int i = 0;i < num.length;i++)
            str.append(Integer.toString(num[i]));
        String result = str.toString();
        if(result.charAt(0)=='0')
            result = "0";
        return result;
    }
    
    private void merge(int num[], int a_begin, int a_end, int b_begin, int b_end){
        int i = a_begin;
        int j = b_begin;
        int k = 0;
        int temp[] = new int[num.length];
        while(i < a_end && j < b_end){
            if(compare(num[i],num[j])<0)
                temp[k++] = num[j++];
            else
                temp[k++] = num[i++];
        }
        while(i < a_end)
            temp[k++] = num[i++];
        while(j < b_end)
            temp[k++] = num[j++];
        for(i = 0;i < k;i++)
            num[a_begin+i] = temp[i];
    }
    
    private int compare(int a, int b){
        String aStr = Integer.toString(a);
        String bStr = Integer.toString(b);
        int i = 0, k = 0;
        while(i < aStr.length() && i < bStr.length()){
            if(aStr.charAt(i) > bStr.charAt(i))
                return 1;
            if(aStr.charAt(i) < bStr.charAt(i))
                return -1;
            i++;
        }
        while(i < aStr.length() && k < bStr.length()){
            if(aStr.charAt(i) > aStr.charAt(k))
                return 1;
            if(aStr.charAt(i) < aStr.charAt(k))
                return -1;
            k++;
        }
        k = k < bStr.length()?k:k-1;
        while(i < aStr.length()){
            if(aStr.charAt(i) > aStr.charAt(k))
                return 1;
            if(aStr.charAt(i) < aStr.charAt(k))
                return -1;
            i++;
        }
        while(i < bStr.length() && k < aStr.length()){
            if(bStr.charAt(i) > aStr.charAt(k))
                return -1;
            if(bStr.charAt(i) < aStr.charAt(k))
                return 1;
            k++;
        }
        k = k < aStr.length()?k:k-1;
        while(i < bStr.length()){
            if(bStr.charAt(i) > aStr.charAt(k))
                return -1;
            if(bStr.charAt(i) < aStr.charAt(k))
                return 1;
            i++;
        }
        return 0;
    }
}