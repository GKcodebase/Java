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
     * Knapsack recursive int.
     *
     * @param lookupTable   the lookup table
     * @param profits       the profits
     * @param profitsLength the profits length
     * @param weights       the weights
     * @param weightsLength the weights length
     * @param capacity      the capacity
     * @param currentIndex  the current index
     * @return the int
     */
    public static int knapsackRecursive(int [][] lookupTable, int profits[], int profitsLength, int weights[], int weightsLength, int capacity, int currentIndex) {

        // base checks
        if (capacity <= 0 || currentIndex >= profitsLength || currentIndex < 0 || weightsLength != profitsLength)
            return 0;

        // if we have already solved the problem, return the result from the table
        if (lookupTable[currentIndex][capacity] != 0)
            return lookupTable[currentIndex][capacity];

        // recursive call after choosing the element at the currentIndex
        // if the weight of the element at currentIndex exceeds the capacity, we shouldn't process this
        int profit1 = 0;
        if (weights[currentIndex] <= capacity)
            profit1 = profits[currentIndex] + knapsackRecursive(lookupTable, profits, profitsLength, weights, weightsLength,
                    capacity - weights[currentIndex], currentIndex + 1);

        // recursive call after excluding the element at the currentIndex
        int profit2 = knapsackRecursive(lookupTable, profits, profitsLength, weights, weightsLength, capacity, currentIndex + 1);

        lookupTable[currentIndex][capacity] = Math.max(profit1, profit2);
        return lookupTable[currentIndex][capacity];
    }

    /**
     * Knap sack int.
     *
     * @param profits       the profits
     * @param profitsLength the profits length
     * @param weights       the weights
     * @param weightsLength the weights length
     * @param capacity      the capacity
     * @return the int
     */
    public static int knapSack(int profits[], int profitsLength, int weights[], int weightsLength, int capacity)
    {
        int lookupTable[][] = new int [profitsLength][];

        for (int i = 0; i < profitsLength; i++) {
            lookupTable[i] = new int[capacity + 1];
            for (int j = 0; j < capacity + 1; j++)
                lookupTable[i][j] = 0;
        }
        return knapsackRecursive(lookupTable, profits, profitsLength, weights, weightsLength, capacity, 0);
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
        System.out.println("Total knapsack (dynamic programming) profit ---> " + knapSack(profits, 4, weights, 4, 6));

    }
}