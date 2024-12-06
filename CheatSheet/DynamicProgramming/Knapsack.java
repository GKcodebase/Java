package CheatSheet.DynamicProgramming;

/**
 * The Knapsack.
 */
public class Knapsack {
    /**
     * Knapsack int.
     *
     * @param weights  the weights
     * @param values   the values
     * @param capacity the capacity
     * @return the int
     */
    public static int knapsack(int[] weights, int[] values, int capacity) {
        int l = weights.length;

        int[][] dp = new int[l + 1][capacity + 1];

        for (int i = 1; i <= l; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (w >= weights[i - 1]) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i-1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }
        for(int i=0;i<=l;i++){
            for(int j=0;j<=capacity;j++){
                System.out.print(dp[i][j]+ " ");
            }
            System.out.println();
        }
        return dp[l][capacity];
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        int[] weights = {1, 2, 3};
        int[] values = {60, 100, 120};
        System.out.println("Knapsack Max Value: " + knapsack(weights, values, 5));
    }
}
