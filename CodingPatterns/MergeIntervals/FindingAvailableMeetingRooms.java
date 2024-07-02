package CodingPatterns.MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given an array of meeting intervals representing occupied rooms,
 * find the minimum number of rooms needed to accommodate all meetings concurrently.
 */
public class FindingAvailableMeetingRooms {

    /**
     * The type Interval.
     */
    static class Interval{
        /**
         * The Start.
         */
        Integer startTime;
        /**
         * The End.
         */
        Integer endTime;

        /**
         * Instantiates a new Interval.
         *
         * @param start the start
         * @param end   the end
         */
        Interval(int start,int end){
            this.startTime=start;
            this.endTime=end;
        }
    }

    /**
     * Find rooms int.
     *
     * @param intervals the intervals
     * @return the int
     */
    public static int findMeetingRooms(List<Interval> intervals){
        Collections.sort(intervals, (a,b)->Integer.compare(a.startTime,b.startTime)); // Sort by start time
        PriorityQueue<Integer> endTimes = new PriorityQueue<>(); // Track ending times
        int maxRooms =0;
        endTimes.add(intervals.get(0).endTime);
        for(int i=1;i<intervals.size();i++){
            if(intervals.get(i).startTime>=endTimes.peek())
                endTimes.poll();
            endTimes.add(intervals.get(i).endTime);
        }
        return endTimes.size();
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        List<Interval> meetings = new ArrayList<>();
        meetings.add(new Interval(8,9));
        meetings.add(new Interval(8,10));
        meetings.add(new Interval(8,12));
        meetings.add(new Interval(2,3));
        meetings.add(new Interval(2,4));
        System.out.println("Maximum number of room required :: "+findMeetingRooms(meetings));
    }
}
