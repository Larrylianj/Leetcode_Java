/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        Interval newInt = new Interval(0,0);
        boolean merge = false;
        int remove_start = -1;
        int remove_end = -1;
        int startT = newInterval.start;
        int endT = newInterval.end;
        
        // get the remove_start index and remove_end index
        for(int i = 0;i < intervals.size();i++){
            int cur_start = intervals.get(i).start;
            int cur_end = intervals.get(i).end;
            if(startT <= cur_end && endT >= cur_start){
                startT = Math.min(startT,cur_start);
                endT = Math.max(endT,cur_end);
                if(!merge){remove_start = i;}
                merge = true;
            }else{
                if(merge){
                    remove_end = i;
                    newInt.start = startT;
                    newInt.end = endT;
                    break;
                }
            }
        }
        remove_end = remove_end == -1?intervals.size():remove_end;
        newInt.start = startT;
        newInt.end = endT;
        
        // insert, remove if needed
        if(!merge){
            if(intervals.size()==0){
                intervals.add(newInterval);
            }else if(startT > intervals.get(intervals.size()-1).end){
                intervals.add(newInterval);
            }else if(endT < intervals.get(0).start){
                intervals.add(0,newInterval);
            }else{
               for(int i = 0;i < intervals.size()-1;i++){
                   if(startT > intervals.get(i).end && endT < intervals.get(i+1).start){
                       intervals.add(i+1,newInterval);
                   }
               } 
            }
            return intervals;
        }
        int count_remove = 0;
        for(int i = 0;i < intervals.size();i++){
            if(i >= remove_start-count_remove && i < remove_end-count_remove){
                intervals.remove(i--);
                count_remove++;
            }
        }
        intervals.add(remove_start, newInt);
        return intervals;
    }
}