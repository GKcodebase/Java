package algorithm.DynamicProgramming;

/**
 * The type Shortest common super sequence.
 */
public class shortestCommonSuperSequence {

    /**
     * Find scs length int.
     *
     * @param s1 the s 1
     * @param s2 the s 2
     * @return the int
     */
    public static int findSCSLength(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                dp[i][j] = -1;
        }
        return findSCSLengthRecursive(0, 0, s1, s2, dp);
    }

    /**
     * Find scs length recursive int.
     *
     * @param m  the m
     * @param n  the n
     * @param s1 the s 1
     * @param s2 the s 2
     * @param dp the dp
     * @return the int
     */
    public static int findSCSLengthRecursive(int m, int n, String s1, String s2, int[][] dp) {
        if (m == s1.length())
            return s2.length() - n;
        if (n == s2.length())
            return s1.length() - m;

        if (dp[m][n] == -1) {
            if (s1.charAt(m) == s2.charAt(n))
                dp[m][n] = 1 + findSCSLengthRecursive(m + 1, n + 1, s1, s2, dp);
            else
                dp[m][n] = Math.min(findSCSLengthRecursive(m, n + 1, s1, s2, dp) + 1, findSCSLengthRecursive(m + 1, n, s1, s2, dp) + 1);
        }
        return dp[m][n];
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        System.out.println(findSCSLength("abcdz", "bdcf"));
        System.out.println(findSCSLength("educative", "educative.io"));
    }
}
