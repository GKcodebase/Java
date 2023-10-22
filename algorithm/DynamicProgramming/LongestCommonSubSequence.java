package algorithm.DynamicProgramming;


/**
 * The type Longest common sub sequence.
 */
public class LongestCommonSubSequence {
    /**
     * Gets sub sequences.
     *
     * @param m the m
     * @param n the n
     * @param a the a
     * @param b the b
     * @return the sub sequences
     */
    public static int getSubSequences(int m, int n, String a, String b) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++)
                dp[i][j] = -1;
        }
        return getSubSequencesUtil(m, n, a, b, dp);
    }

    /**
     * Gets sub sequences util.
     *
     * @param m  the m
     * @param n  the n
     * @param a  the a
     * @param b  the b
     * @param dp the dp
     * @return the sub sequences util
     */
    private static int getSubSequencesUtil(int m, int n, String a, String b, int[][] dp) {
        if (m == 0 || n == 0)
            return 0;
        if (dp[m][n] != -1)
            return dp[m][n];
        if (a.charAt(m - 1) == b.charAt(n - 1))
            return dp[m][n] = 1 + getSubSequencesUtil(m - 1, n - 1, a, b, dp);
        else {
            return dp[m][n] = Math.max(getSubSequencesUtil(m - 1, n, a, b, dp), getSubSequencesUtil(m, n - 1, a, b, dp));
        }
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        String s1 = "0abc321";
        String s2 = "123abcdef";
        String s3 = "educative.io/expl";
        String s4 = "educative.io/edpr";
        System.out.println(getSubSequences(s1.length(), s2.length(), s1, s2));
        System.out.println(getSubSequences(s3.length(), s4.length(), s3, s4));
    }
}
