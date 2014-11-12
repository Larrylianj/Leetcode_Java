import java.util.List;
import java.util.ArrayList;

//Definition for an interval.
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
 }
 
public class Solution {
	public static void main(String arg[]){
		Solution s = new Solution();
		List<Interval> lst = new ArrayList<Interval>();
		Interval t01 = new Interval(2,3);
		Interval t02 = new Interval(2,2);
		Interval t03 = new Interval(3,4);
		Interval t04 = new Interval(1,3);
		Interval t05 = new Interval(5,7);
		Interval t06 = new Interval(2,2);
		Interval t07 = new Interval(4,6);

		lst.add(t01);
		lst.add(t02);
		lst.add(t03);
		lst.add(t04);
		lst.add(t05);
		lst.add(t06);

		lst.add(t07);

		System.out.print(s.merge(lst));

	}
    public List<Interval> merge(List<Interval> intervals) {
        // sort it if needed
        List<Interval> copy = new ArrayList<Interval>();
        for(int i = 0;i < intervals.size();i++){
            Interval newInt = new Interval(intervals.get(i).start,intervals.get(i).end);
            copy.add(newInt);
        }
        intervals = new ArrayList<Interval>();
        intervals = mergeSort(copy);
        
        // one time scan
        if(intervals.size() == 0){return intervals;}
        boolean remove = false;
        int remove_start = -1;
        int pre_start = intervals.get(0).start;
        int pre_end = intervals.get(0).end;
        int cur_start, cur_end;
        for(int i = 1;i < intervals.size();i++){
            cur_start =intervals.get(i).start;
            cur_end = intervals.get(i).end;
            if(pre_end >= cur_start && pre_start <= cur_end){
                pre_start = Math.min(cur_start,pre_start);
                pre_end = Math.max(cur_end,pre_end);
                if(!remove){
                    remove_start = i-1;
                    remove = true;
                }
            }else{
                if(remove){
                    for(int j = remove_start;j < i;j++){
                        intervals.remove(j--);
                        i--;
                    }
                    Interval newInt = new Interval(pre_start,pre_end);
                    intervals.add(remove_start,newInt);
                    remove = false;
                }
            }
        }
        if(remove){
            for(int j = remove_start;j < intervals.size();j++){
                intervals.remove(j--);
            }
            Interval newInt = new Interval(pre_start,pre_end);
            intervals.add(remove_start,newInt);
        }
        return intervals;
    }
    
    private List<Interval> mergeSort(List<Interval> lst){
        // base case
        if(lst.size() == 1){return lst;}
        
        // recursive
        List<Interval> left = new ArrayList<Interval>();
        List<Interval> right = new ArrayList<Interval>();
        for(int i = 0;i < lst.size()/2;i++){left.add(lst.get(i));}
        for(int i = lst.size()/2;i < lst.size();i++){right.add(lst.get(i));}
        return merge(mergeSort(left),mergeSort(right));
    }
    private List<Interval> merge(List<Interval> a, List<Interval> b){
        List<Interval> output = new ArrayList<Interval>();
        int i = 0,j = 0;
        while(i < a.size() && j < b.size()){
            if(a.get(i).start < b.get(j).start){
                output.add(a.get(i++));
            }else{
                output.add(b.get(j++));
            }
        }
        while(i < a.size()){
            output.add(a.get(i++));
        }
        while(j < b.size()){
            output.add(b.get(j++));
        }
        return output;
    }
}