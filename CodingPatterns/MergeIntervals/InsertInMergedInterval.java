package CodingPatterns.MergeIntervals;

import java.util.ArrayList;
import java.util.List;

import static CodingPatterns.MergeIntervals.mergeIntervals.*;

/**
 * The type Insert in merged interval.
 */
public class InsertInMergedInterval {

    /**
     * Insert in merged interval list.
     *
     * @param mergedIntervals the merged intervals
     * @param newInterval     the new interval
     * @return the list
     */
    public static List<mergeIntervals.Interval> insertInMergedInterval(List<Interval> mergedIntervals , Interval newInterval){
        mergedIntervals.add(newInterval);
        return mergeInterval(mergedIntervals);

    }

    /**
     * Print.
     *
     * @param intervals the intervals
     */
    public static void print(List<Interval> intervals){
        System.out.println("Intervals ->");
        for(int i=0;i<intervals.size();i++){
            System.out.println(intervals.get(i).start+" - "+intervals.get(i).end);
        }
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        List<Interval> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(new Interval(8,9));
        mergedIntervals.add(new Interval(9,10));
        mergedIntervals.add(new Interval(10,12));
        mergedIntervals.add(new Interval(16,20));
        print(mergedIntervals);
        mergedIntervals=insertInMergedInterval(mergedIntervals,new Interval(13,14));
        print(mergedIntervals);
        mergedIntervals=insertInMergedInterval(mergedIntervals,new Interval(11,12));
        print(mergedIntervals);
    }
}
