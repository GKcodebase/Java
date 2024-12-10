package CheatSheet.DynamicProgramming;

/**
 * The Palindrome partitioning.
 */
public class PalindromePartitioning {
    /**
     * Gets min cut.
     *
     * @param s the s
     * @return the min cut
     */
    static int getMinCut(String s) {
        int l = s.length();

        boolean[][] isPalindrome = new boolean[l][l];
        int[] dp = new int[l];

        for (int len = 1; len <= l; len++) {
            for (int start = 0; start < l - len + 1; start++) {
                int end = start + len - 1;

                if (len == 1) {
                    isPalindrome[start][end] = true;
                } else if (len == 2) {
                    isPalindrome[start][end] = s.charAt(start) == s.charAt(end);
                } else {
                    isPalindrome[start][end] = (s.charAt(start) == s.charAt(end) &&
                            isPalindrome[start + 1][end - 1]);
                }
            }
        }

        for (int i = 0; i < l; i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (isPalindrome[j + 1][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }

        return dp[l - 1];
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        String s = "aaaabaaaacd";
        // Palindrome Partitioning
        System.out.println("Min Cuts for : " + s + " " + getMinCut(s));
    }
}
