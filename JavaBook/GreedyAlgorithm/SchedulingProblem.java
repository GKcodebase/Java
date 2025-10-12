import java.util.Arrays;

/**
 * The {@code SchedulingProblem} class provides a method to solve the activity selection problem
 * using a greedy algorithm. It determines the maximum number of non-overlapping events (jobs)
 * that can be scheduled given their start and end times.
 *
 * <p>
 * The main method demonstrates usage with a sample set of jobs.
 * </p>
 *
 * <ul>
 *   <li>{@link #countEvents(int[][])}: Returns the maximum number of non-overlapping events.</li>
 * </ul>
 *
 * <p>
 * Example usage:
 * <pre>
 * int[][] jobs = { { 0, 3 }, { 2, 5 }, { 4, 6 }, { 6, 7 }, { 5, 8 }, { 8, 9 } };
 * int maxJobs = SchedulingProblem.countEvents(jobs);
 * </pre>
 * </p>
 */
public class SchedulingProblem {

    public static int countEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[1] - b[1]);
        int count = 1;
        int lastEnd = events[0][1];
        for (int i = 1; i < events.length; i++) {
            if (events[i][0] >= lastEnd) {
                count++;
                lastEnd = events[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] jobs = { { 0, 3 }, { 2, 5 }, { 4, 6 }, { 6, 7 }, { 5, 8 }, { 8, 9 } };
        System.out.println("Maximum number of non-overlapping jobs: " + countEvents(jobs));
    }
}
