package CheatSheet.CompetitveCoding;


import java.util.*;


/**
 * The Merge intervals.
 */
public class MergeIntervals {
    /**
     * Merge intervals int [ ] [ ].
     *
     * @param intervals the intervals
     * @return the int [ ] [ ]
     */
    static int[][] mergeIntervals(int[][] intervals){
        List<int[]> result = new ArrayList<>();


        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int curr[] = new int[]{ intervals[0][0],intervals[0][1]};
        for(int i=1;i<intervals.length; i++ ){
            if(curr[1]>intervals[i][0]){
                curr[1] = Math.max(intervals[i][1],curr[1]);
            } else{
                result.add(curr);
                curr = intervals[i];
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]){
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] mergedIntervals = mergeIntervals(intervals);
        System.out.println("Merge Intervals:");
        for (int[] interval : mergedIntervals) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
