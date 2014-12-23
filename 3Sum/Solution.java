public class Solution {
    List<List<Integer>> output;
    HashSet<List<Integer>> visited;
    public List<List<Integer>> threeSum(int[] num) {
        output = new ArrayList<List<Integer>>();
        visited = new HashSet<List<Integer>>();
        //Arrays.sort(num);
        Map<Integer, Integer> positive = new HashMap<Integer, Integer>();
        Map<Integer, Integer> negative = new HashMap<Integer, Integer>();
        int numOfZeros = 0;
        // construct the mapping
        for(int i = 0;i < num.length;i++){
            if(num[i] == 0)
                numOfZeros++;
            if(num[i] > 0)
                if(positive.containsKey(num[i]))
                    positive.put(num[i], positive.get(num[i])+1);
                else
                    positive.put(num[i],1);
            if(num[i] < 0)
                if(negative.containsKey(num[i]))
                    negative.put(num[i], negative.get(num[i])+1);
                else
                    negative.put(num[i],1);
        }
        
        // generate results
        // two positive + one negative
        for(Map.Entry<Integer, Integer> a:positive.entrySet())
            for(Map.Entry<Integer, Integer> b:positive.entrySet())
                if(a.getKey() != b.getKey() || a.getValue() >= 2)
                    if(negative.containsKey(-a.getKey()-b.getKey()))
                        addResult(a.getKey(),b.getKey(),-a.getKey()-b.getKey());
                    
        
        // two negative + one positive
        for(Map.Entry<Integer, Integer> a:negative.entrySet())
            for(Map.Entry<Integer, Integer> b:negative.entrySet())
                if(a.getKey() != b.getKey() || a.getValue() >= 2)
                    if(positive.containsKey(-a.getKey()-b.getKey()))
                        addResult(a.getKey(),b.getKey(),-a.getKey()-b.getKey());
        
        // one positive+zero+one negative
        if(numOfZeros > 0)
            for(Map.Entry<Integer, Integer> a:negative.entrySet())
                if(positive.containsKey(-a.getKey()))
                    addResult(0,a.getKey(),-a.getKey());
        
        // three zeros
        if(numOfZeros > 2)
            addResult(0,0,0);
            
        return output;
    }
    
    private void addResult(int a, int b, int c){
        int array[] = {a,b,c};
        Arrays.sort(array);
        List<Integer> result = new ArrayList<Integer>();
        result.add(array[0]);
        result.add(array[1]);
        result.add(array[2]);
        if(!visited.contains(result)){
            visited.add(result);
            output.add(result);
        }
    }
}