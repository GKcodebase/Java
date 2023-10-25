package algorithm.DynamicProgramming;

/**
 * The type Longest palindrome sub sequence.
 */
public class LongestPalindromeSubSequence {

    /**
     * Gets longest palindrome.
     *
     * @param str the str
     * @return the longest palindrome
     */
    public static int getLongestPalindrome(String str) {
        int l = str.length();
        int dp[][] = new int[l][l];
        return getLongestPalindromeUtil(str, 0, l - 1, dp);
    }

    /**
     * Gets longest palindrome util.
     *
     * @param str   the str
     * @param start the start
     * @param end   the end
     * @param dp    the dp
     * @return the longest palindrome util
     */
    private static int getLongestPalindromeUtil(String str, int start, int end, int[][] dp) {
        if (start > end)
            return 0;
        if (start == end)
            return 1;
        if (dp[start][end] == 0) {
            if (str.charAt(start) == str.charAt(end)) {
                dp[start][end] = 2 + getLongestPalindromeUtil(str, start + 1, end - 1, dp);
            } else {
                dp[start][end] = Math.max(getLongestPalindromeUtil(str, start + 1, end, dp), getLongestPalindromeUtil(str, start, end - 1, dp));
            }
        }
        return dp[start][end];
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {
        System.out.println(getLongestPalindrome("cddpd"));
        System.out.println(getLongestPalindrome("abdbca"));
        System.out.println(getLongestPalindrome("cddpd"));
        System.out.println(getLongestPalindrome("pqr"));
    }
}
