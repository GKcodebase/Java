package algorithm.DynamicProgramming;

import java.util.Arrays;

/**
 * Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute
 * difference between their sums is minimum.
 * If there is a set S with n elements,
 * then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of
 * abs(sum(Subset1) – sum(Subset2)) should be minimum.
 */
public class MinimumPartition {
    /**
     * Gets min difference.
     *
     * @param arr the arr
     * @param n   the n
     * @return the min difference
     */
    public static int getMinDifference(int[] arr, int n) {
        int sum = 0;
        for (int i : arr)
            sum += i;
        int dp[][] = new int[n + 1][sum + 1];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return util(0, 0, sum, n, arr, dp);
    }

    /**
     * Util int.
     *
     * @param idx      the idx
     * @param sum      the sum
     * @param totalSum the total sum
     * @param n        the n
     * @param arr      the arr
     * @param dp       the dp
     * @return the int
     */
    private static int util(int idx, int sum, int totalSum, int n, int[] arr, int[][] dp) {
        if (n == idx)
            return Math.abs((totalSum - sum) - sum);

        if (dp[idx][sum] != -1)
            return dp[idx][sum];

        int pick = util(idx + 1, sum + arr[idx], totalSum, n, arr, dp);
        int notPick = util(idx + 1, sum, totalSum, n, arr, dp);
        return dp[idx][sum] = Math.min(pick, notPick);

    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 2, 2, 1};
        int n = arr.length;

        // Find the minimum difference between two sets
        System.out.println(
                "The minimum difference between two sets is "
                        + getMinDifference(arr, n));
    }
}
