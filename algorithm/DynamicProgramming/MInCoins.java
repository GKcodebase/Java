package algorithm.DynamicProgramming;

import java.util.Arrays;

/**
 * The type M in coins.
 */
public class MInCoins {

    /**
     * Gets min coins.
     *
     * @param a   the a
     * @param sum the sum
     * @return the min coins
     */
    public static int getMinCoins(int a[], int sum) {
        int dp[] = new int[sum];
        Arrays.fill(dp, -1);
        return getMinCoinHelper(a, sum, dp);
    }

    /**
     * Gets min coin helper.
     *
     * @param a   the a
     * @param sum the sum
     * @param dp  the dp
     * @return the min coin helper
     */
    public static int getMinCoinHelper(int a[], int sum, int dp[]) {
        if (sum == 0) return 0;
        int ans = Integer.MAX_VALUE;
        for (int i : a) {
            if (sum - i >= 0) {
                int subAns = 0;
                if (dp[sum - i] != -1) {
                    subAns = dp[sum - i];
                } else {
                    subAns = getMinCoins(a, sum - i);
                }
                if (subAns + 1 < ans && subAns != Integer.MAX_VALUE)
                    ans = subAns + 1;
            }
        }
        return ans;
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int sum = 18;
        int a[] = {1, 5, 7};
        System.out.println("Coins required is " + getMinCoins(a, sum));
    }
}
