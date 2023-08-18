package algorithm.greedyalgorithm;

import java.util.Arrays;

/**
 * The type Count platform.
 */
public class CountPlatform {
    /**
     * Count platform int.
     *
     * @param arrival   the arrival
     * @param departure the departure
     * @return the int
     */
    public static int countPlatform(int[] arrival, int[] departure) {
        int n = arrival.length;
        Arrays.sort(arrival);
        Arrays.sort(departure);

        int platform = 1;
        int result = 1;
        int i = 1;
        int j = 0;

        while ((i < n) & (j < n)) {
            if (arrival[i] < departure[j]) {
                platform++;
                i++;

                //Update result if needed
                if (platform > result) {
                    result = platform;
                }
            } else {
                //Else decrement count of platforms needed
                platform--;
                j += 1;
            }
        }
        return result;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        //Example 1
        int arrival[] = {900, 940, 950, 1100, 1500, 1800};
        int departure[] = {910, 1200, 1120, 1130, 1900, 2000};
        int answer = countPlatform(arrival, departure);
        System.out.println("Minimum Number of Platforms Required for Plan1 = " + answer);

        System.out.println();

        // Example 2
        int arrival1[] = {200, 210, 300, 320, 350, 500};
        int departure1[] = {230, 240, 320, 430, 400, 520};
        int answer2 = countPlatform(arrival1, departure1);
        System.out.println("Minimum Number of Platforms Required for Plan2 = " + answer2);
    }
}
