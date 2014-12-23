public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if(num.length < 3){return 0;}
        int closest = num[0]+num[1]+num[2];
        int dis = Math.abs(closest-target);
        Arrays.sort(num);
        for(int i = 0;i < num.length-2;i++){
            // set two pointers, one from small-end, one from large-end
            int p = i+1;
            int q = num.length-1;
            while(p < q){
                int sum = num[i]+num[p]+num[q];
                if(Math.abs(sum-target) < dis){
                    closest = sum;
                    dis = Math.abs(sum-target);
                }
                if(sum > target)
                    q--;
                if(sum < target)
                    p++;
                if(sum == target)
                    return sum;
            }
        }
        return closest;
    }
}