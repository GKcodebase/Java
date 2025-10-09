import java.util.Arrays;
public class SchedulingProblem {

    public static int countEvents(int[][] events){
        Arrays.sort(events,(a,b)-> a[1]-b[1]);
        int count = 1;
        int lastEnd = events[0][1];
        for( int i=1;i<events.length;i++){
            if(events[i][0] >=lastEnd){
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
