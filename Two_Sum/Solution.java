public class Solution {
    final static int result[] = new int[2];
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> visited = new HashMap<>();
        for(int i = 0;i < numbers.length;i++){
            if(visited.containsKey(target-numbers[i])){
                result[0] = visited.get(target-numbers[i]);
                result[1] = i+1;
                break;
            }
            if(!visited.containsKey(numbers[i])){
                visited.put(numbers[i], i+1);
            }
        }
        return result;
    }
    
    
}