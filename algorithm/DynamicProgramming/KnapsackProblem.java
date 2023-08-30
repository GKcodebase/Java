package algorithm.DynamicProgramming;

/**
 * The type Knapsack problem.
 */
public class KnapsackProblem
{
    /**
     * Knap sack int.
     *
     * @param profits       the profits
     * @param profitsLength the profits length
     * @param weights       the weights
     * @param weightsLength the weights length
     * @param capacity      the capacity
     * @param currentIndex  the current index
     * @return the int
     */
    public static int knapSack(int profits[], int profitsLength, int weights[], int weightsLength, int capacity ,int currentIndex)
    {
        // Base Case
        if (capacity <= 0 || currentIndex >= profitsLength || currentIndex < 0 || weightsLength != profitsLength)
            return 0;

        // If weight of the nth item is more than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        int profit1 = 0;
        if (weights[currentIndex] <= capacity)
            profit1 = profits[currentIndex] + knapSack(profits, profitsLength, weights, weightsLength, capacity - weights[currentIndex], currentIndex + 1);

        int profit2 = knapSack(profits, profitsLength, weights, weightsLength,  capacity, currentIndex + 1);

        // Return the maximum of two cases:
        return Math.max(profit1, profit2);
    }

    /**
     * Main.
     *
     * @param args the args
     */
    public static void main(String args[])
    {
        int profits[] = {1, 6, 10, 16}; // The values of the jewelry
        int weights[] = {1, 2, 3, 5}; // The weight of each
        System.out.println("Total knapsack profit ---> " + knapSack(profits, 4, weights, 4,  7, 0));
        System.out.println("Total knapsack profit ---> " + knapSack(profits, 4, weights, 4, 6, 0));
    }
}