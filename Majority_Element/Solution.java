public class Solution {
    public int majorityElement(int[] num) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < num.length;i++){
            if(map.containsKey(num[i])){
                if(map.get(num[i]) >= num.length/2)
                    return num[i];
                map.put(num[i],map.get(num[i])+1);
            }else{
                map.put(num[i],1);
            }
        }
        return num.length==0?0:num[0];
    }
}