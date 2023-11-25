package algorithm.DynamicProgramming;

import java.util.Arrays;

/**
 * The type Longest sub sequence.
 */
public class LongestSubSequence {
    /**
     * Gets longest sub sequence.
     *
     * @param arr the arr
     * @param n   the n
     * @return the longest sub sequence
     */
    public static int getLongestSubSequence(int[] arr, int n) {
        int dp[][] = new int[n + 1][n + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return util(0, -1, n, arr, dp);
    }

    /**
     * Util int.
     *
     * @param idx   the idx
     * @param pridx the pridx
     * @param n     the n
     * @param arr   the arr
     * @param dp    the dp
     * @return the int
     */
    private static int util(int idx, int pridx, int n, int[] arr, int[][] dp) {
        if (idx == n)
            return 0;
        else if (dp[idx][pridx + 1] != -1)
            return dp[idx][pridx + 1];

        int notTake = 0 + util(idx + 1, pridx, n, arr, dp);
        int take = Integer.MIN_VALUE;
        if (arr[pridx + 1] > arr[idx] || pridx == -1)
            take = 1 + util(idx + 1, idx, n, arr, dp);

        return dp[idx][pridx + 1] = Math.max(notTake, take);
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        int a[] = {3, 10, 2, 1, 20};
        int n = a.length;

        // Function call
        System.out.println("Length of lis is " + getLongestSubSequence(a, n));
    }
}
