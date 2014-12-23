public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int curHeight = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // map each position with its first appearance position
        for(int i = 0;i < height.length;i++)
            if(!map.containsKey(height[i]))
                map.put(height[i],i);
        // start from left to right to adjust the first appearance position
        for(int i = 0;i < height.length;i++){
            if(height[i] > curHeight){
                for(int j = curHeight+1;j <= height[i];j++)
                    if(map.containsKey(j))
                        map.put(j,i);
                curHeight = height[i];
            }
        }
        // start from right to left to assign the longest distance of each value
        curHeight = 0;
        for(int i = height.length-1;i >= 0;i--){
            if(height[i] > curHeight){
                for(int j = curHeight+1;j <= height[i];j++)
                    if(map.containsKey(j))
                        map.put(j,i-map.get(j));
                curHeight = height[i];
            }
        }
        // check each value to get maximum area
        for(Map.Entry<Integer, Integer> entry:map.entrySet())
            if(entry.getKey()*entry.getValue() > max)
                max = entry.getKey()*entry.getValue();
        
        return max;
    }
}