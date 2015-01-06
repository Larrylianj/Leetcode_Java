public class Solution {
	public static void main(String args[]){
		Solution s = new Solution();
		int num[] = {3,6,9,1};
		System.out.println(s.maximumGap(num));
	}
    public int maximumGap(int[] num) {
        int maxGap = 0;
        
        // edge case
        if(num.length < 2){return maxGap;}
        
        // get maximum and minimum
        int min = num[0];
        int max = num[0];
        for(int i = 0;i < num.length;i++){
            if(num[i] < min)
                min = num[i];
            if(num[i] > max)
                max = num[i];
        }
        
        // divide into identical gaps
        Gap[] gaps = new Gap[num.length-1];
        boolean[] Engaged = new boolean[num.length-1];
        double gap = (double)(max-min)/(double)(num.length-1);
        for(int i = 0;i < gaps.length;i++)
            Engaged[Math.min((int)Math.floor((double)(num[i]-min)/gap),gaps.length-1)] = true;
            
        // assign maximum and minimum for each gap
        for(int i = 0;i < gaps.length;i++)
            gaps[i] = new Gap();
        for(int i = 0;i < num.length;i++){
            int index = (int)Math.floor((double)(num[i]-min)/gap);
            index = Math.min(index,gaps.length-1);
            
            // lower bound
            if(gaps[index].low == -1)
                gaps[index].low = num[i];
            else
                gaps[index].low = Math.min(gaps[index].low, num[i]);
                    
            // upper bound
            if(gaps[index].high == -1)
                gaps[index].high = num[i];
            else
                gaps[index].high = Math.max(gaps[index].high, num[i]);
        }
        
        // find maximum gap
        for(int i = 0;i < gaps.length;i++){
            if(Engaged[i]){
                // check its inner gap
                maxGap = Math.max(gaps[i].high-gaps[i].low, maxGap);
                
                // lower all the way
                int j = i;
                while(--j >= 0){
                    if(Engaged[j])
                        break;
                }
                if(j >= 0)
                    maxGap = Math.max(gaps[i].low - gaps[j].high,maxGap);
                    
                // upper all the way
                j = i;
                while(++j < num.length-2){
                    if(Engaged[j])
                        break;
                }
                if(j < gaps.length)
                    maxGap = Math.max(gaps[j].low - gaps[i].high, maxGap);
            }
        }
        
        return maxGap;
    }
    
    class Gap{
        int low;
        int high;
        Gap(){
            low = -1;
            high = -1;
        }
        Gap(int x,int y){
            low = x;
            high = y;
        }
    }
}