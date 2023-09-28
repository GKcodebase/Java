package algorithm.DynamicProgramming;

/**
 * The type The 0 and 1 knapsack.
 */
public class The0And1Knapsack {
    /**
     * Gets knapp sck.
     *
     * @param weight   the weight
     * @param profit   the profit
     * @param capacity the capacity
     * @return the knapp sck
     */
    public static int getKnappSck(int[] weight, int[] profit, int capacity) {
        int[][] dp = new int[profit.length][capacity + 1];
        return getKnappSckRecursive(dp, weight, profit, capacity, 0);

    }

    /**
     * Gets knapp sck recursive.
     *
     * @param dp           the dp
     * @param weight       the weight
     * @param profit       the profit
     * @param capacity     the capacity
     * @param currentIndex the current index
     * @return the knapp sck recursive
     */
    private static int getKnappSckRecursive(int[][] dp, int[] weight, int[] profit, int capacity, int currentIndex) {

        if (capacity <= 0 || currentIndex >= profit.length || currentIndex < 0 || weight.length != profit.length)
            return 0;
        if (dp[currentIndex][capacity] != 0)
            return dp[currentIndex][capacity];
        int profit0 = 0;
        if (weight[currentIndex] <= capacity) {
            profit0 = profit[currentIndex] + getKnappSckRecursive(dp, weight, profit, capacity - weight[currentIndex], currentIndex + 1);
        }
        int profit1 = getKnappSckRecursive(dp, weight, profit, capacity, currentIndex + 1);
        dp[currentIndex][capacity] = Math.max(profit1, profit0);
        return dp[currentIndex][capacity];
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[]) {

        int profits[] = {1, 6, 10, 16}; // The values of the jewelry
        int weights[] = {1, 2, 3, 5}; // The weight of each
        System.out.println("Maximum profit get from KnapSack :: " + getKnappSck(weights, profits, 6));
    }
}
