package CodingPatterns.MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a list of meeting intervals represented by start and end times,
 * merge overlapping intervals into a minimum set of non-overlapping intervals.
 */
public class mergeIntervals {


    /**
     * The type Interval.
     */
    static class Interval {
        /**
         * The Start.
         */
        int start;
        /**
         * The End.
         */
        int end;
        Interval(int start,int end){
            this.start=start;
            this.end=end;
        }
    }

    /**
     * Merge interval list.
     *
     * @param intervals the intervals
     * @return the list
     */
    public static List<Interval> mergeInterval(List<Interval> intervals){
        Collections.sort(intervals, (a,b)-> Integer.compare(a.start,b.start));
        List<Interval> merged = new ArrayList<>();
        Interval current = intervals.get(0);

        for(int i=1;i<intervals.size();i++){
            Interval next = intervals.get(i);
            if(current.end>=next.start){
                current.end = Math.max(current.end,next.end);
            }else{
                merged.add(current);
                current=next;
            }
        }
        merged.add(current);
        return merged;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        List<Interval> list =  new ArrayList<>();
        list.add(new Interval(1,2));
        list.add(new Interval(12,20));
        list.add(new Interval(4,9));
        list.add(new Interval(9,27));
        list.add(new Interval(29,35));
        list.add(new Interval(3,4));

        list = mergeInterval(list);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).start+" - "+list.get(i).end);
        }
    }
}
