package algorithm.DynamicProgramming;

/**
 * Given a distance ‘dist’, count total number of ways to cover the distance with 1, 2 and 3 steps.
 */
public class CountTheWayToCover {
    /**
     * Count ways int.
     *
     * @param n the n
     * @return the int
     */
    public static int countWays(int n) {
        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int dist = 4;
        System.out.println(countWays(dist));
    }
}
