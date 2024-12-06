package CheatSheet.DynamicProgramming;

/**
 * The Longest common subsequence.
 */
public class LongestCommonSubsequence {
    /**
     * Longest common subsequence int.
     *
     * @param text1 the text 1
     * @param text2 the text 2
     * @return the int
     */
    static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        // Longest Common Subsequence
        System.out.println("LCS Length: " +
                longestCommonSubsequence("ABCDGH", "AEDFHR"));
    }
}
