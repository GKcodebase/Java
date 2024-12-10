package CheatSheet.DynamicProgramming;

/**
 * The Max sum of non adjacent elements.
 */
public class MaxSumOfNonAdjacentElements {
    /**
     * Gets max value.
     *
     * @param arr the arr
     * @return the max value
     */
    static int getMaxValue(int[] arr) {
        int l = arr.length;
        int[] dp = new int[l + 1];
        dp[0] = 0;
        dp[1] = arr[0];
        for (int i = 2; i <= l; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr[i - 1]);
        }
        return dp[l];
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        int[] houses = {2, 7, 9, 3, 1};
        System.out.println("House Robber Max: " + getMaxValue(houses));
    }
}
