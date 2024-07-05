package CodingPatterns.MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This problem could be useful for visualizing availability in scheduling tools.
 * Given a list of calendar events represented by their start and end times,
 * your function should find and return all time ranges during which at least one event is ongoing.
 */
public class FindingBusyPeriodsInACalendar {

    /**
     * Find busy periods list.
     *
     * @param intervals the intervals
     * @return the list
     */
    public static List<mergeIntervals.Interval> findBusyPeriods(List<mergeIntervals.Interval> intervals){
        Collections.sort(intervals,(a,b)->Integer.compare(a.start,b.start));
        List<mergeIntervals.Interval> busyTime = new ArrayList<>();
        mergeIntervals.Interval current  = intervals.get(0);
        for(int i=1;i<intervals.size();i++){
            mergeIntervals.Interval next = intervals.get(i);
            if(current.end >= next.start){
                current.end = Math.max(current.end, next.end);
            }else {
                busyTime.add(current);
                current= next;
            }
        }
        busyTime.add(current); // Add the last busy period
        return busyTime;
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        List<mergeIntervals.Interval> busyTime = new ArrayList<>();
        busyTime.add(new mergeIntervals.Interval(1,5));
        busyTime.add(new mergeIntervals.Interval(3,7));
        busyTime.add(new mergeIntervals.Interval(4,6));
        busyTime.add(new mergeIntervals.Interval(6,8));
        busyTime.add(new mergeIntervals.Interval(10,12));
        busyTime.add(new mergeIntervals.Interval(11,12));
        busyTime=findBusyPeriods(busyTime);
        for (mergeIntervals.Interval event : busyTime) {
            System.out.println("Ongoing event from " + event.start + " to " + event.end);
        }

    }
}
